package OOPS;

interface Flyable {
    void fly(); //Method signature (no implementation)
}

interface Drivable {
    void drive();
}

// A class implementing Flyable (Plane can only fly)
class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane is flying in the sky.");
    }
}
// A class implementing Drivable (Car can only drivable)
class Car11 implements Drivable {
    @Override
    public void drive() {
        System.out.println("Car is driving on the road");
    }
}

// Here Drone is implementing the both Flyable & Drivable bca it can able to fly & Drive..
class Drone implements Flyable, Drivable {
    @Override
    public void fly() {
        System.out.println("Drone is flying with propellers.");
    }
    @Override
    public void drive() {
    System.out.println("Drone is driving on the ground.");
}
}

public class InterfaceMain {
    public static void main(String[] args) {
        Flyable plane = new Plane();
        plane.fly(); // Plane is flying in the sky.
        
        Drivable car = new Car11();
        car.drive(); // Car is driving on the road
       
        // As drone implements both Flyable & Drivable
        Flyable drone = new Drone();
        drone.fly(); // Drone is flying with propellers.

        Drivable drone1 = new Drone();
        drone1.drive(); // Drone is driving on the ground.

        //It is same as like List<T> list = new ArrayList<T>(); always refer with base class object reference

    }
}
