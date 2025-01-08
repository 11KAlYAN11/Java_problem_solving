package OOPS;
abstract class Tree {
    //here Tree is a abstract class cuz we don't need any object instantation on Tree (bcz there was no any implementaion in Tree class)
    String name;
    Tree(String name) {
        this.name = name;
        System.out.println(name+" tree class constructor");
    }
    // we are definig one abstract method (the child classes will implement their own implementation)
    abstract void display();
}

class Neem extends Tree {
    // Here we are passing arguments for Neem while object creation. that will pass
    // to parent Tree class constructor
    Neem(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name + " is a neem tree display method");
    }
}
class Bamboo extends Tree {
    // Here we are passing arguments for Bamboo while object creation. that will pass
    // to parent Tree class constructor
    Bamboo(String name) {
        super(name);
    }
    @Override
    void display() {
        System.out.println(name + " is a bamboo tree display method");
    }
}
public class InterfaceSingleClassDemo {
    public static void main(String[] args) {
        // Creating an object of the class
       // Tree tree = new Tree("Tree"); // will give compile error bcz Tree is an abstract class
       Tree neem = new Neem("Neem From AP");
       Tree bamboo = new Bamboo("Bamboo from TG");
       neem.display();
       bamboo.display();
    }
}
