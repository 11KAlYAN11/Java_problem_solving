package OOPS;
class Machine {
    static void operate() {
        System.out.println("Machine is operating");
    }
}

public class Robot extends Machine{
    static void operate() {
        System.out.println("Robot is operating..");
    }
    void callStaticMethod() {
        Machine.operate(); //calls Machine'static method (No overriding)
    }
    public static void main(String[] args) {
        Robot r = new Robot();
        Robot.operate();
        
        r.callStaticMethod();
        operate();  //calls Robote operate() method
        Machine.operate();
    }
}
