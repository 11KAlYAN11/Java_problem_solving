package Algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            prefixSum += num; // Main step as prefix say we have to sum all prefix[i] = prefix[i-1] + prefix[i-2]..

            // Case 1: subarray from index 0 itself
            if (prefixSum == k) return true;

            /*
                a + b = k
                b = k - a  -> as maths)
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

    /*
        Map stores:
        key   → prefixSum
        value → how many times this prefixSum has appeared so far
    */
    Map<Integer, Integer> map = new HashMap<>();

    /*
        🔥 MOST IMPORTANT INITIALIZATION 🔥

        prefixSum = 0 before starting the array
        We say it has occurred ONCE.

        Why?
        To correctly count subarrays that START from index 0.

        Example:
        arr = [3, ...], k = 3

        prefixSum at index 0 = 3
        prefixSum - k = 0

        If 0 is not in map → we MISS this valid subarray

        So What if first ele in arr == k in that case arr[0] - k == 0 Which is valid so arr[0] - k = 0 bcz both are equal so we store the same zero to make sure won't miss the first valid one
    */
    map.put(0, 1); // 🔥 WHY map.put(0,1) IS NON-NEGOTIABLE

    int prefixSum = 0; // running sum from start
    int count = 0;     // total subarrays with sum = k

    for (int num : arr) {

        // Step 1: Update prefix sum
        prefixSum += num;

        /*
            Step 2: Check if (prefixSum - k) exists

            If yes:
            → There exists a previous prefixSum such that
              currentPrefixSum - previousPrefixSum = k

            → Each occurrence gives ONE valid subarray ending here

            3️⃣ Subarray math (step-by-step)

            Assume:

            prefixSum[j] = sum from 0 → j

            prefixSum[i-1] = sum from 0 → i-1

            Then:

            subarray(i → j) = prefixSum[j] - prefixSum[i-1]


            We want:

            prefixSum[j] - prefixSum[i-1] = k


            Rearranging:

            prefixSum[i-1] = prefixSum[j] - k


🔥 THIS is where prefixSum - k comes from
        */
        count += map.getOrDefault(prefixSum - k, 0);

        /*
            Step 3: Store current prefixSum in map
            (for future subarrays)
        */
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }

    return count;

    /*
                DRY RUN
                ========
                arr = {1, -1, 3, 2, -2, 4}
                k = 3

                INITIAL STATE:
                --------------
                prefixSum = 0
                count = 0
                map = { 0 = 1 }   // IMPORTANT: empty prefix before array starts


                ITERATION 1:
                ------------
                num = 1
                prefixSum = 0 + 1 = 1

                prefixSum - k = 1 - 3 = -2
                map does NOT contain -2
                count = 0

                Add current prefixSum to map
                map = { 0=1, 1=1 }


                ITERATION 2:
                ------------
                num = -1
                prefixSum = 1 + (-1) = 0

                prefixSum - k = 0 - 3 = -3
                map does NOT contain -3
                count = 0

                Add current prefixSum to map
                map = { 0=2, 1=1 }


                ITERATION 3:
                ------------
                num = 3
                prefixSum = 0 + 3 = 3

                prefixSum - k = 3 - 3 = 0
                map CONTAINS 0 with frequency 2

                count += 2   // subarrays:
                            // [1, -1, 3]
                            // [3]

                count = 2

                Add current prefixSum to map
                map = { 0=2, 1=1, 3=1 }


                ITERATION 4:
                ------------
                num = 2
                prefixSum = 3 + 2 = 5

                prefixSum - k = 5 - 3 = 2
                map does NOT contain 2
                count = 2

                Add current prefixSum to map
                map = { 0=2, 1=1, 3=1, 5=1 }


                ITERATION 5:
                ------------
                num = -2
                prefixSum = 5 + (-2) = 3

                prefixSum - k = 3 - 3 = 0
                map CONTAINS 0 with frequency 2

                count += 2   // subarrays:
                            // [1, -1, 3, 2, -2]
                            // [3, 2, -2]

                count = 4

                Add current prefixSum to map
                map = { 0=2, 1=1, 3=2, 5=1 }


                ITERATION 6:
                ------------
                num = 4
                prefixSum = 3 + 4 = 7

                prefixSum - k = 7 - 3 = 4
                map does NOT contain 4
                count = 4

                Add current prefixSum to map
                map = { 0=2, 1=1, 3=2, 5=1, 7=1 }


                FINAL RESULT:
                -------------
                Total subarrays with sum = k is 4
                */

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

    /*
        Map stores:
        key   → prefixSum
        value → FIRST index where this prefixSum appeared

        Why first index?
        Because for longest subarray, we want the EARLIEST occurrence
    */
    Map<Integer, Integer> map = new HashMap<>();

    int prefixSum = 0;
    int maxLen = 0;

    /*
        🔥 VERY IMPORTANT INITIALIZATION 🔥

        prefixSum = 0 at index -1 (before array starts)

        This allows subarrays that START from index 0
        Example:
        arr = [3, ...], k = 3

        At i = 0:
        prefixSum = 3
        prefixSum - k = 0
        length = 0 - (-1) = 1  ✔
    */
    map.put(0, -1);

    for (int i = 0; i < arr.length; i++) {

        // Step 1: Update prefix sum
        prefixSum += arr[i];

        /*
            Step 2: Check if (prefixSum - k) exists

            If yes:
            subarray sum from (map.get(prefixSum - k) + 1) to i = k
            length = i - map.get(prefixSum - k)
        */
        if (map.containsKey(prefixSum - k)) {
            int len = i - map.get(prefixSum - k);
            maxLen = Math.max(maxLen, len);
        }

        /*
            Step 3: Store prefixSum ONLY if not already present

            Why?
            Because:
            - earlier index → longer subarray
            - we NEVER want to overwrite it
        */
        map.putIfAbsent(prefixSum, i);
    }

    return maxLen;

    /* 🧠 CORE DIFFERENCE FROM COUNT VERSION
        Problem	Map stores
        Count subarrays	prefixSum → frequency
        Longest subarray	prefixSum → first index
        DRY RUN
                ========
                arr = {1, -1, 3, 2, -2, 4}
                k = 3

                INITIAL STATE:
                --------------
                prefixSum = 0
                maxLen = 0
                map = { 0 = -1 }   // prefix sum before array starts


                ITERATION 1:
                ------------
                i = 0
                arr[i] = 1
                prefixSum = 0 + 1 = 1

                prefixSum - k = 1 - 3 = -2
                map does NOT contain -2
                maxLen = 0

                Store prefixSum if absent
                map = { 0=-1, 1=0 }


                ITERATION 2:
                ------------
                i = 1
                arr[i] = -1
                prefixSum = 1 + (-1) = 0

                prefixSum - k = 0 - 3 = -3
                map does NOT contain -3
                maxLen = 0

                prefixSum = 0 already exists → DO NOT overwrite
                map = { 0=-1, 1=0 }


                ITERATION 3:
                ------------
                i = 2
                arr[i] = 3
                prefixSum = 0 + 3 = 3

                prefixSum - k = 3 - 3 = 0
                map CONTAINS 0 at index -1

                len = 2 - (-1) = 3
                subarray = [1, -1, 3]

                maxLen = 3

                Store prefixSum
                map = { 0=-1, 1=0, 3=2 }


                ITERATION 4:
                ------------
                i = 3
                arr[i] = 2
                prefixSum = 3 + 2 = 5

                prefixSum - k = 5 - 3 = 2
                map does NOT contain 2
                maxLen = 3

                Store prefixSum
                map = { 0=-1, 1=0, 3=2, 5=3 }


                ITERATION 5:
                ------------
                i = 4
                arr[i] = -2
                prefixSum = 5 + (-2) = 3

                prefixSum - k = 3 - 3 = 0
                map CONTAINS 0 at index -1

                len = 4 - (-1) = 5
                subarray = [1, -1, 3, 2, -2]

                maxLen = 5

                prefixSum = 3 already exists → DO NOT overwrite
                map = { 0=-1, 1=0, 3=2, 5=3 }


                ITERATION 6:
                ------------
                i = 5
                arr[i] = 4
                prefixSum = 3 + 4 = 7

                prefixSum - k = 7 - 3 = 4
                map does NOT contain 4
                maxLen = 5

                Store prefixSum
                map = { 0=-1, 1=0, 3=2, 5=3, 7=5 }


                FINAL RESULT:
                -------------
                Longest subarray length with sum = k is 5
        */
}

 public static int subarraySumDivisibleByK(int[] arr, int k) {

    /*
     * PROBLEM:
     * Count all subarrays whose sum is divisible by K.
     *
     * KEY OBSERVATION:
     *
     * Let:
     * prefixSum[j] = sum till j
     * prefixSum[i] = sum till i
     *
     * Subarray sum = prefixSum[j] - prefixSum[i]
     *
     * We need:
     * (prefixSum[j] - prefixSum[i]) % k == 0
     *
     * Therefore:
     * prefixSum[j] % k == prefixSum[i] % k
     *
     * So instead of storing prefix sums,
     * we store REMAINDERS and count how many
     * times the same remainder has appeared.
     *
     * --------------------------------------------------
     * COMMON MISTAKES I MADE:
     * --------------------------------------------------
     *
     * 1) Stored prefixSum as key instead of remainder.
     *
     * Wrong:
     * map.put(prefixSum, ...)
     *
     * Correct:
     * map.put(rem, ...)
     *
     * --------------------------------------------------
     *
     * 2) Negative remainder issue in Java.
     *
     * Java:
     * -1 % 5 = -1
     *
     * But mathematically:
     * -1 mod 5 = 4
     *
     * Therefore normalize:
     *
     * rem = ((prefixSum % k) + k) % k
     *
     * --------------------------------------------------
     *
     * 3) Applied normalization only during lookup.
     *
     * Wrong:
     * containsKey(normalizedRem)
     * put(rawRem)
     *
     * Same remainder class becomes different keys.
     *
     * Must use SAME rem everywhere:
     * containsKey(rem)
     * get(rem)
     * put(rem)
     *
     * --------------------------------------------------
     *
     * 4) Integer overflow.
     *
     * Hidden test cases contain very large numbers.
     *
     * prefixSum can exceed Integer.MAX_VALUE.
     *
     * Therefore:
     * long prefixSum
     *
     * count can also become huge.
     *
     * Therefore:
     * long count
     *
     * --------------------------------------------------
     *
     * PATTERN RECOGNITION:
     *
     * Subarray Sum = 0
     * -> Same Prefix Sum
     *
     * Subarray Sum = K
     * -> prefixSum - K
     *
     * Subarray Sum Divisible By K
     * -> Same Remainder
     */

    HashMap<Integer, Integer> map = new HashMap<>();

    long prefixSum = 0;
    long count = 0;

    // Handles subarrays starting from index 0
    map.put(0, 1);

    for (int num : arr) {

        prefixSum += num;

        int rem = (int)(((prefixSum % k) + k) % k);

        // All previous occurrences of this remainder
        // form valid subarrays ending here
        if (map.containsKey(rem)) {
            count += map.get(rem);
        }

        map.put(rem, map.getOrDefault(rem, 0) + 1);
    }

    return (int) count;
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
                + countSubarraysWithSum(arr2, 3)); // multiple // count = 4

        System.out.println("Longest subarray with sum 3: "
                + longestSubarrayWithSum(arr2, 3)); // length // 

        int[] arr3 = {4, 5, 0, -2, -3, 1};
        System.out.println("Subarray Sum Divisible By K: "+ subarraySumDivisibleByK(arr3, 5));        
    }
}
