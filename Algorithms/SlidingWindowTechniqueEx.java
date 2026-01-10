package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowTechniqueEx { // Idea Change IDE Checking
    
    public static void main(String[] args) {
        // For Fixed-Size Sliding Window
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of " + k + " consecutive elements: " + maxSumKWindow(arr, k)); // Output: 9
        System.out.println("Max sum of " + k + " consecutive elements: " + maxSumKWindow1(arr, k)); // Output: 9

        int[] arrx = {12, -1, -7, 8, -15, 30, 16, 28};
        firstNegativeEleInWindow(arrx, k); // Output: 9



        // Variable-Size Sliding Window
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        int X = 7;
        System.out.println("Smallest subarray length with sum ≥ " + X + ": " + minSubarrayWithSum(arr1, X)); // Output: 2
        System.out.println("Largest subarray length with sum ≥ " + X + ": " + maxSubarrayWithSum(arr1, X)); // Output: 2
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

    public static int maxSumKWindow1(int[] arr, int k) {

        /*
        🔁 Dry Run Snapshot
            Window	Elements	Sum
            [0–2]	2,1,5	8
            [1–3]	1,5,1	7
            [2–4]	5,1,3	9 ✅
            [3–5]	1,3,2	6

            [ window of size K ] → slides one step right

            Window size = constant k

            Both pointers move together

            Add incoming element

            Remove outgoing element */

        int maxSum = 0;
        int sum = 0;
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(i-idx+1 == k) { // window size reached
                maxSum = Math.max(maxSum, sum);
                sum -= arr[idx]; // Remove outgoing element
                idx++; // SLIDE THE WINDOW
            }
        }
        return maxSum;
    }

    public static void firstNegativeEleInWindow(int[] arr, int k) {
        /*
        🔥 Trick Used

            We use a Queue to track negatives inside window.

            🧠 KEY OBSERVATION

            Queue holds only window elements

            Remove element when it goes out of window

            Peek gives first negative
         */
        Queue<Integer> queue = new LinkedList<>();
        int i = 0; // to track loop from window size reached
        for(int j=0; j<arr.length; j++) {
            // Here we just need negative if jth ele is -Ve will add to queue
            if(arr[j] < 0) queue.add(arr[j]);

            if(j-i +1 == k) { // Window size reached
                if(queue.isEmpty()) System.out.println(" "+'0'); // No negatives in this window
                else System.out.print(" "+queue.peek()); // FIFO 1st element of queue

                // Now is queue is not empty && remove the outdated ele's from peek (Remove element when it goes out of window)
                if(!queue.isEmpty() && arr[i] == queue.peek()) queue.poll(); // Remove that outdated element

                // Now Main Step Slide the window
                i++;
            }
        }

    }


    // Variable-Size Sliding Window
    public static int minSubarrayWithSum(int[] arr1, int X) { // {2, 3, 1, 2, 4, 3};
        int left=0, sum = 0;
        int minLength = Integer.MAX_VALUE; // lets assume heighst values as minimum value for comparision
        for(int right=0; right<arr1.length; right++) {
            sum += arr1[right]; // Expanding the winndow everytime when sum < X
            while(sum >= X) { // We attained the window with more >= X try shrinking
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


         */
    }

    public static int maxSubarrayWithSum(int[] arr, int X) {
        /*
        5️⃣ DRY RUN (NO SHORTCUTS)
                left	right	window	sum	action	maxLen
                0	0	[2]	2	valid	1
                0	1	[2,1]	3	valid	2
                0	2	[2,1,5]	8	❌ shrink	—
                1	2	[1,5]	6	valid	2
                1	3	[1,5,1]	7	valid	3
                1	4	[1,5,1,3]	10	❌ shrink	—
                2	4	[5,1,3]	9	❌ shrink	—
                3	4	[1,3]	4	valid	3
                3	5	[1,3,2]	6	valid	3

                ✅ Answer = 3

                6️⃣ WHY UPDATE AFTER SHRINKING?

                Because:

                During violation → window is invalid

                Only after shrinking → window becomes valid

                Then we safely calculate length

                7️⃣ COMPARISON: MIN vs MAX (VERY IMPORTANT)
                Problem	While loop	Update answer
                Min window	while(valid)	inside loop
                Max window	while(invalid)	after loop */

                int left = 0;
                int sum = 0;
                int maxSubArray = 0;

                for(int right=0; right < arr.length; right++) {
                    sum += arr[right];

                    while(sum > X) { // As sum excedded Than X will try to shrink it
                        sum-= arr[left];
                        left++;
                    }
                    // As we need the max window size we calcualte out-of while loop (is we need min will inside the loop ex: minSubArray)
                    maxSubArray = Math.max(maxSubArray, right - left + 1); // This Right - Left + 1 technique is non-negotiable 
                }
                return maxSubArray;
    }
}
            /*🎯 FIXED WINDOW RULE (WRITE THIS IN BRAIN)

            Window size is constant → both pointers move together

            🧠 WHEN TO USE FIXED WINDOW?

            If problem says:

            “subarray of size K”

            “substring of length K”

            “exactly K elements”

            👉 Sliding Window (Fixed)


*/