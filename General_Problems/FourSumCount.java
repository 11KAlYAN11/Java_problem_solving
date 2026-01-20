package General_Problems;

import java.util.Arrays;
// resource Refer: java -> patternProblemNotes

public class FourSumCount {

    public static int countFourSum(int[] arr, int target) {

        // Always sort first for 2-pointer logic
        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        // First fixed element
        for (int i = 0; i < n - 3; i++) { // needs to be 3 ele

            // Second fixed element
            for (int j = i + 1; j < n - 2; j++) { // needs to be 2 ele's

                int left = j + 1;
                int right = n - 1;

                int remaining = target - arr[i] - arr[j];
                /*
                🔑 WHY BOTH APPROACHES ARE SAME

                Because this equation:

                arr[i] + arr[j] + arr[left] + arr[right] == target


                can be rewritten as:

                arr[left] + arr[right] == target - arr[i] - arr[j]


                So whether you:

                compare full sum to target, OR

                compare partial sum to remaining

                👉 the pointer movements and decisions are identical.

                Integer Overflow (edge case)

                If values are large: (so remaing one is best -> no recalculation)
                 */

                // Two pointer for remaining sum
                while (left < right) {

                    int sum = arr[left] + arr[right];

                    if (sum < remaining) {
                        left++;
                    }
                    else if (sum > remaining) {
                        right--;
                    }
                    else {
                        // ===== MATCH FOUND =====

                        // Case 1: all same values
                        if (arr[left] == arr[right]) {

                            int len = right - left + 1;

                            // choose any 2 from len
                            count += (len * (len - 1)) / 2;
                            break;
                        }

                        // Case 2: different values
                        int leftVal = arr[left];
                        int rightVal = arr[right];

                        int leftCount = 0;
                        int rightCount = 0;

                        while (left < right && arr[left] == leftVal) {
                            left++;
                            leftCount++;
                        }

                        while (left <= right && arr[right] == rightVal) {
                            right--;
                            rightCount++;
                        }

                        count += leftCount * rightCount;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println("4-Sum Count = " + countFourSum(arr, target));
    }
}
