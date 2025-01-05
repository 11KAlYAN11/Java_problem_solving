public class Hello {
    public static void loop(int n) {
        for(int k=0; k<=n; k++) {
            System.out.println(k);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        loop(10);
    }
}
