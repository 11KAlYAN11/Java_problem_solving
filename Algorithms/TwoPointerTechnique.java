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

        if (nums.length == 0) return 0;

        int write = 1; // position to write next unique value

        for (int read = 1; read < nums.length; read++) {

            // compare current element with previous
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }

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
    }
}
