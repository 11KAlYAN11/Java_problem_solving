
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

package Streams;

public class StreamsExp1 {

    public static void main(String[] args) {
        String str = "Java is fun and Java is Powerful that's called java";
        List<String> uniqueWords = Arrays.stream(str.split(" ")).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList()); // From Ytube interview video

        System.out.println(uniqueWords);

        // Stremas xan be consumed only once
        List<Integer> nums = Arrays.asList(5, 3, 1, 6, 9, 4, 10);

        Stream<Integer> data = nums.stream();
        Stream<Integer> mappedData = data.map(n -> n * 2);
        System.err.println("Mapped data stream created.");
        System.out.println();
        // Before java 8 too much loops, iterations a lot of boilerplater code like
        List<String> names = List.of("asam", "pavan", "reddy", "kalyan");
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("k")) {
                result.add(name.toUpperCase());
            }
        }
        // Streams made that too simple like remove loops and boilerplate code support funcationla programming
        names.stream()
                .filter(n -> n.startsWith("k"))
                .map(String::toUpperCase)
                .toList(); // Now it is cleaner, shorter, readabule, parallelizable

        System.out.println();

        // Main characteristics of streams
        /* 
            1) Streams or immutable they don't modify the orginal data source
            2) Streams are funcational (It supports funcation style programming, meaning you focus on what to do, not how to do it.)
            3) Streams are lazy: Intermediate operations like filter, map, sorted, etc. do not execute immediately they run only when a termnal operation is called
            4) Streams can be parallel
         */
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> result1 = numbers.stream()
                .map(n -> n * 10)
                .toList();

        numbers.forEach(System.out::println); // No change in orginal data source
        result1.forEach(System.out::println); //  

        // 2) It' all about What to do, than how to do
        List<Integer> res2 = numbers.stream()
                .filter(s -> s >= 2)
                .map(k -> k * 10)
                .toList();

        System.out.println();
        res2.forEach(System.out::println);

        // 3)Streams are lazy
        // Intermediate operation filter, map, sorted do not execute immediately they run onlyu when a terminal operation is called
        System.out.println(
                List.of(1, 2, 3).stream()
                        .filter(n -> {
                            System.out.println("Filtering: " + n);
                            return n > 1;
                        })
                        .count() // w/o this terminal intermediate operations will not print as streams are lazy
        );

    }
}
