package OOPS;

// Flyable interface defines a method for flying behavior.
interface Flyable {
    void fly(); // Method signature (no implementation)
    // Error: Interfaces cannot have constructors
    /*Flyable() {
        //
    }*/
}

// Drivable interface defines a method for driving behavior.
interface Drivable {
    void drive(); // Method signature (no implementation)
}

// A class implementing Flyable (Plane can only fly)
class Plane implements Flyable {
    @Override
    public void fly() {
        // Implementation of the fly method for Plane
        System.out.println("Plane is flying in the sky.");
    }
}

// A class implementing Drivable (Car can only drive)
class Car11 implements Drivable {
    @Override
    public void drive() {
        // Implementation of the drive method for Car
        System.out.println("Car is driving on the road");
    }
}

// Drone class implementing both Flyable and Drivable interfaces
// This class can both fly and drive.
class Drone implements Flyable, Drivable {
    @Override
    public void fly() {
        // Implementation of the fly method for Drone
        System.out.println("Drone is flying with propellers.");
    }

    @Override
    public void drive() {
        // Implementation of the drive method for Drone
        System.out.println("Drone is driving on the ground.");
    }
}

public class InterfaceMain {
    public static void main(String[] args) {
        // Creating a Plane object and invoking its fly method
        Flyable plane = new Plane();
        plane.fly(); // Plane is flying in the sky.
        
        // Creating a Car object and invoking its drive method
        Drivable car = new Car11();
        car.drive(); // Car is driving on the road
       
        // Creating a Drone object and invoking its fly method
        Flyable drone = new Drone();
        drone.fly(); // Drone is flying with propellers.

        // Creating another Drone object and invoking its drive method
        Drivable drone1 = new Drone();
        drone1.drive(); // Drone is driving on the ground.

        // Demonstrating polymorphism with interface references
        // It is similar to List<T> list = new ArrayList<T>(); always refer base class with parent reference
    }
}
