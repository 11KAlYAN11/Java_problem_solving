package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashingPatterns {
    /* ✅ PART 2 — “If you don’t know where to start, start with HashMap” — valid?
        YES — 100% VALID ADVICE ✅

        But here’s the correct reasoning:

        When you’re stuck, ask:

        “Can I rephrase this problem as counting something so far?”

        If yes → HashMap / Prefix Sum


        👉 ~80–90% of array/string problems are solvable using some COMBINATION of:

            Two Pointer

            Sliding Window

            Hashing

            Prefix Sum

            ⚠️ Prefix Sum is NOT separate —
            it usually works WITH HashMap or Sliding Window.
     */

    /* =========================================================
       1️⃣ COUNT FREQUENCY OF ELEMENTS (BEGINNER)
       ========================================================= */
    static void countFrequency(int[] arr) {
        // HashMap<element, frequency>
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Put all elements into map
        for (int x : arr) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        // Step 2: Iterate using entrySet
        System.out.println("Frequency Count:");
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    /* =========================================================
       2️⃣ FIND DUPLICATE ELEMENTS (BEGINNER)
       ========================================================= */
    static void printDuplicates(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int x : arr) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        System.out.println("Duplicate Elements:");
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) { // frequency > 1 means duplicate
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }

    /* =========================================================
       3️⃣ FIRST REPEATING ELEMENT (ORDER PRESERVED)
       👉 LinkedHashMap keeps insertion order
       ========================================================= */
    static void firstRepeatingElement(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        System.out.println("First Repeating Element:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
                break; // first repeating only
            }
        }
        System.out.println();
    }

    /* =========================================================
       4️⃣ SUBARRAY WITH SUM = K (INTERMEDIATE)
       👉 Prefix Sum + HashMap
       ========================================================= */
    static boolean subarraySumEqualsK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: sum from index 0 to i
            if (prefixSum == k) return true;

            // Case 2: sum between two indices
            if (map.containsKey(prefixSum - k)) {
                return true;
            }

            // Store prefix sum
            map.put(prefixSum, i);
        }
        return false;
    }

    /* =========================================================
       5️⃣ COUNT DISTINCT ELEMENTS IN EVERY WINDOW (SLIDING WINDOW)
       ========================================================= */
    static ArrayList<Integer> countDistinctInWindow(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {

            // Add current element
            freqMap.put(arr[fast], freqMap.getOrDefault(arr[fast], 0) + 1);

            // When window size becomes k
            if (fast - slow + 1 == k) {

                // Number of distinct elements = map size
                result.add(freqMap.size());

                // Remove outgoing element
                freqMap.put(arr[slow], freqMap.get(arr[slow]) - 1);
                if (freqMap.get(arr[slow]) == 0) {
                    freqMap.remove(arr[slow]);
                }
                slow++; // slide window
            }
        }
        return result;
    }

    /* =========================================================
       6️⃣ LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
       👉 Variable size sliding window + HashSet
       ========================================================= */
    static int longestUniqueSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int slow = 0;
        int maxLen = 0;

        for (int fast = 0; fast < s.length(); fast++) {

            // If duplicate found → shrink window
            while (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            }

            // Expand window
            set.add(s.charAt(fast));

            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        return maxLen;
    }

    /* =========================================================
       🔚 MAIN METHOD WITH WELL-KNOWN TEST CASES
       ========================================================= */
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 3, 5};

        countFrequency(arr);
        printDuplicates(arr);
        firstRepeatingElement(arr);

        int[] sumArr = {1, 4, 20, 3, 10, 5};
        System.out.println("Subarray sum = 33 exists? "
                + subarraySumEqualsK(sumArr, 33));
        System.out.println();

        int[] windowArr = {1, 2, 1, 3, 4, 2, 3};
        System.out.println("Distinct in windows of size 4:");
        System.out.println(countDistinctInWindow(windowArr, 4));
        System.out.println();

        String s = "geeksforgeeks";
        System.out.println("Longest unique substring length:");
        System.out.println(longestUniqueSubstring(s));
    }
}
