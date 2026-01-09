package Strings;

public class Atoi {
    public static void main(String[] args) {
        int res = myAtoi("    -214g74836478888geeks12");
        System.out.println(res);

    }

    static int myAtoi(String s) {
        int i =0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // 1) We have to discard leading whitespaces
        while(i<n && s.charAt(i) == ' ') {
            i++;
        }

        // 2) Handle the sign
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1: 1;
            i++; // move after than sign
        }

        // 3) Convert the digits
        while(i<n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // char to int

            // 4) check the overflow & underlow before adding to result;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == -1 ? Integer.MIN_VALUE: Integer.MAX_VALUE; // Overflow and underflow met return Integer MAX or MIN
            }

            result = result * 10 + digit;
            i++;
        }
        return result * sign;

        /*
        MAX = 2147483647
        MIN = -2147483648

         */
    }
}
