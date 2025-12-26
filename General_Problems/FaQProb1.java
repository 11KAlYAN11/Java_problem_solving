
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FaQProb1 {
    public static void main(String[] args) {
        removeDuplicates();
    }

    public static void removeDuplicates() {
        // General method via converting to Set
        int[] arr1 = {2,4,6,8,6,2,4,5};
        Set<Integer> set = new HashSet<>(); // If you want order youcan use LinkedHashSet
        for(int dig : arr1) {
            set.add(dig);
        } // Now set is unique by default
        set.forEach(System.out::print);

        // By using streams
        int[] unique = Arrays.stream(arr1).distinct().toArray();
        System.out.println();
        for(int uni: unique) {
            System.out.print(uni+" ");
        }

        // Using boolean Seen
        boolean[] seen = new boolean[100]; // it is capable till 100 values "limited use cases"
        System.out.println();
        for(int se: arr1) {
            if(!seen[se]) {
                System.out.println(se);
                seen[se] = true; // now marked that position as seen
            }
        }
        
    }
}
