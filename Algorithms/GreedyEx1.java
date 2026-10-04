package Algorithms;

import java.util.Arrays;

public class GreedyEx1 {

    /*
     * ============================================================
     * GREEDY ALGORITHMS - PROBLEMS WE HAVE LEARNED
     * ============================================================
     *
     * Core idea:
     *
     * Greedy means making the best local choice at every step,
     * with the expectation that these choices lead to the
     * globally optimal answer.
     *
     * The main challenge is NOT writing the code.
     * The main challenge is identifying:
     *
     *      "What is the best choice I can make RIGHT NOW?"
     *
     * Problems covered in this reference:
     *
     * 1. Assign Cookies
     * 2. Lemonade Change
     * 3. Jump Game I
     * 4. Jump Game II
     *
     * ============================================================
     */


    /*
     * ============================================================
     * 1. ASSIGN COOKIES
     * ============================================================
     *
     * Given:
     *
     * childGreed[i] = minimum cookie size required by child i
     * cookieSizes[i] = size of cookie i
     *
     * Goal:
     *
     *      Maximize the number of satisfied children.
     *
     * GREEDY CHOICE:
     *
     *      Give the smallest cookie that can satisfy
     *      the least greedy child.
     *
     * Why?
     *
     *      Don't waste a large cookie on a child who can
     *      already be satisfied by a smaller cookie.
     *
     * Pattern:
     *
     *      Smallest requirement
     *              +
     *      Smallest sufficient resource
     *
     * Example:
     *
     *      children = [1,2,3]
     *      cookies  = [1,1]
     *
     *      Child 1 -> cookie 1  -> satisfied
     *      Child 2 -> cookie 1  -> satisfied
     *      Child 3 -> no cookie -> not satisfied
     *
     *      Answer = 2
     *
     * Time: O(N log N) because of sorting
     * Space: O(1) extra
     * ============================================================
     */
    public static int assignCookies(int[] childGreed, int[] cookieSizes) {

        Arrays.sort(childGreed);
        Arrays.sort(cookieSizes);

        int childIndex = 0;
        int cookieIndex = 0;

        while (childIndex < childGreed.length
                && cookieIndex < cookieSizes.length) {

            if (cookieSizes[cookieIndex] >= childGreed[childIndex]) {

                // Current cookie can satisfy current child.
                childIndex++;
            }

            // This cookie cannot be reused.
            cookieIndex++;
        }

        return childIndex;
    }


    /*
     * ============================================================
     * 2. LEMONADE CHANGE
     * ============================================================
     *
     * Lemonade costs $5.
     *
     * Customers can pay using:
     *
     *      $5, $10, $20
     *
     * We need to give correct change.
     *
     * GREEDY CHOICE:
     *
     *      Preserve smaller bills because they are more flexible.
     *
     * For a $20 bill:
     *
     *      FIRST preference:
     *
     *          $10 + $5
     *
     *      Otherwise:
     *
     *          $5 + $5 + $5
     *
     * Why prefer $10 + $5?
     *
     * Because keeping $5 bills gives us more possibilities
     * for future customers.
     *
     * Pattern:
     *
     *      Preserve the most flexible resource.
     *
     * ============================================================
     */
    public static boolean lemonadeChange(int[] bills) {

        int fiveDollarBills = 0;
        int tenDollarBills = 0;

        for (int bill : bills) {

            if (bill == 5) {

                fiveDollarBills++;

            } else if (bill == 10) {

                // Need one $5 as change.
                if (fiveDollarBills == 0) {
                    return false;
                }

                fiveDollarBills--;
                tenDollarBills++;

            } else { // bill == 20

                // Prefer $10 + $5.
                if (tenDollarBills > 0 && fiveDollarBills > 0) {

                    tenDollarBills--;
                    fiveDollarBills--;

                }
                // Otherwise use three $5 bills.
                else if (fiveDollarBills >= 3) {

                    fiveDollarBills -= 3;

                } else {

                    // Cannot give $15 change.
                    return false;
                }
            }
        }

        return true;
    }


    /*
     * ============================================================
     * 3. JUMP GAME I
     * ============================================================
     *
     * arr[i] tells us the maximum number of positions
     * we can jump from index i.
     *
     * Example:
     *
     *      [2,3,1,1,4]
     *
     * Goal:
     *
     *      Can we reach the last index?
     *
     * GREEDY CHOICE:
     *
     *      Don't care about the exact path.
     *
     *      Keep track of the FURTHEST position we can reach.
     *
     * Variable:
     *
     *      maxReach
     *
     * Meaning:
     *
     *      "What is the furthest index I can reach
     *       using everything I have seen so far?"
     *
     * If:
     *
     *      maxReach >= lastIndex
     *
     * then we can reach the end.
     *
     * Pattern:
     *
     *      Maintain the maximum reachable boundary.
     *
     * ============================================================
     */
    public static boolean jumpGameI(int[] jumpLengths) {
        // arr = [2, 3, 1, 1, 4]
        int maxReach = 0;

        for (int currentIndex = 0;
             currentIndex < jumpLengths.length;
             currentIndex++) {

            /*
             * If currentIndex is already beyond maxReach,
             * we cannot even reach this position.
             */
            if (currentIndex > maxReach) {
                return false;
            }

            /*
             * Extend the furthest reachable boundary.
             */
            maxReach = Math.max(
                    maxReach,
                    currentIndex + jumpLengths[currentIndex]
            );

            /*
             * We have already reached the destination.
             */
            if (maxReach >= jumpLengths.length - 1) {
                return true;
            }

            /*int maxReach = 0;

            for (int i = 0; i < arr.length; i++) {

                if (i > maxReach) {
                    return false;
                }

                maxReach = Math.max(maxReach, i + arr[i]);

                if (maxReach >= arr.length - 1) {
                    return true;
                }
            }

            return true;*/
        }

        return true;
    }
    public static boolean jumpGameOne(int[] nums) {
        // arr = [2, 3, 1, 1, 4]
        int n = nums.length;
        int maxReach = 0;
        for(int i=0; i<n; i++) {
            // at anypoint the maxReach goes beyond
            if(i > maxReach) return false;

            maxReach = Math.max(maxReach, i + nums[i]);
            if(maxReach >= n-1) return true;
        }
        return false;
    }



    /*
     * ============================================================
     * 4. JUMP GAME II
     * ============================================================
     *
     * Same array concept as Jump Game I.
     *
     * But now:
     *
     *      Find the MINIMUM number of jumps required.
     *
     *
     * TWO IMPORTANT VARIABLES:
     *
     *      currentEnd
     *      maxReach
     *
     *
     * currentEnd:
     *
     *      Where the CURRENT jump's reachable range ends.
     *
     *
     * maxReach:
     *
     *      Furthest position the NEXT jump can reach.
     *
     *
     * Example:
     *
     *      [2,3,1,1,4]
     *
     * First jump from index 0:
     *
     *      Can reach indices 1 and 2.
     *
     * Therefore:
     *
     *      currentEnd = 2
     *
     * While scanning indices 1 and 2:
     *
     *      index 1 can reach index 4
     *
     * So:
     *
     *      maxReach = 4
     *
     * When:
     *
     *      currentIndex == currentEnd
     *
     * the current jump range is exhausted.
     *
     * Therefore we take another jump:
     *
     *      jumps++
     *      currentEnd = maxReach
     *
     *
     * IMPORTANT MENTAL MODEL:
     *
     *      maxReach
     *          =
     *      "How far can my NEXT jump go?"
     *
     *      currentEnd
     *          =
     *      "Where does my CURRENT jump range end?"
     *
     * ============================================================
     */
    public static int jumpGameII(int[] jumpLengths) {

        int jumps = 0;

        // End of the range covered by the current jump.
        int currentEnd = 0;

        // Furthest position reachable for the next jump.
        int maxReach = 0;

        /*
         * We only need to process until the second-last index.
         * Once the range reaches the last index, we are done.
         */
        for (int currentIndex = 0;
             currentIndex < jumpLengths.length - 1;
             currentIndex++) {

            /*
             * Find how far we can reach from the
             * current jump's range.
             */
            maxReach = Math.max(
                    maxReach,
                    currentIndex + jumpLengths[currentIndex]
            );

            /*
             * Current jump's range has ended.
             *
             * We must take another jump.
             */
            if (currentIndex == currentEnd) {

                jumps++;

                /*
                 * The next jump can now cover everything
                 * up to maxReach.
                 */
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
    public static int jumpGameTwo(int[] nums) {
        // arr = [2, 3, 1, 1, 4]
        int n = nums.length;
        int curEnd = 0;
        int maxReach = 0;
        int jump = 0;

        for(int i=0; i< n-1; i++) {
            // at any point if we can't we from curIndex it's false
            if(i > maxReach) return -1;

            maxReach = Math.max(maxReach, i + nums[i]);

            // we are about to be run out off inner limit we must take a jump
            if(i == curEnd) {
                jump++;
                curEnd = maxReach; // next maxReach will be our curEnd becomes
            }

        }
        return jump;
    }


    /*
     * ============================================================
     * MAIN
     * ============================================================
     *
     * One class -> all problems -> all methods -> one main.
     *
     * This is our learning/reference style.
     *
     * ============================================================
     */
    public static void main(String[] args) {

        // --------------------------------------------------------
        // 1. Assign Cookies
        // --------------------------------------------------------

        int[] childGreed = {1, 2, 3};
        int[] cookieSizes = {1, 1};

        int satisfiedChildren =
                assignCookies(childGreed, cookieSizes);

        System.out.println(
                "Assign Cookies -> " + satisfiedChildren
        );


        // --------------------------------------------------------
        // 2. Lemonade Change
        // --------------------------------------------------------

        int[] bills = {5, 5, 5, 10, 20};

        boolean canProvideChange =
                lemonadeChange(bills);

        System.out.println(
                "Lemonade Change -> " + canProvideChange
        );


        // --------------------------------------------------------
        // 3. Jump Game I
        // --------------------------------------------------------

        int[] jumpArray = {2, 3, 1, 1, 4};

        boolean canReachEnd =
                jumpGameI(jumpArray);

        System.out.println(
                "Jump Game I -> " + canReachEnd
        );

        boolean canReachEndOne =
                jumpGameOne(jumpArray);

        System.out.println(
                "Jump Game I -> " + canReachEndOne
        );


        // --------------------------------------------------------
        // 4. Jump Game II
        // --------------------------------------------------------

        int minimumJumps =
                jumpGameII(jumpArray);

        System.out.println(
                "Jump Game II -> " + minimumJumps
        );

        int minimumJumpsTwo =
                jumpGameTwo(jumpArray);

        System.out.println(
                "Jump Game II -> " + minimumJumpsTwo
        );
    }
}