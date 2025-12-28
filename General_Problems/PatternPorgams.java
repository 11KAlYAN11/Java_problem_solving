public class PatternPorgams {
    public static void main(String[] args) {
        pattern1();
        pattern2();
        pattern3();
        pattern4();
        pattern5();
        rambhous();

        // I think for now this much about patterns is enough here with stars we can replace with numbers etc.. (will se later if req)
    }
    static void pattern1() {
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    static void pattern2() {
        for(int i=5; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    static void pattern3() {
        for(int i=1; i<=5; i++) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) { // This loop is for stars
                System.out.print("*");
            }
            System.out.println();
        }

        // Same as above program but bcz of space we got pyramid shape
         for(int i=1; i<=5; i++) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }

    }

     static void pattern4() {
        System.out.println();
        for(int i=5; i>=1; i--) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k <= i; k++) { // This loop is for stars
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Same as above program but bcz of space we got pyramid shape

        for(int i=5; i>=1; i--) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k <= i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void pattern5() {

        System.out.println();
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
         for(int i1=1; i1<=5; i1++) {
            for(int j1=1; j1<=5; j1++) {
                if(i1==j1) {
                    System.out.print("0");
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void rambhous() {
        System.out.println();
        // Just as above programs only some alignments changes
         for(int i=1; i<=5; i++) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }
        // Just as above programs only some alignments changes

         for(int i=5; i>=1; i--) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k <= i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }



        System.out.println();

        // Just as above programs only some alignments changes
        for(int i=5; i>=1; i--) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k <= i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }
        // Just as above programs only some alignments changes
          for(int i=1; i<=5; i++) { // Here we can take 5 = n
            for(int j=5-i; j>=1; j--) { // This loop is for spaces
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) { // This loop is for stars
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
