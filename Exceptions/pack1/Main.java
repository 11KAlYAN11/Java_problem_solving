package Exceptions.pack1;

public class Main {
    Main() {
        System.out.println("Main from pack1 called");
    }
    public static void hello(){
        System.out.println("Hello from Main/Java");
    }
    public static void main(String[] args) {
        hello();
        Main obx = new Main();
    }
}
