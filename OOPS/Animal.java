package OOPS;
//Abstract Base class (Cannot be Instantiated)
//cuz there is no implementaiton in base class no need tpo create a object for it (to enforce that we are creating a class as abstract)
abstract class Animal {
    String name;
    //Abstract class can have a Constructor
    Animal(String name) {
        this.name = name;
        System.out.println(name+": Animal Constructor Called");
    }
    //Abstract method no implementation
    abstract void makeSound();

    abstract void catSpecialMethodKnownToAnimal();
    abstract void dogSpecialMethodKnownToAnimal();
}
