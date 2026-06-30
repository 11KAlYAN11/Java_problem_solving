package basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class Demo {
    public static boolean validParenthisis(String s) {
        //Easy method
        /* while(true) {
            if(s.contains("()")) {
                s = s.replace("()", "");
            }
            else if(s.contains("{}")) {
                s = s.replace("{}", "");
            }
            else if(s.contains("[]")) {
                s = s.replace("[]", "");
            }
            else {
                return s.isEmpty();
            }
        } */

            // Traditional approch
        /* Stack<Character> s1 = new Stack<>();    
        for(char c: s.toCharArray()) {
            if(c=='(' || c == '{' || c == '[') {
                s1.push(c);
            }

            else {
                if(s1.isEmpty()) return false;
                char top = s1.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        } 
        return s1.isEmpty();   */
        
       //method 02
       Stack<Character> stack = new Stack<>();
       for(char c: s.toCharArray()) {
        if( c == '(')
        stack.push(')');
        else if(c == '{') 
        stack.push('}');
        else if (c == '[')
        stack.push(']');
        else if(stack.isEmpty() || stack.pop() != c)
        return false;
       }
       return stack.isEmpty();
    }
    public static void plusOne(int[] digits) {
        int len = digits.length-1;
        for(int x: digits){ System.out.print(x);}
        //int temp;
        //List<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0; i<=len; i++) {
            if(i==len){
                //arr.set(len, arr.get(i)+1);
                digits[i] = digits[i]+1;
             }
        }
        for(int x: digits){ System.out.print(x);}
    }

    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        // We will add the -ve's to the Queue if invlaid will pop it again
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length;
        int slow = 0; // 1 -> 2 -> 3 -> 
        
        for(int i=0; i<n; i++) { // 1 -> 2 -> 3 -> 4->  
                    if(arr[i] < 0) queue.add(arr[i]); 
            
            if(i-slow+1 == k) { // win size reached
                if(!queue.isEmpty()) list.add(queue.peek())                                                                         ;
                else list.add(0);
                
                // We have to remove the out going element
                if(!queue.isEmpty() && arr[slow] == queue.peek()) queue.poll();
                slow++;
            }
        }
        return list;
        
    }

    public static boolean isPalinSent(String s) {
        // code here
        s = s.toLowerCase().strip();
        StringBuilder sb = new StringBuilder();
        // for(char c: s.toCharArray()) {
        for(int i=0; i<s.length(); i++) {
            // We have to allow only the alphaNumerics chars
            // lettrs fron ato z and A to Z and 0 to 9 except this all should be discarded
            if(Character.isLetterOrDigit(s.charAt(i))) sb.append(s.charAt(i));
        }
        
        // return sb.equals(sb.reverse()); // This will not work bcz this sb always compares the memory ref's so 
        s = sb.toString();
        System.out.println("Is this line palindrome?: ");
        return s.equals(sb.toString()); 
    }
    public static void main(String[] args) {
        String str = "{{}[](){[()]}";
        System.out.println(validParenthisis(str));
        int[] numbers = {1,2,3,4,5};
        plusOne(numbers);

        Number n1 = 10;
        Number n2 = 10.0f;
        Number n3 = 10.0;

        String s = "i.like.this.program.very.much";
        String[] arr = s.split("\\."); 
        /*
        split("\\.")
        split("\\|")
        split("\\*")
        split("\\$") */
        for(String s1: arr) {
            System.out.println(s1);
        }

        System.out.println(isPalinSent("Too hot to hoot"));
        int[] arrx = {-8,2,3,-6,10};
        System.out.println(firstNegInt(arrx, 2));
        // return " ";

        /*IMPORTANT CONCEPT:
        ------------------
        Integer, Double, Float, Long etc
        all extends Number class.

        Hierarchy:

                Object
                ↑
                Number
            ┌────┼────┐
        Integer Double Float

        So:

            Number n = new Integer(10);

        is VALID because:
            Integer IS-A Number

         */

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

    }
}
