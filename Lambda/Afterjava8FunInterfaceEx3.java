interface Multiply{
    int multiply(int a, int b);
}
public class Afterjava8FunInterfaceEx3 {
    public static Multiply helperFuncation() {
        return (x,y) -> x*y;
    }
    public static void main(String[] args) {
        Multiply m = helperFuncation();
        System.out.println(m.multiply(10, 20));
    }
}
