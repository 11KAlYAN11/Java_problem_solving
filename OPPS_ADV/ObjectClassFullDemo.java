package OPPS_ADV;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 =========================================================
 🌟 OBJECT CLASS – COMPLETE HANDS-ON DEMO 🌟
 =========================================================

 🔹 Covers:
   1. Object inheritance
   2. toString()
   3. equals()
   4. hashCode()
   5. getClass()
   6. clone()
   7. HashSet behavior
   8. Reference vs Logical equality

 =========================================================
*/

class Employee implements Cloneable {

    int id;
    String name;

    // 🧱 Constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 🎨 1. toString() – Object → Readable String
    @Override
    public String toString() {
        return "Employee { id=" + id + ", name='" + name + "' }";
    }

    // ⚖ 2. equals() – Logical Comparison
    @Override
    public boolean equals(Object obj) {

        // 🔹 Same reference
        if (this == obj) return true;

        // 🔹 Null or different class
        if (obj == null || getClass() != obj.getClass()) return false;

        // 🔹 Type casting
        Employee emp = (Employee) obj;

        // 🔹 Field comparison
        return id == emp.id && Objects.equals(name, emp.name);
    }

    // 🔑 3. hashCode() – Hash based collections
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // 🧬 4. clone() – Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectClassFullDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("========== 🌟 OBJECT CLASS DEMO 🌟 ==========\n");

        // 🔹 Creating objects
        Employee e1 = new Employee(101, "Kalyan");
        Employee e2 = new Employee(101, "Kalyan");
        Employee e3 = e1;

        // =====================================================
        // 🧪 1. toString()
        // =====================================================
        System.out.println("🖨 toString() Demo:");
        System.out.println(e1); // calls toString()
        System.out.println();

        // =====================================================
        // ⚖ 2. equals() vs ==
        // =====================================================
        System.out.println("⚖ equals() vs == Demo:");

        System.out.println("e1 == e2  : " + (e1 == e2));      // false (different objects)
        System.out.println("e1.equals(e2): " + e1.equals(e2)); // true (same content)

        System.out.println("e1 == e3  : " + (e1 == e3));      // true (same reference)
        System.out.println();

        // =====================================================
        // 🔑 3. hashCode()
        // =====================================================
        System.out.println("🔑 hashCode() Demo:");
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e2.hashCode(): " + e2.hashCode());
        System.out.println("Same hashCode because equals() is true\n");

        // =====================================================
        // 📦 4. HashSet behavior (REAL INTERVIEW FAVORITE)
        // =====================================================
        System.out.println("📦 HashSet Demo:");

        Set<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2); // duplicate logically
        set.add(new Employee(102, "Arjun"));

        System.out.println("HashSet size (should be 2): " + set.size());
        System.out.println("HashSet contents:");
        set.forEach(System.out::println);
        System.out.println();

        // =====================================================
        // 🏷 5. getClass()
        // =====================================================
        System.out.println("🏷 getClass() Demo:");
        System.out.println("Class name: " + e1.getClass().getName());
        System.out.println();

        // =====================================================
        // 🧬 6. clone()
        // =====================================================
        System.out.println("🧬 clone() Demo:");

        Employee clonedEmp = (Employee) e1.clone();

        System.out.println("Original: " + e1);
        System.out.println("Cloned  : " + clonedEmp);

        System.out.println("Same reference? " + (e1 == clonedEmp));       // false
        System.out.println("Same data? " + e1.equals(clonedEmp));         // true
        System.out.println();

        // =====================================================
        // 🧠 SUMMARY
        // =====================================================
        System.out.println("========== ✅ SUMMARY ==========");
        System.out.println("""
        ✔ Every Java class extends Object
        ✔ toString() → readable output
        ✔ equals() → logical comparison
        ✔ hashCode() → Hash collections
        ✔ getClass() → runtime info
        ✔ clone() → object copy
        ✔ equals + hashCode MUST go together
        """);
    }
}
