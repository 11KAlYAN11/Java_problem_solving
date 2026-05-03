package Java5;

/*
========================================
REFLECTION API COMPLETE EXAMPLE
========================================

Reflection:
-----------
Reflection allows inspecting and manipulating
class information dynamically at runtime.

Package:
--------
java.lang.reflect

========================================
WHAT WE ARE DOING HERE
========================================

1. Getting Class object
2. Getting constructors
3. Getting methods
4. Getting fields
5. Creating object dynamically
6. Accessing private field
7. Invoking private method

========================================
IMPORTANT METHODS
========================================

Class methods:
--------------
getName()
getDeclaredMethods()
getDeclaredFields()
getDeclaredConstructors()

Method methods:
---------------
invoke()

Field methods:
--------------
setAccessible(true)
get()
set()

Constructor methods:
--------------------
newInstance()

========================================
INTERVIEW POINT
========================================

Reflection breaks encapsulation because
private members can be accessed.

========================================
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee {

    private int id = 101;

    public String name = "Kalyan";

    public Employee() {
        System.out.println("Employee Constructor Called");
    }

    public void display() {
        System.out.println("Display Method");
    }

    private void showSecret() {
        System.out.println("Private Method Called");
    }
}

public class ReflectionAPIExample {

    public static void main(String[] args) throws Exception {

        /* ========================================
           STEP 1 -> Get Class Object
           ======================================== */

        Class<?> cls = Employee.class;

        System.out.println("Class Name: " + cls.getName());

        System.out.println();

        /* ========================================
           STEP 2 -> Get Constructors
           ======================================== */

        System.out.println("===== Constructors =====");

        Constructor<?>[] constructors =
                cls.getDeclaredConstructors();

        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }

        System.out.println();

        /* ========================================
           STEP 3 -> Get Methods
           ======================================== */

        System.out.println("===== Methods =====");

        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(m.getName());
        }

        System.out.println();

        /* ========================================
           STEP 4 -> Get Fields
           ======================================== */

        System.out.println("===== Fields =====");

        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println();

        /* ========================================
           STEP 5 -> Create Object Dynamically
           ======================================== */

        System.out.println("===== Object Creation =====");

        Object obj =
                cls.getDeclaredConstructor().newInstance();

        System.out.println();

        /* ========================================
           STEP 6 -> Access Private Field
           ======================================== */

        System.out.println("===== Private Field Access =====");

        Field privateField = cls.getDeclaredField("id");

        // bypass private access
        privateField.setAccessible(true);

        System.out.println(
                "Private Field Value: "
                        + privateField.get(obj)
        );

        System.out.println();

        /* ========================================
           STEP 7 -> Invoke Public Method
           ======================================== */

        System.out.println("===== Public Method Call =====");

        Method displayMethod =
                cls.getDeclaredMethod("display");

        displayMethod.invoke(obj);

        System.out.println();

        /* ========================================
           STEP 8 -> Invoke Private Method
           ======================================== */

        System.out.println("===== Private Method Call =====");

        Method privateMethod =
                cls.getDeclaredMethod("showSecret");

        privateMethod.setAccessible(true);

        privateMethod.invoke(obj);
    }
}