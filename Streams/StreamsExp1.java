import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExp1 {
   public static void main(String[] args) {
    String str = "Java is fun and Java is Powerful that's called java";
    List<String> uniqueWords = Arrays.stream(str.split(" ")).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList()); // From Ytube interview video

    System.out.println(uniqueWords);

    // Stremas xan be consumed only once
    List<Integer> nums = Arrays.asList(5,3,1,6,9,4,10);

    Stream<Integer> data = nums.stream();
    Stream<Integer> mappedData = data.map(n -> n*2);
    mappedData.forEach(n -> System.out.println(n));
      // If I try to use one more time it will throw exception
      // mappedData.forEach(n -> System.out.println(n));

      // The above can be intrepretend in one line as below
      nums.stream().map(a -> a*2).forEach(a -> System.out.print(a+" "));
      // Also for better redability
      nums.stream()
                  .map(k -> k*2)
                  .forEach(k -> System.out.print(k+"\t"));
       
      System.out.println();            
      nums.stream()
                  .filter(p -> p%2==1) // Only if nums is odd
                  .sorted()
                  .map(p -> p*2)
                  .forEach(p -> System.out.print(p+"\t"));            
   } 
}
