package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class StreamAggregationDemo {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                // constructor expects age before department
                new Employee(1, "Ram", 55000.0, 25, "IT"),
                new Employee(2, "John", 70000.0, 30, "HR"),
                new Employee(3, "Amit", 45000.0, 23, "IT"),
                new Employee(4, "David", 90000.0, 35, "Finance"),
                new Employee(5, "Kiran", 65000.0, 28, "HR"),
                new Employee(6, "Rahul", 85000.0, 32, "Finance")
        );

        // ----------------------------------------------------
        // 1. Highest Salary
        // ----------------------------------------------------
        Employee highestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

                Employee hs1 = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
                // .orElseThrow()

        System.out.println("Highest Salary");
        System.out.println(highestSalary);

        // ----------------------------------------------------
        // 2. Lowest Salary
        // ----------------------------------------------------
        Employee lowestSalary = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

                Employee ls1 = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

        System.out.println("\nLowest Salary");
        System.out.println(lowestSalary);

        // ----------------------------------------------------
        // 3. Youngest Employee
        // ----------------------------------------------------
        Employee youngest = employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElseThrow();

        System.out.println("\nYoungest");
        System.out.println(youngest);

        // ----------------------------------------------------
        // 4. Oldest Employee
        // ----------------------------------------------------
        Employee oldest = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElseThrow();

        System.out.println("\nOldest");
        System.out.println(oldest);

        // ----------------------------------------------------
        // 5. Longest Name
        // ----------------------------------------------------
        Employee longestName = employees.stream()
                .max(Comparator.comparingInt(
                        e -> e.getName().length()
                ))
                .orElseThrow();

                // Empl having the longest Name
                Employee lne = employees.stream()
                .max(Comparator.comparingInt(e -> e.getName().length()))
                .orElseThrow();

        System.out.println("\nLongest Name");
        System.out.println(longestName);

        // ----------------------------------------------------
        // 6. Group by Department
        // ----------------------------------------------------
        Map<String, List<Employee>> deptMap
                = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment
                                )
                        );
                        // Groupping by department
        Map<String, List<Employee>> dpEmps = employees.stream()
        .collect(
                Collectors.groupingBy(
                        Employee::getDepartment
        ));                

        System.out.println("\nGroup By Department");
        deptMap.forEach((k, v) -> System.out.println(k + " -> " + v));
        dpEmps.forEach((k, v) -> System.out.println(k +" "+ v));

        // ----------------------------------------------------
        // 7. Count Employees per Department
        // ----------------------------------------------------
        Map<String, Long> countMap
                = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.counting()
                                )
                        );
        Map<String, Long> cm1 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));                

        System.out.println("\nCount By Department");
        System.out.println(countMap);

        // ----------------------------------------------------
        // 8. Average Salary by Department
        // ----------------------------------------------------
        Map<String, Double> avgSalary
                = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.averagingDouble(
                                                Employee::getSalary
                                        )
                                )
                        );

        System.out.println("\nAverage Salary");
        System.out.println(avgSalary);

        // ----------------------------------------------------
        // 9. Total Salary by Department
        // ----------------------------------------------------
        Map<String, Double> totalSalary
                = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.summingDouble(
                                                Employee::getSalary
                                        )
                                )
                        );

        System.out.println("\nTotal Salary");
        System.out.println(totalSalary);

        // ----------------------------------------------------
        // 10. Highest Salary Employee per Department
        // ----------------------------------------------------
        Map<String, Optional<Employee>> highestPerDept
                = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.maxBy(
                                                Comparator.comparingDouble(Employee::getSalary)
                                        )
                                )
                        );

        System.out.println("\nHighest Salary Per Department");
        System.out.println(highestPerDept);
    }
}


class Employee {

    private int id;
    private String name;
    private double salary;
    private int age;
    private String department;

    public Employee(int id, String name, double salary, int age, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
