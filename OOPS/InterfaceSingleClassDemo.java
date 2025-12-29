package OOPS;

/**
 * Tree is an abstract class that represents a tree with a name.
 * It contains an abstract method display() that must be implemented by subclasses.
 */
abstract class Tree {
    String name;

    Tree(String name) {
        this.name = name;
        System.out.println(name + " tree class constructor");
    }

    /**
     * Abstract method that must be implemented by subclasses to display tree information.
     */
    abstract void display();
}

/**
 * Neem class extends the Tree class and provides an implementation for the display() method.
 */
class Neem extends Tree {
    Neem(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name + " is a neem tree display method");
    }
}

/**
 * Bamboo class extends the Tree class and provides an implementation for the display() method.
 */
class Bamboo extends Tree {
    Bamboo(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name + " is a bamboo tree display method");
    }
}

/**
 * InterfaceSingleClassDemo class contains the main method to demonstrate the creation of tree objects.
 */
public class InterfaceSingleClassDemo {
    public static void main(String[] args) {
        // Creating an object of the class
        // Tree tree = new Tree("Tree"); // will give compile error because Tree is an abstract class
        Tree neem = new Neem("Neem From AP");
        Tree bamboo = new Bamboo("Bamboo from KL");
        neem.display();
        bamboo.display();
    }
}
