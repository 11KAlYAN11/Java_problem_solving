package com.learning.java.exceptions;

public class E2 {
    // This method demonstrates throwing unchecked exceptions based on input conditions.
    // It throws NullPointerException if both a and b are zero, 
    // ArithmeticException if b is zero, and 
    // a custom exception if a is zero.
    public static void mtd(int a, int b) throws CustomizeException {
        int res;
        if (a == 0 && b == 0) {
            // This is an unchecked exception
            throw new NullPointerException("Both a & b are zeros; no sense of divide");
        }
        if (b == 0) {
            // This is an unchecked exception
            throw new ArithmeticException("Cannot divide by zero");
        }
        if (a == 0) {
            // This is a custom unchecked exception
            throw new CustomizeException("Of course, 'a' can be zero");
        } else {
            res = a / b;
        }
        System.out.println(res);
    }

    // The main method demonstrates calling mtd with parameters that trigger exceptions.
    public static void main(String[] args) {
        try {
            mtd(0, 0); // This will throw a NullPointerException
        } catch (CustomizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
