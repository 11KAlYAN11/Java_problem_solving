package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Employee3 {

    int id;
    String name;
    double salary;

    public Employee3(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return "Employee {id=" + id +
                ", name=" + name +
                ", salary=" + salary + "}";
    }
}

public class ModrenComparableComparator { // ModrenComparableComparator

    public static void main(String[] args) {

        /*
         ==========================================
            SORT BY SALARY THEN ID
         ==========================================
        */

        Set<Employee3> employeesBySalary =
                new TreeSet<>(

                        Comparator
                                .comparingDouble((Employee3 e) -> e.salary)
                                .thenComparingInt(e -> e.id)

                );

        employeesBySalary.add(new Employee3(1, "A1", 300));
        employeesBySalary.add(new Employee3(2, "A2", 200));
        employeesBySalary.add(new Employee3(3, "A3", 200));
        employeesBySalary.add(new Employee3(4, "A4", 400));

        System.out.println("Employees Sorted By Salary:");

        for(Employee3 e : employeesBySalary) {

            System.out.println(e);
        }

        /*
         ==========================================
            SORT BY NAME
         ==========================================
        */

        Set<Employee3> employeesByName =
                new TreeSet<>(

                        Comparator.comparing(e -> e.name)

                );

        employeesByName.add(new Employee3(1, "asam", 300));
        employeesByName.add(new Employee3(2, "pavan", 200));
        employeesByName.add(new Employee3(3, "kalyan", 200));
        employeesByName.add(new Employee3(4, "reddy", 400));

        System.out.println("\nEmployees Sorted By Name:");

        for(Employee3 e : employeesByName) {

            System.out.println(e);
        }
    }
}
