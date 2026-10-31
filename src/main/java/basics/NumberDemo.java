package basics;

/*
========================================================
NUMBER CLASS + POLYMORPHISM + ARRAY COVARIANCE
========================================================

IMPORTANT CONCEPT:
------------------
Integer, Double, Float, Long etc
all extends Number class.

Hierarchy:

        Object
           ↑
         Number
      ┌────┼────┐
   Integer Double Float

So:

    Number n = new Integer(10);

is VALID because:
    Integer IS-A Number

--------------------------------------------------------
1) POLYMORPHISM
--------------------------------------------------------

Parent reference can hold child object.

Example:

    Number n1 = 10;      // Integer object
    Number n2 = 10.5;   // Double object

Compiler does AUTOBOXING:

    10    -> Integer.valueOf(10)
    10.5  -> Double.valueOf(10.5)

--------------------------------------------------------
2) NUMBER METHODS
--------------------------------------------------------

Number class provides:

    intValue()
    doubleValue()
    floatValue()
    longValue()

So all child classes inherit them.

--------------------------------------------------------
3) ARRAY COVARIANCE
--------------------------------------------------------

In Java arrays are COVARIANT.

Meaning:

    Double[] IS-A Number[]

So this is VALID:

    Number[] arr = new Double[3];

BUT...

Actual array type internally is still:
    Double[]

So ONLY Double values allowed.

--------------------------------------------------------
IMPORTANT RUNTIME PROBLEM
--------------------------------------------------------

Compiler checks reference type:
    Number[]

Runtime checks actual object type:
    Double[]

So:

    arr[0] = 10;

becomes:
    Integer object

Integer cannot go inside Double[]

So JVM throws:

    ArrayStoreException

--------------------------------------------------------
KEY LEARNING
--------------------------------------------------------

Reference type:
    What compiler sees

Actual object type:
    What JVM checks at runtime

========================================================
*/

public class NumberDemo {

    public static void main(String[] args) {

        // ====================================================
        // POLYMORPHISM WITH NUMBER
        // ====================================================

        Number n1 = 10;       // Integer object
        Number n2 = 10.5;     // Double object
        Number n3 = 5.6f;     // Float object

        System.out.println("n1 intValue: " + n1.intValue());
        System.out.println("n2 doubleValue: " + n2.doubleValue());
        System.out.println("n3 floatValue: " + n3.floatValue());



        // ====================================================
        // ARRAY COVARIANCE
        // ====================================================

        // Parent reference
        Number[] arr = new Double[3];

        // VALID
        arr[0] = 10.5;
        arr[1] = 20.8;

        System.out.println("\nStored Double values successfully");



        // ====================================================
        // RUNTIME ERROR
        // ====================================================

        try {

            // Integer object trying to store inside Double[]
            arr[2] = 100;

        } catch (ArrayStoreException e) {

            System.out.println("\nRuntime Exception Occurred:");
            System.out.println(e);
        }



        // ====================================================
        // FINAL ARRAY CONTENTS
        // ====================================================

        System.out.println("\nFinal Array:");

        for(Number n : arr) {
            System.out.println(n);
        }
    }
}