package OOPS;

/**
 * BankAccount interface defines the methods for bank account operations.
 */
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
}

/**
 * ICICIBank class implements the BankAccount interface.
 * It provides specific implementations for deposit and withdraw methods.
 */
class ICICIBank implements BankAccount {
    @Override
    public void deposit(double amount) {
        System.out.println("Depositing: " + amount + " to ICIC bank");
    }

    @Override
    public void withdraw(double amount) {
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
        System.out.println("Depositing: " + amount + " to HDFC bank");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount + " from HDFC Bank");
    }
}

/**
 * HCLEmployee class represents an employee with a bank account.
 * It allows depositing and withdrawing salary through the associated bank account.
 */

 //Here HCL Employee not tied to any Bank directly
class HCLEmployee {
    String name;
    BankAccount bankAccount;


    HCLEmployee(String name, BankAccount bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
    }
    // methods to add or deduct the salary
    void depositSalary(double amount) {
        bankAccount.deposit(amount);
    }

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
        HCLEmployee emp1 = new HCLEmployee("pavan", new ICICIBank());
        //Here HCLEmployee is parent reference, for sub class ICICIBank() while run time it will go under overriding from HCLEmp() to ICICIBank()
        emp1.depositSalary(10000);
        emp1.withdrawSalary(5000);

        // Employee moves to JP Morgan (where only HDFC exists)
        emp1.bankAccount = new HDFCBank();
        //Above HCLEmployee is parent reference, changing from ICICIBank() to HDFCbank() later as per that paramaters also will override 
        emp1.depositSalary(20000);
        emp1.withdrawSalary(8000);

        // New employee joins with an HDFC account to HCL
        HCLEmployee emp2 = new HCLEmployee("Preethi", new HDFCBank());
        emp2.depositSalary(10000);
        emp2.withdrawSalary(5000);
    }
}
