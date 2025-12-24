import java.util.Comparator;
import java.util.TreeSet;
/*
 * Comparator<Employee3>:
The Comparator interface is part of Java's java.util package and is used to define a custom comparison logic for objects. By implementing Comparator, we are providing a way to compare two Employee3 objects based on some criteria.
 */
class Employee3 implements Comparable<Employee3> {
    int id;
    String name;
    double salary;
    Employee3(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int compareTo(Employee3 other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
    return "Employee{ id = "+id+", Name = '"+name+"', salary = "+salary+"}";
    }    
}
/*
 * Difference Between Comparable and Comparator
        Comparable:

        Used when you want to define the natural ordering of objects in your class.
        It is implemented directly inside the class.
        There is only one comparison logic (i.e., compareTo() method).
        The class itself defines how objects should be compared.
        Comparator:

        Used when you want to define custom ordering (other than the natural ordering).
        It is usually implemented externally, in a separate class.
        You can have multiple comparators to compare by different fields (e.g., name, salary, etc.).
        It allows you to specify different ways to compare objects for different purposes.
 */
class NameComparator implements Comparator<Employee3> {
    @Override
    public int compare(Employee3 e1, Employee3 e2) {
        return e1.name.compareTo(e2.name);
    }
}
class SalaryComparator implements Comparator<Employee3> {
    @Override
    public int compare(Employee3 e1, Employee3 e2) {
        // Checking if salaries not equal will check with ID's
        int salaryComparison =  Double.compare(e1.salary, e2.salary);
        if(salaryComparison != 0) {
            return salaryComparison;
        }
        // Secondary comparison by ID to avoid equality issues
        // ID should never be equal
        return Integer.compare(e1.id, e2.id);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        System.out.println("Sorting Using Name Comparator: ");
        TreeSet<Employee3> nameSortEmps = new TreeSet<>( new NameComparator());
        nameSortEmps.add(new Employee3(5, "Zavan", 700));
        nameSortEmps.add(new Employee3(10, "Asam", 300));
        nameSortEmps.add(new Employee3(20, "Pavan", 100));
        nameSortEmps.add(new Employee3(30, "Reddy", 400));

        nameSortEmps.forEach(System.out::println); // Method reference
        //employees.forEach(emp -> System.out.println(emp)); // Arrow Function

        System.out.println("Sorting Using Salary Comparator: ");
        TreeSet<Employee3> salarySortEmps = new TreeSet<>( new SalaryComparator());
        salarySortEmps.add(new Employee3(10, "Asam", 300));
        salarySortEmps.add(new Employee3(20, "Pavan", 100));
        salarySortEmps.add(new Employee3(30, "Reddy", 1000));
        salarySortEmps.add(new Employee3(5, "Zavan", 700));
        salarySortEmps.forEach(System.out::println);

        System.out.println("Using no comparator: ");
        //But this Employee3 is is comparable by default it is compare with ID's as mentioned in Employee Class
        // by default sorted by ID's
        TreeSet<Employee3> noSortEmp = new TreeSet<>();
        noSortEmp.add(new Employee3(10, "Asam", 300));
        noSortEmp.add(new Employee3(20, "Pavan", 100));
        noSortEmp.add(new Employee3(30, "Reddy", 400));
        noSortEmp.add(new Employee3(5, "Zavan", 700));
        noSortEmp.forEach(System.out::println);

        TreeSet<Employee3> nameSortEmps1 = new TreeSet<>( new NameComparator());
        TreeSet<Employee3> salarySortEmps1 = new TreeSet<>( new SalaryComparator());
        System.out.println("Using no comparator obj sorting via Name comparator");
        nameSortEmps1.addAll(noSortEmp);
        nameSortEmps1.forEach(System.out::println);

        System.out.println("Using no comparator obj sorting via Salary comparator");
        salarySortEmps1.addAll(noSortEmp);
        salarySortEmps1.forEach(System.out::println);



    }
}
