package General_Problems;

public class PrefixMaxSuffixMinPattern {

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 7};

        System.out.println("Brute Force Result : "
                + findElementBruteForce(arr));

        System.out.println("Optimal Result     : "
                + findElementUsingPreprocessing(arr));
    }

    /*
     * ============================================================
     * PATTERN: Repeated Left & Right Validation
     * ============================================================
     *
     * Interview Thought Process
     * -------------------------
     *
     * Whenever every candidate requires checking BOTH sides,
     * first write the correct brute-force logic.
     *
     * Don't optimize immediately.
     *
     * Template:
     *
     * for(each candidate){
     *      check left
     *      check right
     *      if(valid) save answer
     * }
     *
     * Time  : O(n²)
     * Space : O(1)
     *
     * This approach teaches the validation pattern.
     */

    public static int findElementBruteForce(int[] arr) {

        int n = arr.length;
        int lastValidElement = -1;

        for (int currentIndex = 1; currentIndex < n - 1; currentIndex++) {

            boolean isValid = true;

            // -------------------------------
            // Check every element on LEFT.
            // -------------------------------

            for (int leftIndex = 0; leftIndex < currentIndex; leftIndex++) {

                if (arr[leftIndex] > arr[currentIndex]) {

                    isValid = false;
                    break;
                }
            }

            // -------------------------------
            // Check every element on RIGHT.
            // -------------------------------

            if (isValid) {

                for (int rightIndex = currentIndex + 1;
                     rightIndex < n;
                     rightIndex++) {

                    if (arr[rightIndex] < arr[currentIndex]) {

                        isValid = false;
                        break;
                    }
                }
            }

            // Keep updating so LAST valid element is returned.

            if (isValid)
                lastValidElement = arr[currentIndex];
        }

        /*
         * Dry Run
         *
         * arr = [4,2,5,7]
         *
         * Candidate = 2
         * Left check fails.
         *
         * Candidate = 5
         * Left passes.
         * Right passes.
         *
         * Answer = 5
         */

        return lastValidElement;
    }

    /*
     * ============================================================
     * PATTERN: Preprocessing
     *        (Prefix Max + Suffix Min)
     * ============================================================
     *
     * This is the optimization mindset.
     *
     * Instead of repeatedly asking:
     *
     *      What's the maximum on my LEFT?
     *      What's the minimum on my RIGHT?
     *
     * Build those answers ONCE.
     *
     * --------------------------------------
     * Prefix Max
     * --------------------------------------
     *
     * prefixMax[i]
     *      = Maximum value from index 0 to i.
     *
     * Example
     *
     * arr       = [4,2,5,7]
     * prefixMax = [4,4,5,7]
     *
     * --------------------------------------
     * Suffix Min
     * --------------------------------------
     *
     * suffixMin[i]
     *      = Minimum value from index i to end.
     *
     * Example
     *
     * suffixMin = [2,2,5,7]
     *
     * --------------------------------------
     * Final Trick
     * --------------------------------------
     *
     * For every i:
     *
     *      prefixMax[i-1]
     *      suffixMin[i+1]
     *
     * are already the answers.
     *
     * No scanning.
     * Only lookup.
     *
     * Time:
     *
     * Prefix Build : O(n)
     * Suffix Build : O(n)
     * Final Check  : O(n)
     *
     * Total = O(3n)
     * Big-O ignores constants.
     *
     * Final Complexity = O(n)
     */

    public static int findElementUsingPreprocessing(int[] arr) {

        int n = arr.length;

        if (n < 3)
            return -1;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        // ----------------------------------
        // Build Prefix Max
        // ----------------------------------

        prefixMax[0] = arr[0];

        for (int i = 1; i < n; i++) {

            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        // ----------------------------------
        // Build Suffix Min
        // ----------------------------------

        suffixMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }

        int lastValidElement = -1;

        // ----------------------------------
        // Final Validation
        // ----------------------------------
        //
        // Current element never compares
        // with itself.
        //
        // LEFT  -> prefixMax[i-1]
        // RIGHT -> suffixMin[i+1]
        //

        for (int currentIndex = 1;
             currentIndex < n - 1;
             currentIndex++) {

            if (prefixMax[currentIndex - 1] <= arr[currentIndex]
                    &&
                suffixMin[currentIndex + 1] >= arr[currentIndex]) {

                lastValidElement = arr[currentIndex];
            }
        }

        /*
         * Complete Dry Run
         *
         * arr = [4,2,5,7]
         *
         * prefixMax = [4,4,5,7]
         * suffixMin = [2,2,5,7]
         *
         * currentIndex = 1
         *
         * Left Max  = prefixMax[0] = 4
         * Right Min = suffixMin[2] = 5
         *
         * 4 <= 2 ❌
         *
         * -------------------------
         *
         * currentIndex = 2
         *
         * Left Max  = prefixMax[1] = 4
         * Right Min = suffixMin[3] = 7
         *
         * 4 <= 5 ✅
         * 7 >= 5 ✅
         *
         * Answer = 5
         */

        return lastValidElement;
    }
}