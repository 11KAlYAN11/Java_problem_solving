interface Multiply {
    int multiply(int a, int b);
}

class MyMultiplier implements Multiply {
    @Override
    public int multiply(int a, int b) {
        return a*b;
    }
}

public class BeforeJava8FunInterfaceEx3 {

    public static Multiply helperFuncation() {
        return new MyMultiplier();
    }
    public static void main(String[] args) {
        Multiply m = helperFuncation();
        System.out.println(m.multiply(10,20));
    }
}
