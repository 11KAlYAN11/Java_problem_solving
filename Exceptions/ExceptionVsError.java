package Exceptions;

public class ExceptionVsError {
    //Example for infinate recurssive method StackOverflowError run timeError 
    public static void recurssiveMethod() {
        System.out.println("Recusrrice Method called");
        recurssiveMethod();
    }
    public static void main(String[] args) {
         /*
          * 1️⃣ Exception
            Definition: An Exception is a condition that can be caught and handled in the program.
            When it occurs: Due to programming errors or external conditions (e.g., invalid input, file not found, division by zero).
            How to handle: Using try-catch blocks or declaring with throws.
            Types of Exceptions:
            Checked Exception – Must be handled (e.g., IOException, SQLException).
            Unchecked Exception – Occurs at runtime, can be avoided by fixing logic (e.g., NullPointerException, ArrayIndexOutOfBoundsException).
          */
        try {
            int a = 5 / 0; //ArithmaticException (divide by zero)

        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

        /*
         * 2️⃣ Error
            Definition: An Error is a serious problem that CANNOT be handled in the program.
            When it occurs: Due to system-level issues (e.g., memory overflow, infinite recursion, JVM crashes).
            How to handle: Generally, cannot be handled using try-catch. The only option is to fix the root cause.
            Examples of Errors:
            OutOfMemoryError – When JVM runs out of memory.
            StackOverflowError – Due to infinite recursion.
            NoClassDefFoundError – If a required class is missing at runtime.
         */
        recurssiveMethod();
    }
    
}
