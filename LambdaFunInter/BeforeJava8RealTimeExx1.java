
package com.learning.java.lambdafuninter;

interface Discount {
    double apply(double amount);
}

class FestivalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.90; // 10% off
    }
}

class NewUserDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.85; // 15% off
    }
}

class BulkDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.80; // 20% off
    }
}
public class BeforeJava8RealTimeExx1 {
    public static void main(String[] args) {
        Discount fesDis = new FestivalDiscount();
        Discount newUserDis = new NewUserDiscount();
        Discount bulkDis = new BulkDiscount();

        System.out.println(fesDis.apply(2000));
        System.out.println(newUserDis.apply(2000));
        System.out.println(bulkDis.apply(2000));

        /* 
        
        ❌ Issues

        Too many classes

        Lots of boilerplate

        Hard to maintain*/
    }
}
