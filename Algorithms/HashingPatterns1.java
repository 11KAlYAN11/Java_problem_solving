package Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashingPatterns1 {


    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println("Has Two sum: " + hasTwoSumSet(arr, 9)); // Hash set + prefix sum

        int[] arr2 = {1, 5, 7, -1, 5};
        System.out.println("Count of 2 Sums: "+ countTwoSum(arr2, 6)); // Count of all possible (duplicates allowed)
        System.out.println("Count of 2 Sums: "+ hasTwoSumSorted(arr2, 6)); // As array was sortable we can via 2 Pointer technique
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

}
