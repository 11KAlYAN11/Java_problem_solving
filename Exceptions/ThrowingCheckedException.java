package com.learning.java.exceptions;

import java.io.IOException;

public class ThrowingCheckedException {
    // This method demonstrates throwing a checked exception
    // The method readFile throws an IOException, which must be handled or declared to be thrown
    public static void readFile() throws IOException {
        throw new IOException("File not found");
    }

    public static void main(String[] args) {
        try {
            readFile(); // This will throw an IOException
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
