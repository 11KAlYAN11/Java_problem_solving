import java.util.Random;

public class FAQProb2 {
    public static void main(String[] args) {
        armstrongNumber(153);
        armstrongNumber1(153);
        randomNumber();
    }
    static void armstrongNumber(int num) {
        // num = sum of (each digit ^ number_of_digits)
        String numStr = Integer.toString(num);
        int no_of_digits = numStr.length(); // 3 -> 153

        // int nodigits = String.valueOf(num).length(); // simple one

        int sum = 0;
        for(char ch: numStr.toCharArray()) {
            int digit = ch - '0'; // char -> int
            // Here we are getting the loosy conversion issue while converting from double to int so rounf and int typecasting we did
            sum = sum + (int)Math.round(Math.pow(digit, no_of_digits)); // (1,3) , (5, 3), (3, 3) 1 + 125 + 27 = 153
        }
        System.out.println("is ArmstrongNum: "+(sum == num));
    }

    static void armstrongNumber1(int num) {
        int noOfDigits = String.valueOf(num).length();
        int sum = 0;
        int dupNum = num; // Cux dupNum will go into operations and it will de decreased
        while(dupNum > 0) {
            int digit = dupNum%10; // 153 -> 3, 15 -> 5, 1 -> 1
            sum += power(digit, noOfDigits); // the base, exponential format like (3, 3) -> (5, 3) -> (1, 3)
            dupNum /= 10; // 153 -> 15 -> 1
        }
        System.out.println("Is ArmStrong number: "+ (sum == num));
    }
    static int power(int base, int exp) { // 5^3, 5=Base, 3 = Exp (1)
        int prdt = 1;
        for(int i=0; i<exp; i++) {
            prdt *= base;
        }
        return prdt;
    }

    static void randomNumber() {
        System.out.println((int)(Math.random() * 10)); // random numer from 0 to 9

        Random rand = new Random();
        System.out.println(rand.nextInt(100)); // Most flexible one for all int's, long, double etc..
    }
}
