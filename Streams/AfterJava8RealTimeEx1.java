import java.util.Arrays;
import java.util.List;

package com.learning.java.streams;

class Employee {
    private String name;
    private int salary;
    private boolean active;

    public Employee(String name, int salary, boolean active) {
        this.name = name;
        this.salary = salary;
        this.active = active;
    }

    public String getName() { return name; }
    public int getSalary() { return salary; }
    public boolean isActive() { return active; }
}

public class AfterJava8RealTimeEx1 {
    public static void main(String[] args) {
       
        List<Employee> employees = Arrays.asList(
            new Employee("Kalyan", 70000, true),
            new Employee("Pavan", 30000, false),
            new Employee("Reddy", 50000, true)
        );

        List<String> names = employees.stream()
            .filter(Employee :: isActive)
            .sorted((a,b) -> a.getSalary() - b.getSalary())
            .map(Employee::getName)
            .toList();

        System.out.println(names);   
        /*
        ✔ Why this is powerful?

        One single flow

        No temp lists

        No manual loops

        It reads like English

        Used in EVERY Spring Boot microservice
         */ 
    }
}
