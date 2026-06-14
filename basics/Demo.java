package basics;

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
