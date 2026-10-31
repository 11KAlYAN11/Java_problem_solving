package General_Problems;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 5, 4, 3};
        int[] height2 = {3, 1, 2, 4, 5};

        System.out.println("Input Array:");
        printArray(height);

        System.out.println("\nBrute Force Answer  : "
                + maxWaterBruteForce(height));

        System.out.println("Two Pointer Answer : "
                + maxWaterTwoPointer(height));

                System.out.println("Two Pointer Answer : "
                + maxWaterTwoPointer(height2));
    }

    /*
     * ============================================================
     * APPROACH 1 : BRUTE FORCE
     * ============================================================
     *
     * Idea:
     * -----
     * Try every possible pair (i, j)
     *
     * Water Stored:
     *
     * width  = j - i
     * height = min(arr[i], arr[j])
     *
     * area = width * height
     *
     * Keep track of maximum area found.
     *
     * Time  : O(n²)
     * Space : O(1)
     *
     */
    public static int maxWaterBruteForce(int[] arr) {

        int n = arr.length;
        int maxWater = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int width = j - i;

                int height =
                        Math.min(arr[i], arr[j]);

                int area = width * height;

                maxWater =
                        Math.max(maxWater, area);
            }
        }

        return maxWater;
    }

    /*
     * ============================================================
     * APPROACH 2 : TWO POINTER
     * ============================================================
     *
     * Key Observation:
     * ----------------
     * Area depends on:
     *
     * min(leftHeight, rightHeight)
     * *
     * width
     *
     * Smaller wall limits the water.
     *
     * So:
     *
     * If left wall is smaller:
     *      left++
     *
     * If right wall is smaller:
     *      right--
     *
     * Why?
     * ----
     * Moving the larger wall cannot help because
     * width decreases and limiting wall remains same.
     *
     * Time  : O(n)
     * Space : O(1)
     *
     */
    public static int maxWaterTwoPointer(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int maxWater = 0;

        while (left < right) {

            int width = right - left;

            int height =
                    Math.min(arr[left], arr[right]);

            int area = width * height;

            maxWater =
                    Math.max(maxWater, area);

            if (arr[left] < arr[right]) {

                left++;

            } else {

                right--;
            }
        }

        return maxWater;
    }

    /*
     * Utility Method
     */
    public static void printArray(int[] arr) {

        System.out.print("[ ");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("]");
    }
}
