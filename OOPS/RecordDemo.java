package OOPS;

/*
 =============================================================================
                            JAVA RECORDS DEMO
 =============================================================================

    RECORDS introduced in:
    ----------------------
    Java 14 (stable from Java 16)

    Used for:
    ----------
    Immutable data carrier classes

 =============================================================================

    BEFORE RECORDS:
    ---------------
    We manually write:

        ✅ constructor
        ✅ getters
        ✅ toString()
        ✅ equals()
        ✅ hashCode()

    TOO MUCH boilerplate code.

 =============================================================================

    WITH RECORDS:
    -------------
    Java automatically generates everything.

 =============================================================================
*/


/*
 =============================================================================
                        NORMAL POJO CLASS
 =============================================================================

    Traditional way before records
 =============================================================================
*/

class EmployeeOld {

    private int id;
    private String name;
    private double salary;

    public EmployeeOld(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public double getSalary() {

        return salary;
    }

    @Override
    public String toString() {

        return "EmployeeOld { id = " + id +
                ", name = " + name +
                ", salary = " + salary + " }";
    }
}


/*
 =============================================================================
                            RECORD
 =============================================================================

    Java automatically generates:

        ✅ constructor
        ✅ getters
        ✅ toString()
        ✅ equals()
        ✅ hashCode()

 =============================================================================
*/

record EmployeeRecord(

        int id,
        String name,
        double salary

) {}



public class RecordDemo {

    public static void main(String[] args) {

        /*
         =========================================================================
                            NORMAL CLASS OBJECT
         =========================================================================
        */

        EmployeeOld emp1 =
                new EmployeeOld(
                        1,
                        "Kalyan",
                        85000
                );

        System.out.println("========== NORMAL POJO ==========");

        System.out.println(emp1);

        System.out.println("ID      : " + emp1.getId());

        System.out.println("Name    : " + emp1.getName());

        System.out.println("Salary  : " + emp1.getSalary());



        /*
         =========================================================================
                                RECORD OBJECT
         =========================================================================
        */

        EmployeeRecord emp2 =
                new EmployeeRecord(
                        2,
                        "Pavan",
                        95000
                );

        System.out.println("\n========== RECORD ==========");

        /*
         ---------------------------------------------------
            Auto-generated toString()
         ---------------------------------------------------
        */

        System.out.println(emp2);

        /*
         ---------------------------------------------------
            Record getters
         ---------------------------------------------------

            IMPORTANT:
            ----------
            Records use:
                    fieldName()

            NOT:
                    getFieldName()

         ---------------------------------------------------
        */

        System.out.println("ID      : " + emp2.id());

        System.out.println("Name    : " + emp2.name());

        System.out.println("Salary  : " + emp2.salary());



        /*
         =========================================================================
                            RECORD IMMUTABILITY
         =========================================================================

            IMPORTANT:
            ----------
            Records are IMMUTABLE.

            Fields cannot be modified after creation.

         =========================================================================
        */

        /*
            ❌ NOT ALLOWED

            emp2.name = "ABC";

            emp2.salary = 100000;

         */


        /*
         =========================================================================
                            equals() DEMO
         =========================================================================

            Records automatically generate equals()
            based on all fields.
         =========================================================================
        */

        EmployeeRecord emp3 =
                new EmployeeRecord(
                        2,
                        "Pavan",
                        95000
                );

        System.out.println("\n========== EQUALS CHECK ==========");

        System.out.println(
                "emp2 equals emp3 : " +
                        emp2.equals(emp3)
        );


        /*
         =========================================================================
                            hashCode() DEMO
         =========================================================================
        */

        System.out.println("\n========== HASHCODES ==========");

        System.out.println(
                "emp2 hashCode : " +
                        emp2.hashCode()
        );

        System.out.println(
                "emp3 hashCode : " +
                        emp3.hashCode()
        );



        /*
         =========================================================================
                            INTERVIEW NOTES
         =========================================================================

            RECORDS:
            --------

            ✅ Immutable
            ✅ Less boilerplate
            ✅ Cleaner code
            ✅ Ideal for DTOs
            ✅ Good for API responses

         =========================================================================

            IMPORTANT:
            ----------

            Record fields are:
                    private + final internally

         =========================================================================

            RECORD GETTERS:
            ----------------

                    emp.id()

            NOT:

                    emp.getId()

         =========================================================================

            WHERE RECORDS USED?
            -------------------

            ✅ DTOs
            ✅ API responses
            ✅ Request/response models
            ✅ Read-only objects

         =========================================================================

            WHEN NOT TO USE RECORDS?
            ------------------------

            ❌ Mutable objects
            ❌ Complex business entities
            ❌ JPA entities generally

         =========================================================================

            WHY RECORDS FAMOUS?
            -------------------

            Reduced massive boilerplate code in Java.

         =========================================================================

            INTERVIEW ONE-LINER:
            --------------------

            Records are immutable data carrier classes
            that automatically generate constructor,
            getters, equals, hashCode, and toString.

         =========================================================================
        */
    }
}