package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashingPatterns1 {


    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println("Has Two sum: " + hasTwoSumSet(arr, 9)); // Hash set + prefix sum

        int[] arr2 = {1, 5, 7, -1, 5};
        System.out.println("Count of 2 Sums: "+ countTwoSum(arr2, 6)); // Count of all possible (duplicates allowed)
        System.out.println("Count of 2 Sums: "+ hasTwoSumSorted(arr2, 6)); // As array was sortable we can via 2 Pointer technique
        
        // -------------------------------
    // Test Case 1: Basic zero target
    // -------------------------------
    int[] arr1 = {0, -1, 2, -3, 1};
    int target1 = 0;

    System.out.println("Has Triplet (Boolean): " +
            hasThreeSumCount(arr1, target1));
    // true → (-1, 0, 1)

    System.out.println("Unique Triplet Values: " +
            tripletValuesUnique(arr1, target1));
    // [[-1, 0, 1], [-3, 1, 2]]

    // -------------------------------
    // Test Case 2: Target not zero
    // -------------------------------
    int[] arrx = {1, 2, -2, 0, -1, 1};
    int target2 = 1;

    System.out.println("\nHas Triplet (Boolean): " +
            hasThreeSumCount(arrx, target2));
    // true → (-2, 1, 2)

    System.out.println("Unique Triplet Values: " +
            tripletValuesUnique(arr2, target2));
    // [[-2, 1, 2], [-1, 0, 2]]

    // -------------------------------
    // Test Case 3: All duplicates
    // -------------------------------
    int[] arr3 = {0, 0, 0, 0};
    int target3 = 0;

    System.out.println("\nHas Triplet (Boolean): " +
            hasThreeSumCount(arr3, target3));
    // true

    System.out.println("Unique Triplet Values: " +
            tripletValuesUnique(arr3, target3));
    // [[0, 0, 0]]

    // -------------------------------
    // Test Case 4: No possible triplet
    // -------------------------------
    int[] arr4 = {5, 7, 9, 11};
    int target4 = 10;

    System.out.println("\nHas Triplet (Boolean): " +
            hasThreeSumCount(arr4, target4));
    // false

    System.out.println("Unique Triplet Values: " +
            tripletValuesUnique(arr4, target4));
    // []
}

    static boolean hasTwoSumSet(int[] arr, int target) {

        /* for i = 0 to n-1
        for j = i+1 to n-1
        if arr[i] + arr[j] == target
            return true


            arr = [2, 7, 11, 15]
            target = 9

            x=2 → need=7 → not in set → add 2
            x=7 → need=2 → FOUND → return true
         */
        Set<Integer> seen = new HashSet<>();

        for (int x : arr) {
            int need = target - x;

            if (seen.contains(need)) {
                return true; // pair found
            }

            seen.add(x);
        }
        return false;
    }

    static int countTwoSum(int[] arr, int target) {
        /*
        arr = [1, 5, 7, -1, 5]
        target = 6

        Pairs:
        (1,5), (1,5), (7,-1)
        → count = 3
         */
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int x : arr) {
            int need = target - x;

            count += map.getOrDefault(need, 0);

            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return count;
    }

    static boolean hasTwoSumSorted(int[] arr, int target) {
        /* 6️⃣ Optimized approach #2 — TWO POINTER (SORTED ARRAY)
            When to use?

            Array is sorted or allowed to sort

            Want O(1) space

            Need pairs / closest / triplets later

            🧠 Idea
            left = 0
            right = n-1

            while left < right:
                sum = arr[left] + arr[right]

                if sum == target → FOUND
                if sum < target → left++
                if sum > target → right--

                Why pointer movement works (CRITICAL)

                Sorted array

                Increasing left → increases sum

                Decreasing right → decreases sum

                This is greedy + two pointer
         */
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static boolean hasThreeSumCount(int[] arr, int target) {
        // As here we do need count so will go for hash set
        // As 3 pairs sum so will fix the arr[i] and j will run in side
        HashSet<Integer> seen = new HashSet<>(); // just for boolean value so set
        // boolean hasTriplet = false;
        int n = arr.length;

        // here i go till n-3 means after i there should be 2 elements left always as i<j<k ..
        for(int i=0; i<n-2; i++) { // arr of i was fixed
            // a+b+c = 0
            // c = -a-b
            // a+b+c = target
            // c = target -a -b; as maths 
            for(int j=i+1; j<n; j++) { // As j every time start from just before ith element
                // int need = - arr[i] - arr[j]; // By default 0 was considered
                int need = target - arr[i] - arr[j]; // If target was not zero

                if(seen.contains(need)) { // found the pair count++;
                    return true; // found the pair
                }
                seen.add(arr[j]);
            }
        }
        return false;
    }

    public static List<List<Integer>> tripletValuesUnique(int[] arr, int tar) {
        // Will take nested set<List<>> bcz for inner list we have to sort so order matters, for outer we need such unique pairs
        Set<List<Integer>> set = new HashSet<>();
        //Now outer loop stop just before the last 3 ele's so
        int n= arr.length;

        for(int i=0; i<n-2; i++) {
            // From here approx same as 2 sum as outer ith loop was fixed
            HashSet<Integer> seen = new HashSet<>();

            for(int j=i+1; j<n; j++) {
                // a+b+c = target
                // c = target -a -b; as maths 
                int need = tar - arr[i] - arr[j];
                if(seen.contains(need)) {
                    // found such pair, so as this as sorted list to set
                    List<Integer> list = Arrays.asList(arr[i], arr[j], need);
                    Collections.sort(list);
                    set.add(list);
                }

                // Now we have to add that ele to seen set
                seen.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

}
