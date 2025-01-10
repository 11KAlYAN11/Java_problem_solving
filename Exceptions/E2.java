package Exceptions;

public class E2 {
    // public static void mtd(int a, int b) throws CustomizeException {
    public static void mtd(int a, int b) throws Exception {
        int res;
        if (a == 0 && b == 0) {
            // this is a unchecked exception
            throw new NullPointerException("Both a & b are zeros no sense of divide");
        }
        if (b == 0) {
            // this is a unchecked exception
            throw new ArithmeticException("Cannot divide by zero");
        }
        if (a == 0) {
            // this is a unchecked exception
            throw new CustomizeException("Offcourse \'a\' can be zero");
        }

        else {
            res = a / b;
        }
        System.out.println(res);
    }

    // public static void main(String[] args) throws CustomizeException
    public static void main(String[] args) throws Exception {
        mtd(0, 0);
    }
}
