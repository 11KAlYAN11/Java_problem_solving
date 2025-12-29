package LambdaFunInter;

interface Multiply{
    int multiply(int a, int b);
}
public class Afterjava8FunInterfaceEx3 {
    public static Multiply helperFuncation() {
        return (x,y) -> x*y;
    }
   /*  public static void main(String[] args) {
        Multiply m = helperFuncation();
        System.out.println(m.multiply(10, 20));
    }
 */
    // optimazation1: 
    /* public static void main(String[] args) {
        Multiply m = (x,y) -> x*y;
        System.out.println(m.multiply(10, 20)); // Helper funcation is optional
    } */

        // Optimazation 2 no varible only
        public static void main(String[] args) {
             System.out.println(((Multiply)(x, y) -> x * y).multiply(10, 20));
        }
}
