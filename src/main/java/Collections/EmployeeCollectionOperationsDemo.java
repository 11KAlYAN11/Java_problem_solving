package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 =====================================================================
                    EMPLOYEE COLLECTION PROBLEMS
 =====================================================================

 This program covers MOST COMMON Java interview concepts:

 ✅ OOP Basics
 ✅ Collections
 ✅ HashSet
 ✅ Duplicate Removal
 ✅ Sorting using Comparator
 ✅ Filtering
 ✅ Finding Maximum
 ✅ Comparator utility methods
 ✅ Traditional loops
 ✅ Stream alternatives (reference)

 =====================================================================

 IMPORTANT INTERVIEW LEARNING:

 Most real interview questions are combinations of:
    - List<Object>
    - Filtering
    - Sorting
    - Duplicate removal
    - Aggregation (max/min/count)

 =====================================================================
*/

class Employee {

    int id;
    String name;
    double salary;

    /*
     ==========================================================
        Constructor
     ==========================================================
    */

    public Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /*
     ==========================================================
        toString()

        Without overriding:
            Employee@7ab23c

        With overriding:
            readable object output
     ==========================================================
    */

    @Override
    public String toString() {

        return id + " " + name + " " + salary;
    }

    /*
     ==========================================================

        NOTE:
        -----
        We did NOT override:
            - equals()
            - hashCode()

        So:
            Set<Employee>

        will NOT automatically remove duplicates.

        Because HashSet compares:
            object references

        NOT actual field values.

     ==========================================================

        IF WE WANT:

            Set<Employee>

        to automatically remove duplicates,
        then we MUST override:

            equals()
            hashCode()

        based on employee id.

     ==========================================================
    */
}

public class EmployeeCollectionOperationsDemo { 

    public static void main(String[] args) {

        /*
         ==========================================================
            SAMPLE EMPLOYEE DATA
         ==========================================================
        */

        List<Employee> employees = Arrays.asList(

                new Employee(1, "John", 50000),
                new Employee(2, "Sam", 60000),
                new Employee(3, "Alex", 45000),

                // Duplicate Employee ID
                new Employee(1, "John", 50000),

                new Employee(4, "David", 70000)
        );

        /*
         =================================================================
                            1. REMOVE DUPLICATES
         =================================================================

            GOAL:
            -----
            Remove duplicate employees based on ID.

         =================================================================

            APPROACH USED:
            --------------
            Set<Integer> + List<Employee>

            WHY?
            ----
            Integer already overrides:
                equals()
                hashCode()

            So HashSet can properly detect duplicate IDs.

         =================================================================

            IMPORTANT:
            ----------
            Set.add() returns:

                true  -> inserted successfully
                false -> duplicate already exists

         =================================================================

            TIME COMPLEXITY:
            ----------------
            O(n)

         =================================================================
        */

        System.out.println("============== UNIQUE EMPLOYEES ==============");

        Set<Integer> ids = new HashSet<>();

        List<Employee> uniqueEmployees = new ArrayList<>();

        for(Employee e : employees) {

            /*
             ------------------------------------------------------
                ids.add(e.id)

                returns TRUE only for first insertion.
             ------------------------------------------------------
            */

            if(ids.add(e.id)) {

                uniqueEmployees.add(e);
            }
        }

        for(Employee e : uniqueEmployees) {

            System.out.println(e);
        }

        /*
         =================================================================
            OTHER POSSIBLE APPROACHES FOR DUPLICATE REMOVAL
         =================================================================

            1. Override equals() + hashCode()
               Then directly use:

                    Set<Employee>

            2. Streams + HashSet

                Set<Integer> ids = new HashSet<>();

                employees.stream()
                         .filter(e -> ids.add(e.id))
                         .toList();

            3. Collectors.toMap()

                Useful in enterprise projects.

         =================================================================
        */


        /*
         =================================================================
                            2. SORT BY SALARY
         =================================================================

            Comparator:
            -----------
            Used for custom sorting.

            comparingDouble():
            ------------------
            Utility method for sorting double values.

         =================================================================

            IMPORTANT:
            ----------
            Comparator is ONLY for sorting.

            NOT for duplicate removal.

         =================================================================

            TIME COMPLEXITY:
            ----------------
            O(n log n)

         =================================================================
        */

        List<Employee> sortedEmployees =
                new ArrayList<>(uniqueEmployees);

        sortedEmployees.sort(

                Comparator.comparingDouble(e -> e.salary)

        );

        /*
         ==========================================================
            STREAM VERSION (REFERENCE)

            employees.stream()
                     .sorted(
                         Comparator.comparingDouble(
                             e -> e.salary
                         )
                     )
                     .toList();
         ==========================================================
        */

        System.out.println("\n============== SORTED BY SALARY ==============");

        for(Employee e : sortedEmployees) {

            System.out.println(e);
        }


        /*
         =================================================================
                    3. FIND HIGHEST SALARY EMPLOYEE
         =================================================================

            APPROACH:
            ---------
            Keep track of current maximum employee.

            Compare one by one.

         =================================================================

            TIME COMPLEXITY:
            ----------------
            O(n)

         =================================================================
        */

        Employee highestSalaryEmployee =
                sortedEmployees.get(0);

        for(Employee e : sortedEmployees) {

            if(e.salary > highestSalaryEmployee.salary) {

                highestSalaryEmployee = e;
            }
        }

        /*
         ==========================================================
            STREAM VERSION (REFERENCE)

            employees.stream()
                     .max(
                         Comparator.comparingDouble(
                             e -> e.salary
                         )
                     );
         ==========================================================
        */

        System.out.println("\n========== HIGHEST SALARY EMPLOYEE ==========");

        System.out.println(highestSalaryEmployee);


        /*
         =================================================================
                    4. FILTER SALARY > 50000
         =================================================================

            CONDITION-BASED FILTERING

         =================================================================

            TIME COMPLEXITY:
            ----------------
            O(n)

         =================================================================
        */

        List<Employee> highSalaryEmployees =
                new ArrayList<>();

        for(Employee e : sortedEmployees) {

            if(e.salary > 50000) {

                highSalaryEmployees.add(e);
            }
        }

        /*
         ==========================================================
            STREAM VERSION (REFERENCE)

            employees.stream()
                     .filter(e -> e.salary > 50000)
                     .toList();
         ==========================================================
        */

        System.out.println("\n========== SALARY > 50000 ==========");

        for(Employee e : highSalaryEmployees) {

            System.out.println(e);
        }


        /*
         =================================================================
                            FINAL INTERVIEW NOTES
         =================================================================

         1. HashSet duplicate logic depends on:
                - hashCode()
                - equals()

         2. Comparator is used for:
                custom sorting

         3. Comparable:
                natural/default sorting

         4. Set.add() returns:
                true  -> inserted
                false -> duplicate

         5. Traditional loops are STILL important.
            Don't depend only on streams.

         6. Most interview problems test:
                Collections + OOP together

         =================================================================
        */
    }
}