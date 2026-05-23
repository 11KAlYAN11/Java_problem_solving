package OOPS;

/*
========================================================
MAIN METHOD
OVERLOADING vs OVERRIDING
========================================================

VERY IMPORTANT INTERVIEW CONCEPT
========================================================

1) main() CAN be overloaded ✅
2) main() CANNOT be truly overridden ❌

WHY?
--------------------------------------------------------

Because main() is STATIC.

Static methods belong to CLASS,
NOT objects.

So static methods are:
    METHOD HIDDEN

NOT:
    METHOD OVERRIDDEN

========================================================
PART 1 → MAIN METHOD OVERLOADING
========================================================

JVM ONLY recognizes:

    public static void main(String[] args)

Other main methods are just NORMAL overloaded methods.

--------------------------------------------------------
OVERLOADING RULE:
--------------------------------------------------------

Same method name
Different parameters

Examples:

    main(int x)
    main(String s)

========================================================
PART 2 → MAIN METHOD "OVERRIDING"
========================================================

main() is static.

Static methods are resolved using:
    REFERENCE TYPE

NOT:
    OBJECT TYPE

So runtime polymorphism DOES NOT happen.

This is called:
    METHOD HIDING

========================================================
IMPORTANT DIFFERENCE
========================================================

INSTANCE METHODS:
    overridden
    runtime polymorphism

STATIC METHODS:
    hidden
    compile-time binding

========================================================
*/


// ======================================================
// PARENT CLASS
// ======================================================

class Parent {

    // Static main-like method
    static void main() {
        System.out.println("Parent static main()");
    }
}



// ======================================================
// CHILD CLASS
// ======================================================

class Child extends Parent {

    // This is NOT overriding
    // This is METHOD HIDING
    static void main() {
        System.out.println("Child static main()");
    }
}



// ======================================================
// DRIVER CLASS
// ======================================================

public class MainMtdOverLoadOverride { // MainMtdOverLoadOverride

    // JVM starts ONLY from this method
    public static void main(String[] args) {

        System.out.println("===== MAIN OVERLOADING =====");

        // Calling overloaded versions
        main(10);
        main("Hello");


        System.out.println("\n===== MAIN HIDING =====");

        Parent p = new Child();

        // Static methods use REFERENCE TYPE
        // So Parent version executes
        p.main();



        System.out.println("\n===== DIRECT CALLS =====");

        Parent.main();
        Child.main();
    }
//     ===== MAIN OVERLOADING =====
        // Overloaded main(int): 10
        // Overloaded main(String): Hello

        // ===== MAIN HIDING =====
        // Parent static main()

        // ===== DIRECT CALLS =====
        // Parent static main()
        // Child static main()



    // ==================================================
    // OVERLOADED MAIN METHODS
    // ==================================================

    static void main(int x) {
        System.out.println("Overloaded main(int): " + x);
    }

    static void main(String s) {
        System.out.println("Overloaded main(String): " + s);
    }
}