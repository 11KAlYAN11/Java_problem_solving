package Algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoPointerTechnique {

    /*
     ---------------------------------------------------
     1️⃣ OPPOSITE DIRECTION TWO POINTERS
     ---------------------------------------------------
     Problem:
     Given a SORTED array, check if there exists
     a pair whose sum is equal to target.

     Example:
     arr = [1, 2, 3, 4, 6], target = 6
     Output: true (2 + 4)
     ---------------------------------------------------
     */
    public static boolean hasPairWithSum(int[] arr, int target) {

        int left = 0;                  // start pointer
        int right = arr.length - 1;    // end pointer

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true; // pair found
            } 
            else if (sum < target) {
                left++;  // increase sum
            } 
            else {
                right--; // decrease sum
            }
        }

        return false; // no pair found

        /*
        7️⃣ IMPORTANT LIMITATION ⚠️

        ❌ Does NOT work for unsorted arrays
        ✔ For unsorted arrays:

        Sort first → O(n log n) + O(n)

        OR use HashSet → O(n)
         */
    }


    /*
     ---------------------------------------------------
     2️⃣ SAME DIRECTION TWO POINTERS
     ---------------------------------------------------
     Problem:
     Remove duplicates from SORTED array in-place.

     Example:
     nums = [1,1,2,2,3]
     Output array = [1,2,3]
     ---------------------------------------------------
     */
    public static int removeDuplicates(int[] nums) {
        // This logic works ONLY because the array is SORTED.

        if (nums.length == 0) return 0;

        int write = 1; // position to write next unique value

        for (int read = 1; read < nums.length; read++) {

            // compare current element with previous
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }

        // We can also just add to Set to get rid of duplicates
        // But this was inplace removing the duplicates

        /* 🔥 BIGGEST MINDSET SHIFT (THIS IS IT)

        We are NOT deleting elements
        We are OVERWRITING duplicates with unique values

        Duplicates stay in array, but we ignore them.

        🧠 ONE-LINE INTUITION

        read finds unique values,
        write stores them compactly at the front. */
        return write; // new length of unique elements
    }


    /*
     ---------------------------------------------------
     3️⃣ SLIDING WINDOW (TWO POINTERS HYBRID)
     ---------------------------------------------------
     Problem:
     Find length of longest substring without
     repeating characters.

     Example:
     s = "abcabcbb"
     Output = 3 ("abc")
     ---------------------------------------------------
     */
    public static int longestUniqueSubstring(String s) {

        int left = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            // shrink window if duplicate found
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static boolean isValidEncoding(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int n = s1.length();
        int slow = 0;
        int fast;

        while(slow < n) {
            char ch = s1.charAt(slow); // a -> b -> c
            fast = slow; // aaa  bb  cc   fast pointer will travel in small grps slow pointer will fiz at start of fast pointer every time
            int count = 0;

            while(fast < n && s1.charAt(fast) == ch) {
                count++;
                fast++;
            }
            sb.append(ch);
            sb.append(count); //a3 -> b2 -> c2   sb = "a3b2c2"

            slow = fast; // Will update slow to new group starting (fast stopped at new grp starting so slow = fast)
        }
        return s2.equals(sb.toString());
    }

    // Method to count number of valid triangles
    public static int countTriangles(int[] arr) {

        int n = arr.length;

        // If less than 3 elements, triangle not possible
        if (n < 3) return 0;

        // Step 1: Sort the array
        // Sorting helps us apply two pointer logic
        Arrays.sort(arr);

        int count = 0;

        /*
         * Step 2:
         * Fix the largest side of the triangle
         *
         * Why k from last?
         * Because triangle condition depends on the LARGEST side
         *
         * k goes from n-1 down to 2
         * because we need at least two elements before it
         */
        for (int k = n - 1; k >= 2; k--) {

            /*
             * i -> smallest side (starts from 0)
             * j -> second largest side (just before k)
             */
            int i = 0;
            int j = k - 1;

            /*
             * Now we check pairs (i, j) such that:
             * arr[i] + arr[j] > arr[k]
             */
            while (i < j) {

                /*
                 * If sum of smallest + second largest
                 * is greater than the largest side
                 */
                if (arr[i] + arr[j] > arr[k]) {

                    /*
                     * IMPORTANT LOGIC:
                     *
                     * Since array is sorted:
                     * arr[i] <= arr[i+1] <= ... <= arr[j-1] <= arr[j]
                     *
                     * If arr[i] + arr[j] > arr[k]
                     * then ALL elements from i to j-1
                     * will also satisfy the condition
                     *
                     * Number of such pairs = (j - i)
                     */
                    count += (j - i);

                    /*
                     * Move j left to try a smaller second side
                     */
                    j--;
                }
                else {
                    /*
                     * If sum is NOT greater than arr[k],
                     * it means arr[i] is too small
                     *
                     * So increase i to try a bigger value
                     */
                    i++;
                }
            }
        }

        return count;
    }


    /*
     ---------------------------------------------------
     MAIN METHOD - FOR QUICK TESTING

     (will be adding the more concize 2 point technique FAQ's.)
     ---------------------------------------------------
     */
    public static void main(String[] args) {

        // 1️⃣ Opposite Direction Test
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println(hasPairWithSum(arr, 6)); // true


        // 2️⃣ Same Direction Test
        int[] nums = {1, 1, 2, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));


        // 3️⃣ Sliding Window Test
        String s = "abcabcbb";
        System.out.println(longestUniqueSubstring(s)); // 3

        // Is a Valid String Encoding
        System.out.println(isValidEncoding("aaabbcc", "a3b2c2")); // true
        System.out.println(isValidEncoding("aaabbccaabb", "a3b2c2a2b2")); // true
        System.out.println(isValidEncoding("aaabbcc", "a3b2c1")); // false
        System.out.println(isValidEncoding("abc", "a1b1c1"));     // true


        int[] arr1 = {4, 6, 3, 7};
        System.out.println("Count: " + countTriangles(arr1));
        // Expected output: 3

        int[] arr2 = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Count: " + countTriangles(arr2));
        // Expected output: 6

        int[] arr3 = {1, 2, 3};
        System.out.println("Count: " + countTriangles(arr3));
        // Expected output: 0
    }
}
