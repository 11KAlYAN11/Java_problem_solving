package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 =============================================================================
                COMPARATOR : OLD STYLE vs MODERN JAVA STYLE
 =============================================================================

    This class demonstrates:

    ✅ Old Comparator style
    ✅ Modern Comparator style (Java 8+)
    ✅ TreeSet custom sorting
    ✅ Lambda expressions
    ✅ Comparator utility methods
    ✅ thenComparing()
    ✅ Real interview understanding

 =============================================================================

    IMPORTANT:
    ----------
    Comparator is used for:
        CUSTOM SORTING

    Examples:
        - Sort by salary
        - Sort by name
        - Sort by age
        - Sort descending
        - Multiple field sorting

 =============================================================================
*/

class Employee3 {

    int id;
    String name;
    double salary;

    public Employee3(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return "Employee { id = " + id +
                ", name = " + name +
                ", salary = " + salary + " }";
    }
}

/*
 =============================================================================
                    OLD STYLE COMPARATOR
 =============================================================================

    BEFORE JAVA 8:
    --------------
    We used:
        - Separate Comparator classes
        - Anonymous inner classes

    More boilerplate code.
    More verbose.

 =============================================================================
*/

class SalaryComparator implements Comparator<Employee3> {

    @Override
    public int compare(Employee3 e1, Employee3 e2) {

        /*
         ==========================================================
            Compare by salary first
         ==========================================================
        */

        int salaryCompare =
                Double.compare(e1.salary, e2.salary);

        /*
         ==========================================================
            If salary same,
            compare using ID
         ==========================================================
        */

        if(salaryCompare != 0) {

            return salaryCompare;
        }

        return Integer.compare(e1.id, e2.id);
    }
}

/*
 =============================================================================
                    OLD STYLE NAME COMPARATOR
 =============================================================================
*/

class NameComparator implements Comparator<Employee3> {

    @Override
    public int compare(Employee3 e1, Employee3 e2) {

        return e1.name.compareTo(e2.name);
    }
}

public class ModernComparableComparator {

    public static void main(String[] args) {

        /*
         =========================================================================
                            OLD STYLE COMPARATOR
         =========================================================================

            BEFORE JAVA 8:
            --------------
            We create separate comparator classes.

            Then pass object while creating TreeSet.

         =========================================================================
        */

        Set<Employee3> oldStyleSalarySort =
                new TreeSet<>(new SalaryComparator());

        oldStyleSalarySort.add(new Employee3(1, "A1", 300));
        oldStyleSalarySort.add(new Employee3(2, "A2", 200));
        oldStyleSalarySort.add(new Employee3(3, "A3", 200));
        oldStyleSalarySort.add(new Employee3(4, "A4", 400));

        System.out.println("========== OLD STYLE : SORT BY SALARY ==========");

        for(Employee3 e : oldStyleSalarySort) {

            System.out.println(e);
        }

        /*
         =========================================================================
                            OLD STYLE NAME SORT
         =========================================================================
        */

        Set<Employee3> oldStyleNameSort =
                new TreeSet<>(new NameComparator());

        oldStyleNameSort.add(new Employee3(1, "sam", 300));
        oldStyleNameSort.add(new Employee3(2, "alex", 200));
        oldStyleNameSort.add(new Employee3(3, "john", 500));
        oldStyleNameSort.add(new Employee3(4, "david", 400));

        System.out.println("\n========== OLD STYLE : SORT BY NAME ==========");

        for(Employee3 e : oldStyleNameSort) {

            System.out.println(e);
        }


        /*
         =========================================================================
                            MODERN JAVA STYLE
         =========================================================================

            JAVA 8+ introduced:
            -------------------
            ✅ Lambda Expressions
            ✅ Functional Interfaces
            ✅ Comparator Utility Methods

            Result:
            -------
            Less code
            Cleaner syntax
            Better readability

         =========================================================================
        */

        Set<Employee3> modernSalarySort =
                new TreeSet<>(

                        Comparator

                                /*
                                 -----------------------------------------
                                    Sort by salary
                                 -----------------------------------------
                                */
                                .comparingDouble(
                                        (Employee3 e) -> e.salary
                                )

                                /*
                                 -----------------------------------------
                                    If salary same,
                                    then compare by ID
                                 -----------------------------------------
                                */
                                .thenComparingInt(
                                        e -> e.id
                                )
                );

        modernSalarySort.add(new Employee3(1, "A1", 300));
        modernSalarySort.add(new Employee3(2, "A2", 200));
        modernSalarySort.add(new Employee3(3, "A3", 200));
        modernSalarySort.add(new Employee3(4, "A4", 400));

        System.out.println("\n========== MODERN STYLE : SORT BY SALARY ==========");

        for(Employee3 e : modernSalarySort) {

            System.out.println(e);
        }

        /*
         =========================================================================
                            MODERN NAME SORT
         =========================================================================
        */

        Set<Employee3> modernNameSort =
                new TreeSet<>(

                        Comparator.comparing(
                                e -> e.name
                        )
                );

        modernNameSort.add(new Employee3(1, "asam", 300));
        modernNameSort.add(new Employee3(2, "pavan", 200));
        modernNameSort.add(new Employee3(3, "kalyan", 200));
        modernNameSort.add(new Employee3(4, "reddy", 400));

        System.out.println("\n========== MODERN STYLE : SORT BY NAME ==========");

        for(Employee3 e : modernNameSort) {

            System.out.println(e);
        }

        /*
         =========================================================================
                                INTERVIEW NOTES
         =========================================================================

            OLD STYLE:
            ----------
            ✔ Separate comparator class
            ✔ compare() method overridden manually
            ✔ More code
            ✔ Used heavily before Java 8

            MODERN STYLE:
            -------------
            ✔ Lambda expressions
            ✔ Comparator utility methods
            ✔ Cleaner & concise
            ✔ Mostly used in modern projects

         =========================================================================

            IMPORTANT:
            ----------
            TreeSet internally uses comparator logic
            to maintain sorted order.

         =========================================================================

            Comparator Utility Methods:
            ---------------------------

            comparing()
            comparingInt()
            comparingDouble()
            comparingLong()

            thenComparing()

            reversed()

         =========================================================================

            WHY MODERN STYLE IS PREFERRED?
            ------------------------------

            ✅ Less boilerplate
            ✅ Readable
            ✅ Functional programming style
            ✅ Easier maintenance
            ✅ Cleaner production code

         =========================================================================

            VERY IMPORTANT:
            ---------------
            Comparator is used ONLY for sorting.

            NOT for duplicate removal.

         =========================================================================
        */
    }
}