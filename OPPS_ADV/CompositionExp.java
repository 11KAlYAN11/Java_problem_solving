package com.learning.java.opps_adv;

/*
 * =======================
 * Address class
 * =======================
 * Used ONLY by Employee
 */
class Address1 {

    String city;
    String state;
    int pincode;

    public Address1(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public void displayAddress() {
        System.out.println(
            "City: " + city +
            ", State: " + state +
            ", Pincode: " + pincode
        );
    }
}

/*
 * =======================
 * Employee class
 * =======================
 * Employee OWNS Address
 * This is Composition
 */
class Employee {

    int id;
    String name;
    int salary;

    // 🔥 Composition
    // Address lifecycle is tied to Employee
    private Address1 address1;

    // Constructor receives raw values
    // Address object is CREATED inside Employee
    public Employee(int id, String name, int salary,
                    String city, String state, int pincode) {

        this.id = id;
        this.name = name;
        this.salary = salary;

        // 🔥 Address is CREATED here
        this.address1 = new Address1(city, state, pincode);
    }

    public void displayEmployee() {
        System.out.println("\nEmployee ID      : " + id);
        System.out.println("Employee Name    : " + name);
        System.out.println("Employee Salary  : " + salary);

        System.out.println("---- Address Details ----");
        address1.displayAddress();
    }
}

/*
 * =======================
 * Main class
 * =======================
 */
public class CompositionExp {

    public static void main(String[] args) {

        // Employee creates Address internally
        Employee e1 = new Employee(1, "Asam", 10, "Vizag", "AP", 555555);
        Employee e2 = new Employee(2, "Pavan", 20, "BLR", "KA", 999999);

        e1.displayEmployee();
        e2.displayEmployee();

        /*
         * IMPORTANT:
         * If Employee object is destroyed,
         * Address object is ALSO destroyed.
         *
         * That is Composition.
         */
    }
}
