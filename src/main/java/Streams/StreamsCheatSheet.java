package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsCheatSheet {

    public static void main(String[] args) {

        /*
         * STREAMS CHEAT SHEET
         * Think of streams like:
         * collection -> filter -> transform -> collect
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // -------------------------------------------------
        // 1. FILTER + MAP + COLLECT
        // Keep even numbers and square them
        // -------------------------------------------------
        List<Integer> squaredEvens = numbers.stream()
                .filter(n -> n % 2 == 0)   // keep even numbers
                .map(n -> n * n)           // square each number
                .toList();                 // collect into list

        System.out.println("Squared evens: " + squaredEvens);


        // -------------------------------------------------
        // 2. FILTER STRINGS
        // -------------------------------------------------
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "John");

        List<String> namesStartingWithA = names.stream()
                .filter(s -> s.startsWith("A"))
                .toList();

        System.out.println("Names starting with A: " + namesStartingWithA);


        // -------------------------------------------------
        // 3. MAP (transform values)
        // Convert strings to their lengths
        // -------------------------------------------------
        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();

        System.out.println("Name lengths: " + lengths);


        // -------------------------------------------------
        // 4. FIND FIRST
        // -------------------------------------------------
        Optional<String> firstLongName = names.stream()
                .filter(s -> s.length() > 3)
                .findFirst();

        firstLongName.ifPresent(s ->
                System.out.println("First long name: " + s)
        );


        // -------------------------------------------------
        // 5. SUM NUMBERS
        // -------------------------------------------------
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: " + sum);


        // -------------------------------------------------
        // 6. GROUPING EXAMPLE
        // Group people by city
        // -------------------------------------------------
        List<Person> people = List.of(
                new Person("Rahul", "Mumbai"),
                new Person("Priya", "Delhi"),
                new Person("Amit", "Mumbai")
        );

        Map<String, List<Person>> byCity =
                people.stream()
                        .collect(Collectors.groupingBy(Person::getCity));

        System.out.println("Grouped by city: " + byCity);


        // -------------------------------------------------
        // 7. FLATMAP EXAMPLE
        // Flatten list of lists into a single list
        // -------------------------------------------------
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        List<Integer> flattened = listOfLists.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Flattened list: " + flattened);
    }
}


// Simple class for grouping example
class Person {
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name;
    }
}
