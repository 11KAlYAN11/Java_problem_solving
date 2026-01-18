package Algorithms;

import java.util.*;

/*
    ============================================
    PREFIX SUM MASTER CLASS (BEGINNER → INTERMEDIATE)
    ============================================

    Patterns covered:
    1) Prefix Sum + Set       → Boolean problems
    2) Prefix Sum + HashMap   → Count / Longest problems

    GOLDEN RULE:
    If array has NEGATIVE numbers → Sliding window FAILS → Prefix Sum WINS
*/

public class PrefixSumPatterns {

    /* =====================================================
       BEGINNER METHOD 1
       -----------------------------------------------------
       Check if ANY subarray with sum = K exists (YES / NO)
       -----------------------------------------------------
       Technique: Prefix Sum + HashSet
       Why Set?
       - We only care if something exists
       - We don't care how many times
    ===================================================== */
    static boolean hasSubarrayWithSum(int[] arr, int k) {

        // Set stores prefix sums we have already seen
        Set<Integer> seen = new HashSet<>();

        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            // Case 1: subarray from index 0 itself
            if (prefixSum == k) return true;

            /*
                Core logic:
                If prefixSum - k was seen before,
                then there exists a subarray with sum = k
            */
            if (seen.contains(prefixSum - k)) return true;

            // Store current prefix sum
            seen.add(prefixSum);
        }
        return false;
    }

    /* =====================================================
       BEGINNER METHOD 2
       -----------------------------------------------------
       Check if ZERO sum subarray exists
       -----------------------------------------------------
       Special case of Method 1 where k = 0
       Technique: Prefix Sum + Set
    ===================================================== */
    static boolean hasZeroSumSubarray(int[] arr) {

        Set<Integer> seen = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;

            /*
                If prefixSum repeats → sum between them = 0
            */
            if (prefixSum == 0 || seen.contains(prefixSum)) {
                return true;
            }
            seen.add(prefixSum);
        }
        return false;
    }

    /* =====================================================
       INTERMEDIATE METHOD 1
       -----------------------------------------------------
       Count total subarrays with sum = K
       -----------------------------------------------------
       Technique: Prefix Sum + HashMap
       Why HashMap?
       - We must COUNT how many times prefixSum occurs
    ===================================================== */
    static int countSubarraysWithSum(int[] arr, int k) {

        // Map: prefixSum → how many times it occurred
        Map<Integer, Integer> map = new HashMap<>();

        /*
            VERY IMPORTANT LINE 🔥
            prefixSum = 0 occurs once before array starts
            This handles subarrays starting from index 0
        */
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            /*
                If (prefixSum - k) exists in map,
                it means that many subarrays end here with sum = k
            */
            count += map.getOrDefault(prefixSum - k, 0);

            // Store/update prefix sum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    /* =====================================================
       INTERMEDIATE METHOD 2
       -----------------------------------------------------
       Longest subarray with sum = K
       -----------------------------------------------------
       Technique: Prefix Sum + HashMap
       Store FIRST occurrence of prefixSum
    ===================================================== */
    static int longestSubarrayWithSum(int[] arr, int k) {

        // Map: prefixSum → first index where it appeared
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        // prefixSum 0 at index -1 (before array starts)
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            /*
                If prefixSum - k exists,
                subarray length = currentIndex - storedIndex
            */
            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            /*
                Store prefixSum ONLY if not seen before
                (We want longest length → earliest index)
            */
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }

    /* =====================================================
       MAIN METHOD — TEST EVERYTHING
    ===================================================== */
    public static void main(String[] args) {

        int[] arr1 = {4, 2, -3, 1, 6};
        int[] arr2 = {1, -1, 3, 2, -2, 4};

        System.out.println("Has subarray with sum 0: "
                + hasSubarrayWithSum(arr1, 0)); // true

        System.out.println("Has zero sum subarray: "
                + hasZeroSumSubarray(arr1)); // true

        System.out.println("Count subarrays with sum 3: "
                + countSubarraysWithSum(arr2, 3)); // multiple

        System.out.println("Longest subarray with sum 3: "
                + longestSubarrayWithSum(arr2, 3)); // length
    }
}
