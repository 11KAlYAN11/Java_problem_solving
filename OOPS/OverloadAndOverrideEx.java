package OOPS;

/*
==================================================
OVERLOADING + OVERRIDING
==================================================

Parent class has overloaded methods:
    show(int)
    show(String)

Child overrides one of them.

==================================================
*/

class Parent {

    void show(int x) {
        System.out.println("Parent int: " + x);
    }

    void show(String s) {
        System.out.println("Parent String: " + s);
    }
}

class Child extends Parent {

    // Overriding this overloaded version
    @Override
    void show(int x) {
        System.out.println("Child int: " + x);
    }
}

public class OverloadAndOverrideEx { // OverloadAndOverrideEx

    public static void main(String[] args) {

        Parent p = new Child();

        p.show(10);
        p.show("Hello");
    }

    /* 🔥 Output
        Child int: 10
        Parent String: Hello
        🧠 Why?

        show(int):

        overridden

        so runtime polymorphism happens.

        But:

        show(String)

        not overridden.

        So parent version executes.

        🔥 Important Interview Line
        Overloaded methods can absolutely be overridden individually.
     */
}