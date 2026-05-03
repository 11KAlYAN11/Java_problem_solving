package Arrays;

/*
========================================
JAVA PASS BY VALUE - PRIMITIVES
========================================

In primitives:
--------------
A COPY of actual value is passed.

Original variable is NOT modified.

========================================
*/

public class CallByValue { 

    static void change(int x) {

        System.out.println("Inside method before change: " + x);

        x = 100;

        System.out.println("Inside method after change: " + x);
    }

    public static void main(String[] args) {

        int a = 10;

        System.out.println("Before method call: " + a);

        change(a);

        System.out.println("After method call: " + a);
    }
}