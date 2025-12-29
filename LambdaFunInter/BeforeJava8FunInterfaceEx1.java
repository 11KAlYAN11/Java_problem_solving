// Step 1: Create an interface with ONE abstract method
package com.learning.java.lambdafuninter;

interface Add {
    int addParameters(int a, int b);  // Contract: whoever implements must define this
}

// Step 2: Create a class that implements the interface
class MyAdder implements Add {

    // Step 3: Provide the real logic for addParameters
    @Override
    public int addParameters(int a, int b) {
        return a + b;  // simple addition logic
    }
}

public class BeforeJava8FunInterfaceEx1 {
    public static void main(String[] args) {

        // Step 4: Create an object of MyAdder
        Add adder = new MyAdder();

        // Step 5: Use the method
        System.out.println(adder.addParameters(10, 20));  // Output: 30
    }
}
