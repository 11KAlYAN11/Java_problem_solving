import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

        List<Integer>list = Arrays.asList(1,2,3,4,5,6);
        List<Integer> evens = list.stream()
                                .filter(n -> n % 2 == 0) 
                                // .collect(Collectors.toList()); // java 8+
                                .toList(); // java 16+ for newer JDk's
                                // .forEach(System.out::print);
        evens.forEach(System.out::print);
    }
}
