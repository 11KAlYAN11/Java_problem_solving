package OOPS_ADV;

class Address {

    String city;
    String state;
    int pincode;

    public Address(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    public void displayAddress() {
        System.out.println(
            "City: " + city +
            " State: " + state +
            " Pincode: " + pincode
        );
    }
    
}

class Employee {
    int id;
    String name;
    int salary;

    // 🔥🔥 Composition
    private Address address;

    public Employee(int id, String name, int salary, String city, String state, int pincode) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        // 🔥 Address CREATED INSIDE Employee
        this.address = new Address(city, state, pincode);
    }

    public void displayEmployee() {
        System.out.println("Employee ID   : " + this.id);
        System.out.println("Employee Name : " + this.name);
        System.out.println("Employee Salary : " + this.salary);

        System.out.println("---- Address Details ----");
        address.displayAddress();
    }

}

public class CompostionExp {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Asam", 10, "Vizag", "AP", 555555);
        Employee e2 = new Employee(2, "Pavan", 20, "BLR", "KA", 999999);

        e1.displayEmployee();
        e2.displayEmployee();
    }
}
