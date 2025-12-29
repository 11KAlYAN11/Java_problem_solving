
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

package com.learning.java.general_problems;

public class FaQProb1 {
    public static void main(String[] args) {
        removeDuplicates();
        longestCommonPrefix();
        intersection();
        union();
        isAnagram();
        reverseString();
        palindrome();
        primeOrNot();
    }

    public static void removeDuplicates() {
        // General method via converting to Set
        int[] arr1 = {2,4,6,8,6,2,4,5};
        Set<Integer> set = new HashSet<>(); // If you want order youcan use LinkedHashSet
        for(int dig : arr1) {
            set.add(dig);
        } // Now set is unique by default
        set.forEach(System.out::print);

        // By using streams
        int[] unique = Arrays.stream(arr1).distinct().toArray();
        System.out.println();
        for(int uni: unique) {
            System.out.print(uni+" ");
        }

        // Using boolean Seen
        boolean[] seen = new boolean[100]; // it is capable till 100 values "limited use cases"
        System.out.println();
        for(int se: arr1) {
            if(!seen[se]) {
                System.out.println(se);
                seen[se] = true; // now marked that position as seen
            }
        }
    }

    public static void longestCommonPrefix() {
        String[] listOfNames = {"Asam", "Asammmm"};
        // Now we need to compare 1st and 2nd string
        String firstStr = listOfNames[0];
        String lastString = listOfNames[listOfNames.length - 1]; // last String
        int i = 0;
        while(i<firstStr.length() && i<lastString.length() && firstStr.charAt(i) == lastString.charAt(i)) { // untill both are equal len and same characters
            i++;
        }
        System.out.println("Longest Common Prefix: "+ firstStr.substring(0, i));
    }

    public static void intersection() {

    /*
     =========================================================
      INPUT ARRAYS
     =========================================================
      arri  -> first array
      arrii -> second array

      Example:
      arri  = [1, 2, 2, 1]
      arrii = [2, 2]
     =========================================================
    */

    int[] arri  = {1, 2, 2, 1};
    int[] arrii = {2, 2};

    /* =========================================================
       METHOD 1 : INTERSECTION WITH DUPLICATES
       (LeetCode 350 – Intersection of Two Arrays II)

       RULE:
       - Each element should appear as many times as it appears
         in BOTH arrays.

       Expected Output:
       [2, 2]

       LOGIC:
       - Convert second array into a List
       - For each element in first array:
           - If present in list → add to result
           - Remove that ONE occurrence from list
       =========================================================
    */

    List<Integer> list = new ArrayList<>();
    List<Integer> resList = new ArrayList<>();

    // Convert second array to List
    for (int i : arrii) {
        list.add(i);
    }
    // list = [2, 2]

    // Traverse first array
    for (int k : arri) {
        if (list.contains(k)) {
            resList.add(k);                // add matched value
            list.remove(Integer.valueOf(k)); // remove ONE occurrence
        }
    }

    // Output: [2, 2]
    System.out.println("Method 1 - Duplicate Intersection:");
    resList.forEach(i -> System.out.print(i + " "));



    /* =========================================================
       METHOD 2 : UNIQUE INTERSECTION
       (LeetCode 349 – Intersection of Two Arrays)

       RULE:
       - Only UNIQUE common elements
       - No duplicates allowed

       Expected Output:
       [2]

       LOGIC:
       - Use Set to automatically avoid duplicates
       - TreeSet is used for:
           ✔ uniqueness
           ✔ sorted order
       =========================================================
    */

    List<Integer> list2 = new ArrayList<>();
    Set<Integer> resList2 = new TreeSet<>();

    // Convert second array to List
    for (int i : arrii) {
        list2.add(i);
    }
    // list2 = [2, 2]

    // Traverse first array
    for (int k : arri) {
        if (list2.contains(k)) {
            resList2.add(k);                // Set avoids duplicates
            list2.remove(Integer.valueOf(k)); // optional removal
        }
    }

    // Output: [2]
    System.out.println("\n\nMethod 2 - Unique Intersection:");
    resList2.forEach(System.out::println);



    /* =========================================================
       METHOD 3 : OPTIMIZED INTERSECTION (BEST PRACTICE)
       (Using HashMap – Industry Standard)

       WORKS FOR:
       ✔ duplicate intersection
       ✔ unique intersection (just switch List → Set)

       TIME COMPLEXITY:
       O(n + m)

       SPACE COMPLEXITY:
       O(n)

       LOGIC:
       - Store frequencies of elements from first array
       - Traverse second array:
           - If count > 0 → add to result
           - Decrease count to avoid duplicates
       =========================================================
    */

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> resa = new ArrayList<>();
    // For UNIQUE intersection → use Set<Integer> instead

    // Count frequency of elements in first array
    for (int i : arri) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }
    // map = {1=2, 2=2}

    // Traverse second array
    for (int i1 : arrii) {
        if (map.getOrDefault(i1, 0) > 0) {
            resa.add(i1);                   // add common element
            map.put(i1, map.get(i1) - 1);   // reduce count
        }
    }

    // Output: [2, 2]
    System.out.println("\nMethod 3 - Optimized Intersection:");
    resa.forEach(System.out::println);

    }

    public static void union() {

    /*
     =========================================================
      INPUT ARRAYS
      arr1 = [1, 2, 2, 1]
      arr2 = [2, 3]

      Expected Output:
      [1, 2, 3]
     =========================================================
    */

    int[] arr1 = {1, 2, 2, 1};
    int[] arr2 = {2, 3};

    // LinkedHashSet preserves insertion order
    Set<Integer> unionSet = new LinkedHashSet<>();

    // Add all elements from both arrays
    for (int n : arr1) {
        unionSet.add(n);
    }
    for (int n : arr2) {
        unionSet.add(n);
    }

    System.out.println("\nUnion WITHOUT duplicates:");
    unionSet.forEach(i -> System.out.print(i + " "));
    }

    public static void isAnagram() {

    String s = "anagram";
    String t = "nagaram";

    // 1️⃣ Length check (mandatory)
    if (s.length() != t.length()) {
        System.out.println("Not an Anagram");
        return;
    }

    /*
     =================================================
     Using HashMap because:
     ✔ Order does NOT matter
     ✔ Fast lookup
     ✔ Works for any character set
     =================================================
    */
    Map<Character, Integer> counts = new HashMap<>();

    // 2️⃣ Count frequency of characters in s
    for (char c : s.toCharArray()) {
        counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    // 3️⃣ Reduce frequency using t
    for (char c : t.toCharArray()) {

        // Character not present → not an anagram
        if (!counts.containsKey(c)) {
            System.out.println("Not an Anagram");
            return;
        }

        counts.put(c, counts.get(c) - 1);

        // Remove character when count becomes zero
        if (counts.get(c) == 0) {
            counts.remove(c);
        }
    }

    // 4️⃣ If map is empty → perfect anagram
    System.out.println("Is Anagram: " + counts.isEmpty());
}

public static void palindrome() {
    // Basic normal method 1
    String s1 = "akkass";
    s1 = s1.toLowerCase();
    int i=0, j=s1.length()-1;
    while(i<j) {
        if(s1.charAt(i) != s1.charAt(j)) {
            System.out.println("Not a Palindrome! ");
            // return;
            break;
        }
        i++;
        j--;
    }
    System.out.println("Yes!, It's a Palindrome. ");

    // Method 2
    StringBuilder s2 = new StringBuilder();
    int fromLast = s1.length()-1;
    while(fromLast >= 0) {
        s2.append(s1.charAt(fromLast));
        fromLast--;
    }
    String res = new String(s2);
    System.out.println("Is Palindrome: "+s1.equals(res)); // Is s1 and res are equal values

    // method 3: 
    String reversed = new StringBuilder(s1).reverse().toString();
    System.out.println("Palindrome: "+s1.equals(reversed));

    // Method 4: 
    char[] arr = s1.toCharArray();
    int i1 = 0, j1=arr.length-1;
    while(i1 < j1) {
        if(arr[i1++] != arr[j1--]) { 
            System.out.println("Not Palindrome!"); 
            return;
        }
    }
    System.out.println("It's a Palindrome! ");
}
public static void reverseString() {
    String str = "Kumar"; // ramuk
    char[] word = str.toCharArray();
    for(int i=0,j=word.length-1; i<j; i++,j--) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
    String res = new String(word);
    System.out.println("Reversed String: "+res);

    // Method 2
    String reversed = new StringBuilder(str).reverse().toString();
    System.out.println("Palindrome: "+str.equals(reversed));

}
public static void primeOrNot() {
    int num = 99;
    for(int i=2; i*i<num; i++) { // i<19/2  -> (num / 2) -> sqrt(num) = i*i as maths priciple sqrt goes tat side it will become that i*i
        if(num %i == 0) {
            System.out.println("Not Prime! ");
            return;
            // break;
        }
    }
    System.out.println("Prime ");

    // 
}


}
