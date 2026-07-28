package Streams;

import java.util.Comparator;
import java.util.List;

public class SortingMaster {

    public static void main(String[] args) {

        List<Employee> employees = List.of(

                new Employee(101,"Ram",50000,25,"IT"),

                new Employee(102,"John",70000,30,"Finance"),

                new Employee(103,"Amit",45000,22,"IT"),

                new Employee(104,"David",70000,27,"Finance"),

                new Employee(105,"Kiran",50000,24,"HR")

        );

        System.out.println("========== Original ==========");

        employees.forEach(System.out::println);


        // ---------------------------------------------------
        // 1. Name ASC
        // ---------------------------------------------------

        System.out.println("\nSort By Name");

        employees.stream()

                .sorted(
                        Comparator.comparing(Employee::getName)
                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 2. Salary ASC
        // ---------------------------------------------------

        System.out.println("\nSort By Salary");

        employees.stream()

                .sorted(
                        Comparator.comparingDouble(Employee::getSalary)
                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 3. Salary DESC
        // ---------------------------------------------------

        System.out.println("\nHighest Salary First");

        employees.stream()

                .sorted(

                        Comparator
                                .comparingDouble(Employee::getSalary)
                                .reversed()

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 4. Age
        // ---------------------------------------------------

        System.out.println("\nYoungest First");

        employees.stream()

                .sorted(

                        Comparator
                                .comparingInt(Employee::getAge)

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 5. Department
        // ---------------------------------------------------

        System.out.println("\nDepartment");

        employees.stream()

                .sorted(

                        Comparator
                                .comparing(Employee::getDepartment)

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 6. Department -> Salary
        // ---------------------------------------------------

        System.out.println("\nDepartment then Salary");

        employees.stream()

                .sorted(

                        Comparator

                                .comparing(Employee::getDepartment)

                                .thenComparingDouble(Employee::getSalary)

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 7. Department -> Salary DESC
        // ---------------------------------------------------

        System.out.println("\nDepartment then Highest Salary");

        employees.stream()

                .sorted(

                        Comparator

                                .comparing(Employee::getDepartment)

                                .thenComparing(

                                        Comparator

                                                .comparingDouble(Employee::getSalary)

                                                .reversed()

                                )

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 8. Salary DESC -> Age ASC
        // ---------------------------------------------------

        System.out.println("\nHighest Salary then Youngest");

        employees.stream()

                .sorted(

                        Comparator

                                .comparingDouble(Employee::getSalary)

                                .reversed()

                                .thenComparingInt(Employee::getAge)

                )

                .forEach(System.out::println);


        // ---------------------------------------------------
        // 9. Department -> Salary -> Age
        // ---------------------------------------------------

        System.out.println("\nDepartment -> Salary -> Age");

        employees.stream()

                .sorted(

                        Comparator

                                .comparing(Employee::getDepartment)

                                .thenComparingDouble(Employee::getSalary)

                                .thenComparingInt(Employee::getAge)

                )

                .forEach(System.out::println);

    }

}


class Employee {

    private Integer id;
    private String name;
    private double salary;
    private int age;
    private String department;

    public Employee(Integer id,
                    String name,
                    double salary,
                    int age,
                    String department) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public double getSalary() { return salary; }

    public int getAge() { return age; }

    public String getDepartment() { return department; }

    @Override
    public String toString() {

        return id + " | "
                + name + " | "
                + salary + " | "
                + age + " | "
                + department;
    }
}