package OOPS;

public class Cat extends Animal {
    // Constructor for Cat Class
    // The constructor takes a name parameter and passes it to the parent class constructor.
    Cat(String name) {
        super(name); // Calls Animal's Constructor
    }

    @Override
    void makeSound() {
        // Implementation of the abstract method from Animal class
        // This method defines the sound that the cat makes.
        System.out.println(name + " Says Meow");
    }

    // Specific method for Cat
    void catSpecialMethod() {
        // This method demonstrates a special behavior specific to cats.
        System.out.println("This is a cat special Method");
    }

    @Override
    void dogSpecialMethodKnownToAnimal() {
        // Implementation of the abstract method from Animal class
        // This method provides a behavior related to dogs, as known to the Animal class.
        System.out.println("This is a dog special method known to animal");
    }

    @Override
    void catSpecialMethodKnownToAnimal() {
        // Implementation of the abstract method from Animal class
        // This method provides a behavior specific to cats, as known to the Animal class.
        System.out.println("This is a cat special method known to animal");
    }
}
