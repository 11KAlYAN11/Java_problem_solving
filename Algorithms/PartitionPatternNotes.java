package Algorithms;


import java.util.Arrays;

/*
 * ============================================================
 * DSA PPS-5 : PARTITION / SEGREGATION PATTERN
 * ============================================================
 *
 * Recognition Keywords:
 *
 * - Move all X to one side
 * - Segregate
 * - Partition
 * - Rearrange
 * - Group elements
 * - Order DOES NOT matter
 * - In-place preferred
 *
 * Core Pattern:
 *
 * left  -> start
 * right -> end
 *
 * while(left < right)
 *
 *      if(left side already correct)
 *              left++
 *
 *      else if(right side already correct)
 *              right--
 *
 *      else
 *              swap
 *
 * Complexity:
 *
 * Time  : O(n)
 * Space : O(1)
 *
 * ============================================================
 */

public class PartitionPatternNotes {

    public static void main(String[] args) {

        /*
         * ====================================================
         * 1. Move Negatives To Left Side
         * ====================================================
         */

        int[] negLeft = {1, -2, 3, -4, 5, -6};

        moveNegativesLeft(negLeft);

        System.out.println(
                "Move Negatives Left : "
                        + Arrays.toString(negLeft));

        /*
         * Possible Output:
         * [-6, -2, -4, 3, 5, 1]
         */

        /*
         * ====================================================
         * 2. Move Negatives To End
         * ====================================================
         */

        int[] negEnd = {1, -2, 3, -4, 5, -6};

        moveNegativesEnd(negEnd);

        System.out.println(
                "Move Negatives End  : "
                        + Arrays.toString(negEnd));

        /*
         * Possible Output:
         * [1, 5, 3, -4, -2, -6]
         */

        /*
         * ====================================================
         * 3. Move Zeros To End
         * ====================================================
         */

        int[] zeros = {1, 0, 3, 0, 5};

        moveZerosEnd(zeros);

        System.out.println(
                "Move Zeros End      : "
                        + Arrays.toString(zeros));

        /*
         * Possible Output:
         * [1, 5, 3, 0, 0]
         */

        /*
         * ====================================================
         * 4. Segregate Even & Odd
         * ====================================================
         */

        int[] evenOdd = {1, 2, 3, 4, 5, 6};

        segregateEvenOdd(evenOdd);

        System.out.println(
                "Even Odd Segregate  : "
                        + Arrays.toString(evenOdd));

        /*
         * Possible Output:
         * [6, 2, 4, 3, 5, 1]
         */

        /*
         * ====================================================
         * 5. Sort 0's and 1's
         * ====================================================
         */

        int[] zeroOne = {1, 0, 1, 0, 0, 1};

        sortZeroOne(zeroOne);

        System.out.println(
                "Sort 0 & 1          : "
                        + Arrays.toString(zeroOne));

        /*
         * Output:
         * [0, 0, 0, 1, 1, 1]
         */
    }

    /*
     * ============================================================
     * 1. Move Negatives To Left Side
     * ============================================================
     *
     * Correct Left  = Negative
     * Correct Right = Positive / Zero
     *
     * Example:
     *
     * [1,-2,3,-4,5,-6]
     *
     * ->
     *
     * [-6,-2,-4,3,5,1]
     *
     * Order NOT preserved
     */

    public static void moveNegativesLeft(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] < 0) {
                left++;
            }

            else if (arr[right] >= 0) {
                right--;
            }

            else {

                swap(arr, left, right);

                left++;
                right--;
            }
        }
    }

    /*
     * ============================================================
     * 2. Move Negatives To End
     * ============================================================
     *
     * Correct Left  = Positive / Zero
     * Correct Right = Negative
     *
     * Order NOT preserved
     */

    public static void moveNegativesEnd(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] >= 0) {
                left++;
            }

            else if (arr[right] < 0) {
                right--;
            }

            else {

                swap(arr, left, right);

                left++;
                right--;
            }
        }
    }

    /*
     * ============================================================
     * 3. Move Zeros To End
     * ============================================================
     *
     * Correct Left  = Non-Zero
     * Correct Right = Zero
     *
     * Order NOT preserved
     */

    public static void moveZerosEnd(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] != 0) {
                left++;
            }

            else if (arr[right] == 0) {
                right--;
            }

            else {

                swap(arr, left, right);

                left++;
                right--;
            }
        }
    }

    /*
     * ============================================================
     * 4. Segregate Even & Odd
     * ============================================================
     *
     * Correct Left  = Even
     * Correct Right = Odd
     *
     * Order NOT preserved
     */

    public static void segregateEvenOdd(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] % 2 == 0) {
                left++;
            }

            else if (arr[right] % 2 != 0) {
                right--;
            }

            else {

                swap(arr, left, right);

                left++;
                right--;
            }
        }
    }

    /*
     * ============================================================
     * 5. Sort 0's and 1's
     * ============================================================
     *
     * Correct Left  = 0
     * Correct Right = 1
     *
     * Output:
     *
     * [0,0,0,1,1,1]
     */

    public static void sortZeroOne(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] == 0) {
                left++;
            }

            else if (arr[right] == 1) {
                right--;
            }

            else {

                swap(arr, left, right);

                left++;
                right--;
            }
        }
    }

    /*
     * Common Swap Utility
     */

    public static void swap(int[] arr,
                            int i,
                            int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
