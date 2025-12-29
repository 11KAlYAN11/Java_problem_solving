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

    // 🔥 HAS-A relationship (Aggregation)
    Address address;

    public Employee(int id, String name, int salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public void displayEmployee() {
        System.out.println("Employee ID   : " + this.id);
        System.out.println("Employee Name : " + this.name);
        System.out.println("Employee Salary : " + this.salary);

        System.out.println("---- Address Details ----");
        address.displayAddress();
    }

}

public class AggregationExp {
    public static void main(String[] args) {

        Address a1 = new Address("Vizag", "AP", 555555);
        Address a2 = new Address("BLR", "KA" , 999999);

        Employee e1 = new Employee(1, "Asam", 10, a1);
        Employee e2 = new Employee(2, "Pavan", 20, a2);

        e1.displayEmployee();
        e2.displayEmployee();
    }
}
