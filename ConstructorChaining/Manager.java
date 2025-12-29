package ConstructorChaining;

class Person {
    String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person initialized");
    }
}

class Employee extends Person {
    int empId;

    Employee(String name, int empId) {
        super(name);
        this.empId = empId;
        System.out.println("Employee initialized");
    }
}

class Manager extends Employee {
    String dept;

    Manager(String name, int empId, String dept) {
        super(name, empId);
        this.dept = dept;
        System.out.println("Manager initialized");
    }

    void display() {
        System.out.println(name + " | " + empId + " | " + dept);
    }

    public static void main(String[] args) {
        Manager m = new Manager("Pavan", 101, "IT");
        m.display();
    }
}
