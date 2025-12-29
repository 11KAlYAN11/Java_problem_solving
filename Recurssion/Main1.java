package com.learning.java.recurssion;

public class Main1 {
    public static void main(String[] args) {
        printNum(10);
        System.out.println(factorial(5));
        System.out.println(sumOfN(5));
        System.out.println(factorialR(5));
        System.out.println(fib(5));
    }
    static int fib(int n) {
        // tn = tn-1 + tn-2
        if(n==0 || n==1) return n;
        return fib(n-1)+fib(n-2);
    }
    static int factorialR(int n) {
        if(n==1) {
            return 1;
        }
        return n * factorialR(n-1);
    }
    static void printNum(int num) {
        if(num > 1) {
            printNum(num - 1);
        }
        System.out.print(num + " ");
    }
    static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    static int sumOfN(int n) {
        if(n==0) {
            return 0;
        }
        return n + sumOfN(n - 1);
    }
}
