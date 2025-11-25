import java.util.List;

public class StreamsIntermidiateOperations {
    public static void main(String[] args) {
        filterAndDistinct();
    }

    public static void filterAndDistinct() {
        List<Integer> evens = List.of(1,2,2,3,4,6,3,4,5,6,7,8);
        evens.stream()
            .filter(n -> n%2 == 0)
            .forEach(n -> System.out.println(n));

            System.out.println();
            evens.stream()
            .filter(n -> n%3 == 0)
            .distinct()
            .forEach(n -> System.out.println(n));
    }
}
