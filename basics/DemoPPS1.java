package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * ============================================================
 * DSA PPS-5 NOTES
 * ============================================================
 *
 * Problems Covered:
 * 1. First Repeating Element
 * 2. Two Sum - Unique Pairs with Sum = 0
 *
 * ------------------------------------------------------------
 * Problem 1: First Repeating Element
 * ------------------------------------------------------------
 *
 * Example:
 *
 * arr = [1, 5, 3, 4, 3, 5, 6]
 *
 * Frequencies:
 * 1 -> 1
 * 5 -> 2
 * 3 -> 2
 * 4 -> 1
 * 6 -> 1
 *
 * Repeating Elements:
 * 5, 3
 *
 * First occurrence indexes:
 * 5 -> index 2 (1-based)
 * 3 -> index 3 (1-based)
 *
 * Answer = 2
 *
 * Approach:
 *
 * 1. Store frequencies in LinkedHashMap
 *    (preserves insertion order)
 *
 * 2. First element whose frequency > 1
 *    is our repeating element.
 *
 * 3. Traverse original array and return
 *    its first occurrence position.
 *
 * Complexity:
 * Time  : O(n)
 * Space : O(n)
 *
 *
 * ------------------------------------------------------------
 * Problem 2: Unique Pairs with Sum = 0
 * ------------------------------------------------------------
 *
 * Example:
 *
 * arr = [-1,0,1,2,-1,-4]
 *
 * Valid Pairs:
 *
 * (-1,1)
 * (1,-1)
 *
 * Unique Pair:
 *
 * [-1,1]
 *
 * ------------------------------------------------------------
 *
 * Why Math.min / Math.max ?
 *
 * Suppose:
 *
 * arr = [1,-1]
 *
 * Pair becomes:
 *
 * [1,-1]
 *
 * But expected:
 *
 * [-1,1]
 *
 * So normalize:
 *
 * pair.add(Math.min(a,b));
 * pair.add(Math.max(a,b));
 *
 * This guarantees:
 *
 * [-1,1]
 * always
 *
 * ------------------------------------------------------------
 *
 * Why HashSet<ArrayList<Integer>> ?
 *
 * To avoid duplicate pairs.
 *
 * Example:
 *
 * arr = [-1,-1,-1,1,1]
 *
 * Pair found multiple times:
 *
 * [-1,1]
 * [-1,1]
 * [-1,1]
 *
 * HashSet keeps only one copy.
 *
 * Complexity:
 *
 * Brute Force:
 * Time  : O(n²)
 * Space : O(n)
 *
 * Better Approaches:
 * 1. HashSet
 * 2. Sort + Two Pointers
 *
 * ============================================================
 */

public class DemoPPS1 {

    public static void main(String[] args) {

        /*
         * ------------------------------------------------------
         * ConcurrentModificationException Demo
         * ------------------------------------------------------
         */

        List<Integer> list = new ArrayList<>();

        /*
         * This throws ConcurrentModificationException
         *
         * for(Integer i : list){
         *     list.add(10);
         * }
         *
         * Reason:
         * Enhanced for-loop internally uses Iterator.
         * Modifying collection while iterating
         * breaks fail-fast behavior.
         */

        /*
         * ------------------------------------------------------
         * First Repeating Element
         * ------------------------------------------------------
         */

        int[] arr1 = {1, 5, 3, 4, 3, 5, 6};

        System.out.println(
                "First Repeating Index = "
                        + firstRepeated(arr1));

        /*
         * Expected Output:
         * 2
         */

        /*
         * ------------------------------------------------------
         * Two Sum Pairs with Sum = 0
         * ------------------------------------------------------
         */

        int[] arr2 = {-1, 0, 1, 2, -1, -4};

        int[] arr3 = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};

        System.out.println(getPairs(arr2));

        /*
         * Expected:
         * [[-1,1]]
         */

        System.out.println(getPairs(arr3));

        /*
         * Expected:
         * [[-6,6],[-1,1]]
         */

        System.out.println(firstRepeated(arr3));
    }

    /*
     * ============================================================
     * First Repeating Element
     * ============================================================
     */
    public static int firstRepeated(int[] arr) {

        LinkedHashMap<Integer, Integer> freq =
                new LinkedHashMap<>();

        int repeatingElement = 0;

        // Count Frequencies
        for (int num : arr) {
            freq.put(num,
                    freq.getOrDefault(num, 0) + 1);
        }

        // Find first repeating element
        for (Map.Entry<Integer, Integer> entry :
                freq.entrySet()) {

            if (entry.getValue() > 1) {
                repeatingElement = entry.getKey();
                break;
            }
        }

        // Return first occurrence position (1-based)
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == repeatingElement) {
                return i + 1;
            }
        }

        return -1;
    }

    /*
     * ============================================================
     * Unique Pairs With Sum = 0
     * ============================================================
     */
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {

        HashSet<ArrayList<Integer>> uniquePairs =
                new HashSet<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] + arr[j] == 0) {

                    ArrayList<Integer> pair =
                            new ArrayList<>();

                    pair.add(Math.min(arr[i], arr[j]));

                    pair.add(Math.max(arr[i], arr[j]));

                    uniquePairs.add(pair);
                }
            }
        }

        ArrayList<ArrayList<Integer>> result =
                new ArrayList<>(uniquePairs);

        // Sort based on first element
        Collections.sort(result,
                (a, b) -> a.get(0) - b.get(0));

        return result;
    }

    public int firstNonRepeating(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>(); // As we need first non repeating so gng with LinkedHashMap but if we go iterating via arr we can with hash map also
        
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i: arr) {
            if(map.get(i) == 1) { // If only one time repeated that was that non repeating character
                return i;
            }
        }
        return 0;

    }
}