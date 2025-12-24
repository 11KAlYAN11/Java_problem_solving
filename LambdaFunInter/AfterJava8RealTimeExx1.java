

interface Discount {
    public double apply(double amount);
}

public class AfterJava8RealTimeExx1 {
    public static void main(String[] args) {
        
        Discount fesDis = amount -> amount * 0.90;  
        /* Internally it will be like 
            class FestivalDiscount implements Discount {
            public double apply(double amount) {
                return amount * 0.90; // 10% off
            }
        }
         */
        Discount newUserDis = amount -> amount * 0.85;
        Discount bulkUserDis = amount -> amount * 0.80;

        System.out.println(fesDis.apply(5000));
        System.out.println(newUserDis.apply(5000));
        System.out.println(bulkUserDis.apply(5000));

        /*
        No extra classes.
        Just function-style coding. */
    }
}
