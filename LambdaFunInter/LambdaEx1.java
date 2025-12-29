import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

package LambdaFunInter;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(4, 5, 3, 1, 8, 6, 20, 13);
        
                data.stream()
                          .filter(k -> k%2 ==1) // Only if data is odd
                          .sorted()
                          .map(k -> k*2)
                          .forEach(k -> System.out.print(k+"\t"));
                
            // Here filter is a type of predicate which returns boolean value
            Predicate<Integer> predi = new Predicate<Integer>() {
                @Override
                public boolean test(Integer n) {
                    return n%2 == 1;
                }
            }; 
            
            // Optimizing the predicator 1
            Predicate<Integer> predicate1 = n -> n%2 == 1;
            
            System.out.println();           
            data.stream()
                        .filter(predicate1) // Only if data is odd
                        .sorted()
                        .map(k -> k*2)
                        .forEach(k -> System.out.print(k+"\t"));
               
            System.out.println();
            List<Integer> list = List.of(1, 2, 3, 4, 5);
        
            list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .forEach(System.out::println);
        
        
            // Before java 8 too much loops, iterations a lot of boilerplater code like
            List<String> names = List.of("asam", "pavan", "reddy", "kalyan");
            List<String> result = new ArrayList<>();
            for(String name: names) {
                if(name.startsWith("k")) {
                    result.add(name.toUpperCase());
                }
            }
            // Streams made that too simple like remove loops and boilerplate code support funcationla programming
            names.stream()
                .filter(n -> n.startsWith("k"))
                .map(String::toUpperCase)
                .toList(); // Now it is cleaner, shorter, readabule, parallelizable

                

    }
}
