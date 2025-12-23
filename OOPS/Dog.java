package OOPS;

public class Dog extends Animal {
    // Constructor for Dog Class
    // The constructor takes a name parameter and passes it to the parent class constructor.
    Dog(String name) {
        super(name); // Calls Animal's Constructor
    }

    @Override
    void makeSound() {
        // Implementation of the abstract method from Animal class
        // This method defines the sound that the dog makes.
        System.out.println(name + " Says boww!");
    }

    // Specific method for Dog
    void dogSpecialMethod() {
        // This method demonstrates a special behavior specific to dogs.
        System.out.println("This is a special method for Dog");
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
