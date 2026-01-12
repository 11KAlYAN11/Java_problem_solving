package General_Problems;

import java.util.HashMap;
import java.util.HashSet;

public class PairSumUsingHashing {
    

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;

        System.out.println("Pair exists? : " + hasPairWithSum(arr, target));
        System.out.println("Total pair count : " + countPairsWithSum(arr, target));
    }

    /**
     * 🧠 ONE-LINE MATH RULE (REMEMBER THIS FOREVER)
        If a + b = target
        then b = target - a
        
     * ---------------------------------------------------------
     * METHOD 1: CHECK IF AT LEAST ONE PAIR EXISTS (BOOLEAN)
     * ---------------------------------------------------------
     *
     * Problem:
     * Given an unsorted array, check whether there exists
     * any pair (i, j) such that:
     *
     *      arr[i] + arr[j] == target
     *
     * Approach:
     * We use a HashSet to store numbers we have already seen.
     *
     * Math Strategy:
     * If current number is x,
     * we need another number = (target - x)
     *
     * Example:
     * target = 6
     * current = 2
     * needed = 6 - 2 = 4
     *
     * If 4 already exists in the set → pair found.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static boolean hasPairWithSum(int[] arr, int target) {

        HashSet<Integer> seen = new HashSet<>();

        for (int x : arr) {

            // Core math logic:
            // If x + y = target, then y = target - x
            int needed = target - x;

            // Check if required value is already seen
            if (seen.contains(needed)) {
                return true; // Pair exists
            }

            // Store current number for future checks
            seen.add(x);
        }

        // No valid pair found
        return false;
    }

    /**
     * ---------------------------------------------------------
     * METHOD 2: COUNT ALL POSSIBLE PAIRS
     * ---------------------------------------------------------
     *
     * Problem:
     * Count all pairs (i, j) such that:
     *
     *      arr[i] + arr[j] == target
     *      i < j
     *
     * Array may contain duplicates.
     *
     * Approach:
     * We use a HashMap to store frequency of elements.
     *
     * Why HashMap and NOT HashSet?
     * - HashSet only tells if a value exists
     * - HashMap tells HOW MANY TIMES it exists
     *
     * Math Strategy:
     * For current value x,
     * we need (target - x).
     *
     * If (target - x) has appeared k times already,
     * then current x can form k new pairs.
     *
     * Example:
     * arr = [1, 5, 5], target = 6
     *
     * When x = second 5:
     * needed = 1
     * freq[1] = 1
     * → count += 1
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int countPairsWithSum(int[] arr, int target) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int x : arr) {

            // Core math logic:
            // x + needed = target
            // needed = target - x
            int needed = target - x;

            // If needed exists, it forms pairs with current x
            if (freqMap.containsKey(needed)) {
                count += freqMap.get(needed);
            }

            // Update frequency of current element
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        return count;
    }
}

