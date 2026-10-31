package Algorithms;

import java.util.Arrays;

public class GreedyExs3 {

    /*
     * Problem: Non-overlapping Intervals
     * LeetCode 435
     *
     * Goal:
     * Remove the minimum number of intervals so the remaining
     * intervals do not overlap.
     *
     * Greedy idea:
     * Sort by ending time. Keeping an interval that ends earlier
     * leaves as much room as possible for later intervals.
     *
     * Variant 1 is the approach we derived together:
     * count the valid intervals AFTER the first one, then subtract
     * that count and the first interval from the total.
     *
     * Variant 2 counts removals directly. Both use the same greedy
     * choice, but Variant 1 preserves our original solution style.
     *
     * Time: O(n log n) due to sorting.
     * Auxiliary space: O(1), ignoring sorting implementation details.
     */

    // Variant 1: Our approach — count compatible intervals, then subtract.
    public static int eraseOverlapIntervalsOurWay(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort intervals by their ending coordinate in ascending order.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonCon = 0; // Counts valid intervals AFTER the first interval.
        int n = intervals.length;
        int lastEnd = intervals[0][1]; // The first interval is implicitly kept.

        for (int i = 1; i < n; i++) {
            // If current start >= lastEnd, the current interval can be kept.
            // Equality is allowed: [1,2] and [2,3] do not overlap here.
            if (intervals[i][0] >= lastEnd) {
                nonCon++;
                lastEnd = intervals[i][1]; // Update only when we keep it.
            }
            // Otherwise it overlaps, so skip it and leave lastEnd unchanged.
        }

        // nonCon excludes the first interval, which is already implicitly kept.
        // Total kept = nonCon + 1; removals = n - (nonCon + 1).
        return n - nonCon - 1;
    }

    // Variant 2: Same greedy strategy, but count removed intervals directly.
    public static int eraseOverlapIntervalsCountRemovals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int lastEnd = intervals[0][1]; // Keep the earliest-ending interval first.

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlap: because of end-time sorting, skip the current interval.
                removed++;
            } else {
                // No overlap: keep it and move the end boundary forward.
                lastEnd = intervals[i][1];
            }
        }

        return removed;
    }

    public static void main(String[] args) {
        int[][] example1 = {{1, 2}, {2, 3}, {1, 3}};
        System.out.println("Example 1 - our approach: " +
                eraseOverlapIntervalsOurWay(copyIntervals(example1))); // Expected: 1
        System.out.println("Example 1 - direct removals: " +
                eraseOverlapIntervalsCountRemovals(copyIntervals(example1))); // Expected: 1

        int[][] example2 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Example 2 - our approach: " +
                eraseOverlapIntervalsOurWay(copyIntervals(example2))); // Expected: 1
        System.out.println("Example 2 - direct removals: " +
                eraseOverlapIntervalsCountRemovals(copyIntervals(example2))); // Expected: 1

        int[][] example3 = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println("Example 3 - our approach: " +
                eraseOverlapIntervalsOurWay(copyIntervals(example3))); // Expected: 2
        System.out.println("Example 3 - direct removals: " +
                eraseOverlapIntervalsCountRemovals(copyIntervals(example3))); // Expected: 2

        int[][] example4 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Example 4 - our approach: " +
                eraseOverlapIntervalsOurWay(copyIntervals(example4))); // Expected: 0
        System.out.println("Example 4 - direct removals: " +
                eraseOverlapIntervalsCountRemovals(copyIntervals(example4))); // Expected: 0
    }

    // The methods sort their input in place, so make a fresh copy for each test.
    private static int[][] copyIntervals(int[][] intervals) {
        int[][] copy = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            copy[i][0] = intervals[i][0];
            copy[i][1] = intervals[i][1];
        }
        return copy;
    }
}
