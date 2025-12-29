package com.learning.java.oops;

public class AnimalCatDogMain {
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
        // Instead we can try only with references from Cat & Dog classes itslef (Not a best practice but try)
        Cat cat1 = new Cat("Kitty1");
        Dog dog1 = new Dog("Buddy1");
        cat1.catSpecialMethod();
        dog1.dogSpecialMethod();

        // Calling specific methods known to the Animal class
        cat.catSpecialMethodKnownToAnimal(); // Calls the method specific to Cat
        dog.dogSpecialMethodKnownToAnimal(); // Calls the method specific to Dog
    }
}
