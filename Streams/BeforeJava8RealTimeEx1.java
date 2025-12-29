package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Employee {
    private String name;
    private int salary;
    private boolean isActive;

    public Employee(String name, int salary, boolean isActive) {
        this.name = name;
        this.salary = salary;
        this.isActive = isActive;
    }
    public String getName() {return name;}
    public int getSalary() {return salary;}
    public boolean isActive() {return isActive;}
}

public class BeforeJava8RealTimeEx1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Kalyan", 100, true),
            new Employee("Pandu", 200, false),
            new Employee("Reddy", 300, true)
        );

        // filter Active Employees
        List<Employee> activEmployees = new ArrayList<>();
        for(Employee e: employees) {
            if(e.isActive()) {
            activEmployees.add(e);
            }
        }
        // Print active employees
        for (Employee e : activEmployees) {
            System.out.println("Active Employee: " + e.getName() + ", Salary: " + e.getSalary());
        }

        // Sort by salary
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2){
                return e1.getSalary() - e2.getSalary();
            }
        });

        // Extract names
        List<String> employeeNames = new ArrayList<>();
        for(Employee e: employees) {
            employeeNames.add(e.getName());
        }
        System.out.println(employeeNames);
        /*
        ❌ Issues

        Too many loops

        Too many temporary lists

        Too many classes/interfaces

        Hard to read */
    }
}
