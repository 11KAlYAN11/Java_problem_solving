package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 =============================================================================
                    EMPLOYEE COLLECTION PRACTICE CLASS
 =============================================================================

    PRACTICE THESE OPERATIONS:

    1. Remove duplicates based on employee ID

    2. Sort employees by:
            - salary
            - name
            - id

    3. Find highest salary employee

    4. Filter employees with salary > 50000

    5. Find employee count

    6. Find average salary

    7. Group employees by salary

 =============================================================================

    IMPORTANT:
    ----------

    Practice using:
        ✅ Traditional loops
        ✅ Streams
        ✅ Comparator
        ✅ HashSet
        ✅ HashMap

 =============================================================================
*/

class EmployeePractice {

    int id;
    String name;
    double salary;

    public EmployeePractice(int id, String name, double salary) {

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

public class EmployeeCollectionPractice {

    public static void main(String[] args) {

        /*
         =========================================================================
                                SAMPLE DATA
         =========================================================================
        */

        List<EmployeePractice> employees = Arrays.asList(

                new EmployeePractice(1, "John", 50000),
                new EmployeePractice(2, "Sam", 65000),
                new EmployeePractice(3, "Alex", 45000),
                new EmployeePractice(4, "David", 70000),

                // Duplicate ID
                new EmployeePractice(1, "John", 50000),

                new EmployeePractice(5, "Kalyan", 80000),
                new EmployeePractice(6, "Pavan", 30000)
        );


        /*
         =========================================================================
                            1. REMOVE DUPLICATES
         =========================================================================

            REQUIREMENT:
            ------------
            Remove duplicate employees based on employee ID.

            TRY:
            ----
            ✅ HashSet + List
            ✅ Streams
            ✅ equals() + hashCode()

         =========================================================================
        */

         Set<Integer> ids = new HashSet<>();

         List<EmployeePractice> uniqueEmps = new ArrayList<>();
         for(EmployeePractice e: employees) {
            if(ids.add(e.id)) { // HashSet if insertes True returned else false
               uniqueEmps.add(e);
            }
         }

         System.out.println("Unique Employees Sorted: ");
         for(EmployeePractice e: uniqueEmps) System.out.println(e);



        /*
         =========================================================================
                            2. SORT EMPLOYEES
         =========================================================================

            REQUIREMENT:
            ------------

            Sort by:
                ✅ salary
                ✅ name
                ✅ id

            TRY:
            ----
            ✅ Comparator.comparing()
            ✅ comparingDouble()
            ✅ thenComparing()

         =========================================================================
        */
         List<EmployeePractice> salarySortedEmps = new ArrayList<>(uniqueEmps);
         salarySortedEmps.sort(Comparator.comparingDouble(e -> e.salary));
         System.out.println("Salary wise sorted Emp's: ");
         salarySortedEmps.forEach(System.out::println);

         List<EmployeePractice> nameSortedEmps = new ArrayList<>(uniqueEmps);
         nameSortedEmps.sort(Comparator.comparing(e -> e.name));
         System.out.println("Name wise Sorted Emp's: ");
         nameSortedEmps.forEach(System.out::println);

         List<EmployeePractice> idSortedEmps = new ArrayList<>(uniqueEmps);
         idSortedEmps.sort(Comparator.comparing(e -> e.id));
         System.out.println("ID wise Sorted Emp's: ");
         idSortedEmps.forEach(System.out::println);


         // The same we can do in single step via Set (TreeSet)
         Set<EmployeePractice> slarySortedEmps1 = new TreeSet<>(
            Comparator.comparingDouble(
               (EmployeePractice e) -> e.salary
            )
            .thenComparingInt(
               e -> e.id
            )
         );
         /*
         List<EmployeePractice> slarySortedEmps1 = new ArrayList<>(
            Comparator.comparingDouble(
               (EmployeePractice e) -> e.salary
            )
            .thenComparingInt(
               e -> e.id
            )
         );
         
         TreeSet accepts Comparator in constructor because it maintains elements in sorted order internally.
         ArrayList only stores elements in insertion order, so sorting must be done separately using sort().
         Comparator defines sorting logic, not actual collection data.
         */
         System.out.println("Salary1 Sorted Emps: ");
         slarySortedEmps1.addAll(uniqueEmps); // we are adding that uniqueEmps it will be sorted based on above criteria
         slarySortedEmps1.forEach(System.out::println);

         Set<EmployeePractice> nameSortedEmps1 = new TreeSet<>(
            Comparator.comparing(
               // This (EmployeePractice e) not required directly e -> e.id but when compiler confuses we have to explicity mentioned and cast that 
               (EmployeePractice e) -> e.name
               )

            .thenComparingDouble(e -> e.salary)
            .thenComparingInt(e -> e.id)
            // First check with name -> salary -> id for sorting
         );
         System.out.println("Name1 Sorted Emp's: ");
         nameSortedEmps1.addAll(uniqueEmps);
         nameSortedEmps1.forEach(System.out::println);



        /*
         =========================================================================
                        3. HIGHEST SALARY EMPLOYEE
         =========================================================================

            REQUIREMENT:
            ------------

            Find employee with maximum salary.

            TRY:
            ----
            ✅ Traditional loop
            ✅ Stream max()

         =========================================================================
        */

         EmployeePractice heighestSalaryEmp = employees.get(0);
         for(EmployeePractice e: employees) {
            if(e.salary > heighestSalaryEmp.salary) heighestSalaryEmp = e; // For emp obj we are asigning the heighestSalary Employee
         }
         System.out.println("Heighest Salary Employee: ");
         System.out.println(heighestSalaryEmp);


        /*
         =========================================================================
                        4. FILTER SALARY > 50000
         =========================================================================

            REQUIREMENT:
            ------------

            Print employees having salary greater than 50000.

            TRY:
            ----
            ✅ Traditional loop
            ✅ Stream filter()

         =========================================================================
        */
       List<EmployeePractice> empsSalaryMoreThan50k = new ArrayList<>();
       for(EmployeePractice e: employees) {
         if(e.salary >= 50000) empsSalaryMoreThan50k.add(e);
       }
       System.out.println("Employees With salary more than 50k: ");
       empsSalaryMoreThan50k.forEach(System.out::println);



        /*
         =========================================================================
                            5. TOTAL EMPLOYEE COUNT
         =========================================================================

            REQUIREMENT:
            ------------

            Count total employees.

            TRY:
            ----
            ✅ size()
            ✅ Stream count()

         =========================================================================
        */

         System.out.println("Total Employee Count: ");
         System.out.println(uniqueEmps.size());


        /*
         =========================================================================
                            6. AVERAGE SALARY
         =========================================================================

            REQUIREMENT:
            ------------

            Find average employee salary.

            TRY:
            ----
            ✅ Manual calculation
            ✅ Stream average()

         =========================================================================
        */
       double sumOfEmpSalary = 0;
       for(EmployeePractice e: employees) sumOfEmpSalary += e.salary;
       System.out.println(sumOfEmpSalary);
       double avgSalary = sumOfEmpSalary / employees.size();
       System.out.println("Employees Avg Salary: ");
       System.out.println(avgSalary);



        /*
         =========================================================================
                            7. GROUP BY SALARY
         =========================================================================

            REQUIREMENT:
            ------------

            Group employees based on salary.

            TRY:
            ----
            ✅ HashMap
            ✅ Collectors.groupingBy()

         =========================================================================
        */
       Map<Double, List<EmployeePractice>> empsGrpBySalary = new HashMap<>();
       for(EmployeePractice e: employees) {
         empsGrpBySalary.putIfAbsent(
            e.salary,
            new ArrayList<>()
         );
         // Add emp's into the salary grp
         empsGrpBySalary.get(e.salary).add(e);
       }

       // Print the grouped Employees
       for(Map.Entry<Double, List<EmployeePractice>> entry: empsGrpBySalary.entrySet()) {
         System.out.println("Salary : "+entry.getKey());
         for(EmployeePractice e: entry.getValue()) {
            System.out.println(e);
         }
       }


        /*
         =========================================================================
                                PRACTICE IDEAS
         =========================================================================

            ADD MORE QUESTIONS:

            ✅ Lowest salary employee
            ✅ Second highest salary
            ✅ Sort descending
            ✅ Find duplicate employees
            ✅ Find employees starting with A
            ✅ Count employees by salary range
            ✅ Convert List to Map
            ✅ Partition employees
            ✅ Custom TreeSet sorting

         =========================================================================
        */


        /*
         =========================================================================
                                INTERVIEW NOTES
         =========================================================================

            MOST IMPORTANT CONCEPTS:

            ✅ Comparator
            ✅ Comparable
            ✅ equals()
            ✅ hashCode()
            ✅ HashSet
            ✅ TreeSet
            ✅ Streams
            ✅ Filtering
            ✅ Sorting
            ✅ Aggregation

         =========================================================================
        */
    }
}