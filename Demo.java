import java.util.*;
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
    }
}
