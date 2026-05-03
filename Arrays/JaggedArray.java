package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class JaggedArray { 
    public static void main(String[] args) {
        // Jagged Arrays or irregular Arrays
        int[][] jaggedArray = {
            {1,2,3},
            {4,5},
            {6,7,8,9}
        };

        int[][] jgarr = Stream.of(
            new int[]{1,2,3},
            new int[]{4,5},
            new int[]{6,7,8,9})
            .toArray(int[][]::new);

            Arrays.stream(jgarr).flatMapToInt(row -> Arrays.stream(row).map(x -> x*2)).forEach(System.out::print);
        /* Arrays.stream(jaggedArray)
        .forEach(row -> {
            Arrays.stream(row)
            .forEach(element -> System.out.print(element+ " "));

            System.out.println();
        }); */

        Arrays.stream(jaggedArray)
        .forEach(row -> {
            Arrays.stream(row)
            .forEach(element -> System.out.print(element +" "));

            System.out.println();
        }
        );
    }
    
}
