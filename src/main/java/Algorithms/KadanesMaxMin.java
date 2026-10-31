package Algorithms;

public class KadanesMaxMin {
    /*
                =========================================================
                        KADANE FAMILY – CORE FORMULAS (JAVA NOTES)
                =========================================================

                ---------------------------------------------------------
                1) MAX SUBARRAY SUM (KADANE)
                ---------------------------------------------------------
                Goal:
                - Find maximum sum of a contiguous subarray
                - Works with negative numbers

                Meaning:
                - curSum  → best subarray sum ending at index i
                - maxSum  → best sum seen so far

                Formula:
                curSum = Math.max(arr[i], curSum + arr[i]);
                maxSum = Math.max(maxSum, curSum);

                Initialization:
                curSum = arr[0];
                maxSum = arr[0];

                Notes:
                - Either START new subarray at arr[i]
                - OR EXTEND previous subarray
                - Handles all-negative arrays naturally

                ---------------------------------------------------------
                2) MAX PRODUCT SUBARRAY (PRODUCT KADANE)
                ---------------------------------------------------------
                Goal:
                - Find maximum product of a contiguous subarray

                Meaning:
                - maxProd → maximum product ending at index i
                - minProd → minimum product ending at index i
                (IMPORTANT because negative × negative = positive)

                Formula:
                int temp = maxProd;

                maxProd = Math.max(arr[i],
                            Math.max(arr[i] * maxProd, arr[i] * minProd));

                minProd = Math.min(arr[i],
                            Math.min(arr[i] * temp, arr[i] * minProd));

                ans = Math.max(ans, maxProd);

                Initialization:
                maxProd = arr[0];
                minProd = arr[0];
                ans = arr[0];

                Notes:
                - temp is REQUIRED to preserve old maxProd
                - Zero automatically resets product
                - minProd is the KEY difference from sum Kadane

                ---------------------------------------------------------
                3) CIRCULAR MAX SUBARRAY SUM
                ---------------------------------------------------------
                Goal:
                - Maximum subarray sum in circular array

                Two cases:
                1) Normal max subarray (Kadane)
                2) Circular subarray (wrap-around)

                Formulas:
                maxKadane = normal Kadane result
                minKadane = minimum subarray sum
                totalSum  = sum of all elements

                circularSum = totalSum - minKadane;

                answer = Math.max(maxKadane, circularSum);

                IMPORTANT EDGE CASE:
                If all elements are negative:
                - circularSum becomes 0 (invalid)
                - So return maxKadane

                Condition:
                if (maxKadane < 0) return maxKadane;

                Notes:
                - minKadane removes the worst subarray
                - Remaining elements form best circular subarray
                - maxKadane and minKadane can be computed in one loop

                ---------------------------------------------------------
                ONE-LINE MEMORY
                ---------------------------------------------------------
                Sum Kadane      → only MAX matters
                Product Kadane  → MAX + MIN matter
                Circular Kadane → MAX + MIN + TOTAL matter
                =========================================================


    🧠 SIDE-BY-SIDE COMPARISON
        Requirement	Kadane	Prefix+Map
        Max subarray sum	✅	❌
        Min subarray sum	✅	❌
        Exact sum = K	❌	✅
        Count subarrays	❌	✅
        Need indices explicitly	⚠️	✅
        Circular max subarray	✅	❌
        Negative numbers	✅	✅
     */

    // O(n^2) brute force approach
    public static int maxSubarrayBrute(int[] arr) {
        //  {2,3,-8,7,-1,2,3};

        int n = arr.length;

        // Initialize result with first element
        // Important for all-negative arrays
        int maxSum = arr[0];

        // Outer loop: choose starting index
        for (int i = 0; i < n; i++) {

            int curSum = 0;

            // Inner loop: extend subarray from i to j
            for (int j = i; j < n; j++) {
                curSum += arr[j];

                // Update maximum sum found so far
                maxSum = Math.max(maxSum, curSum);
            }
        }

        return maxSum;
    }
        // O(n) Kadane's Algorithm
    public static int maxSubarrayKadane(int[] arr) {
        /* curSum = best subarray sum ENDING at current index
            maxSum = best subarray sum SEEN SO FAR
         */
        //  {2,3,-8,7,-1,2,3};

        int n = arr.length;

        // Both initialized to first element
        int curSum = arr[0];
        int maxSum = arr[0];
        /*  Dry Run (IMPORTANT)

            Input

            arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

            i	arr[i]	curSum = max(arr[i], curSum + arr[i])	maxSum
            0	-2	     -2	        -2
            1	1	    max(1, -2+1=-1) = 1	        1
            2	-3	    max(-3, 1-3=-2) = -2	    1
            3	4	    max(4, -2+4=2) = 4	        4
            4	-1	    max(-1, 4-1=3) = 3	        4
            5	2	    max(2, 3+2=5) = 5	        5
            6	1	    max(1, 5+1=6) = 6	        6
            7	-5	    max(-5, 6-5=1) = 1	        6
            8	4	    max(4, 1+4=5) = 5	        6

            ✅ Answer = 6 → [4, -1, 2, 1]

            // i = 0
            // curSum = -2
            // maxSum = -2

            // i = 1, arr[i] = 1
            // curSum = max(1, -2 + 1 = -1) = 1
            // maxSum = max(-2, 1) = 1

            // i = 2, arr[i] = -3
            // curSum = max(-3, 1 + (-3) = -2) = -2
            // maxSum = max(1, -2) = 1

            // i = 3, arr[i] = 4
            // curSum = max(4, -2 + 4 = 2) = 4   <-- restart here
            // maxSum = max(1, 4) = 4

            // i = 4, arr[i] = -1
            // curSum = max(-1, 4 + (-1) = 3) = 3
            // maxSum = max(4, 3) = 4

            // i = 5, arr[i] = 2
            // curSum = max(2, 3 + 2 = 5) = 5
            // maxSum = max(4, 5) = 5

            // i = 6, arr[i] = 1
            // curSum = max(1, 5 + 1 = 6) = 6
            // maxSum = max(5, 6) = 6

            // i = 7, arr[i] = -5
            // curSum = max(-5, 6 + (-5) = 1) = 1
            // maxSum = max(6, 1) = 6

            // i = 8, arr[i] = 4
            // curSum = max(4, 1 + 4 = 5) = 5
            // maxSum = max(6, 5) = 6

         */

        for (int i = 1; i < n; i++) {

            // Either start new subarray OR extend previous
            curSum = Math.max(arr[i], curSum + arr[i]);

            // Track global maximum
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
    public static int maxProductSubarray(int[] arr) {

    // Edge case: array has at least one element
    int n = arr.length;

    /*
     currMax → maximum product subarray ending at current index
     currMin → minimum product subarray ending at current index
     
     Why both?
     Because multiplying by a negative number flips signs:
     (- * - = +)
    */
    int currMax = arr[0];
    int currMin = arr[0];

    // Stores the final answer (global maximum product)
    int maxProd = arr[0];

    // Start from second element
    for (int i = 1; i < n; i++) {

        int current = arr[i];

        /*
         We must calculate new currMax and currMin
         using OLD currMax and currMin.
         
         temp is required to preserve the old currMax
         before updating it.
        */
        int tempMax = Math.max(
                current,
                Math.max(current * currMax, current * currMin)
        );

        int tempMin = Math.min(
                current,
                Math.min(current * currMax, current * currMin)
        );

        // Update current max and min
        currMax = tempMax;
        currMin = tempMin;

        /*      int temp = maxProd;

                maxProd = Math.max(arr[i],
                Math.max(arr[i] * maxProd, arr[i] * minProd));

                minProd = Math.min(arr[i],
                Math.min(arr[i] * temp, arr[i] * minProd));
         */

        // Update global maximum product
        maxProd = Math.max(maxProd, currMax);
    }

    return maxProd;
    /*
    3️⃣ Mental Model (lock this in)
        Kadane Sum:

        “If it hurts, drop it.”

        Product Subarray:

        “Even if it hurts now, it might help later.”

        That’s the entire difference.

        // i = 0
            // maxProd = 2
            // minProd = 2
            // ans = 2

            // i = 1, arr[i] = 3
            // temp = 2
            // maxProd = max(3, max(3*2=6, 3*2=6)) = 6
            // minProd = min(3, min(3*2=6, 3*2=6)) = 3
            // ans = max(2, 6) = 6

            // i = 2, arr[i] = -2   <-- NEGATIVE NUMBER
            // temp = 6
            // maxProd = max(-2, max(-2*6=-12, -2*3=-6)) = -2
            // minProd = min(-2, min(-2*6=-12, -2*3=-6)) = -12
            // ans = max(6, -2) = 6

            // NOTE:
            // minProd = -12 is IMPORTANT
            // because negative * negative can become positive later

            // i = 3, arr[i] = 4
            // temp = -2
            // maxProd = max(4, max(4*-2=-8, 4*-12=-48)) = 4
            // minProd = min(4, min(4*-2=-8, 4*-12=-48)) = -48
            // ans = max(6, 4) = 6

                */
            }



            /*
                PROBLEM:
                Find maximum subarray sum in a CIRCULAR array.

                CORE IDEA (MUST REMEMBER FOREVER):

                There are only TWO possibilities for maximum sum:

                1) Normal subarray (does NOT wrap)
                -> solved by normal Kadane's (maxKadane)

                2) Circular subarray (wraps from end to start)
                -> remove the MINIMUM subarray from total sum
                -> circularSum = totalSum - minKadane

                FINAL ANSWER:
                max(maxKadane, circularSum)

                SPECIAL CASE:
                If all numbers are negative:
                -> maxKadane itself is the answer


                Q1: Why do we need minProd?

            Because:

            negative × negative = positive


            👉 Today’s worst (min) can become tomorrow’s best (max).

            🔹 Q2: What do maxProd and minProd represent?

            maxProd → best product ending at i

            minProd → worst product ending at i

            Both are needed.

            🔹 Q3: Why do we store temp = maxProd?

            Because:

            maxProd gets updated first
            minProd still needs OLD maxProd


If you don’t store temp → ❌ logic breaks.
*/

static int maxCircularKadane(int[] arr) {

    int n = arr.length;

    // ---------- Step 1: Initialize everything ----------
    int totalSum = arr[0];

    int curMax = arr[0];
    int maxKadane = arr[0];

    int curMin = arr[0];
    int minKadane = arr[0];

    // ---------- Step 2: Single loop does EVERYTHING ----------
    for (int i = 1; i < n; i++) {

        int val = arr[i];

        // ----- Normal Kadane (MAX subarray) -----
        // Either start fresh from current element
        // OR extend previous subarray
        curMax = Math.max(val, curMax + val);
        maxKadane = Math.max(maxKadane, curMax);

        // ----- Reverse Kadane (MIN subarray) -----
        // Used for circular logic
        curMin = Math.min(val, curMin + val);
        minKadane = Math.min(minKadane, curMin);

        // ----- Total sum of array -----
        totalSum += val;
    }

    // ---------- Step 3: IMPORTANT EDGE CASE ----------
    // If all numbers are negative, circular sum becomes 0 (invalid)
    // So directly return maxKadane
    if (maxKadane < 0) {
        return maxKadane;
    }

    // ---------- Step 4: Circular subarray sum ----------
    int circularSum = totalSum - minKadane;

    // ---------- Step 5: Final answer ----------
    return Math.max(maxKadane, circularSum);

    /*
     // Edge case: all elements positive
    if (minKadane > 0) {
        return minKadane;
    }

    int circularMin = totalSum - maxKadane;

    return Math.min(minKadane, circularMin);    // for MinCircularSubarr minCircularKadanes

    
            🧠 FULL JAVA-STYLE DRY RUN (PASTE-READY)
            // arr = {8, -1, 3, 4}

            // ---------- Initialization ----------
            // i = 0
            // totalSum = 8
            // curMax = 8
            // maxKadane = 8
            // curMin = 8
            // minKadane = 8

            // ---------- i = 1, val = -1 ----------

            // MAX Kadane
            // curMax = max(-1, 8 + (-1) = 7) = 7
            // maxKadane = max(8, 7) = 8

            // MIN Kadane
            // curMin = min(-1, 8 + (-1) = 7) = -1
            // minKadane = min(8, -1) = -1

            // totalSum = 8 + (-1) = 7

            // ---------- i = 2, val = 3 ----------

            // MAX Kadane
            // curMax = max(3, 7 + 3 = 10) = 10
            // maxKadane = max(8, 10) = 10

            // MIN Kadane
            // curMin = min(3, -1 + 3 = 2) = 2
            // minKadane = min(-1, 2) = -1

            // totalSum = 7 + 3 = 10

            // ---------- i = 3, val = 4 ----------

            // MAX Kadane
            // curMax = max(4, 10 + 4 = 14) = 14
            // maxKadane = max(10, 14) = 14

            // MIN Kadane
            // curMin = min(4, 2 + 4 = 6) = 4
            // minKadane = min(-1, 4) = -1

            // totalSum = 10 + 4 = 14
            🔄 FINAL CALCULATION
            // maxKadane = 14     (normal subarray: [8, -1, 3, 4])
            // minKadane = -1    (subarray to REMOVE)
            // totalSum = 14

            // circularSum = totalSum - minKadane
            // circularSum = 14 - (-1) = 15

            // answer = max(14, 15) = 15

                */

            /*
            🧠 SELF-CHECK AFTER WRITING CODE

            Did I start loop from i = 1?

            Did I update maxSum every time?

            Did I avoid initializing with 0? */
}


                

    // MAIN METHOD — only for testing & comparison
    public static void main(String[] args) {

        int[] arr = {2,3,-8,7,-1,2,3};
        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Brute Force Result : " + maxSubarrayBrute(arr));
        System.out.println("Kadane Result     : " + maxSubarrayKadane(arr));

        System.out.println("Brute Force Result : " + maxSubarrayBrute(arr2));
        System.out.println("Kadane Result     : " + maxSubarrayKadane(arr2));

        int[] arr3 = {-2,6,-3,-10,0,2};

        System.out.println(maxProductSubarray(arr3));
        System.out.println(maxProductSubarray(arr2));

        int[] arr4 = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(maxCircularKadane((arr3)));
        System.out.println(maxCircularKadane((arr4)));
    }
}
