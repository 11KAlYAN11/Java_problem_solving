package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSortingDemo {

    public static void main(String[] args) {

        // ==========================================================
        // 1. sorted() - Natural Ordering
        // ==========================================================

        System.out.println("========== 1. Natural Sorting ==========");

        List<Integer> numbers = Arrays.asList(8, 2, 9, 1, 5);

        System.out.println("Original : " + numbers);

        List<Integer> ascending =
                numbers.stream()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("Ascending : " + ascending);

        /*
            Output

            Original : [8, 2, 9, 1, 5]
            Ascending : [1, 2, 5, 8, 9]

            sorted() uses Comparable internally.
            Integer already implements Comparable.
        */


        // ==========================================================
        // 2. Strings using sorted()
        // ==========================================================

        System.out.println("\n========== 2. String Natural Sorting ==========");

        List<String> names =
                Arrays.asList("Ram", "John", "Amit", "David");

        System.out.println("Original : " + names);

        names.stream()
                .sorted()
                .forEach(System.out::println);

        /*
            Amit
            David
            John
            Ram

            Alphabetical because String implements Comparable.
         */


        // ==========================================================
        // 3. sorted(Comparator)
        // ==========================================================

        System.out.println("\n========== 3. Descending ==========");

        numbers.stream()
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        /*
            9
            8
            5
            2
            1

            We supplied our own comparison logic.
         */


        // Cleaner way

        System.out.println("\nUsing Comparator.reverseOrder()");

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        // ==========================================================
        // 4. Sort String by Length
        // ==========================================================

        System.out.println("\n========== 4. Sort by Length ==========");

        names.stream()
                .sorted((a, b) ->
                        Integer.compare(a.length(), b.length()))
                .forEach(System.out::println);

        /*
            Ram
            Amit
            John
            David

            Not alphabetical.

            Based on String length.
         */


        // ==========================================================
        // 5. Objects
        // ==========================================================

        System.out.println("\n========== 5. Objects ==========");

        List<Employee> employees = Arrays.asList(

                new Employee(101, "Ram", 50000, 25, "IT"),

                new Employee(102, "John", 70000, 28, "Finance"),

                new Employee(103, "Amit", 45000, 24, "IT"),

                new Employee(104, "David", 65000, 30, "HR"),

                new Employee(105, "Kiran", 50000, 27, "Finance")
        );

        employees.forEach(System.out::println);


        /*
            If you do

            employees.stream().sorted()

            Compilation Error

            Employee doesn't implement Comparable.
         */


        // ==========================================================
        // 6. Comparator.comparing()
        // ==========================================================

        System.out.println("\n========== 6. Sort By Salary ==========");

        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        /*
            Lowest salary first.
         */


        // ==========================================================
        // 7. Reverse Salary
        // ==========================================================

        System.out.println("\n========== 7. Highest Salary ==========");

        employees.stream()
                .sorted(
                        Comparator
                                .comparing(Employee::getSalary)
                                .reversed())
                .forEach(System.out::println);


        // ==========================================================
        // 8. Sort by Name
        // ==========================================================

        System.out.println("\n========== 8. Name ==========");

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getName))
                .forEach(System.out::println);


        // ==========================================================
        // 9. Sort by Age
        // ==========================================================

        System.out.println("\n========== 9. Age ==========");

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);


        // ==========================================================
        // 10. Multiple Sorting
        // ==========================================================

        System.out.println("\n========== 10. Department then Salary ==========");

        employees.stream()
                .sorted(
                        Comparator
                                .comparing(Employee::getDepartment)
                                .thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        /*
            HR

            Finance

            Finance

            IT

            IT
         */


        // ==========================================================
        // 11. Department then Salary Desc
        // ==========================================================

        System.out.println("\n========== 11. Department then Highest Salary ==========");

        employees.stream()
                .sorted(

                        Comparator
                                .comparing(Employee::getDepartment)

                                .thenComparing(

                                        Comparator
                                                .comparing(Employee::getSalary)
                                                .reversed()

                                )

                )
                .forEach(System.out::println);


        // ==========================================================
        // 12. Highest Salary then Youngest
        // ==========================================================

        System.out.println("\n========== 12. Highest Salary then Youngest ==========");

        employees.stream()
                .sorted(

                        Comparator
                                .comparing(Employee::getSalary)
                                .reversed()
                                .thenComparing(Employee::getAge)

                )
                .forEach(System.out::println);


        // ==========================================================
        // 13. Custom Comparator (Manual)
        // ==========================================================

        System.out.println("\n========== 13. Manual Comparator ==========");

        employees.stream()
                .sorted((e1, e2) ->

                        Double.compare(
                                e1.getSalary(),
                                e2.getSalary()))

                .forEach(System.out::println);


        /*
            Same output as Comparator.comparing()

            But much more code.

            That's why Comparator.comparing() is preferred.
         */


        // ==========================================================
        // 14. Reverse Manual Comparator
        // ==========================================================

        System.out.println("\n========== 14. Manual Desc ==========");

        employees.stream()
                .sorted((e1, e2) ->

                        Double.compare(
                                e2.getSalary(),
                                e1.getSalary()))

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

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