package General_Problems;

public class A {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "holel";
        String s = "geeksforgeeks";


        String arm = "153";


        String a1 = Integer.toString(10);
        System.out.println(a1);

        String a2 = String.valueOf(10);
        System.out.println(a2);


        int n1 = Integer.parseInt(arm);
        int n2 = Integer.valueOf(arm);
        System.out.println(n1+n2); // so valueOf is smtg like we can use anywhere


        // character encoding
        char ch = '7';

        int n = ch - '0';
        System.out.println(n);

        int nx = 7;
        char ch1 = (char)(nx+'0');
        System.out.println(ch1);


    }
}