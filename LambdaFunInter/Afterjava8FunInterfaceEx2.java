package com.learning.java.lambdafuninter;

interface Hello {
    void sayhello();
}
public class Afterjava8FunInterfaceEx2 {

    // Returning lamda instead of a class object
    public static Hello helperFuncation() {
        return () -> System.out.println("Hello from lambda!");
    /* Equivalent to 
    class MyHello implements Hello {
    @Override
    public void sayhello() {
        System.out.println("Hello from MyHello class!");
    }
} */
    }

    public static void main(String[] args) {
        Hello h = helperFuncation();
        h.sayhello();
    }
}
