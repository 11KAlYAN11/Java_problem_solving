package General_Problems;

import java.util.Arrays;

public class EquilibriumIndex {

    // =========================
    // 1️⃣ Brute Force Approach
    // =========================
    // Time: O(n^2), Space: O(1)
    // Idea: For each index, compute left sum and right sum from scratch
    public static int findEquilibriumBruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;

            // Sum of elements before i
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            // Sum of elements after i
            for (int j = i + 1; j < n; j++) {
                rightSum += arr[j];
            }

            // Check equilibrium
            if (leftSum == rightSum) {
                // Dry run example:
                // arr = [1,3,5,2,2], i=2
                // leftSum = 1+3=4, rightSum=2+2=4 ✅ equilibrium
                return i;
            }
        }

        return -1; // no equilibrium
    }

    // ========================================
    // 2️⃣ Prefix + Suffix Arrays Approach
    // ========================================
    // Time: O(n), Space: O(n)
    // Idea: precompute left (prefix) sums and right (suffix) sums
    public static int findEquilibriumPrefixSuffix(int[] arr) {
        int n = arr.length;
        int[] pref = new int[n];
        int[] suff = new int[n];

        // Initialize
        pref[0] = arr[0];
        suff[n - 1] = arr[n - 1];

        // Build prefix sums
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + arr[i];
        }

        // Build suffix sums
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + arr[i];
        }

        // Compare prefix and suffix sums
        for (int i = 0; i < n; i++) {
            if (pref[i] == suff[i]) {
                // Dry run:
                // arr = [1,3,5,2,2]
                // pref = [1,4,9,11,13]
                // suff = [13,12,9,4,2]
                // i=2: pref[2]=9, suff[2]=9 ✅ equilibrium
                return i;
            }
        }

        return -1;
    }

    // ========================================
    // 3️⃣ Single-pass Optimized Approach
    // ========================================
    // Time: O(n), Space: O(1)
    // Mental picture:
    // total = leftSum + arr[pivot] + rightSum
    // rightSum = total - leftSum - arr[pivot]
    // If leftSum == rightSum → equilibrium
    public static int findEquilibriumOptimized(int[] arr) {
        int n = arr.length;
        int total = 0;
        int leftSum = 0;

        // Step 1: Compute total sum
        for (int ele : arr) total += ele;

        // Step 2: Iterate pivot index
        for (int pivot = 0; pivot < n; pivot++) {
            int rightSum = total - leftSum - arr[pivot];

            // Dry run snapshot:
            // arr = [1,3,5,2,2], total=13
            // pivot=2 → leftSum=4, arr[2]=5
            // rightSum=13-4-5=4 ✅ equilibrium

            if (leftSum == rightSum) return pivot;

            leftSum += arr[pivot]; // update leftSum for next pivot
        }

        return -1;
    }

    // ========================
    // Main Method for Testing
    // ========================
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};

        System.out.println("Brute Force Index: " + findEquilibriumBruteForce(arr));
        System.out.println("Prefix-Suffix Index: " + findEquilibriumPrefixSuffix(arr));
        System.out.println("Optimized Single-Pass Index: " + findEquilibriumOptimized(arr));
    }
}

