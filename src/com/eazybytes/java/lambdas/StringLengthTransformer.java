package com.eazybytes.java.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * The Function functional interface exercise
 */
public class StringLengthTransformer {

    static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "lambda");
        transformStringLengths(words);
    }

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
}
