package com.learning.java.exceptions;

// Defining a custom checked exception
// Here we are extending the Exception superclass because Exception is the parent for all checked exceptions
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomUserDefinedCheckedExceptionExample {
    // This method checks the age and throws InvalidAgeException if the age is less than 18
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("You must be 18 or older");
        } else {
            System.out.println("Welcome");
        }
    }

    public static void main(String[] args) {
        try {
            int age = 16; // Example age
            checkAge(age); // This will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
