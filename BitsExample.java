package com.learning.java.basics;

public class BitsExample {
    public static void main(String[] args) {
        int n=14;
        int n1 = n;
        StringBuilder sb = new StringBuilder();
        while(n1>0) {
            sb.append(n1%2);
            n1/=2; // As we need to find base of 2 binary so div by 10
        }
        System.out.println(sb.toString());
        
        // other inbuilt methods
        String binary = Integer.toBinaryString(n);
        System.out.println("Binary of " + n + " is: " + binary);

        String str = Integer.toString(n,2); // to which format would we like to convert
        System.out.println(str);

        int a = Integer.parseInt(str,2);
        System.out.println(a);
    }
}
