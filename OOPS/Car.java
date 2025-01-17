// Base class (Parent)
//This class is all about how different type of class method can be invoked from child class with super, with object(having reference of parent class) & parent with sub class refernce
package OOPS;
class Vehicle {
    void startEngine() {
        System.out.println("Vehicle engine starts");
    }
}

// Subclass (Child)
class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine starts with a key");
    }

    void test1() {
        Vehicle v = new Vehicle();
        v.startEngine(); // Calls Vehicle's method (NO OVERRIDING)
    }

    void test2() {
        Vehicle v = new Car();
        v.startEngine(); // Calls Car's overridden method (OVERRIDING)
    }

    void test3() {
        super.startEngine(); // Calls Vehicle's method (NO OVERRIDING)
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.test1();  // Prints "Vehicle engine starts" (No Overriding)
        myCar.test2();  // Prints "Car engine starts with a key" (Overriding)
        myCar.test3();  // Prints "Vehicle engine starts" (No Overriding)
    }
}
