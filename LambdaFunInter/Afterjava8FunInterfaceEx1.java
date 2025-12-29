package com.learning.java.lambdafuninter;

interface Add {
    int addParameters(int a, int b); // Functional interface (1 abstract method only)
}
public class Afterjava8FunInterfaceEx1 {
    public static void main(String[] args) {
        
        // By using this we don't need to create that 1 extra class where it will implement that Add class we can directly provide implementation via lambda expressions
        // step1: provide the implementation directly using lambda
        Add adder = (a,b) -> a+b;
        /*
        smtg equivalent to 
        // Step 2: Create a class that implements the interface
            class MyAdder implements Add {

                // Step 3: Provide the real logic for addParameters
                @Override
                public int addParameters(int a, int b) {
                    return a + b;  // simple addition logic
                }
            } */
        System.out.println(adder.addParameters(10, 20));
        
    }
}
