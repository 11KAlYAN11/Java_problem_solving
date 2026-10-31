package General_Problems;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class JavaReferenceTypesDemo {

    public static void main(String[] args) throws Exception {

        strongReferenceDemo();

        weakReferenceDemo();

        softReferenceDemo();

        weakHashMapDemo();

        phantomReferenceDemo();
    }

    // -----------------------------
    // STRONG REFERENCE
    // -----------------------------
    static void strongReferenceDemo() {

        System.out.println("\n===== STRONG REFERENCE =====");

        Employee emp =
                new Employee(1, "Kalyan");

        System.gc();

        System.out.println(emp);

        /*
         * Strong reference exists.
         * GC cannot remove object.
         */
    }

    // -----------------------------
    // WEAK REFERENCE
    // -----------------------------
    static void weakReferenceDemo()
            throws Exception {

        System.out.println("\n===== WEAK REFERENCE =====");

        Employee emp =
                new Employee(2, "Reddy");

        WeakReference<Employee> ref =
                new WeakReference<>(emp);

        System.out.println(
                "Before GC : " + ref.get());

        emp = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println(
                "After GC : " + ref.get());

        /*
         * Usually becomes null.
         */
    }

    // -----------------------------
    // SOFT REFERENCE
    // -----------------------------
    static void softReferenceDemo()
            throws Exception {

        System.out.println("\n===== SOFT REFERENCE =====");

        Employee emp =
                new Employee(3, "Java");

        SoftReference<Employee> ref =
                new SoftReference<>(emp);

        emp = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println(
                "After GC : " + ref.get());

        /*
         * Usually survives GC.
         * Removed only when memory is low.
         */
    }

    // -----------------------------
    // WEAK HASH MAP
    // -----------------------------
    static void weakHashMapDemo()
            throws Exception {

        System.out.println("\n===== WEAK HASHMAP =====");

        WeakHashMap<Object, String> map =
                new WeakHashMap<>();

        Object key = new Object();

        map.put(key, "Employee");

        System.out.println(
                "Before GC : " + map);

        key = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println(
                "After GC : " + map);

        /*
         * Entry disappears automatically.
         */
    }

    // -----------------------------
    // PHANTOM REFERENCE
    // -----------------------------
    static void phantomReferenceDemo()
            throws Exception {

        System.out.println("\n===== PHANTOM REFERENCE =====");

        ReferenceQueue<Employee> queue =
                new ReferenceQueue<>();

        Employee emp =
                new Employee(4, "Phantom");

        PhantomReference<Employee> ref =
                new PhantomReference<>(
                        emp,
                        queue);

        System.out.println(
                "ref.get() = " + ref.get());

        emp = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println(
                "Reference queued ? "
                        + (queue.poll() != null));

        /*
         * ref.get() always returns null.
         * Used with ReferenceQueue.
         */
    }
}
