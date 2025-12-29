
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

package Streams;

public class TypesOfStreams {

    public static void main(String[] args) {
        // 1) Creating the streams from collections (Applies to any class that implements collection)
        // Collection.stream()
        List<String> names = List.of("Kalyan", "Sonu", "Rahul", "Yadav");
        names.stream() // names.parallelStream()
                .filter(n -> n.startsWith("K"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        // 2) Creating a streams from Arrays
        System.out.println();
        int[] numbers = {1, 2, 3, 4};
        Arrays.stream(numbers)
                .map(n -> n * n)
                .sorted()
                .forEach(System.out::print);

        /*✅ 3. Creating Streams using Stream.of()
                Best for small sets of values or when you want to quickly wrap elements into a stream.
                Stream.of() can take unlimited arguments.
         */
        System.out.println();
        Stream.of("Apple", "Banana", "Kiwi", "Monngo")
                .filter(f -> f.length() > 4)
                .forEach(System.out::print);

        /* 4. Creating Streams from Maps
        Maps (HashMap, TreeMap, LinkedHashMap) do NOT directly support .stream()
        Because Map is not a Collection, it has no stream() method.
        But we can stream over map.entrySet().stream()
                                map.keySet().stream()
                                map.values().stream()
         */
        System.out.println();
        Map<String, Integer> map = Map.of(
                "A", 10,
                "B", 20,
                "C", 30,
                "D", 40
        );
        map.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 15)
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        // 🟦 Extra: Create an empty or infinite stream
        // Stream.empty();
        /* Str̥eam<Integer> infinate = Stream.iterate(1, n -> n + 1);
        infinate.forEach(n -> System.out.print(n));
         */

 /* 2. Stream.generate()

                Stream.generate() is used when you want to create an infinite stream of values.
                Because it is infinite, you almost always combine it with .limit().
         */
        Stream<Double> randoms = Stream.generate(Math::random)
                .limit(10);
        randoms.forEach(System.out::println);

        Stream<String> streams = Stream.generate(() -> "Kalyan")
                .limit(3);
        streams.forEach(System.out::println);

        int sum = IntStream.range(1, 10).sum(); // Exclusive 10
        System.out.println(sum);

        int sum2 = IntStream.rangeClosed(1, 10).sum(); // Inclusive 10
        System.out.println(sum2);

    }
}
