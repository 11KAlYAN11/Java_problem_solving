
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapParallelEtcStreams {

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );
        // 1) By using map - x
        list.stream()
                .map(l -> l.stream())
                .forEach(System.out::print);
        // Because map return Stream<Stream<Integer>>

        //2)  Using the flat map 
        System.out.println();
        list.stream()
                .flatMap(l -> l.stream())
                .forEach(System.out::println);

        List<List<String>> teams = List.of(
                List.of("A", "B"),
                List.of("C", "D")
        );

        List<String> result = teams.stream()
                .flatMap(t -> t.stream())
                .collect(Collectors.toList());

        result.forEach(System.out::println);

        IntStream.rangeClosed(1, 5)
                .parallel()
                .forEach(i -> {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                });

        System.out.println();
        int sum = IntStream.range(1, 1000000)
                .parallel()
                .map(i -> i * 2)
                .sum();
        System.out.println(sum);
    }
}
