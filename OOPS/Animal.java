package com.learning.java.oops;

// Abstract Base class (Cannot be Instantiated)
// This class serves as a blueprint for all animals, enforcing that all subclasses must implement specific behaviors.
abstract class Animal {
    String name;

    // Abstract class can have a Constructor
    // The constructor initializes the name of the animal and prints a message indicating the constructor call.
    Animal(String name) {
        this.name = name;
        System.out.println(name + ": Animal Constructor Called");
    }

    // Abstract method with no implementation
    // Subclasses must provide their own implementation of this method to define the sound the animal makes.
    abstract void makeSound();

    // Abstract methods for specific behaviors known to the Animal class
    // These methods must be implemented by subclasses to define specific behaviors for cats and dogs.
    abstract void catSpecialMethodKnownToAnimal();
    abstract void dogSpecialMethodKnownToAnimal();
}
