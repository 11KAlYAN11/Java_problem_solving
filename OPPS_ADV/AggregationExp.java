package OPPS_ADV;

/*
 * =======================
 * Address class
 * =======================
 * This class can EXIST independently
 * It does NOT depend on Employee
 */
class Address2 {

    String city;
    String state;
    int pincode;

    // Constructor
    public Address2(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // Method to display address
    public void displayAddress() {
        System.out.println(
            "City: " + city +
            ", State: " + state +
            ", Pincode: " + pincode
        );
    }
}

/*
 * =======================
 * Employee class
 * =======================
 * Employee HAS-A Address (Aggregation)
 * Address is passed from outside
 */
class Employee {

    int id;
    String name;
    int salary;

    // 🔥 Aggregation
    // Address is NOT created here
    // It is supplied from outside
    Address2 address2;

    // Constructor receives Address object
    public Employee(int id, String name, int salary, Address2 address2) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address2 = address2; // reference assigned
    }

    // Display employee + address details
    public void displayEmployee() {
        System.out.println("\nEmployee ID      : " + id);
        System.out.println("Employee Name    : " + name);
        System.out.println("Employee Salary  : " + salary);

        System.out.println("---- Address Details ----");
        address2.displayAddress();
    }
}

/*
 * =======================
 * Main class
 * =======================
 */
public class AggregationExp {

    public static void main(String[] args) {

        // Address objects created independently
        Address2 a1 = new Address2("Vizag", "AP", 555555);
        Address2 a2 = new Address2("BLR", "KA", 999999);

        // Address objects are injected into Employee
        Employee e1 = new Employee(1, "Asam", 10, a1);
        Employee e2 = new Employee(2, "Pavan", 20, a2);

        e1.displayEmployee();
        e2.displayEmployee();

        /*
         * IMPORTANT:
         * Even if Employee objects are destroyed,
         * Address objects CAN still exist.
         *
         * That is Aggregation.
         */
    }
}
