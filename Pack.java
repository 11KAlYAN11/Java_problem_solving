//import myPackage.MyClass;
import myPackage.*;

package basics;

public class Pack {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.greet();
        int sum = myClass.add(5, 10);
        System.out.println("Sum: " + sum);
    }
}
