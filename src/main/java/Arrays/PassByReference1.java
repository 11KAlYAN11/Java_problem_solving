package Arrays;

class Employee {
    int id = 101;
}
public class PassByReference1 {
    static void modify(Employee e) {
        System.out.println("Inside mtd before change: "+e.id);

        e.id = 202;
        System.out.println("Inside mtd After change: "+e.id);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();

        System.out.println("Before mtd call: "+emp.id);

        modify(emp);

        System.out.println("After mtd call: "+emp.id);
    }

    /*========================================
JAVA PASS BY VALUE vs REFERENCE
========================================

1. Java is ALWAYS pass-by-value.
   There is NO true pass-by-reference in Java.

2. For primitive types:
   Java passes COPY of actual value.
   Changes inside method do NOT affect original variable.

3. For objects:
   Java passes COPY of reference,
   NOT actual reference itself.

4. Since copied reference points to same object,
   object data can be modified inside method.

5. Reassigning object reference inside method
   does NOT affect original reference outside method.

========================================
IMPORTANT INTERVIEW LINE
========================================

Java does NOT support true pass-by-reference.
It only passes copies of values
(primitives or object references).

========================================
     */
}
