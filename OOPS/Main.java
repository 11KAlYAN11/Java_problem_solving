package OOPS;

public class Main {
    public static void main(String[] args) {
        // Animal obj = new Animal("Some Animal"); X ERROR: Cannot instantiate abstract class Animal
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Buddy");
        cat.makeSound();
        dog.makeSound();
        //cat.catSpecialMethod(); // -> here compilation errot bcz that catSpecialMethod() not known to Parent Animal class
        //dog.dogSpecialMethod(); // -> here compilation error bcz that dogSpecialMethod() not known to Parent Animal class
        cat.catSpecialMethodKnownToAnimal();
        dog.dogSpecialMethodKnownToAnimal();
       
    }
    
}
