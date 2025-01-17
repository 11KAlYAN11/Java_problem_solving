package Exceptions;

public class ThrowingUncheckedExceptionExample {
    /*
     * Why Do Unchecked Exceptions Not Require throws in Method Declaration?
     Unlike checked exceptions, unchecked exceptions (RuntimeExceptions) do not require the throws declaration in the method signature because:

     ✅ 1. Compiler Does Not Enforce Handling
     Unchecked exceptions (like NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException) are caused by programming logic errors.
     The compiler does not check if the exception is handled using try-catch or declared with throws.
     Developers are expected to fix these errors in the code rather than force handling.
     */
    
    static void divideByZero() {
        /*
         * This method demonstrates throwing an unchecked exception.
         * An ArithmeticException is thrown to indicate that division by zero is not allowed.
         */
        throw new ArithmeticException("Division by zero is not allowed");
    }

    public static void main(String[] args) {
        try {
            divideByZero(); // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
