package OOPS;

/*
 =============================================================================
                    SHALLOW COPY vs DEEP COPY
 =============================================================================

    VERY IMPORTANT INTERVIEW TOPIC

    This class demonstrates:

    ✅ Shallow Copy
    ✅ Deep Copy
    ✅ Reference sharing
    ✅ Independent object creation
    ✅ Real memory understanding

 =============================================================================
*/

class Address {

    String city;

    public Address(String city) {

        this.city = city;
    }

    @Override
    public String toString() {

        return "Address { city = " + city + " }";
    }
}

class Employee {

    int id;
    String name;

    /*
     ---------------------------------------------------
        Employee HAS-A Address
     ---------------------------------------------------
    */

    Address address;

    public Employee(int id, String name, Address address) {

        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {

        return "Employee { id = " + id +
                ", name = " + name +
                ", address = " + address + " }";
    }
}

public class ShallowVsDeepCopyDemo {

    public static void main(String[] args) {

        /*
         =========================================================================
                                ORIGINAL OBJECT
         =========================================================================
        */

        Address address1 =
                new Address("Hyderabad");

        Employee emp1 =
                new Employee(
                        1,
                        "Kalyan",
                        address1
                );

        System.out.println("Original Employee:");
        System.out.println(emp1);


        /*
         =========================================================================
                                SHALLOW COPY
         =========================================================================

            IMPORTANT:
            ----------
            Here we copy ONLY references.

            Both employees share SAME Address object.

         =========================================================================
        */

        Employee shallowCopyEmp =
                new Employee(
                        emp1.id,
                        emp1.name,
                        emp1.address // SAME address reference
                );

        System.out.println("\n========== SHALLOW COPY ==========");

        System.out.println("Before Changing City:");

        System.out.println("emp1            : " + emp1);
        System.out.println("shallowCopyEmp  : " + shallowCopyEmp);

        /*
         ---------------------------------------------------
            Change city using copied object
         ---------------------------------------------------
        */

        shallowCopyEmp.address.city = "Bangalore";

        System.out.println("\nAfter Changing City In Shallow Copy:");

        /*
         ---------------------------------------------------
            BOTH changed because:
            both share SAME Address object
         ---------------------------------------------------
        */

        System.out.println("emp1            : " + emp1);
        System.out.println("shallowCopyEmp  : " + shallowCopyEmp);


        /*
         =========================================================================
                                DEEP COPY
         =========================================================================

            IMPORTANT:
            ----------
            Here we create COMPLETELY NEW nested object.

            Objects become independent.

         =========================================================================
        */

        Employee deepCopyEmp =
                new Employee(

                        emp1.id,

                        emp1.name,

                        /*
                         -----------------------------------------
                            NEW Address object created
                         -----------------------------------------
                        */

                        new Address(emp1.address.city)
                );

        System.out.println("\n========== DEEP COPY ==========");

        System.out.println("Before Changing City:");

        System.out.println("emp1         : " + emp1);
        System.out.println("deepCopyEmp  : " + deepCopyEmp);

        /*
         ---------------------------------------------------
            Change city in deep copy
         ---------------------------------------------------
        */

        deepCopyEmp.address.city = "Chennai";

        System.out.println("\nAfter Changing City In Deep Copy:");

        /*
         ---------------------------------------------------
            emp1 unaffected because:
            separate Address objects
         ---------------------------------------------------
        */

        System.out.println("emp1         : " + emp1);
        System.out.println("deepCopyEmp  : " + deepCopyEmp);


        /*
         =========================================================================
                                MEMORY UNDERSTANDING
         =========================================================================

            SHALLOW COPY:
            -------------
                    emp1  -----------> Address("Bangalore")
                    shallowCopyEmp --^

            BOTH point to SAME address object.

         =========================================================================

            DEEP COPY:
            ----------
                    emp1 --------> Address("Bangalore")

                    deepCopyEmp -> Address("Chennai")

            COMPLETELY separate objects.

         =========================================================================

            VERY IMPORTANT:
            ---------------
            Primitive values:
                copied directly

            Objects:
                references copied

         =========================================================================

            INTERVIEW ONE-LINER:
            --------------------

            Shallow copy copies object references,
            while deep copy creates completely independent objects.

         =========================================================================
        */
    }
}