package OOPS;

public class Cat extends Animal {
    //Here Cat is Constructor for Cat Class, the values coming into the constructor are being passed to the parent class constructor. like we are overriding the parent class constructor.
    Cat(String name) {
        super(name); //calls Animal's Constructor
    }

    @Override
    void makeSound() {
        System.out.println(name+ " Say's Meow");
    }
    void catSpecialMethod() {
        System.out.println("This is a cat special Method");
    }
    @Override
    void catSpecialMethodKnownToAnimal() {
        System.out.println("This is cat special method known to animal");
    }
}
