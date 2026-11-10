package com.eazybytes.java.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaceExercise {

    static void main(String[] args) {
//        transformStringList();
//        filterByAge(29);
        filterByCity("New York");
    }

    // Method to apply string transformation using custom functional interface - StringTransformer
    public static List<String> transformStringList() {
        List<String> words = List.of("hello", "world", "java", "lambda");
        List<String> result = new ArrayList<>();

        // Write your logic below

        // Solving this without streams (the old fashion way, using only a lambda expression with the business logic)
        StringTransformer uppercaseTransformer = (String s) -> s.toUpperCase();
        for (String word : words) {
            result.add(uppercaseTransformer.transform(word));
        }

        return result;
    }

    // Predicate<T>, boolean test(t), Exercise
    public static List<Person> filterByAge(int age) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 28, "New York"));
        persons.add(new Person("Jane", 22, "Los Angeles"));
        persons.add(new Person("Jack", 30, "New York"));
        persons.add(new Person("Jill", 24, "Chicago"));

        // Write your code below
        return filter(persons, p -> p.getAge() > age);

//        persons = persons.stream()
//                .filter(p -> p.getAge() > age)
//                .collect(Collectors.toList());
//
//        return persons;
    }

    // Predicate<T>, boolean test(t), Exercise
    public static List<Person> filterByCity(String city) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 28, "New York"));
        persons.add(new Person("Jane", 22, "Los Angeles"));
        persons.add(new Person("Jack", 30, "New York"));
        persons.add(new Person("Jill", 24, "Chicago"));

        // Write your code below
        return filter(persons, p -> p.getCity().equals(city));

//        persons = persons.stream()
//                .filter(p -> p.getCity().equalsIgnoreCase(city))
//                .collect(Collectors.toList());
//
//        return persons;
    }

    // Predicate<T>, boolean test(t), Exercise
    public static List<Person> filter(List<Person> persons, Predicate<Person> predicate) {
        List<Person> filteredPersons = new ArrayList<>();
        for (Person person : persons) {
            if (predicate.test(person)) {
                filteredPersons.add(person);
            }
        }
        return filteredPersons;
    }
}
