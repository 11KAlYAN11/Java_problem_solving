public class Demo1 {
    
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234599999));
        System.out.println(sumOfDigits1(1234599999));
        // As we are passing it as a String length is not a matter
        System.out.println(sumOfDigits2("123459999912345999991234599999"));
        System.out.println(reverseDigits(123456789));
        System.out.println(isPrime(97));
        System.out.println(isPowerOfAnother(2L, 256L));
        System.out.println();
        System.out.println(factorial(5));
        System.out.println(factorialR(5));
    }
    static int factorialR(int n) {
        if(n==1) {
            return 1;
        }
        return n * factorialR(n-1);
    }

    static int factorial(int n) {
        // code here
        if(n==0) return 0;
        if(n==1) return 1;
        int a=0;
        int b=1;
        int c = a+b;
        int sum = 0;
        while(c <= n) {
            c = a+b;
            sum += c;
            
            a=b;
            b=c;
            System.out.print(c+" ");
        }
        return sum;
    }

    static Long isPowerOfAnother(Long X, Long Y){
        // code here
        /*int pow = 1;
        while(pow < Y) pow *= X;
        return (pow == Y)? 1L: 0L;*/
        
        //Edge case
        // If X == 1, then 1^n is always 1 for any integer n.
        // This means Y must also be 1 for it to be a power of 1.
        // Example: 1^1 = 1, 1^5 = 1, 1^100 = 1 (always 1)
        // However, if Y is anything other than 1 (e.g., Y = 4, 0, 5), 
        // there is no exponent n that satisfies 1^n = Y.
        // Hence, return 1L only if Y == 1; otherwise, return 0L.
        if (X == 1) return (Y == 1) ? 1L : 0L;

        // offcourse it was correct but too complexity
        // Put is simple by using logerthimitic functions
        double res1 = Math.log(Y) / Math.log(X);
        return (res1%1 == 0)? 1L: 0L;
    }
    static boolean isPrime(int n) {
        // code here
        // bascially will follow i<n -> i<n/2 -> i<=sqrt(n) here sqrt goes to i means i*i <= n Anntamata Arthamaienda😎!
        for(int i=2; i*i <= n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    // Reversing of Digits using String approach (less work unlike n%10, prd = d*10+dig, n/=10;)
    static int reverseDigits(int n) {
        // Code here
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        int res = Integer.parseInt(String.valueOf(sb));
        return res;
    }

    // 1) using general approach
    static int sumOfDigits(int n) {
        int sum=0;
        while(n>0) { // n!=0
            // Extract the last digit
            int last = n%10;
            sum += last;
            n/=10;
        }
        return sum;
    }
    // Using iterative approach
    static int sumOfDigits1(int n) {
        int sum=0;
        if(n==0) return 0;
        return (n%10) + sumOfDigits1(n/10);
        /*
         * Step-by-Step Execution
        Call	Expression	Returned Value
        sumOfDigits1(1234)	(1234 % 10) + sumOfDigits1(123)	4 + ?
        sumOfDigits1(123)	(123 % 10) + sumOfDigits1(12)	3 + ?
        sumOfDigits1(12)	(12 % 10) + sumOfDigits1(1)	2 + ?
        sumOfDigits1(1)	(1 % 10) + sumOfDigits1(0)	1 + ?
        sumOfDigits1(0)	0 (Base case)	0
        Now, we return back through the recursive calls:

        sumOfDigits1(0) → 0
        sumOfDigits1(1) → 1 + 0 = 1
        sumOfDigits1(12) → 2 + 1 = 3
        sumOfDigits1(123) → 3 + 3 = 6
        sumOfDigits1(1234) → 4 + 6 = 10
        So, Final Output = 10

        Tree Representation of Recursion
        markdown
        Copy
        Edit
        sumOfDigits1(1234)
            |
            → 4 + sumOfDigits1(123)
                    |
                    → 3 + sumOfDigits1(12)
                                |
                                → 2 + sumOfDigits1(1)
                                        |
                                        → 1 + sumOfDigits1(0) → returns 0
         */
    }
    // 3 The idea is to take the input number as a string and then iterate over all the characters(digits) to find the sum of digits. To find the actual value of a digit from a character, subtract the ASCII value of ‘0’ from the character. 
    //This approach is used when the input number is so large that it cannot be stored in integer data types.

    static int sumOfDigits2(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++) {
            int digit = s.charAt(i) - '0'; // this char will be converted to respective int
            sum += digit;
        }
        return sum;
    }
}
