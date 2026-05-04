package Exceptions;

/*
=====================================================================================
                    JAVA EXCEPTION HANDLING COMPLETE MASTERCLASS
=====================================================================================

DEFINITION:
-----------
Exception is an unwanted/unexpected event that occurs during program execution
and disrupts normal flow of program.

=====================================================================================
WHY EXCEPTION HANDLING IS IMPORTANT
=====================================================================================

Without exception handling:
---------------------------
Program terminates abnormally.

With exception handling:
------------------------
Program continues gracefully.

=====================================================================================
HIERARCHY
=====================================================================================

                    Throwable
                    /      \
                   /        \
               Error      Exception
                               \
                                \
                          RuntimeException

=====================================================================================
1. ERROR
=====================================================================================

Serious JVM problems.

Examples:
---------
- OutOfMemoryError
- StackOverflowError

Usually NOT handled.

=====================================================================================
2. EXCEPTION
=====================================================================================

Application-level problems.

Can be handled.

=====================================================================================
TYPES OF EXCEPTIONS
=====================================================================================

1. Checked Exceptions
2. Unchecked Exceptions

=====================================================================================
CHECKED EXCEPTIONS
=====================================================================================

Checked at COMPILE TIME.

Must handle OR declare using throws.

Examples:
---------
- IOException
- SQLException
- FileNotFoundException

=====================================================================================
UNCHECKED EXCEPTIONS
=====================================================================================

Occur at RUNTIME.

Not checked at compile time.

Examples:
---------
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException

=====================================================================================
KEYWORDS
=====================================================================================

try
catch
finally
throw
throws

=====================================================================================
IMPORTANT RULES
=====================================================================================

1. try must be followed by catch or finally

2. finally block executes ALWAYS
   (except System.exit())

3. Multiple catch blocks allowed

4. Specific catch should come first

Correct:
--------
catch(ArithmeticException e)
catch(Exception e)

Wrong:
------
catch(Exception e)
catch(ArithmeticException e)

=====================================================================================
CUSTOM EXCEPTION
=====================================================================================

User-defined exception by extending Exception class.

=====================================================================================
THROW vs THROWS
=====================================================================================

throw:
------
Used to explicitly throw exception object.

throws:
-------
Used to declare exception in method signature.

=====================================================================================
FINAL vs FINALLY vs FINALIZE
=====================================================================================

final:
------
Keyword

finally:
--------
Exception handling block

finalize():
-----------
GC cleanup method (deprecated)

=====================================================================================
COMPLETE PROGRAM
=====================================================================================
*/

import java.io.*;
import java.util.Scanner;

/* ================================================================================
   CUSTOM EXCEPTION
   ================================================================================ */

class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionMasterClass {

    /*
    ================================================================================
    throws EXAMPLE
    ================================================================================
    */

    static void checkAge(int age)
            throws InvalidAgeException {

        if (age < 18) {

            /*
            =========================================================================
            throw EXAMPLE
            =========================================================================
            */

            throw new InvalidAgeException(
                    "Age must be 18 or above"
            );
        }

        System.out.println("Eligible for voting");
    }

    public static void main(String[] args) {

        /*
        ================================================================================
        1. ARITHMETIC EXCEPTION
        ================================================================================
        */

        System.out.println(
                "================ ARITHMETIC EXCEPTION ================"
        );

        try {

            int a = 10 / 0;

            System.out.println(a);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Cannot divide by zero"
            );

            System.out.println(
                    "Exception Message: " + e.getMessage()
            );
        }

        System.out.println();

        /*
        ================================================================================
        2. NULL POINTER EXCEPTION
        ================================================================================
        */

        System.out.println(
                "================ NULL POINTER EXCEPTION ================"
        );

        try {

            String str = null;

            System.out.println(str.length());

        } catch (NullPointerException e) {

            System.out.println(
                    "String is null"
            );
        }

        System.out.println();

        /*
        ================================================================================
        3. ARRAY INDEX OUT OF BOUNDS
        ================================================================================
        */

        System.out.println(
                "================ ARRAY INDEX EXCEPTION ================"
        );

        try {

            int[] arr = {10, 20, 30};

            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Invalid array index"
            );
        }

        System.out.println();

        /*
        ================================================================================
        4. NUMBER FORMAT EXCEPTION
        ================================================================================
        */

        System.out.println(
                "================ NUMBER FORMAT EXCEPTION ================"
        );

        try {

            int num = Integer.parseInt("ABC");

            System.out.println(num);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid number format"
            );
        }

        System.out.println();

        /*
        ================================================================================
        5. MULTIPLE CATCH BLOCKS
        ================================================================================
        */

        System.out.println(
                "================ MULTIPLE CATCH ================"
        );

        try {

            int[] arr = {1, 2};

            System.out.println(arr[5]);

            int x = 10 / 0;

        }

        catch (ArithmeticException e) {

            System.out.println(
                    "Arithmetic Exception"
            );
        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Array Index Exception"
            );
        }

        catch (Exception e) {

            System.out.println(
                    "Generic Exception"
            );
        }

        System.out.println();

        /*
        ================================================================================
        6. FINALLY BLOCK
        ================================================================================
        */

        System.out.println(
                "================ FINALLY BLOCK ================"
        );

        try {

            int x = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println(
                    "Exception occurred"
            );

        } finally {

            /*
            finally always executes
            */

            System.out.println(
                    "Finally block executed"
            );
        }

        System.out.println();

        /*
        ================================================================================
        7. FILE HANDLING CHECKED EXCEPTION
        ================================================================================
        */

        System.out.println(
                "================ CHECKED EXCEPTION ================"
        );

        try {

            FileReader fr =
                    new FileReader("abc.txt");

            BufferedReader br =
                    new BufferedReader(fr);

            System.out.println(br.readLine());

        }

        catch (FileNotFoundException e) {

            System.out.println(
                    "File not found"
            );
        }

        catch (IOException e) {

            System.out.println(
                    "IO Exception occurred"
            );
        }

        System.out.println();

        /*
        ================================================================================
        8. CUSTOM EXCEPTION
        ================================================================================
        */

        System.out.println(
                "================ CUSTOM EXCEPTION ================"
        );

        try {

            checkAge(16);

        }

        catch (InvalidAgeException e) {

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println();

        /*
        ================================================================================
        9. NESTED TRY
        ================================================================================
        */

        System.out.println(
                "================ NESTED TRY ================"
        );

        try {

            try {

                int x = 10 / 0;

            } catch (ArithmeticException e) {

                System.out.println(
                        "Inner catch block"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Outer catch block"
            );
        }

        System.out.println();

        /*
        ================================================================================
        10. TRY WITH RESOURCES
        ================================================================================
        */

        System.out.println(
                "================ TRY WITH RESOURCES ================"
        );

        /*
        Auto closes resources.
        Introduced in Java 7.
        */

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println(
                    "Try-with-resources executed"
            );

        } catch (Exception e) {

            System.out.println(
                    "Exception occurred"
            );
        }

        System.out.println();

        /*
        ================================================================================
        11. STACK TRACE
        ================================================================================
        */

        System.out.println(
                "================ STACK TRACE ================"
        );

        try {

            int x = 100 / 0;

        } catch (Exception e) {

            /*
            Prints complete exception details
            */

            e.printStackTrace();
        }

        System.out.println();

        /*
        ================================================================================
        12. IMPORTANT METHODS
        ================================================================================
        */

        System.out.println(
                "================ EXCEPTION METHODS ================"
        );

        try {

            String s = null;

            s.length();

        } catch (Exception e) {

            System.out.println(
                    "Message: " + e.getMessage()
            );

            System.out.println(
                    "toString(): " + e.toString()
            );

            System.out.println(
                    "Class Name: " + e.getClass()
            );
        }

        System.out.println();

        /*
        ================================================================================
        13. INTERVIEW NOTES
        ================================================================================
        */

        System.out.println(
                "================ INTERVIEW NOTES ================"
        );

        System.out.println(
                "Exception = Recoverable problem"
        );

        System.out.println(
                "Error = Non-recoverable JVM problem"
        );

        System.out.println(
                "Checked Exception -> Compile time"
        );

        System.out.println(
                "Unchecked Exception -> Runtime"
        );

        System.out.println(
                "finally always executes"
        );

        System.out.println(
                "throw used to explicitly throw exception"
        );

        System.out.println(
                "throws used for declaration"
        );

        System.out.println(
                "Try-with-resources auto closes resources"
        );

        System.out.println();

        /*
        ================================================================================
        14. COMMON RUNTIME EXCEPTIONS
        ================================================================================
        */

        System.out.println(
                "================ COMMON EXCEPTIONS ================"
        );

        System.out.println(
                "ArithmeticException"
        );

        System.out.println(
                "NullPointerException"
        );

        System.out.println(
                "ArrayIndexOutOfBoundsException"
        );

        System.out.println(
                "StringIndexOutOfBoundsException"
        );

        System.out.println(
                "ClassCastException"
        );

        System.out.println(
                "NumberFormatException"
        );

        System.out.println();

        /*
        ================================================================================
        15. FINAL SUMMARY
        ================================================================================
        */

        System.out.println(
                "================ FINAL SUMMARY ================"
        );

        System.out.println(
                "try -> risky code"
        );

        System.out.println(
                "catch -> handles exception"
        );

        System.out.println(
                "finally -> cleanup block"
        );

        System.out.println(
                "throw -> manually throw exception"
        );

        System.out.println(
                "throws -> declares exception"
        );

        System.out.println(
                "Custom exceptions improve readability"
        );

        System.out.println(
                "Proper exception handling prevents abnormal termination"
        );
    }
}
