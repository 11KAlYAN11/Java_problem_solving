package General_Problems;
class MaxSubarray {

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

    // MAIN METHOD — only for testing & comparison
    public static void main(String[] args) {

        int[] arr = {2,3,-8,7,-1,2,3};
        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Brute Force Result : " + maxSubarrayBrute(arr));
        System.out.println("Kadane Result     : " + maxSubarrayKadane(arr));

        System.out.println("Brute Force Result : " + maxSubarrayBrute(arr2));
        System.out.println("Kadane Result     : " + maxSubarrayKadane(arr2));
    }
}
