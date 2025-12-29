package com.learning.java.lambdafuninter;

interface Hello {
    void sayHello(); // this interface is just like a contract who ever implements thsi has to add logic for thsi that is the contract

}
class MyHello implements Hello { // As per Interface contract this class has to provide the logic for it
    @Override
    public void sayHello() { // providing the logic
        System.out.println("Hello from MyHello class");
    }

}
public class BeforeJava8FunInterfaceEx2 {
    public static void main(String[] args) {
        Hello h = new MyHello(); // Always hold subclass reference with parent reference

        h.sayHello(); // calling the sayHello mtd
    }
}
