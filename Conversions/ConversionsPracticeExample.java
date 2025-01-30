/* import java.util.LinkedHashMap;
import java.util.Map; */

public class ConversionsPracticeExample {
    public static void main(String[] args) {
        // int[] numbers = {1,2,3,4,5};
        String s = " ";
        if(s.isBlank()) {
            System.out.println("Str is empty or Blank");
        }


        /* String str = "Coding is fun and challenging BangloreAndraPradesh";
        String[] res1 = str.split(" ");
        int len=0;
        String lenStr="";
        for(String s: res1) { // for(String s: res1.split(" ")) {
            if(s.length() > len) {
                len = s.length();
                lenStr = s;
            }
        }
        //System.out.println(len);
        //System.out.println(lenStr);
        // challenge
        Map<Character,Integer> resMap = new LinkedHashMap<>();
        for(char c: lenStr.toCharArray()) {
            resMap.put(c,resMap.getOrDefault(c, 0)+1);
        }
        System.out.println("Longest word: " + lenStr);
        // {c:1, h:1, a:1, l:2, e:2, n:1, g:1}
        for(Map.Entry<Character,Integer> entry: resMap.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        } */
    }
}
