
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FaQProb1 {
    public static void main(String[] args) {
        removeDuplicates();
        longestCommonPrefix();
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

    public static void longestCommonPrefix() {
        String[] listOfNames = {"Asam", "Asammmm"};
        // Now we need to compare 1st and 2nd string
        String firstStr = listOfNames[0];
        String lastString = listOfNames[listOfNames.length - 1]; // last String
        int i = 0;
        while(i<firstStr.length() && i<lastString.length() && firstStr.charAt(i) == lastString.charAt(i)) { // untill both are equal len and same characters
            i++;
        }
        System.out.println("Longest Common Prefix: "+ firstStr.substring(0, i));
    }
}
