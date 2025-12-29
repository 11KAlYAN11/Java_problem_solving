package com.learning.java.oops;

/**
 * BankAccount interface defines the methods for bank account operations.
 * This interface enforces a contract for deposit and withdraw methods.
 */
interface BankAccount {
    void deposit(double amount); // Method to deposit an amount
    void withdraw(double amount); // Method to withdraw an amount
}

/**
 * ICICIBank class implements the BankAccount interface.
 * It provides specific implementations for deposit and withdraw methods.
 */
class ICICIBank implements BankAccount {
    @Override
    public void deposit(double amount) {
        // Implementation of deposit method for ICIC Bank
        System.out.println("Depositing: " + amount + " to ICIC bank");
    }

    @Override
    public void withdraw(double amount) {
        // Implementation of withdraw method for ICIC Bank
        System.out.println("Withdrawing " + amount + " from ICIC Bank");
    }
}

/**
 * HDFCBank class implements the BankAccount interface.
 * It provides specific implementations for deposit and withdraw methods.
 */
class HDFCBank implements BankAccount {
    @Override
    public void deposit(double amount) {
        // Implementation of deposit method for HDFC Bank
        System.out.println("Depositing: " + amount + " to HDFC bank");
    }

    @Override
    public void withdraw(double amount) {
        // Implementation of withdraw method for HDFC Bank
        System.out.println("Withdrawing " + amount + " from HDFC Bank");
    }
}

/**
 * HCLEmployee class represents an employee with a bank account.
 * It allows depositing and withdrawing salary through the associated bank account.
 * This class is not tied to any specific bank directly, allowing flexibility.
 */
class HCLEmployee {
    String name; // Employee's name
    BankAccount bankAccount; // Reference to a BankAccount implementation

    // Constructor for HCLEmployee
    HCLEmployee(String name, BankAccount bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
    }

    // Method to deposit salary into the bank account
    void depositSalary(double amount) {
        bankAccount.deposit(amount);
    }

    // Method to withdraw salary from the bank account
    void withdrawSalary(double amount) {
        bankAccount.withdraw(amount);
    }
}

/**
 * InterfaceOverInheritance class contains the main method to demonstrate the functionality.
 */
public class InterfaceOverInheritance {
    public static void main(String[] args) {
        // Employee initially has an ICIC bank account
        HCLEmployee emp1 = new HCLEmployee("Pavan", new ICICIBank());
        // Here HCLEmployee is parent reference, for subclass ICICIBank() while runtime it will go under overriding from HCLEmp() to ICICIBank()
        emp1.depositSalary(10000);
        emp1.withdrawSalary(5000);

        // Employee moves to JP Morgan (where only HDFC exists)
        emp1.bankAccount = new HDFCBank();
        // Above HCLEmployee is parent reference, changing from ICICIBank() to HDFCBank() later as per that parameters also will override 
        emp1.depositSalary(20000);
        emp1.withdrawSalary(8000);

        // New employee joins with an HDFC account to HCL
        HCLEmployee emp2 = new HCLEmployee("Preethi", new HDFCBank());
        emp2.depositSalary(10000);
        emp2.withdrawSalary(5000);
    }
}
