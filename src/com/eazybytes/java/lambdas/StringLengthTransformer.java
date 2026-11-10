package com.eazybytes.java.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * The Function<T,R>, UnaryOperator<T>, void Consumer<T>, exercises
 */
public class StringLengthTransformer {

    static void main(String[] args) {

//        List<String> words = Arrays.asList("hello", "world", "java", "lambda");
//        transformStringLengths(words);

//        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
//        incrementList(nums, 3);

        List<String> inputString = Arrays.asList("apple", "banana", "carrot");
        convertAndPrint(inputString);
    }

    /**
     * Function<T,R>, R apply(t), Exercise
     */
    public static List<Integer> transformStringLengths(List<String> strings) {

        // Define a lambda expression using the Function functional interface
        Function<String, Integer> lengthTransformer = p -> p.length();

        // Apply the lambda expression to each string in the list
        List<Integer> lengthList = new ArrayList<>();
        for (String str : strings) {
            lengthList.add(lengthTransformer.apply(str));
        }

        return lengthList;
    }

    /**
     * UnaryOperator<T>, T apply(t), Exercise
     */
    public static List<Integer> incrementList(List<Integer> numbers, int incrementValue) {

        // Define a lambda expression using the UnaryOperator functional interface
        UnaryOperator<Integer> incrementer = i -> i + incrementValue;

        // Apply the lambda expression to each integer in the list
        List<Integer> incrementedList = new ArrayList<>();
        for (Integer val : numbers) {
            incrementedList.add(incrementer.apply(val));
        }

        return incrementedList;
    }

    /**
     * Consumer<T>, void accept(t), Exercise
     */
    public static void convertAndPrint(List<String> inputString) {

        Consumer<String> uppercaseConverter = input -> System.out.println(input.toUpperCase());
        inputString.forEach(uppercaseConverter);
    }
}
