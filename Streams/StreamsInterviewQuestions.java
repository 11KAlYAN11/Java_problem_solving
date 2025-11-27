import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
    }
}
