package General_Problems;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams { // GroupAnagrams
    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>(); // bcz in map will store hash: count 
        
        // this map1 is for 2nd method
        HashMap<String, ArrayList<String>> map1 = new HashMap<>();
        
        /*for(int i=0; i<arr.length; i++) {
            
            String hash = getHash(arr[i]);
            
            if(!map.containsKey(hash)) { // If our map is not having the key add it
                map.put(hash, map.size()); // adding that map.size() it bit tricky bit guessable
                res.add(new ArrayList<>());
            }
            res.get(map.get(hash)).add(arr[i]);
        }
        return res;*/
        for(String s: arr) {
            String hash = getHash(s);
            
            map1.putIfAbsent(hash, new ArrayList<>());
            map1.get(hash).add(s);
        }
        return new ArrayList<>(map1.values());
        /* Side-by-side mental model 🧠
            Problem type	    Map value	    Pattern
            Count things	    Integer	        getOrDefault + 1
            Store indices	    List<Integer>	putIfAbsent + add
            Group strings	    List<String>	computeIfAbsent + add
            Prefix sum freq	    Integer	        getOrDefault + 1
            Prefix sum index	Integer	        putIfAbsent

            One-liner rule to remember forever 🔥
            Map value decides the pattern.
            Numbers → getOrDefault + math
            Collections → putIfAbsent / computeIfAbsent + add
         */
    }
    
    // helper method
    public static String getHash(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        
        for(char c: s.toCharArray()) freq[c - 'a']++; 
        
        for(int i=0; i<freq.length; i++) {
            sb.append(freq[i]);
            sb.append("$"); // delimeter is must if frequency of any cahrs go beyond single digit 
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        ArrayList<ArrayList<String>> res = anagrams(arr);
        for(ArrayList<String> s: res) {
            System.out.println(s.toString());
        }
    }
}
