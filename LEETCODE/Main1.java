package LEETCODE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        /* System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3)); */
        /* int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
        String s1 = "asampavanasam";
        System.out.println("IndexOfAsam: "+s1.indexOf("asam")); */
        //System.out.println(addDigits(248));
        //char[] arr = {"h","e","l","l","o"};
        /* char[] arr = {'h','e','l','l','o'};
        reverseString(arr); */
        //System.out.println(isAnagram("asam", "saama"));
        int[] arr={3,2,1,4,6,1,2,3,3,4};
        //System.out.println(missingNumber(arr));
        /* System.out.println(thirdMax(arr));
        String s = new String(); */
        System.out.println('3'-'0');
        System.out.println('4' - '0');
    }
    public static int thirdMax(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        Set<Integer> set1 = new TreeSet<>(); // By default tree set has ascending order preservation
        for(int n: nums) { // 2,3,1
            set1.add(n);
        }
        //Collections.sort(set1); // {1, 2, 3}
        list1.addAll(set1);
        if(list1.size() == 1) { return list1.get(0);} // only 1 largest sending that
        if(list1.size() == 2) { return list1.get(1);} // sending second largest
        // if(list1.size() >= 3) { return list1.get(2);} // third largest // [1,2,3,4,5] -1=5, -2=4, -3=3
        return list1.get(list1.size()-3); // -1 is first largest, -2 is second largest, -3 is third largest
    }

    public static int missingNumber(int[] nums) {
        int len1 = nums.length;
        int absSum = (len1*(len1+1))/2; // (n(n+1))/2;
        int arrSum = 0;
        for(int i: nums) {
            arrSum+= i;
        }
        return absSum-arrSum;
    } 

    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> sCounts = new LinkedHashMap<>();
        //Map<Character,Integer> tCounts = new LinkedHashMap<>();
        if(s.length() != t.length()) {return false;}
        for(char s1:s.toCharArray()) {
            sCounts.put(s1, sCounts.getOrDefault(s1, 0) +1);
        }
       /*  for(char t1:t.toCharArray()) {
            tCounts.put(t1, tCounts.getOrDefault(t1, 0) +1);
        }
        for(Map.Entry<Character, Integer> entry : sCounts.entrySet()) {
            if(entry.getValue() != tCounts.get(entry.getKey())) {
                return false;
            }
        }
        return true; */
        // Optimized and works well for large strings
        // Subtract frequencies for characters in 't'
    for (char c : t.toCharArray()) {
        if (!sCounts.containsKey(c)) {
            return false; // If 't' has a character not in 's', not an anagram
        }
        sCounts.put(c, sCounts.get(c) - 1);
        if (sCounts.get(c) == 0) {
            sCounts.remove(c); // Clean up to optimize space
        }
    }
    
    // If map is empty, strings are anagrams
    return sCounts.isEmpty();
        
    }


    public static void reverseString(char[] s) {
        //if(s.length == 1) {System.out.println(s[0]);}
        for(char ch: s) {
            System.out.println(ch);
        } 
        int left=0, right=s.length-1;
        while(left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        for(char ch: s) {
            System.out.println(ch);
        } 
    }


    public static int addDigits(int num) {
        if(num <= 9) { return num;}
        while(num >= 10) {
            int sum = 0;
            while(num>0) {
                sum += num%10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
    
        int k = 1; // First element is always unique
        for (int i = 1; i < nums.length; i++) { // [1,1,2,2,3,3,3,4]
            if (nums[i] != nums[k - 1]) { // Check if current element is unique
                nums[k] = nums[i]; // Update the position for unique element
                k++; // Move to the next unique position
            }
        }
    
        // Optional: Print the modified array
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    
        return k; // Return the count of unique elements
    }
    public static int removeElement(int[] nums, int val) {
        List<Integer> res1 = new ArrayList<>();
        for(int n: nums) { // 3, 2, 2, 3
            if(n != val) {
                res1.add(n);
            }
        }
        return res1.size();
    }


    public static boolean isPalindrome(String s) {
        if(s.isEmpty() || s.isBlank()) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase(); // Step 1: The replaceAll method removes all characters that aren't letters or numbers (spaces, commas, colons, etc.), leaving us with "AmanaplanacanalPanama". 
        System.out.println(s);
        int left = 0, right = s.length()-1;
        while(left<right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
