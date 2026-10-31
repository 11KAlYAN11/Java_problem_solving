package General_Problems;

public class CountThreeSumORcountTripletsProblem {

    public static int countTriplets(int[] arr, int target) {
        /*
            for each i (0 → n-3)
            left = i + 1
            right = n - 1

            while left < right
                if sum < target → left++
                if sum > target → right--
                else
                    if arr[left] == arr[right]
                        count C(n,2)
                        break
                    else
                        count leftGroup × rightGroup
 */

        int n = arr.length;
        int count = 0;

        // ------------------------------------------------------------
        // We fix one element arr[i] and reduce the problem to:
        //   arr[left] + arr[right] = target - arr[i]
        // This is classic TWO POINTER on a sorted array
        //
        // Why i < n-2 ?
        // Because for a triplet we need at least TWO elements after i
        // ------------------------------------------------------------
        for (int i = 0; i < n - 2; i++) {

            // left pointer starts just after i
            int left = i + 1;

            // right pointer starts at the end
            int right = n - 1;

            // --------------------------------------------------------
            // Two pointer traversal for the remaining part of array
            // --------------------------------------------------------
            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                // ----------------------------------------------------
                // If sum is smaller, we need a bigger value
                // Since array is sorted, move left forward
                // ----------------------------------------------------
                if (sum < target) {
                    left++;
                }

                // ----------------------------------------------------
                // If sum is larger, we need a smaller value
                // Move right backward
                // ----------------------------------------------------
                else if (sum > target) {
                    right--;
                }

                // ----------------------------------------------------
                // sum == target → THIS IS THE IMPORTANT PART
                // Here duplicates MUST be handled carefully
                // ----------------------------------------------------
                else {

                    // =================================================
                    // CASE 1:
                    // arr[left] == arr[right]
                    //
                    // Since array is sorted, this means:
                    // ALL elements between left and right are SAME
                    //
                    // Example:
                    //   [ 0, 0, 0, 0 ]
                    //     ^        ^
                    //    left     right
                    //
                    // We must count how many (j, k) index pairs
                    // can be formed from these identical elements
                    //
                    // Number of pairs = C(n,2) = n*(n-1)/2
                    // =================================================
                    if (arr[left] == arr[right]) {

                        int len = right - left + 1;

                        // Count all possible index pairs (j, k)
                        count += (len * (len - 1)) / 2;

                        // All pairs are counted, no need to continue
                        break;
                    }

                    // =================================================
                    // CASE 2:
                    // arr[left] != arr[right]
                    //
                    // This means we have TWO DIFFERENT GROUPS:
                    //   left group  → same values as arr[left]
                    //   right group → same values as arr[right]
                    //
                    // Each left element can pair with
                    // each right element
                    //
                    // Total pairs = leftCount * rightCount
                    // =================================================

                    int leftVal = arr[left];
                    int rightVal = arr[right];

                    int leftCount = 0;
                    int rightCount = 0;

                    // Count duplicates on the left side
                    while (left < right && arr[left] == leftVal) {
                        left++;
                        leftCount++;
                    }

                    // Count duplicates on the right side
                    while (left <= right && arr[right] == rightVal) {
                        right--;
                        rightCount++;
                    }

                    // Multiply combinations from both sides
                    count += leftCount * rightCount;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
         // Test Case 1
        int[] arr1 = {-3, -1, -1, 0, 1, 2};
        int target1 = -2;
        System.out.println("Triplets Count = " + countTriplets(arr1, target1));
        // Expected Output: 4

        // Test Case 2
        int[] arr2 = {-2, 0, 1, 1, 5};
        int target2 = 1;
        System.out.println("Triplets Count = " + countTriplets(arr2, target2));
        // Expected Output: 0

        // Test Case 3 (all duplicates case)
        int[] arr3 = {0, 0, 0, 0};
        int target3 = 0;
        System.out.println("Triplets Count = " + countTriplets(arr3, target3));
        // Expected Output: 4  → C(4,3)
    }
}
