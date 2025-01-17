package OOPS;
// Abstract class providing Structure (Common properties & methods)
// Same structure means in each class the method for startEngine() is must irrespective of implementation.
/* Structural Inheritance (Abstract Class)
🔹 Use an abstract class when you want to provide a common structure (fields + methods) for all subclasses.
🔹 It allows defining some common behavior while forcing subclasses to implement specific methods.
🔹 abstract methods must be implemented by subclasses, while concrete methods provide a default implementation.

 */
abstract class Vehicle11 {
    int speed; //commom property for all classes
    Vehicle11(int speed) {
        this.speed = speed;
    }
    void showSpeed() { //concrete method already implemented
        System.out.println("Speed is "+ speed + "km/h");
    }
    abstract void startEngine(); //Abstract method (subclasses must implement)

}

class Bus extends Vehicle11 {
    Bus(int speed) {
        super(speed);
    }
    @Override
    void startEngine() {
        System.out.println("Car engine started with a car key");
    }
}

class Bike extends Vehicle11 {
    Bike(int speed) {
        super(speed);
    }
    @Override
    void startEngine() {
        System.out.println("Bike engine starts with a kick");
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        //As a best practice always refer with base class reference
        Vehicle11 myBus = new Bus(60);
        myBus.showSpeed(); //calls inherited concrete method
        myBus.startEngine(); //calls inherited concrete method

        Vehicle11 myBike = new Bike(100);
        myBike.showSpeed();//calls inherited concrete method
        myBike.startEngine();//calls inherited concrete method

    }
}