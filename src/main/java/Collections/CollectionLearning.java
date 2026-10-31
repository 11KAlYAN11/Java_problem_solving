package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
========================================================
COLLECTION vs LIST vs SET
========================================================

COLLECTION:
-------------
Collection is the ROOT INTERFACE of most collection
data structures in Java.

Hierarchy:

                Collection
                     |
        --------------------------------
        |               |             |
       List            Set          Queue


List:
-----
- Ordered
- Allows duplicates
- Access by index possible

Examples:
ArrayList, LinkedList

Set:
----
- No duplicates
- Mostly unordered

Examples:
HashSet, LinkedHashSet, TreeSet

========================================================
IMPORTANT INTERVIEW QUESTION
========================================================

Q) Which is better?

1) List<Integer> list = new ArrayList<>();

OR

2) Collection<Integer> c = new ArrayList<>();

--------------------------------------------------------

ANSWER:
--------

Usually prefer:

    List<Integer> list = new ArrayList<>();

WHY?
-----
Because List gives MORE functionalities:

- get(index)
- set(index)
- add(index, value)
- sort()
- order guarantee

Whereas Collection is more GENERAL.

--------------------------------------------------------

Collection reference:
---------------------

Collection<Integer> c = new ArrayList<>();

Can ONLY access methods present in Collection interface.

GOOD FOR:
---------
Loose coupling / abstraction.

BAD:
----
Cannot use List-specific methods.

Example:
c.get(0); ❌ ERROR

because get() is not inside Collection interface.

--------------------------------------------------------

List reference:
---------------

List<Integer> list = new ArrayList<>();

Can access:
- Collection methods
- List specific methods

So generally MORE useful.

========================================================
PROGRAM START
========================================================
*/

public class CollectionLearning {

    public static void main(String[] args) {

        /*
        ========================================================
        1️⃣ Collection<Integer> with ArrayList
        ========================================================

        Here object is ArrayList
        but reference type is Collection.

        So only Collection interface methods accessible.
        */

        Collection<Integer> numbers = new ArrayList<>();

        // add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Collection<Integer>:");
        System.out.println(numbers);

        // remove element
        numbers.remove(20);

        System.out.println("After removing 20:");
        System.out.println(numbers);

        // contains check
        System.out.println("Contains 10? " + numbers.contains(10));

        // size
        System.out.println("Size: " + numbers.size());



        /*
        ========================================================
        2️⃣ Collection<String> with ArrayList
        ========================================================
        */

        Collection<String> names = new ArrayList<>();

        names.add("Kalyan");
        names.add("Reddy");
        names.add("Java");

        System.out.println("\nCollection<String>:");
        System.out.println(names);



        /*
        ========================================================
        3️⃣ Collection<Integer> with HashSet
        ========================================================

        YES this absolutely makes sense.

        Because HashSet ALSO implements Collection interface.

        Set 특징:
        - No duplicates
        - Order not guaranteed
        */

        Collection<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(10); // duplicate ignored
        set.add(30);

        System.out.println("\nCollection<Integer> using HashSet:");
        System.out.println(set);

        /*
        Output may be:
        [20, 10, 30]

        Duplicate 10 removed automatically.
        */



        /*
        ========================================================
        4️⃣ List<Integer> with ArrayList
        ========================================================

        MOST COMMON WAY
        */

        List<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println("\nList<Integer>:");
        System.out.println(list);

        /*
        List specific methods
        */

        // access by index
        System.out.println("Element at index 1: " + list.get(1));

        // replace
        list.set(1, 999);

        System.out.println("After set():");
        System.out.println(list);

        // add at index
        list.add(1, 555);

        System.out.println("After adding at index:");
        System.out.println(list);



        /*
        ========================================================
        5️⃣ Why List is usually preferred over Collection
        ========================================================

        Collection:
        -----------
        Generic abstraction.

        List:
        -----
        More functionality.

        So if you KNOW:
        "I need ordered/indexed data"

        Prefer:
            List<Integer>

        If you only need:
        add/remove/contains

        Then:
            Collection<Integer>

        is enough.

        ========================================================
        DRY RUN MENTALITY
        ========================================================

        Collection<Integer> c = new ArrayList<>();

        Means:

        Reference type:
            Collection

        Actual object:
            ArrayList

        So compiler allows ONLY methods available
        in Collection interface.

        --------------------------------------------------------

        List<Integer> list = new ArrayList<>();

        Reference type:
            List

        Actual object:
            ArrayList

        Now compiler allows:
        - Collection methods
        - List specific methods

        ========================================================
        IMPORTANT INTERVIEW CONCEPT
        ========================================================

        This is called:

            UPCASTING / PROGRAMMING TO INTERFACE

        We write:

            List<Integer> list = new ArrayList<>();

        instead of:

            ArrayList<Integer> list = new ArrayList<>();

        because later implementation can change easily.

        Example:
            List<Integer> list = new LinkedList<>();

        without changing rest of code.

        ========================================================
        */
    }
}