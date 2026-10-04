package Algorithms;

import java.util.*;

/*
 * ============================================================
 * GREEDY ALGORITHM - EXAMPLES 2
 * ============================================================
 *
 * Continuing from GreedyExs1:
 *
 * L11 -> Valid Parenthesis String
 * L12 -> Candy
 * L13 -> Fractional Knapsack
 * L14 -> Activity Selection / Maximum Meetings
 *
 * ============================================================
 *
 * GREEDY CORE IDEA
 * ============================================================
 *
 * Greedy problems usually ask:
 *
 * "What is the best local decision I can make right now
 *  that keeps the solution optimal?"
 *
 * The difficult part is NOT the code.
 *
 * The difficult part is identifying:
 *
 *     "What should I greedily optimize?"
 *
 * Examples:
 *
 * Assign Cookies
 * -> satisfy the smallest child with the smallest sufficient cookie
 *
 * Jump Game
 * -> maximize reachable distance
 *
 * Job Sequencing
 * -> take highest profit first
 *
 * Minimum Platforms
 * -> process events chronologically
 *
 * Activity Selection
 * -> choose the activity that finishes earliest
 *
 * Fractional Knapsack
 * -> take highest value/weight ratio first
 *
 * ============================================================
 */

public class GreedyExs2 {

    /*
     * ============================================================
     * L11 - VALID PARENTHESIS STRING
     * ============================================================
     *
     * Problem:
     *
     * We are given a string containing:
     *
     *     '('
     *     ')'
     *     '*'
     *
     * '*' can represent:
     *
     *     '('
     *     ')'
     *     or empty
     *
     * Return true if the string can be a valid parenthesis string.
     *
     * Example:
     *
     * s = "(*)"
     *
     * '*' can become ')' or empty.
     *
     * Therefore:
     *
     *     "(*)"
     *
     * can become:
     *
     *     "()"
     *
     * so answer = true.
     *
     * ------------------------------------------------------------
     *
     * GREEDY IDEA
     * ------------------------------------------------------------
     *
     * Instead of deciding exactly what every '*' should become,
     * maintain a RANGE of possible open-parenthesis counts.
     *
     * minOpen = minimum possible number of unmatched '('
     * maxOpen = maximum possible number of unmatched '('
     *
     * For each character:
     *
     * '('
     *     minOpen++
     *     maxOpen++
     *
     * ')'
     *     minOpen--
     *     maxOpen--
     *
     * '*'
     *
     *     It could be ')'
     *     OR '('
     *     OR empty
     *
     *     Therefore:
     *
     *     minOpen--
     *     maxOpen++
     *
     * ------------------------------------------------------------
     *
     * IMPORTANT
     * ------------------------------------------------------------
     *
     * minOpen can never go below 0.
     *
     * Why?
     *
     * We cannot have negative unmatched opening brackets.
     *
     * So:
     *
     *     minOpen = Math.max(0, minOpen)
     *
     * If maxOpen becomes negative:
     *
     *     impossible
     *
     * because even the most optimistic interpretation cannot
     * balance the string.
     *
     * At the end:
     *
     *     if minOpen == 0
     *
     * there exists at least one valid interpretation.
     *
     * ============================================================
     */

    public static boolean validParenthesisString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char currentCharacter : s.toCharArray()) {

            if (currentCharacter == '(') {

                minOpen++;
                maxOpen++;

            } else if (currentCharacter == ')') {

                minOpen--;
                maxOpen--;

            } else { // '*'

                /*
                 * '*' can behave in the most restrictive way
                 * as ')'
                 */
                minOpen--;

                /*
                 * '*' can behave in the most generous way
                 * as '('
                 */
                maxOpen++;
            }

            /*
             * We can never have fewer than 0 unmatched
             * opening brackets.
             */
            minOpen = Math.max(0, minOpen);

            /*
             * Even the maximum possible number of opening
             * brackets became negative.
             *
             * Therefore there is no possible solution.
             */
            if (maxOpen < 0) {
                return false;
            }
        }

        /*
         * If minimum possible unmatched '(' is zero,
         * we can form a valid parenthesis string.
         */
        return minOpen == 0;
    }


    /*
     * ============================================================
     * L12 - CANDY
     * ============================================================
     *
     * Problem:
     *
     * We have children with ratings.
     *
     * Every child must receive at least one candy.
     *
     * If:
     *
     *     rating[i] > rating[i - 1]
     *
     * then:
     *
     *     candy[i] > candy[i - 1]
     *
     * Similarly:
     *
     *     rating[i] > rating[i + 1]
     *
     * then:
     *
     *     candy[i] > candy[i + 1]
     *
     * Goal:
     *
     * Minimize total candies.
     *
     * Example:
     *
     * ratings = [1, 2, 3]
     *
     * candies = [1, 2, 3]
     *
     * total = 6
     *
     * ------------------------------------------------------------
     *
     * GREEDY IDEA
     * ------------------------------------------------------------
     *
     * There are TWO independent directions:
     *
     *     LEFT -> RIGHT
     *
     *     RIGHT -> LEFT
     *
     * First satisfy the left neighbour condition.
     *
     * Then satisfy the right neighbour condition.
     *
     * ------------------------------------------------------------
     *
     * LEFT -> RIGHT
     * ------------------------------------------------------------
     *
     * If:
     *
     *     ratings[i] > ratings[i - 1]
     *
     * then:
     *
     *     candies[i] = candies[i - 1] + 1
     *
     * ------------------------------------------------------------
     *
     * RIGHT -> LEFT
     * ------------------------------------------------------------
     *
     * If:
     *
     *     ratings[i] > ratings[i + 1]
     *
     * then:
     *
     *     candies[i] = max(
     *         candies[i],
     *         candies[i + 1] + 1
     *     )
     *
     * We use max because the left-to-right requirement may
     * already have given this child more candies.
     *
     * ------------------------------------------------------------
     *
     * GREEDY PATTERN
     * ------------------------------------------------------------
     *
     * When constraints come from BOTH directions:
     *
     *     Solve one direction.
     *     Solve the other direction.
     *     Combine using max().
     *
     * ============================================================
     */

    public static int candy(int[] ratings) {

        int n = ratings.length;

        int[] candies = new int[n];

        /*
         * Everyone must receive at least one candy.
         */
        Arrays.fill(candies, 1);

        /*
         * LEFT -> RIGHT
         */
        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {

                candies[i] = candies[i - 1] + 1;
            }
        }

        /*
         * RIGHT -> LEFT
         *
         * We go backwards because now we want to compare
         * the current child with the right neighbour.
         */
        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {

                candies[i] = Math.max(
                        candies[i],
                        candies[i + 1] + 1
                );
            }
        }

        /*
         * Add all candies.
         */
        int totalCandies = 0;

        for (int candyCount : candies) {
            totalCandies += candyCount;
        }

        return totalCandies;
    }


    /*
     * ============================================================
     * L13 - FRACTIONAL KNAPSACK
     * ============================================================
     *
     * Problem:
     *
     * We have items with:
     *
     *     value
     *     weight
     *
     * Knapsack has limited capacity.
     *
     * IMPORTANT:
     *
     * We ARE allowed to take a fraction of an item.
     *
     * Therefore this is a GREEDY problem.
     *
     * Example:
     *
     * Items:
     *
     * value = 60, weight = 10
     * value = 100, weight = 20
     * value = 120, weight = 30
     *
     * Capacity = 50
     *
     * ------------------------------------------------------------
     *
     * GREEDY CHOICE
     * ------------------------------------------------------------
     *
     * Which item should we take first?
     *
     * NOT:
     *
     *     highest value
     *
     * NOT:
     *
     *     lowest weight
     *
     * Instead:
     *
     *     value / weight
     *
     * The item giving the maximum value for every unit
     * of weight should be taken first.
     *
     * ------------------------------------------------------------
     *
     * Example:
     *
     * Item 1:
     *
     *     60 / 10 = 6
     *
     * Item 2:
     *
     *     100 / 20 = 5
     *
     * Item 3:
     *
     *     120 / 30 = 4
     *
     * Order:
     *
     *     Item 1
     *     Item 2
     *     Item 3
     *
     * ------------------------------------------------------------
     *
     * WHY GREEDY WORKS
     * ------------------------------------------------------------
     *
     * Since fractions are allowed, there is no reason to keep
     * a lower-value-per-unit item while a higher-value-per-unit
     * item is available.
     *
     * If the best ratio item can still fit:
     *
     *     take the whole item
     *
     * Otherwise:
     *
     *     take only the fraction that fits.
     *
     * ============================================================
     */

    public static double fractionalKnapsack(
            int[] values,
            int[] weights,
            int capacity) {

        int n = values.length;

        /*
         * Each row:
         *
         * [0] -> value
         * [1] -> weight
         * [2] -> value/weight ratio
         *
         * We use double for the ratio.
         */
        double[][] items = new double[n][3];

        for (int i = 0; i < n; i++) {

            items[i][0] = values[i];
            items[i][1] = weights[i];
            items[i][2] = (double) values[i] / weights[i];
        }

        /*
         * Highest value/weight ratio first.
         */
        Arrays.sort(
                items,
                (a, b) -> Double.compare(b[2], a[2])
        );

        double maximumValue = 0;

        int remainingCapacity = capacity;

        for (double[] item : items) {

            int value = (int) item[0];
            int weight = (int) item[1];

            /*
             * Whole item fits.
             */
            if (weight <= remainingCapacity) {

                maximumValue += value;

                remainingCapacity -= weight;
            }

            /*
             * Only part of the item can fit.
             */
            else {

                /*
                 * Fraction we can take:
                 *
                 * remainingCapacity / weight
                 */
                maximumValue +=
                        item[2] * remainingCapacity;

                /*
                 * Knapsack is now completely full.
                 */
                break;
            }
        }

        return maximumValue;
    }


    /*
     * ============================================================
     * L14 - ACTIVITY SELECTION / MAXIMUM MEETINGS
     * ============================================================
     *
     * Problem:
     *
     * We have several activities.
     *
     * Each activity has:
     *
     *     start time
     *     end time
     *
     * We can attend only one activity at a time.
     *
     * Goal:
     *
     * Select the maximum number of non-overlapping activities.
     *
     * ------------------------------------------------------------
     *
     * GREEDY CHOICE
     * ------------------------------------------------------------
     *
     * Always select the activity that FINISHES EARLIEST.
     *
     * Why?
     *
     * Suppose we have two possible activities:
     *
     * Activity A finishes at 5.
     * Activity B finishes at 8.
     *
     * If we choose A:
     *
     *     more time remains for future activities.
     *
     * If we choose B:
     *
     *     we unnecessarily block the time from 5 to 8.
     *
     * Therefore:
     *
     *     earliest finish = maximum remaining room
     *
     * ------------------------------------------------------------
     *
     * STEPS
     * ------------------------------------------------------------
     *
     * 1. Sort activities by ending time.
     *
     * 2. Select the first activity.
     *
     * 3. For every next activity:
     *
     *        if start >= lastEnd
     *
     *            select it
     *
     * 4. Update lastEnd.
     *
     * ------------------------------------------------------------
     *
     * This is one of the most important greedy patterns.
     *
     * Remember:
     *
     *     "Maximum number of non-overlapping activities"
     *
     *     =>
     *
     *     "Choose earliest finishing activity."
     *
     * ============================================================
     */

    public static int activitySelection(
            int[] start,
            int[] end) {

        int n = start.length;

        /*
         * Store:
         *
         * [0] -> start
         * [1] -> end
         */
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {

            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        /*
         * Sort by earliest finishing time.
         */
        Arrays.sort(
                activities,
                (a, b) -> Integer.compare(a[1], b[1])
        );

        /*
         * Select the first activity.
         */
        int selectedActivities = 1;

        int lastEndTime = activities[0][1];

        /*
         * Check remaining activities.
         */
        for (int i = 1; i < n; i++) {

            /*
             * Current activity starts after or exactly when
             * the previous selected activity ends.
             *
             * Therefore it does not overlap.
             */
            if (activities[i][0] >= lastEndTime) {

                selectedActivities++;

                lastEndTime = activities[i][1];
            }
        }

        return selectedActivities;
    }


    /*
     * ============================================================
     * MAIN - QUICK TESTING
     * ============================================================
     */

    public static void main(String[] args) {

        /*
         * --------------------------------------------------------
         * L11 - VALID PARENTHESIS STRING
         * --------------------------------------------------------
         */

        String parenthesisString = "(*)";

        System.out.println(
                "L11 Valid Parenthesis String: "
                        + validParenthesisString(parenthesisString)
        );


        /*
         * --------------------------------------------------------
         * L12 - CANDY
         * --------------------------------------------------------
         */

        int[] ratings = {1, 0, 2};

        System.out.println(
                "L12 Candy: "
                        + candy(ratings)
        );


        /*
         * --------------------------------------------------------
         * L13 - FRACTIONAL KNAPSACK
         * --------------------------------------------------------
         */

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};

        int capacity = 50;

        System.out.println(
                "L13 Fractional Knapsack: "
                        + fractionalKnapsack(
                        values,
                        weights,
                        capacity
                )
        );


        /*
         * --------------------------------------------------------
         * L14 - ACTIVITY SELECTION
         * --------------------------------------------------------
         */

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(
                "L14 Activity Selection: "
                        + activitySelection(start, end)
        );
    }
}