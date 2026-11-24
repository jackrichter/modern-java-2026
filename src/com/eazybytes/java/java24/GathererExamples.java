package com.eazybytes.java.java24;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class GathererExamples {

    static void main(String[] args) {
        helloGatherer();
        devFriendlyGatherer();
        finisherGatherer();
        mutableStateGatherer();
        parallelGatherer();
        interruptingGatherer();
        chainingGatherer();
    }

    /// ## ***A basic example of a gatherer function***
    private static void helloGatherer() {
        var strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Gatherer<String, ?, String> gatherer = () ->
                (state, element, downstream) ->
                        downstream.push(element.toUpperCase());

        var result = strings.stream()
                .gather(gatherer)
                .toList();

        System.out.println(result);
    }

    /// ## ***A gatherer function that is more developer friendly***
    private static void devFriendlyGatherer() {
        var strings = List.of("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");

        var result = strings.stream()
                .gather(Gatherer.of((_, element, downstream)
                        -> downstream.push(element.toLowerCase(Locale.ROOT))))
                .toList();

        System.out.println(result);
    }

    /// ## ***A gatherer function with an Initializer of a mutable state, an Integrator and a finisher***
    private static void finisherGatherer() {
        // Input - [1, 2, 3, 4, 5, 6, 7]
        // Output - [[2, 4, 6], [8, 10, 12], [14]] == [[1*2, 2*2, 3*2], [4*2, 5*2, 6*2], [7*2]]

        Gatherer<Integer, List<Integer>, List<Integer>> batchGatherer =
                Gatherer.ofSequential(
                        ArrayList::new,     // Initializer
                        (listBuffer, item, downstream) -> {
                            listBuffer.add(item);
                            if (listBuffer.size() == 3) {
                                downstream.push(new ArrayList<>(listBuffer));
                                listBuffer.clear();
                            }
                            return true;    // Integrator needs to return true to continue processing
                        },
                        (listBuffer, downstream) -> {   // Finisher
                            if (!listBuffer.isEmpty()) {
                                downstream.push(new ArrayList<>(listBuffer));
                            }
                        }
                );

        var result = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(item -> item * 2)
                .gather(batchGatherer)
                .toList();

        System.out.println(result);
    }

    /// ## ***A sequential gatherer function with mutable state***
    private static void mutableStateGatherer() {
        // Input - 10, 20, 30, 40
        // Output - 10, 30, 60, 100

        Gatherer<Integer, AtomicInteger, Integer> cumulativeSum =
                Gatherer.ofSequential(
                        AtomicInteger::new,     // Initializer
                        (atomicInteger, item, downstream) -> {
                            atomicInteger.addAndGet(item);
                            return downstream.push(atomicInteger.get());  // Integrator needs to return true to continue processing
                        }
                );

        var result = Stream.of(10, 20, 30, 40)
                .gather(cumulativeSum)
                .toList();

        System.out.println(result);
    }

    /// ## ***A gatherer function combining sums in parallel***
    /// ### ***With Initializer, Integrator, Combiner and Finisher***
    private static void parallelGatherer() {
        Gatherer<Integer, ?, Integer> parallelSum =
                Gatherer.of(()->new AtomicInteger(),        // Initializer
                        (sum, number, downstream) -> {
                            System.out.printf("[Integrator] Thread: %s | number: %d%n",
                                    Thread.currentThread().getName(), number);
                            sum.addAndGet(number);
                            return true;
                        },
                        (i1,i2) -> {
                            System.out.printf("[Combiner] Thread: %s | combining %d + %d%n",
                                    Thread.currentThread().getName(), i1.get(), i2.get());
                            i1.addAndGet(i2.get()); // combiner
                            return i1;
                        },
                        (sum, downstream) -> {
                            System.out.printf("[Finisher] Thread: %s | sum: %d%n",
                                    Thread.currentThread().getName(), sum.get());
                            downstream.push(sum.get());
                        });

        var result = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .gather(parallelSum)
                .toList();

        System.out.println(result);
    }

    /// ## ***Gatherer function that gets interrupted by a limit operation***
    /// ## Rules to remember:
    /// - ***Downstream is going to start in non rejecting state***
    /// - ***A downstream can only go from non-rejecting to rejecting***
    /// - ***The state only changes when you push an element to it***
    private static void interruptingGatherer() {

        // Simulate a large list
        List<Integer> largeList = Stream.iterate(1, i -> i + 1)
                .limit(1000)
                .toList();

        Gatherer<Integer, ?, Integer> limitGatherer =
                Gatherer.of(
                        (_, element, downstream) -> {
                            return downstream.push(element);    // Returns false when limit of 10 is reached, thus interrupting the gatherer
                        }
                );

        var result = largeList.stream()
                .limit(10)
                .gather(limitGatherer)
                .toList();

        System.out.println(result);
    }

    /// ## ***Gatherer function that chains multiple gatherers together***
    private static void chainingGatherer() {

        Gatherer<String, ?, String> upper =
                Gatherer.of((_, element, downstream) ->
                        downstream.push(element.toUpperCase()));

        Gatherer<String, ?, String> filter =
                Gatherer.of((_, element, downstream) -> {
                    if (element.startsWith("J")) {
                        downstream.push(element);
                    }
                    return true;
                });

        var result = Stream.of("java", "spring", "react")
                .gather(upper.andThen(filter))
                .toList();

        System.out.println(result);
    }
}
