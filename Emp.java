import java.util.*;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{id=" +id+", name='" + name + "'}";
    }
   
}

public class Emp{
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        // Adding Employees to the list
        list.add(new Employee("Alice", 101));
        list.add(new Employee("Bob", 102));

        // Iterating through the list
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}
