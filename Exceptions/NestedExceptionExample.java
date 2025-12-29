package com.learning.java.exceptions;

public class NestedExceptionExample {
    public static void kalyan() throws Exception{
        try {
            int num = 5/0;
            System.out.println(num);
        }
        catch (ArithmeticException e) {
            System.out.println("Caught in Process: "+e.getMessage());
            throw new Exception("Process failed: "+e); // Wrapping with additional context
        }
    }
    public static void main(String[] args) {
        try{
            kalyan();
        }
        catch(Exception e) {
            System.out.println("Caught in main: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
