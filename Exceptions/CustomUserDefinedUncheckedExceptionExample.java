package Exceptions;

// Here we are implementing the Custom User defined Unchecked exception
// Here we are extending RuntimeException because it is the parent for defining custom unchecked exceptions at runtime
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

/*
 * Why Do Unchecked Exceptions Not Require throws in Method Declaration?
Unlike checked exceptions, unchecked exceptions (RuntimeExceptions) do not require the throws declaration in the method signature because:

✅ 1. Compiler Does Not Enforce Handling
Unchecked exceptions (like NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException) are caused by programming logic errors.
The compiler does not check if the exception is handled using try-catch or declared with throws.
Developers are expected to fix these errors in the code rather than force handling.
 */

public class CustomUserDefinedUncheckedExceptionExample {
    static void validateInput(int num) {
        if(num < 0) {
            throw new InvalidInputException("Negative numbers not allowed");
        }
        System.out.println("Valid input: " + num);
    }

    public static void main(String[] args) {
        validateInput(-5); // No need to handle explicitly
    }
}
