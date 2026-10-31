
package LambdaFunInter;

interface DiscountRule {

    public double apply(double price);
}

public class AfterJava8RealTimeExx {

    public static void main(String[] args) {

        DiscountRule tenPercent = price -> price * 0.90; // 10% Off
        DiscountRule twentyPercent = price -> price * 0.80; // 20% Off
        DiscountRule bogo = price -> price / 2; // one by One
        DiscountRule festival = price -> price > 5000 ? price * 0.70 : price * 0.10; // If more 30% Off else 10% Off

        applyAndPrint("10% OFF", tenPercent, 3000);
        applyAndPrint("20% OFF", twentyPercent, 3000);
        applyAndPrint("Buy 1 Get 1", bogo, 1200);
        applyAndPrint("Festival Sale", festival, 8000);

    }

    static void applyAndPrint(String ruleName, DiscountRule rule, double price) {
        System.out.println(ruleName + ": Orginal = " + price + " -> After Discount = " + rule.apply(price));
    }
}
