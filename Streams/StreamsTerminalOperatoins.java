import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

package Streams;

public class StreamsTerminalOperatoins {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,4,6,8,10,22,40,100, -1);

        // A Matching Operators
        boolean hasEven = list1.stream()
            .anyMatch(n -> n%2 == 0);
        System.out.println(hasEven); 
        
        boolean allPoitive = list1.stream()
            .allMatch(n -> n > 0);
        System.out.println(allPoitive);
        
        
        boolean noneNegative = list1.stream()
            .noneMatch(n -> n < 0);
        System.out.println(noneNegative);
        
        
        // B Finding Elements
        Optional<Integer> any = list1.parallelStream().findAny();
        System.out.println(any.get()); // Run 10 times – you will see different results with findAny()

        Optional<Integer> first = list1.parallelStream().findFirst();
        System.out.println(first.get());

        // 3 Reduction IMP
        // Reduction operations combine all stream elements to produce one final value
        
        long count = list1.stream().count();
        System.out.println(count);

        int sum = list1.stream()
            .mapToInt(n -> n)
            .sum();
        System.out.println(sum);

        double avg = list1.stream()
            .mapToInt(n -> n)
            .average()
            .orElse(0);
        System.out.println(avg);


        // 3 reduce()
        Optional<Integer> nums = list1.stream()
            .reduce((a,b) -> a + b);
        System.out.println(nums.get()); 
        
        int result = list1.stream()
            .reduce(2, (a,b) -> a+b);

        System.out.println(result);     
            

        /* ✅ SECTION 4 — Collecting (Terminal Operations)

            collect() is one of the most powerful Stream terminal operations.
            It is used to convert stream output into:
         */
        List<String> names = List.of("kalyan", "reddy", "kalyan", "sunil");

        List<String> list = names.stream()
                                .collect(Collectors.toList());

                            

        list.forEach(System.out::print);
        
         Set<String> set = names.stream()
                                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        String result2 = names.stream()
                            .collect(Collectors.joining("@"));
                    
        System.out.println(result2);
        
    
        
        Map<Integer, List<String>> grouped = names.stream()
        .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);

        names.stream().forEachOrdered(System.out::println); // Gurantees Order -> even in parallel streams
    }
}
