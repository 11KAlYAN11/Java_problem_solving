package ConstructorChaining;

class Car {
    String brand;
    int speed;

    // Constructor1
    Car() {
        this("unkonwn", 0);
        System.out.println("Default constrctor called");
    }

    // Constructor 2 
    Car(String brand) {
        this(brand, 100); // Calls constructor 3
        System.out.println("Constructor 2 is called: ");
    }

    //Constructor 3 (Master constructor)
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        System.out.println("Paramaterized constructor is called: ");
    }

    void display() {
        System.out.println("Car: "+brand+",  "+ "speed: "+speed);
    }
}
public class ThisConstructorSameClass {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.display();

        System.out.println();

        Car c2 = new Car("Hundai");
        c2.display();
    }
}
