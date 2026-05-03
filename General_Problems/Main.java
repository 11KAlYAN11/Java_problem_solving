package General_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Employee {

    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000),
                new Employee(2, "Sam", 60000),
                new Employee(3, "Alex", 45000),
                new Employee(1, "John", 50000), // duplicate
                new Employee(4, "David", 70000)
        );

        // 1. Remove duplicates based on id

        List<Employee> uniqueEmployees = new ArrayList<>();

        Set<Integer> ids = new HashSet<>();

        for(Employee e : employees) {

            if(!ids.contains(e.id)) {

                ids.add(e.id);

                uniqueEmployees.add(e);
            }
        }

        System.out.println("Unique Employees:");
        for(Employee e : uniqueEmployees) {

            System.out.println(e);
        }

        // 2. Sort by salary

        List<Employee> sortedEmployees = new ArrayList<>(employees);

        Collections.sort(sortedEmployees, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {

                return Double.compare(e1.salary, e2.salary);
            }
        });

        /*
          List<Employee> sortedEmployees =
                employees.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                        .toList();
         */

        System.out.println("\nSorted By Salary:");

        for(Employee e : sortedEmployees) {

            System.out.println(e);
        }

        // 3. Highest salary employee
        /*
         Optional<Employee> highestSalaryEmployee =
                employees.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary));
         */

        Employee highest = employees.get(0);

        for(Employee e : employees) {

            if(e.salary > highest.salary) {

                highest = e;
            }
        }

        System.out.println("\nHighest Salary Employee:");
        System.out.println(highest);

        // 4. Salary greater than 50000

        List<Employee> highSalaryEmployees = new ArrayList<>();

        for(Employee e : employees) {

            if(e.salary > 50000) {

                highSalaryEmployees.add(e);
            }
        }
        
        /* List<Employee> highSalaryEmployees =
                employees.stream()
                        .filter(e -> e.getSalary() > 50000)
                        .toList();
         */

        System.out.println("\nSalary Greater Than 50000:");

        for(Employee e : highSalaryEmployees) {

            System.out.println(e);
        }
    }
}