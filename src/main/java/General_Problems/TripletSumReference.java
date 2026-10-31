package General_Problems;

import java.util.*;

/*
 * Find All Triplets With Given Sum
 *
 * Lessons Learned:
 *
 * 1. For "Has Triplet Sum?" only:
 *      - HashSet is enough
 *      - O(n²)
 *
 * 2. For "Return All Triplets (VALUES)":
 *      - Sort + Two Pointers is the cleanest approach
 *      - Naturally handles ordering
 *      - Easier duplicate removal
 *
 * 3. For "Return All Triplets (INDICES)":
 *      - Map<Value, List<Index>>
 *      - One value can occur at multiple positions
 *      - Need List on value side
 *
 * 4. Map Design Rule:
 *      Key   -> What I search for
 *      Value -> Information needed after finding key
 *
 * 5. Why Map<Integer, List<Integer>> ?
 *
 *      arr = [1,2,2,2,5]
 *
 *      2 -> [1,2,3]
 *
 *      If we store only:
 *
 *      2 -> 3
 *
 *      then indices 1 and 2 are lost.
 *
 * 6. HashSet:
 *      - Removes duplicates
 *      - Does NOT preserve order
 *
 * 7. ArrayList:
 *      - Preserves insertion order
 *      - Does NOT remove duplicates
 *
 * 8. HashSet<List<Integer>>
 *      works because List overrides equals() and hashCode().
 *
 * 9. Sort each triplet before inserting into HashSet.
 *
 *      [0,-3,1]
 *      ->
 *      [-3,0,1]
 *
 *      Otherwise same triplet may appear in multiple forms.
 *
 * 10. If problem wants:
 *
 *      [-3,-1,2]
 *      [-3,0,1]
 *
 *      then outer List<List<Integer>>
 *      must also be sorted.
 *
 */
public class TripletSumReference {

    public static List<List<Integer>> findTriplets(int[] arr, int target) {

        int n = arr.length;

        HashSet<List<Integer>> unique = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {

                int need = target - arr[i] - arr[j];

                if (map.containsKey(need)) {

                    for (int idx : map.get(need)) {

                        List<Integer> triplet =
                                new ArrayList<>(
                                        Arrays.asList(
                                                arr[i],
                                                arr[idx],
                                                arr[j]
                                        )
                                );

                        Collections.sort(triplet);

                        unique.add(triplet);
                    }
                }

                map.computeIfAbsent(
                        arr[j],
                        x -> new ArrayList<>()
                ).add(j);
            }
        }

        List<List<Integer>> result =
                new ArrayList<>(unique);

        // Sort outer list lexicographically
        result.sort((a, b) -> {

            for (int i = 0; i < 3; i++) {

                int cmp =
                        Integer.compare(
                                a.get(i),
                                b.get(i)
                        );

                if (cmp != 0) {
                    return cmp;
                }
            }

            return 0;
        });

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};

        int target = -2;

        List<List<Integer>> ans =
                findTriplets(arr, target);

        System.out.println(ans);
    }
}