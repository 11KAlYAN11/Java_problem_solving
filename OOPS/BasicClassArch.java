package OOPS;
/*
 * Class
A class is a blueprint or template that defines the properties (attributes) and behaviors (methods) shared by all objects of that type.
Object
An object is a specific instance of a class, created using the class blueprint. Each object can have its own unique values for the attributes defined by the class.

Example: Car
	• Class: A blueprint for a car (e.g., TATA Curv) defines:
		○ Attributes: color, size, weight, yearOfManufacturing.
		○ Methods: drive(), brake(), horn().
	• Objects:
		○ Car 1: Red, High-end model, Automatic transmission.
		○ Car 2: Blue, Basic model, Manual transmission.
Each car object has its own configuration based on the customer's choices, but they follow the class blueprint.
		
		While the blueprint is fixed, individual objects (cars) can have different configurations:
			§ Example: One car object could be red with a sunroof, while another might be blue without a sunroof.
		

Example: Pen
	• Class: Blueprint for a pen, with:
		○ Attributes: color (black, blue, red), type (ballpoint, gel).
		○ Methods: write().
	• Objects:
		○ Pen 1: Blue ink, Gel type.
		○ Pen 2: Black ink, Ballpoint type.
Each pen object represents a specific customer preference while adhering to the class design.
		
While the blueprint is fixed, individual objects (cars) can have different configurations:
	• Example: One car object could be red with a sunroof, while another might be blue without a sunroof.

 */

class Car {
    // Attributes describing common properties of a car
    private String brand;
    private String color;
    private String type; // SUV, compact, hatchback, sedan, etc.
    private int price;
    private int yearOfManufacturing;

    // Non -paramaterized constructor
    public Car() {

    }
    //Paramaterized Constructor
    // Constructor to initialize a car
    public Car(String brand, String color, String type, int price, int yearOfManufacturing) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
    }
    // Copied constructor
    // Now for this all attributes of car2 to assigned means copied i.e: copied constructor
    public Car(Car c2) {
        this.brand = c2.brand;
        this.color = c2.color;
        this.type = c2.type;
        this.price = c2.price;
        this.yearOfManufacturing = c2.yearOfManufacturing;
    }

    // Behaviors of a car
    public void driving() {
        System.out.println(brand + " is driving.");
    }

    public void breaking() {
        System.out.println(brand + " is breaking.");
    }

    public void horning() {
        System.out.println(brand + " is honking the horn.");
    }

    // Display car details
    public void carDetails() {
        System.out.println("Car Details:\nBrand = " + brand + 
            "\nColor = " + color + 
            "\nType = " + type + 
            "\nPrice = " + price + 
            "\nYear of Manufacturing = " + yearOfManufacturing);
    }
}

public class BasicClassArch {
    public static void main(String[] args) {
        // First customer's car
        Car car1 = new Car("TATA", "Blue", "SUV", 100, 2024);
        car1.carDetails();
        car1.driving();
        car1.breaking();
        car1.horning();

        System.out.println();

        // Second customer's car
        Car car2 = new Car("Mahindra", "Red", "Electric SUV", 120, 2025);
        car2.carDetails();
        car2.driving();
        car2.breaking();
        car2.horning();

        Car car3 = new Car(car2);
        car3.carDetails();
        car3.driving();
        car3.breaking();
        car3.horning();
    }
}
