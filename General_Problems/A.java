package General_Problems;

import java.util.HashSet;

public class A {

    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444};
        System.out.println(isPalinArray(arr));

        LongestUniqueString();
        String[] arrStr = {"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(longestCommonPrefix(arrStr));
    }

    public static boolean isPalinArray(int[] arr) {
        // code here.
        boolean isPalin = false;
        for(int i: arr) {
            isPalin = palindrome(i);
            if(!isPalin) return false;
        }
        return true;
    }
    
    public static boolean palindrome(int n) {
        int n1 = n;
        int prdt = 0;
        
        while(n1 > 0) {
            int dig = n1 % 10;
            prdt = prdt * 10 + dig;
            n1 /= 10;
        }
        if(prdt == n) return true;
        return false;
    }

    public static void LongestUniqueString() {
        String s = "geeksforgeeks";
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) {
            while(set.contains(c)) {
                maxLen = Math.max(maxLen, set.size());
                set.remove(c);
            }
            set.add(c);
        }

        System.out.println(maxLen);
    }

     public static String longestCommonPrefix(String arr[]) {
        // code here
        StringBuilder sb = new StringBuilder();
        if(arr.length == 1) return arr[0];
        
        int count = 0;
        String s = arr[0]; // First will see by taking the first String
        
        // char c = s.charAt(count);
        boolean reached = false;
        for(char ch: s.toCharArray()) {
        
            for(int i=0; i<arr.length; i++) {
                String s1 = arr[i];
                if(ch != s1.charAt(count)) {
                    reached = true;
                    break;
                }
            }

            if(reached) break;
            // We have to increase the count 
            count++;
        }
        return s.substring(0,count);
    }
}
