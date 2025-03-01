import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
/*
 * Resources for all this Note book & Note pad Don't  forgot
 */

public class PrintAllSubsets {
    public static void PrintAllSubsetsOfArray(Vector<Integer> arr, Vector<Integer> res, int i) {
        // Base Case: If we reached the end, print the subset and return
        if(i == arr.size()) {
            System.out.println(res);
            return;
        }

        // Include the current element
        res.add(arr.get(i));
        PrintAllSubsetsOfArray(arr, res, i+1);

        // Exclude the current element
        // res.remove(res.size() - 1); // Always removes the LAST element added (backtracking step)
        // This below one is main & Backtracking step
        res.remove(res.size() - 1);
        PrintAllSubsetsOfArray(arr, res, i+1);
    }


    public static void findSubsets(Vector<Integer> arr, Vector<Integer> res, int i, List<List<Integer>> ansSubsets) {
        // Base Case: If all elements have been considered
        if (i == arr.size()) {
            ansSubsets.add(new ArrayList<>(res)); // Store the subset (copy of res)
            return;
        }

        /* // **1️⃣ Exclude current element**
        findSubsets(arr, res, i + 1, ansSubsets);

        // **2️⃣ Include current element**
        res.add(arr.get(i)); 
        findSubsets(arr, res, i + 1, ansSubsets);
        
        // **Backtrack: Remove last element to restore the state**
        res.remove(res.size() - 1);
        // [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]] */

        res.add(arr.get(i));   // Include
        findSubsets(arr, res, i + 1, ansSubsets);
        res.remove(res.size() - 1);   // Exclude (Backtrack)
        findSubsets(arr, res, i + 1, ansSubsets);
        // [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
        /*
        follow Note book & One Note for more clear info
         *                []
                         /       \
                      [1]          []
                     /   \        /     \
                 [1,2]   [1]      [2]     []
                 /   \    / \       / \     / \
         [1,2,3]  [1,2] [1,3] [1] [2,3] [2] [3] []

         */
    }

    public static List<List<Integer>> subsets(Vector<Integer> nums) {
        List<List<Integer>> ansSubsets = new ArrayList<>();
        Vector<Integer> res = new Vector<>(); // Stores the current subset
        findSubsets(nums, res, 0, ansSubsets);
        return ansSubsets;
    }

    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>(Arrays.asList(1,2,3));
        Vector<Integer> res = new Vector<>();
        PrintAllSubsetsOfArray(arr, res, 0);
        int[] asam = {1,2,3,4};
        System.out.println(Arrays.toString(asam));

        Vector<Integer> nums1 = new Vector<>(Arrays.asList(1, 2, 3));
        System.out.println(subsets(nums1));

        Vector<Integer> nums2 = new Vector<>(Arrays.asList(0));
        System.out.println(subsets(nums2));
    }
}
