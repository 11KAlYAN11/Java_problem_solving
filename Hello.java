package com.learning.java.basics;

public class Hello {
    
   
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(isEven(101));
        System.out.println(isEven1(100));

    }
    public static boolean isEven(int num) {
        return (num & 1) == 0;
        /*
         *   1010   (10 in binary)
            & 0001   (1 in binary)
            ------------
            0000   (Result = 0)

            1001   (9 in binary)
            & 0001   (1 in binary)
            ------------
            0001   (Result = 1)
         */
    }
    public static boolean isEven1(int num) {
        int absN = Math.abs(num);
        boolean out = true;
        for(int i=0; i<absN; i++) {
            out = !out; // keep on fliping from true to false, false to true
        }
        return out;
    }

    
}
