import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(4,5,3,1,8,6,20,13);

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
                  
    }
}
