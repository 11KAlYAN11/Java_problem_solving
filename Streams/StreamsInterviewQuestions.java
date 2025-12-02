import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInterviewQuestions {
    public static void main(String[] args) {
        // 1) What is the difference between map() vs faltMap() (Teached Data transformation , flattening nested structures)

        List<List<String>> nestedNames = List.of(
            List.of("Asam", "Pavan"),
            List.of("Kalyan", "Reddy")
        );

        List<String> flattenNames = nestedNames.stream()
        .flatMap(l -> l.stream())
        .toList();

        flattenNames.forEach(System.out::println);

        // 2️⃣ Why are Streams lazy? What executes first — map or filter? 🚀 Teaches: Optimization, pipeline execution order Streams use vertical evaluation: 
        List.of(1,2,3,4)
            .stream()
            .filter(n -> {
                System.out.println("Filter: "+ n);
                return  n%2 == 0;
            })
            .map(n -> {
                System.out.println("Map: "+ n);
                return n*10;
            })
            .forEach(System.out::println);

        // 3️⃣ Why can’t we reuse a Stream? What is IllegalStateException: stream has already been operated upon or closed? 🚀 Teaches: Immutability, one-time consumption

        Stream<Integer> s = List.of(1,2,3).stream();

        s.forEach(System.out::println);
        // s.forEach(System.out::println); // ❌ IllegalStateException


        Optional<List<String>> a =  nestedNames.stream().findFirst(); // maintains order
        System.out.println(a);
        Optional<List<String>> b = nestedNames.parallelStream().findAny(); // fastest available element
        System.out.println(b);

        // 6️⃣ How does reduce() work? Why do people say reduce is tricky? 🚀 Teaches: Functional reduction, accumulator + combiner
        // reduce(identity, accumulator, combiner)
        int sum = List.of(1,2,3,4).stream()
        .reduce(0, (c,d) -> c+d);
        System.out.println(sum);


        //1) Find all even numbers from a list

        List<Integer>list = Arrays.asList(1,2,3,4,5,6);
        List<Integer> evens = list.stream()
                                .filter(n -> n % 2 == 0) 
                                // .collect(Collectors.toList()); // java 8+
                                .toList(); // java 16+ for newer JDk's
                                // .forEach(System.out::print);
        evens.forEach(System.out::print);

        // approach 2:
        List<Integer> evens2 = list.stream()
            .collect(Collectors.filtering(n -> n%2 == 0, Collectors.toList()));
        System.out.println();
        evens2.forEach(System.out::println);  
        
        // 2)  Find the sum of all numbers in a list
        int sum1 = list.stream()
            .mapToInt(n -> n)
            .sum();
        System.out.println(sum1);    

        int sum2 = list.stream()
            .mapToInt(Integer::intValue) // It is same as first just Method reference expression
            .sum();
        System.out.println(sum2);   
        
        int sum3 = list.stream()
            .reduce(0, Integer::sum); 
            // .reduce(0, (a1,a2) -> a1 + a2);
        System.out.println(sum3);    


        int max = list.stream()
            /* .mapToInt(Integer::intValue) // It is same as first just Method reference expression // Why it works: Use IntStream.max + orElseThrow for empty handling.
            .max().orElseThrow(); */
            .reduce(Integer::max).orElseThrow();  // Why it works: reduce with Integer::max avoids converting to primitive stream. 
        System.out.println(max); 


        // 6) Count the number of strings starting with a specific letter
        List<String> words = List.of("Apple", "Ant", "bob", "cast", "as");
        long count = words.stream()
            // .filter(s1 -> s1.toLowerCase().startsWith("a"))
            .filter(s1 -> s1.startsWith("A"))
            .count();
        System.out.println();
        System.out.println(count);  
        
        long count1 = words.stream() 
              .collect(Collectors.filtering(sx -> sx.startsWith("A"),Collectors.counting()));
        System.out.println(count1); // Why it works: Use Collectors.filtering + counting.

        // 7) Remove duplicates from a list of integers
        List<Integer> nums = Arrays.asList(1,2,2,3,3,3,4);
        List<Integer> uniqueNums = nums.stream()
            .distinct()
            .toList();
        System.out.println(uniqueNums);

        List<Integer> uniqueNums1 = nums.stream()
            .collect(Collectors.toSet()) // Why it works: Collectors.toSet removes duplicates.
            .stream()
            .toList();
        System.out.println(uniqueNums1);

        List<Integer> uniqueNums3 = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNums3);

        List<Integer> sorted = nums.stream()
            .sorted()
            .toList();
        sorted.forEach(System.out::print);    

        List<Integer> sorted1 = nums.stream()   
            /* .sorted()
            .collect(Collectors.toList()); */
            // .sorted(Comparator.naturalOrder()).collect(Collectors.toList()); // with comparator natural oreder ascending order
            .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println();
        sorted1.forEach(System.out::print);

        // SLN SLN SLN SLN
        // anyMatch() check if any element in the list matches a condition

        boolean hasEven = nums.stream().anyMatch( n -> n%2 == 0);
        System.out.println(hasEven);

        // allMatch() check if all elements match a condition

        boolean allEven = nums.stream().allMatch(n-> n%2 == 0);
        System.out.println(allEven);

        boolean noneLongerThan10 = nums.stream().noneMatch(n -> n > 10); // means none should be greater than 10
        System.out.println(noneLongerThan10);

        // Filter none values from list
        /*
        ⚠️ List.of() is strict → it throws NPE if ANY element is null.
        ❌ Problem  -> List<String> shorts = List.of("kal", "pan", "red", null, "blu", null, null, "Alice");
        ✅ Correct Solutions -> List<String> shorts = Arrays.asList("kal", "pan", "red", null, "blu", null, null, "Alice");

        "Can List.of() contain nulls?"
            Correct answer:
            “No, all List.of(), Set.of() and Map.of() factory methods throw NullPointerException if any element or key/value is null because they return immutable collections that don't allow nulls.”
            This is a strong point to mention in interviews.
         */
        List<String> shorts = Arrays.asList("kal", "pan", "red", null, "blu", null, null, "Alice");
        List<String> nonNull =  shorts.stream().filter(Objects::nonNull).collect(Collectors.toList()); // simply we can alos use .toList() from java 16+
        nonNull.forEach(System.out::println);

        // we can also use flatMap to drop null values
        List<String> nonNull2 = shorts.stream().flatMap(s1 -> s1 == null ? Stream.empty() : Stream.of(s1)).collect(Collectors.toList());
        nonNull2.forEach(System.out::println);

        Set<String> set1 = shorts.stream().collect(Collectors.toSet());
        set1.forEach(System.out::println);

        // If you want to preserve the insertion order leverage LinkedHashSet()

        System.out.println();
        Set<String> set2 = shorts.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        set2.forEach(System.out::println);
        


    }
}
