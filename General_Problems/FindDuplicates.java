package General_Problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int num: arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3, 4,4};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }
}
