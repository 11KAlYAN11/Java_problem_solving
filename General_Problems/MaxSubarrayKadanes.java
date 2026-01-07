package General_Problems;
class MaxSubarrayKadanes {

    // O(n^2) brute force approach
    public static int maxSubarrayBrute(int[] arr) {

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

        int n = arr.length;

        // Both initialized to first element
        int curSum = arr[0];
        int maxSum = arr[0];

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
     */
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
    }
}
