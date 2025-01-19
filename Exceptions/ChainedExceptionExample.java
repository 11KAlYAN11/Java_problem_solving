package Exceptions;

public class ChainedExceptionExample {
    static void readFile() throws Exception {
        try {
            throw new ArithmeticException("Division by zero occured");
        }
        catch (ArithmeticException e) {
            throw new Exception("Error while reading the file", e); //Wrapping the orginal Exception. As we are wrapping the orginal Exception with more briefied message it aslo called as wrapped Exception.
        }
    }
    public static void main(String[] args) {
        try {
            readFile();
        }
        catch (Exception e) {
            System.out.println("Caught Exception: "+e.getMessage());
            System.out.println("Caused by: "+e.getCause());
        }
    }
    
}
