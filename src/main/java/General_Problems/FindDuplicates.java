package General_Problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int num: arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        // Instead of all the keys and values we can go ike this with only keySet()
        System.out.println();
        for(int key: counts.keySet()) {
            if(counts.get(key) > 1) System.out.print(" "+key);
        }

        return result;
    }

    public static void findDuplicatesBruteForce(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) System.out.print(arr[i]+" ");
            }
        }
    }
    
    public static void findDuplicatesHashSetWay(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        /*  Condition	            Return
            inserted successfully	true
            already exists	        false
         */
        for(int a: arr) {
            if(!set.add(a)) System.out.print(a+" ");
        }

    }

    public static void findDuplicatesHashSetWay(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) {
            if(!set.add(c)) System.out.print(c+" ");
        }
    }

    public static void findDuplicatesUsingFreqArrayTech(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) { 
            freq[c - 'a']++; // character Encoding

            // at any point if count == 2 will print that
            if(freq[c - 'a'] == 2) System.out.print(c+" ");
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3,4,4};
        // HashMap frequency count way
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);

        // Bruteforce duplicate way with 2 loops
        findDuplicatesBruteForce(arr);

        System.out.println();
        findDuplicatesHashSetWay(arr);

        String s = "programming";
        System.out.println();
        findDuplicatesHashSetWay(s); // overloading 😊

        System.out.println();
        findDuplicatesUsingFreqArrayTech(s);

    }

    /* This Solves MANY Problems

        Using SAME frequency logic:

        Problem	Logic
        duplicates	freq > 1
        unique	freq == 1
        majority element	freq > n/2
        first non-repeating	freq == 1
        anagram	same frequencies
        character count	hashmap
top K frequent	hashmap + heap
     */
}
