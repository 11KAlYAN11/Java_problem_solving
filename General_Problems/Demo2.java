import java.util.function.Consumer;

public class Demo2 {
    public static void main(String[] args) {
        Consumer<String> greet = (name) -> {
            System.out.println("Hello, "+name);
        };

        greet.accept("Asam Kalyan");
    }
}
