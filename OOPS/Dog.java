package OOPS;

public class Dog extends Animal {
    // Here for Dog constructor we are getting dog name. that we are passing to the Main Animal Class.
    Dog(String name) {
        super(name); // calls Animal's Constructor
    }

    @Override
    void makeSound() {
        System.out.println(name + " Says Woof!");
    }

    void dogSpecialMethod() {
        System.out.println("This is a special method for Dog");
    }

    @Override
    void dogSpecialMethodKnownToAnimal() {
        System.out.println("This is a dog special method known to animal");
    }

    @Override
    void catSpecialMethodKnownToAnimal() {
        System.out.println("This is a cat special method known to animal");
    }
}
