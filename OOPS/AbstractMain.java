package OOPS;

// Abstract class providing Structure (Common properties & methods)
// This class serves as a blueprint for all vehicles, enforcing that all subclasses must implement the startEngine() method.
abstract class Vehicle11 {
    int speed; // Common property for all classes

    // Constructor for Vehicle11
    // Initializes the speed of the vehicle.
    Vehicle11(int speed) {
        this.speed = speed;
        System.out.println("The vehicle11 Constructor called");
    }

    // Concrete method already implemented (like along with abstract methods normal methods also allowed in abstract methods)
    // This method displays the speed of the vehicle.
    void showSpeed() {
        System.out.println("Speed is " + speed + " km/h");
    }

    // Abstract method (subclasses must implement)
    // This method must be implemented by subclasses to define how the vehicle starts its engine.
    abstract void startEngine();
}

// Note as the abstract class property all the classes which extends Vehicle11 has same structure. like same methods
// Bus class extending Vehicle11
class Bus extends Vehicle11 {
    // Constructor for Bus
    Bus(int speed) {
        super(speed); // As int spees alreaday intialized in parent vehicle11 class we are just using it to intilize a spped varaible
    }

    @Override
    void startEngine() {
        // Implementation of the abstract method from Vehicle11
        // This method defines how the bus starts its engine.
        System.out.println("Bus engine started with a bus key");
    }
}

// Bike class extending Vehicle11
class Bike extends Vehicle11 {
    // Constructor for Bike
    Bike(int speed) {
        super(speed); // As int spees alreaday intialized in parent vehicle11 class we are just using it to intilize a spped varaible
    }

    @Override
    void startEngine() {
        // Implementation of the abstract method from Vehicle11
        // This method defines how the bike starts its engine.
        System.out.println("Bike engine starts with a kick");
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        // As a best practice, always refer with base class reference
        Vehicle11 myBus = new Bus(60);
        myBus.showSpeed(); // Calls inherited concrete method
        myBus.startEngine(); // Calls overridden method

        Vehicle11 myBike = new Bike(100);
        myBike.showSpeed(); // Calls inherited concrete method
        myBike.startEngine(); // Calls overridden method
    }
}
