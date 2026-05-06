package General_Problems;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import General_Problems.Employee3.NameComparator;

class Employee3 implements Comparable<Employee3> {
    int id;
    String name;
    double salary;

    public Employee3(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee3 other) {
        // compare by salary first
        int salaryComparison = Double.compare(this.salary, other.salary);
        if(salaryComparison != 0) return salaryComparison; // so salaries was not equal

        // compare by ID if salary is same
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee {id = "+ id + ", Name = "+ name +", salary = "+salary+" } ";
    }

    static class NameComparator implements Comparator<Employee3> {
        @Override
        public int compare(Employee3 e1, Employee3 e2) {
            return e1.name.compareTo(e2.name);
        }
    }
}
public class A {
    public static void main(String[] args) {
        Set<Employee3> emps = new TreeSet<>();

        // As treeset used to be sorted 1 with salary 2nd with id if salaries matched
        emps.add(new Employee3(1, "A1", 300));
        emps.add(new Employee3(2, "A2", 200));
        emps.add(new Employee3(3, "A3", 200));
        emps.add(new Employee3(4, "A4", 400));

        System.out.println("Employees Sorted by salary: ");
        for(Employee3 emp: emps) {
            System.out.println(emp);
        }

        Set<Employee3> employee3s = new TreeSet<>(new NameComparator());

        employee3s.add(new Employee3(1, "asam", 300));
        employee3s.add(new Employee3(2, "pavan", 200));
        employee3s.add(new Employee3(3, "kalayn", 200));
        employee3s.add(new Employee3(4, "reddy", 400));

        
        System.out.println("Employees Sorted by Name1: ");
        for(Employee3 e: employee3s) {
            System.out.println(e);
        }
    }
}