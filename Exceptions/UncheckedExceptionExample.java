package com.learning.java.exceptions;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            /*
             * Examples of Unchecked Exceptions:
             * - ArithmeticException: Thrown when an exceptional arithmetic condition has occurred, e.g., division by zero.
             * - NullPointerException: Thrown when an application attempts to use null in a case where an object is required.
             * - ArrayIndexOutOfBoundsException: Thrown to indicate that an array has been accessed with an illegal index.
             * - ClassCastException: Thrown when an object is cast to a subclass of which it is not an instance.
             */
            //int a = 5 / 0; // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            // The finally block executes regardless of whether an exception occurred or not.
            System.out.println("Program Executed Successfully");
        }
    }
}
