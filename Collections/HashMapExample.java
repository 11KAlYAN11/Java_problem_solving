package Collections;

import java.util.*;

public class HashMapExample {
    public static List<Integer> findDuplicates(int[] arr) {
        // Step 1: Create a HashMap to count occurrences
        HashMap<Integer, Integer> counts = new HashMap<>();

        // Step 2: Count occurrences of each element in the array
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1); //
//here we are inserting that key, values & at a time if same key found i ncrementions the value
       
        }

        // Step 3: Filter elements that occur more than once
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        // Step 4: Return the list of duplicates
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 3};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates); // Output: [2, 3]


        Set<Integer> set1 = new HashSet<>();
        int[] arr1 = {4,5,6,3,2,5,6,7,4,7,7};
        int[] arr2 = {10,10,10,11}; // try with 10,10,10 u won't get anything
        List<Integer> res1 = new ArrayList<>();
        for(int i : arr2) {
            set1.add(i);
        }
        res1.addAll(set1);
        if(res1.size() > 1) { //compare with set1 or res1 no problem
            Collections.sort(res1, Collections.reverseOrder());
            //Collections.sort(res1);
            //Collections.reverse(res1);
            //System.out.println(res1);
            System.out.println("Largest is: "+res1.get(0));
            System.out.println("Scond largest is: "+res1.get(1));
        }

        Arrays.sort(arr1);
       
        // System.out.println("Largest is: "+arr1[arr1.length-1]); // last element in array after sorting in largest
        // System.out.println("Scond largest is: "+arr1[arr1.length-2]); // Last but one in second largest in the array.
    }
}
