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

    public static int trappedRainWater(int[] arr) {
        int n = arr.length;
        int res = 0;
        // Will use brute force intially
        /* To trap water at any index in the elevation map, there must be taller bars on both its left and right sides. The water that can be stored at each position is determined by the height of the shorter of the two boundaries (left and right), minus the height of the current bar.
            We compute the trapped water at each index as: min(leftMax, rightMax) - height[i], if this value is positive.
            The total trapped water is the sum of water stored at all valid indices.
         */
        // Note in rain water we don't need to count on left boundary and right boundary means i=0 & i<n only from i=1 to i<n-1
        for(int i=1; i<n-1; i++) {
            // Now at every index will find the left max and right max to see how much water can be filled

            int left = arr[i];
            for(int j=0; j<i; j++) { // only on left side from current index
                left = Math.max(left, arr[j]);
            }

            int right = arr[i];
            for(int k=i+1; k<n; k++) { // in right we have to start from current index + 1 till end of the array
                right = Math.max(right, arr[k]);
            }

            // Now from both boundaries will take min of them (cuz water will flow from low height)
            res += Math.min(left, right) - arr[i]; // at 3 & 6 boundries but filled water a index 2 is 3-2 = 1 // so we hav eto minus the current index height
        }
        return res;
    }

     static int maxWaterTrapping(int[] arr) {

        // We NEVER calculate water for first and last bar
        // Because water needs walls on BOTH sides
        int left = 1;                     // Start just after first bar
        int right = arr.length - 2;       // Start just before last bar

        // lMax = highest wall seen so far from LEFT side
        // Initially, it's the very first bar
        int lMax = arr[left - 1];

        // rMax = highest wall seen so far from RIGHT side
        // Initially, it's the very last bar
        int rMax = arr[right + 1];

        // This will store total trapped water
        int res = 0;

        // We move until left pointer crosses right pointer
        while (left <= right) {

            /*
             IMPORTANT LOGIC:
             ----------------
             If left max wall is SMALLER or EQUAL,
             then left side decides the water.
             
             Because:
             A wall of height rMax is GUARANTEED on right side.
            */
            if (lMax <= rMax) {

                // Water above current left bar
                // = left max wall - current bar height
                int water = lMax - arr[left];

                // Water can never be negative
                // If bar is taller than wall, add 0
                res += Math.max(0, water);

                // Update left max if current bar is taller
                lMax = Math.max(lMax, arr[left]);

                // Move left pointer forward
                // Because water for this bar is decided
                left++;

            } else {

                /*
                 If right max wall is SMALLER,
                 then right side decides the water.
                */

                // Water above current right bar
                int water = rMax - arr[right];

                // Add only positive water
                res += Math.max(0, water);

                // Update right max if needed
                rMax = Math.max(rMax, arr[right]);

                // Move right pointer backward
                right--;
            }
        }

        // Total trapped water
        return res;
        /*
        .

            🌧️ Trapping Rain Water
            Example 2 (FOCUS ONLY THIS)
            arr = {3, 0, 2, 0, 4}
            index   0  1  2  3  4

            STEP 0️⃣ – Initialization (CODE VIEW)
            int left = 1;
            int right = arr.length - 2; // = 3

            int lMax = arr[left - 1];   // arr[0] = 3
            int rMax = arr[right + 1]; // arr[4] = 4

            int res = 0;


            So now:

            left = 1
            right = 3
            lMax = 3
            rMax = 4
            res = 0

            🔴 MOST IMPORTANT LINE (BURN THIS IN BRAIN)
            if (lMax <= rMax)


            Here:

            3 <= 4  ✅ TRUE


            👉 Means:
            Right side is TALL ENOUGH
            So left side decides water

            STEP 1️⃣ – Process LEFT = 1
            CODE SNIPPET
            res += Math.max(0, lMax - arr[left]);

            VALUE SUBSTITUTION
            res += max(0, 3 - 0)
            res += 3

            UPDATE POINTER
            left++;

            STATE NOW
            res = 3
            left = 2
            lMax = 3 (unchanged)
            rMax = 4

            STEP 2️⃣ – LEFT = 2

            Again check:

            lMax <= rMax → 3 <= 4 → TRUE

            CODE
            res += Math.max(0, 3 - arr[2]);

            CALCULATION
            res += (3 - 2) = 1

            UPDATE
            left++;

            STATE
            res = 4
            left = 3

            STEP 3️⃣ – LEFT = 3

            Again:

            3 <= 4 → TRUE

            CODE
            res += Math.max(0, 3 - arr[3]);

            CALCULATION
            res += (3 - 0) = 3

            UPDATE
            left++;

            STATE
            res = 7
            left = 4

            🛑 STOP CONDITION
            while (left <= right)


            Now:

            left = 4
            right = 3


            ❌ loop stops

            ✅ FINAL ANSWER
            res = 7

            🧠 NOW THE MAGIC EXPLAINED IN ONE LINE

            When rMax ≥ lMax, the right wall is guaranteed tall enough,
            so water at left depends ONLY on lMax

            That’s it. Nothing more.

            🪜 Visual Intuition (VERY IMPORTANT)
            Heights:  3   0   2   0   4
                    ↑       ↑       ↑
                    leftMax           rightMax


            Since right wall (4) is taller than left wall (3),
            water will spill only based on 3, not 4.
                    */
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

        int[] arr4 = {3, 0, 1, 0, 4, 0 ,2};
        int[] arr5 = {3, 0, 2, 0, 4};
        System.out.println("Trapped Rain water: "+trappedRainWater(arr4));
        System.out.println("Trapped Rain water: "+trappedRainWater(arr5));

        // Advanced

        int[] arr = {3, 0, 2, 0, 4};
        System.out.println(maxWaterTrapping(arr)); // Output: 7
        
    }
}
