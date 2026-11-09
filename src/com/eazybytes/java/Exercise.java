package com.eazybytes.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Exercise {

    public static void main (String[] args) {
//        Exercise.funnyFoodDecision(true, true, true);
//        Exercise.funnyFoodDecision(true, true, false);
//        Exercise.funnyFoodDecision(true, false, true);
//        Exercise.funnyFoodDecision(false, true, true);
//        Exercise.rankCalculator(95);
//        Exercise.rankCalculator(83);
//        Exercise.rankCalculator(75);
//        Exercise.rankCalculator(65);
//        Exercise.rankCalculator(55);
//        Exercise.moodAnalyzer("HAPPY");
//        Exercise.moodAnalyzer("SAD");
//        Exercise.moodAnalyzer("TIRED");
//        Exercise.moodAnalyzer("EXCITED");
//        Exercise.moodAnalyzer("NONE");
//        Exercise.sumOfFirst100Numbers();
//        Exercise.sumOfNumbers(100);
//        Exercise.sumOfNumbers(10000);
//        Exercise.findDivisibleNumber(2, 3);
//        Exercise.findDivisibleNumber(2, 5);

//        String[] strArr = {"Woof!", "Meow!", "Quack!"};
//        String[] strArr = new String[] {"Woof!", "Meow!", "Quack!"};
//        System.out.println(strArr.length);
//        System.out.println(Arrays.toString(strArr));

//        String[] animalSounds = {
//                "Moo!",
//                "Baa!",
//                "Oink!",
//                "Meow!",
//                "Woof!"
//        };
//
//        // Write the iteration logic below and convert to upper case
//        for (String sound: animalSounds) {
//            System.out.println(sound.toUpperCase());
//        }
//        subtractionMatrices();
//        try {
//            bufferReaderArithmeticExpressions();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        scannerArithmeticExpressions();

//        var persons = new ArrayList<Person>();
//        persons.add(new Person("James", 65));
//        persons.add(new Person("Sneha", 34));
//        persons.add(new Person("Jenna", 30));
//        persons.add(new Person("Harry", 29));
//        // Sort the Persons based on age and return
//        System.out.println(persons);
////      persons.sort(Person::compareTo);
//        Collections.sort(persons);
//        System.out.println(persons);

//        List<Integer> li = Arrays.asList(1, 2, 3);
//        List<String> ls = Arrays.asList("One", "Two", "Three");
//        unboundedWildcardExample(li);
//        unboundedWildcardExample(ls);

//        wordsLength();

//        removeVowelWords();

//        double toll = calculateToll(VehicleType.CAR);
//        System.out.println("Toll: " + toll);

//        String dateStr = createDateAndParse();
//        System.out.println("Date Created: " + dateStr);

//        listOfTimezonesIds();

//        String dateStr = createCalendarDateAndParse();
//        System.out.println(dateStr);

//        localDateOperations();
//        localTimeOperations();
//        localDateTimeOperations();

//        londonNYTimeZoneScheduler();

        formatDateTime(
                LocalDateTime.of(2030, 05, 20, 14, 30));
        parseDateTime("20/05/2030 14:30:00");

    }

    public static String funnyFoodDecision(boolean isHungry, boolean hasPizza,
                                           boolean hasBurger)
    {
        // Write your logic below
        if (isHungry & hasPizza & hasBurger){
            return "I'm hungry and I have both pizza and burger! Let's feast!";
        }else if (isHungry & hasPizza &!hasBurger) {
            return "I'm hungry and I have pizza! Let's enjoy some slices!";
        }else if (isHungry & !hasPizza & hasBurger) {
            return "I'm hungry and I have a burger! Let's munch on it!";
        }else {
            return "I'm not hungry. Let's wait for the next mealtime!";
        }
    }

    public static String rankCalculator(int score)
    {
        // Write your code below
        String rank;
        rank = (score >= 90) ? "Grandmaster" : (score >= 80) ? "Master" :
                (score >= 70) ? "Expert" : (score >= 60) ? "Intermediate" : "Beginner";
        System.out.println(rank);
        return rank;
    }

    public static String moodAnalyzer (String mood) {

        // Write your switch expression below and return String

        return switch (mood) {
            case "HAPPY" -> "😀";
            case "SAD" -> "😞";
            case "TIRED" -> "🥱";
            case "EXCITED" -> "😱";
            default -> "🤔";
        };
    }

    public static int sumOfFirst100Numbers () {
        int sum = 0;
        int number = 1;

        // Write your logic below
        while (number <= 100) {
            sum += number;
            number++;
        }
        System.out.println(sum);
        return sum;
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;
        int number = 1;

        // Write your logic below using do while
        do {
            factorial *= number;
            number++;
        } while (number <= n);
        return factorial;
    }

    public static long sumOfNumbers(int number) {
        long sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }

    public static int findDivisibleNumber(int num1, int num2) {
        int firstDivisibleNum = num1;

        while (firstDivisibleNum % num1 != 0 || firstDivisibleNum % num2 != 0) {
            firstDivisibleNum++;
        }

        return firstDivisibleNum;
    }

    public static int[][] subtractionMatrices() {
        int[][] array1 = {
                {3,6,2}, {4,9,8}
        };
        int[][] array2 = {
                {9,1,7}, {6,4,0}
        };

        // Write your code below
        int[][] result = new int[array1.length][array1[0].length];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                result[i][j] = array1[i][j] - array2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));

        return result;
    }

    public static void bufferReaderArithmeticExpressions() throws IOException {

        // Declare the object of BufferedReader
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Arithmetic Operations using BufferedReader!");
        System.out.print("Please enter the first number: ");

        // Accept first number num1 here
        int num1 = Integer.parseInt(bfr.readLine());

        System.out.print("Please enter the second number: ");

        // Accept first number num2 here
        int num2 = Integer.parseInt(bfr.readLine());

        System.out.println("Which operation would you like to perform?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1/2/3/4): ");

        // Accept Arithmetic operation choice here and perform the corresponding operation
        int choice = Integer.parseInt(bfr.readLine());
        int result = switch (choice) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> num1 / num2;
            default -> 0;
        };
        System.out.println("Result: " + result);
    }

    public static void scannerArithmeticExpressions() {

        // Declare the object of Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Arithmetic Operations using Scanner!");
        System.out.print("Please enter the first number: ");

        // Accept first number num1 here
        int num1 = scanner.nextInt();

        System.out.print("Please enter the second number: ");

        // Accept first number num2 here
        int num2 = scanner.nextInt();

        System.out.println("Which operation would you like to perform?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1/2/3/4): ");

        // Accept Arithmetic operation choice here and perform the corresponding operation
        int choice = scanner.nextInt();
        int result = switch (choice) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> num1 / num2;
            default -> 0;
        };
        System.out.println("Result: " + result);
    }

    // OBS! Generic Method Example!
    public <T> Object[] swap(T[] array, int index1, int index2) {
        T temp = (T) array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        // Covariance Example!! (Not supported in Collections)
        Object[] objArray = {"Hi", 123, null, "Hello", 3.14, true};
        Number[] numberArray = {1, 2.12, 3, 41234564577L, 5, null, 50123477.2345};

        return array;
    }

    // Unbounded Wildcard Example!
    public static void unboundedWildcardExample(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // Map
    public static Map<String,Integer> wordsLength() {

        List<String> words = List.of("apple", "banana", "orange", "grape", "kiwi");

        // Write your code below
        var wordLengthMap = new HashMap<String,Integer>();
        for (String word : words) {
            wordLengthMap.put(word, word.length());
        }
        for (String key : wordLengthMap.keySet()) {
            System.out.println(key + " - " + wordLengthMap.get(key));
        }
        return wordLengthMap;
    }

    // Set
    public static Set<String> removeVowelWords () {

        // Write your code below
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("lynx");
        fruits.add("grape");

        Iterator<String> fruitsIterator = fruits.iterator();

        while(fruitsIterator.hasNext()) {
            String fruit = fruitsIterator.next();
            if (fruit.matches(".*[aeiou|AEIOU].*")) {
                fruitsIterator.remove();
            }
        }
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        return fruits;
    }

    // Enum
    public static double calculateToll(VehicleType type) {
        return switch (type) {
            case CAR -> 5.0;
            case MOTORCYCLE -> 3.0;
            case BUS -> 10.0;
            case TRUCK -> 15.0;
        };
    }

    // Date (Legacy: java.util.Date)
    public static String createDateAndParse() {
        Date date = new Date(125, 11, 26);

        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMMM-yy HH:mm:ss");
        String dateString = formattedDate.format(date);

        return dateString;
    }

    // Timezone + GregorianCalendar
    public static void listOfTimezonesIds() {
        String[] timeZoneIds = TimeZone.getAvailableIDs();

        for (String timeZoneId : timeZoneIds) {
            System.out.println(timeZoneId);
        }

        // Current time in NY
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String formattedDate = dateFormat.format(new Date());
        System.out.println("NY current date and time: " + formattedDate);

        // Current time in LA
        GregorianCalendar gregorianCalendar =
                new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
        int year = gregorianCalendar.get(Calendar.YEAR);
        int month = gregorianCalendar.get(Calendar.MONTH);
        month += 1; // (Months are zero-based)
        int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = gregorianCalendar.get(Calendar.MINUTE);
        int seconds = gregorianCalendar.get(Calendar.SECOND);
        System.out.printf("LA current date and time: %04d-%02d-%02d %02d:%02d:%02d",
                year, month, day, hour, minutes, seconds);
    }

    public static String createCalendarDateAndParse() {
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        GregorianCalendar calendar = new GregorianCalendar(timeZone);
        calendar.set(Calendar.YEAR, 2026);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DATE, 25);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.add(Calendar.HOUR_OF_DAY, -6);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStr = dateFormat.format(calendar.getTime());

        return formattedStr;
    }

    // LocalDate, LocalTime and LocalDateTime (java.time)
    public static LocalDate localDateOperations() {
        LocalDate localDate = LocalDate.of(2025, Month.DECEMBER, 25);
        LocalDate ld1 = localDate.plusMonths(6).plusDays(18);
        System.out.println(ld1);

        return ld1;
    }

    public static LocalTime localTimeOperations() {
        LocalTime localTime = LocalTime.of(9, 0);
        LocalTime lt1 = localTime.plusHours(8).plusMinutes(15);
        System.out.println(lt1);

        return lt1;
    }

    public static LocalDateTime localDateTimeOperations() {
        LocalDateTime localDateTime = LocalDateTime.of(2025, Month.DECEMBER, 25, 9, 30);
        LocalDateTime ldt = localDateTime.minusWeeks(4).minusMinutes(30);
        System.out.println(ldt);

        return ldt;
    }

    // ZonedDateTime
    public static void londonNYTimeZoneScheduler() {
        ZonedDateTime londonStartTime, londonEndTime, newYorkStartTime,newYorkEndTime;

        // Write your logic below
        londonStartTime = ZonedDateTime.of(2024, 10, 15, 14, 0,
                0, 0, ZoneId.of("Europe/London"));
        londonEndTime = londonStartTime.plusHours(2);

        newYorkStartTime = londonStartTime.withZoneSameInstant(
                ZoneId.of("America/New_York"));
        newYorkEndTime = newYorkStartTime.plusHours(2);

        System.out.println("Conference Call Start Time (London): " + londonStartTime);
        System.out.println("Conference Call End Time (London): " + londonEndTime);
        System.out.println("Conference Call Start Time (New York): " + newYorkStartTime);
        System.out.println("Conference Call End Time (New York): " + newYorkEndTime);
    }

    // DateTimeFormatter
    public static String formatDateTime(LocalDateTime localDateTime) {

        // Write your code below
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy h:mm a", Locale.US);
        String formattedDateTime = formatter.format(localDateTime);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }


    public static LocalDateTime parseDateTime(String dateTimeString) {

        // Write your code below
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println(localDateTime);

        return localDateTime;
    }

    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age + " years old";
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public enum VehicleType {
        CAR, MOTORCYCLE, BUS, TRUCK
    }
}
