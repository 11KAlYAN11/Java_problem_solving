
package Streams;

import java.util.List;


public class StreamsIntermidiateOperations {

    public static void main(String[] args) {
        filterAndDistinct();
    }

    public static void filterAndDistinct() {
        // 🅰 A. FILTERING OPERATIONS
        List<Integer> evens = List.of(1, 2, 2, 3, 4, 6, 3, 4, 5, 6, 7, 8);
        evens.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));

        System.out.println();
        evens.stream()
                .filter(n -> n % 3 == 0)
                .distinct()
                .forEach(n -> System.out.println(n));

        // B. MAPPING OPERATIONS
        List<Integer> squares = List.of(1, 2, 3, 4)
                .stream()
                .map(n -> n * n)
                .toList();
        squares.forEach(System.out::println);
        // 2️⃣ mapToInt(), mapToLong(), mapToDouble()  

        // ⭐ 3️⃣ flatMap() → VERY VERY IMPORTANT
        // This is used when your data in nested and you need to flatten it.
        // 1) Flatten Lists
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );
        List<Integer> flatList = nestedList.stream()
                .flatMap(l -> l.stream())
                .toList();
        flatList.forEach(System.out::print);    // o/p: [1,2,3,4,5,6]

        // C. SORTING
        // Sorts natural order like soreted()
        // 2) sorted(Comparator) - custom comparator
        List<String> names = List.of("Kalyan", "Reddy", "Aadi", "Vikram")
                .stream()
                .sorted((a, b) -> b.compareTo(a)) // descending
                .toList();
        System.out.println();
        names.forEach(name -> System.out.print(name));

        // 🅳 D. LIMITING & SKIPPING
        // 1) Limit takes only the first n elements
        List<Integer> first4 = List.of(1, 2, 3, 4, 5)
                .stream()
                .limit(4)
                .toList();
        System.out.println();
        first4.forEach(System.out::print);

        // 2) Skips the first n elements
        List<Integer> skip2 = List.of(1, 2, 3, 4, 5)
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println();
        skip2.forEach(System.out::print);
    }
}
