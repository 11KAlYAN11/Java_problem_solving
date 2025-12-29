package com.learning.java.collections;

import java.util.TreeSet;

class Employee2 implements Comparable<Employee2> {
    int id;
    String name;
    double salary;

    Employee2(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee2 other) {
        // Compare by salary first
        int salaryComparison = Double.compare(this.salary, other.salary);
        if (salaryComparison != 0) {  // Return result if salaries are not equal
            return salaryComparison;
        }
        // Secondary comparison by ID to avoid equality issues
        // ID should never be equal
        return Integer.compare(this.id, other.id);
        /*
         * Comparisons During Insertion:
            Adding Employee2(10, "Asam", 100):

            Since the TreeSet is empty, this employee is added directly.
            Adding Employee2(20, "Pavan", 300):

            Compare 300 (Pavan's salary) with 100 (Asam's salary):
            Double.compare(300, 100) returns positive (1).
            Pavan is added after Asam.
            Adding Employee2(30, "Kalyan", 400):

            Compare 400 (Kalyan's salary) with 100 (Asam's salary):
            Double.compare(400, 100) returns positive (1).
            Compare 400 (Kalyan's salary) with 300 (Pavan's salary):
            Double.compare(400, 300) returns positive (1).
            Kalyan is added after Pavan.
         */
    }

    @Override
    public String toString() {
        return "Employee2 {id =" + id + ", Name = '" + name + "', salary=" + salary + "}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        TreeSet<Employee2> employees = new TreeSet<>();
        // As TreeSet follows the principle of tree, all elements are in ascending order
        employees.add(new Employee2(10, "Asam", 400));
        employees.add(new Employee2(20, "Pavan", 100));
        employees.add(new Employee2(30, "Kalyan", 300));
        employees.add(new Employee2(30, "Reddy", 400));

        System.out.println("Employee2 Sorted by Salary: ");
        for (Employee2 emp : employees) {
            System.out.println(emp);
        }
    }
}
