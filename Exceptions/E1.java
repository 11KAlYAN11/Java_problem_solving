package com.learning.java.exceptions;

public class E1 {
    public static void divide(int num, int den) {
        int res;
        try {
            res = num / den;
            System.out.println(res);
        }
        // Here first catch all sub class of Exception like arithmatic, nullPointer,
        // etc..
        // After all this only general Exception parent sub class we catch.
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This is finally block");
        }

    }

    public static void main(String[] args) {
        divide(10, 0);// This will print Ai
    }

}
