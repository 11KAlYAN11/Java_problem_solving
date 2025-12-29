package com.learning.java.oops;

// Base class (Parent)
// This class demonstrates how different types of methods can be invoked from child classes using super, 
// with an object having a reference of the parent class, and with a subclass reference.
class Vehicle {
    void startEngine() {
        System.out.println("Vehicle engine starts");
    }
}

// Subclass (Child)
class Car extends Vehicle { // hwhy warnigs here
    @Override
    void startEngine() {
        System.out.println("Car engine starts with a key");
    }

    // Test method to demonstrate method invocation
    void test1() {
        Vehicle v = new Vehicle();
        v.startEngine(); // Calls Vehicle's method (NO OVERRIDING)
    }

    // Test method to demonstrate method overriding
    void test2() {
        Vehicle v = new Car();
        v.startEngine(); // Calls Car's overridden method (OVERRIDING)
    }

    // Test method to demonstrate calling the parent class method
    void test3() {
        super.startEngine(); // Calls Vehicle's method (NO OVERRIDING)
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.test1();  // Prints "Vehicle engine starts" (No Overriding)
        myCar.test2();  // Prints "Car engine starts with a key" (Overriding)
        myCar.test3();  // Prints "Vehicle engine starts" (No Overriding)
    }
}
