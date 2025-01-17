package OOPS;

public class Main {
    public static void main(String[] args) {
        // Attempting to instantiate an abstract class will result in a compilation error.
        // Animal obj = new Animal("Some Animal"); // X ERROR: Cannot instantiate abstract class Animal

        // Creating instances of Cat and Dog using the Animal reference type
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Buddy");

        // Calling the makeSound method for both Cat and Dog
        cat.makeSound(); // Calls the overridden method in Cat
        dog.makeSound(); // Calls the overridden method in Dog

        // The following lines demonstrate the limitations of using parent class references
        // cat.catSpecialMethod(); // Compilation error because catSpecialMethod() is not known to the Animal class
        // dog.dogSpecialMethod(); // Compilation error because dogSpecialMethod() is not known to the Animal class

        // Calling specific methods known to the Animal class
        cat.catSpecialMethodKnownToAnimal(); // Calls the method specific to Cat
        dog.dogSpecialMethodKnownToAnimal(); // Calls the method specific to Dog
    }
}
