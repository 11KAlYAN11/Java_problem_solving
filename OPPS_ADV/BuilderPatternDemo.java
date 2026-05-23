package OPPS_ADV;

/*
 ============================================================================
            BUILDER DESIGN PATTERN - COMPLETE BEGINNER FRIENDLY
 ============================================================================
 
 WHY BUILDER PATTERN?
 --------------------
 Suppose Employee class has many fields.

 Traditional constructor approach becomes ugly/confusing:

    new Employee("John", 25, "IT", 50000);

 Problems:
 ----------
 1. Hard to understand parameters
 2. Parameter order mistakes possible
 3. Too many constructor arguments
 4. Optional fields difficult to manage

 Builder Pattern solves this problem by:
 ---------------------------------------
 ✅ Step-by-step object creation
 ✅ Readable code
 ✅ Flexible initialization
 ✅ Method chaining

 REAL LIFE ANALOGY 🍔
 --------------------
 Ordering Burger:

    add cheese
    add mayo
    add chicken
    build final burger

 Similar way:
 
    Employee.builder()
             .name("John")
             .salary(50000)
             .build();

 ============================================================================
*/

public class BuilderPatternDemo {

    public static void main(String[] args) {

        /*
         ============================================================
                        OBJECT CREATION USING BUILDER
         ============================================================

         Flow:
         -----
         1. builder() creates Builder object
         2. name() sets name
         3. age() sets age
         4. salary() sets salary
         5. build() creates final Employee object
        */

        Employee employee =

                Employee.builder()
                        .name("John")
                        .age(25)
                        .department("IT")
                        .salary(50000)
                        .build();

        /*
         ============================================================
                            DISPLAY OBJECT
         ============================================================
        */

        employee.display();
    }
}

/*
 ============================================================================
                            EMPLOYEE CLASS
 ============================================================================
*/

class Employee {

    /*
     ============================================================
                            INSTANCE VARIABLES
     ============================================================
    */

    private String name;
    private int age;
    private String department;
    private double salary;

    /*
     ============================================================
                        PRIVATE CONSTRUCTOR
     ============================================================

     WHY PRIVATE?
     ------------
     We don't want users to create object directly using:

         new Employee()

     Instead they should use Builder only.

     Builder sends itself to constructor.

     Constructor copies Builder values into Employee object.
    */

    private Employee(EmployeeBuilder builder) {

        this.name = builder.name;
        this.age = builder.age;
        this.department = builder.department;
        this.salary = builder.salary;
    }

    /*
     ============================================================
                        STATIC BUILDER METHOD
     ============================================================

     WHY STATIC?
     -----------
     So users can call:

         Employee.builder()

     without creating Employee object first.
    */

    public static EmployeeBuilder builder() {

        return new EmployeeBuilder();
    }

    /*
     ============================================================
                            DISPLAY METHOD
     ============================================================
    */

    public void display() {

        System.out.println("\n=========== EMPLOYEE DETAILS ===========");

        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + department);
        System.out.println("Salary     : " + salary);

        System.out.println("========================================");
    }

    /*
     =========================================================================
                            STATIC INNER BUILDER CLASS
     =========================================================================

     This class is responsible for:
     --------------------------------
     ✅ Storing temporary values
     ✅ Step-by-step object construction
     ✅ Returning final Employee object
    */

    public static class EmployeeBuilder {

        /*
         ============================================================
                        TEMPORARY BUILDER VARIABLES
         ============================================================

         These hold values temporarily until build() called.
        */

        private String name;
        private int age;
        private String department;
        private double salary;

        /*
         ============================================================
                                name()
         ============================================================

         WHAT IS HAPPENING?
         -------------------
         1. Sets builder variable
         2. Returns SAME builder object

         WHY return this?
         ----------------
         To enable METHOD CHAINING.

         Example:
         --------
             .name()
             .age()
             .salary()
        */

        public EmployeeBuilder name(String name) {

            this.name = name;

            return this;
        }

        /*
         ============================================================
                                age()
         ============================================================
        */

        public EmployeeBuilder age(int age) {

            this.age = age;

            return this;
        }

        /*
         ============================================================
                            department()
         ============================================================
        */

        public EmployeeBuilder department(String department) {

            this.department = department;

            return this;
        }

        /*
         ============================================================
                                salary()
         ============================================================
        */

        public EmployeeBuilder salary(double salary) {

            this.salary = salary;

            return this;
        }

        /*
         ============================================================
                                build()
         ============================================================

         FINAL STEP 🔥

         Creates actual Employee object using collected values.

         Flow:
         ------
         Builder values ---> Employee Constructor ---> Final Object
        */

        public Employee build() {

            return new Employee(this);
        }
    }
}

/*
 ============================================================================
                                OUTPUT
 ============================================================================

=========== EMPLOYEE DETAILS ===========
Name       : John
Age        : 25
Department : IT
Salary     : 50000.0
========================================


 ============================================================================
                        INTERNAL FLOW VISUALIZATION
 ============================================================================

Employee.builder()
        ↓
creates EmployeeBuilder object
        ↓
.name("John")
        ↓
stores value + returns same builder
        ↓
.age(25)
        ↓
stores value + returns same builder
        ↓
.salary(50000)
        ↓
stores value + returns same builder
        ↓
.build()
        ↓
creates final Employee object


 ============================================================================
                    MOST IMPORTANT CONCEPTS TO REMEMBER
 ============================================================================

1. Builder Pattern solves constructor chaos

2. "return this" enables method chaining

3. Builder stores temporary values

4. build() creates final object

5. Private constructor forces Builder usage

6. Used heavily in:
    - Lombok @Builder
    - Spring APIs
    - ResponseEntity
    - Security Configurations

 ============================================================================
*/