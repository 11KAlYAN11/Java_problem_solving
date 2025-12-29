package com.learning.java.mypackage;

public class MyClass {
    public static void greet() {
        System.out.println("Hello from MyClass!");
    }

    public static  int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        greet();
        System.out.println(add(10,20));
    }
}
