package com.learning.java.algorithms;

public class SlidingWindowTechniqueEx {
    
    public static void main(String[] args) {
        // For Fixed-Size Sliding Window
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of " + k + " consecutive elements: " + maxSumKWindow(arr, k)); // Output: 9

        // Variable-Size Sliding Window
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        int X = 7;
        System.out.println("Smallest subarray length with sum ≥ " + X + ": " + minSubarrayWithSum(arr1, X)); // Output: 2
    }
    // Fixed-Size Sliding Window
    public static int maxSumKWindow(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1; // Edge case: If window size > array size

        int maxSum = 0, windowSum = 0;

        // Compute the sum of the first k elements
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum; // // First window sum acts as the initial max if no other maxsum found.

        // Slide the window, remove leftmost element, add new rightmost element
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k]; // Add new element, remove old element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    // Variable-Size Sliding Window
    public static int minSubarrayWithSum(int[] arr1, int X) { // {2, 3, 1, 2, 4, 3};
        int left=0, sum = 0;
        int minLength = Integer.MAX_VALUE; // lets assume heighst values as minimum value for comparision
        for(int right=0; right<arr1.length; right++) {
            sum += arr1[right]; // Expanding the winndow everytime when sum < X
            while(sum >= X) {
                minLength = Math.min(minLength, right-left+1); // at 4th element 3rd index element if we want to get size right + 1, but while decresing size we need to minue left so r-l+1
                sum -= arr1[left]; // Removing left most element from sum
                left++; // move left pointer
            }
        }
        return (minLength == Integer.MAX_VALUE)? 0: minLength;
        /*
         * 🔹 Step-by-Step Execution
            Step	Window (start → end)	Window Sum	Action
            1	[2]	2	Expand end
            2	[2, 3]	5	Expand end
            3	[2, 3, 1]	6	Expand end
            4	[2, 3, 1, 2]	8 ✅	Try shrinking
            5	[3, 1, 2]	6	Expand end
            6	[3, 1, 2, 4]	10 ✅	Shrink
            7	[1, 2, 4]	7 ✅	Shrink
            8	[2, 4]	6	Expand end
            9	[2, 4, 3]	9 ✅	Shrink
            10	[4, 3]	7 ✅	Shrink (smallest window found)

            ✨ Summary of What We Discussed
            ✅ Fixed-Size Sliding Window: Used for fixed-length problems like max sum of K elements.
            ✅ Variable-Size Sliding Window: Used when window size is dynamic, e.g., smallest subarray with sum ≥ S.
            ✅ Efficiency: Both approaches run in O(N) time and are much faster than brute force O(N²).

            Would you like me to provide more examples or discuss advanced variations? 🚀

         */
    }
}
