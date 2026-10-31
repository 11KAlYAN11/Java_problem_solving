package Strings;

/*
===============================================================================
                STRING vs STRINGBUFFER vs STRINGBUILDER
===============================================================================

AUTHOR:
-------
Complete Interview + Internal Working + Memory + Performance + Thread Safety

===============================================================================
1. STRING
===============================================================================

Definition:
-----------
String is an IMMUTABLE class in Java.

Meaning:
--------
Once String object is created,
its content CANNOT be changed.

Any modification creates NEW object.

Example:
--------
String s = "Java";

s.concat(" Spring");

Old object:
-----------
"Java"

New object created:
-------------------
"Java Spring"

Original object remains unchanged.

===============================================================================
WHY STRING IS IMMUTABLE
===============================================================================

Java intentionally made String immutable because:

1. SECURITY
------------
Used in:
- Database URLs
- Network connections
- File paths
- Socket programming
- Class loading

Example:
--------
Database URL should never change accidentally.

String dbUrl =
"jdbc:mysql://localhost:3306/mydb";

If mutable:
-----------
Hackers/code could modify URL at runtime.

Immutable => Safe.

-------------------------------------------------------------------------------

2. STRING CONSTANT POOL
------------------------
Java reuses String objects from SCP.

Example:
--------
String a = "Java";
String b = "Java";

Both point to SAME object.

Possible only because String is immutable.

-------------------------------------------------------------------------------

3. THREAD SAFETY
----------------
Immutable objects are naturally thread-safe.

Multiple threads can safely use same String object.

-------------------------------------------------------------------------------

4. HASHCODE CACHING
-------------------
String frequently used in:
- HashMap
- Hashtable
- Caching

Hashcode cached internally for performance.

If mutable:
-----------
Hashcode would change after modification.

HashMap structure would break.

-------------------------------------------------------------------------------

5. CLASS LOADING SAFETY
------------------------
Class names stored as Strings.

Immutable prevents security issues during class loading.

===============================================================================
STRING MEMORY UNDERSTANDING
===============================================================================

String str = "Java";

Memory:
-------
SCP:
----
"Java"

Now:
----
str.concat(" Spring");

NEW OBJECT:
-----------
"Java Spring"

Old object:
------------
Still exists.

Because String immutable.

===============================================================================
2. STRINGBUFFER
===============================================================================

Definition:
-----------
StringBuffer is MUTABLE.

Meaning:
--------
Original object can be modified.

No new object created for modifications.

===============================================================================
STRINGBUFFER FEATURES
===============================================================================

1. Mutable
2. Thread-safe
3. Synchronized
4. Slower than StringBuilder
5. Introduced in Java 1.0

===============================================================================
WHY THREAD SAFE
===============================================================================

Methods are synchronized.

Example internally:
-------------------

public synchronized StringBuffer append(String str)

Locking happens.

Only one thread modifies object at a time.

===============================================================================
PROBLEM WITH STRINGBUFFER
===============================================================================

Synchronization overhead.

More locking:
-------------
Lower performance.

===============================================================================
3. STRINGBUILDER
===============================================================================

Definition:
-----------
StringBuilder is also MUTABLE.

Introduced:
-----------
Java 1.5

===============================================================================
STRINGBUILDER FEATURES
===============================================================================

1. Mutable
2. NOT synchronized
3. NOT thread-safe
4. Faster than StringBuffer
5. Best for single-threaded operations

===============================================================================
WHY STRINGBUILDER IS FAST
===============================================================================

No synchronization.

No locking overhead.

Better performance.

===============================================================================
INTERNAL STORAGE
===============================================================================

StringBuffer and StringBuilder internally use:
----------------------------------------------
Resizable character array.

Like:
-----
char[]

When capacity full:
-------------------
New bigger array created.

===============================================================================
DEFAULT CAPACITY
===============================================================================

StringBuffer/StringBuilder:
---------------------------
Default capacity = 16

If initialized with String:
---------------------------
capacity = string length + 16

===============================================================================
IMPORTANT METHODS
===============================================================================

append()
insert()
delete()
reverse()
replace()
capacity()
length()

===============================================================================
MUTABILITY COMPARISON
===============================================================================

String:
-------
Immutable

StringBuffer:
-------------
Mutable

StringBuilder:
--------------
Mutable

===============================================================================
THREAD SAFETY COMPARISON
===============================================================================

String:
-------
Thread-safe due to immutability

StringBuffer:
-------------
Thread-safe due to synchronization

StringBuilder:
--------------
Not thread-safe

===============================================================================
PERFORMANCE ORDER
===============================================================================

FASTEST -----------------> SLOWEST

StringBuilder
    >
StringBuffer
    >
String

===============================================================================
WHEN TO USE WHAT
===============================================================================

Use String:
-----------
- Read-only data
- Constants
- Database URLs
- Configuration values

Use StringBuffer:
-----------------
- Multi-threaded string modifications

Use StringBuilder:
------------------
- Single-threaded heavy string modifications

===============================================================================
INTERVIEW TRAPS
===============================================================================

Q) Does String.concat() modify original object?

Answer:
-------
NO

Because String immutable.

-------------------------------------------------------------------------------

Q) Which is fastest?

Answer:
-------
StringBuilder

-------------------------------------------------------------------------------

Q) Which is thread-safe?

Answer:
-------
String
StringBuffer

-------------------------------------------------------------------------------

Q) Why StringBuilder faster than StringBuffer?

Answer:
-------
No synchronization overhead.

-------------------------------------------------------------------------------

Q) Why String immutable?

Answer:
-------
Security
Thread safety
SCP optimization
Hashcode caching

===============================================================================
REAL INDUSTRY USAGE
===============================================================================

String:
-------
- API URLs
- JWT tokens
- SQL queries
- File paths

StringBuilder:
--------------
- Log generation
- Dynamic query building
- JSON/XML creation

StringBuffer:
-------------
Rare today.
Mostly legacy systems.

===============================================================================
COMPLETE PROGRAM
===============================================================================
*/

public class StringCompleteGuide {

    public static void main(String[] args) {

        /* =========================================================================
           STRING EXAMPLE
           ========================================================================= */

        System.out.println("=============== STRING ===============");

        String str = "Java";

        System.out.println("Before concat(): " + str);

        /*
        concat() creates NEW object.
        Original object remains unchanged.
        */

        str.concat(" Spring");

        System.out.println("After concat(): " + str);

        /*
        Output:
        -------
        Java

        Because String immutable.
        */

        /*
        Correct way:
        Reassign returned object.
        */

        str = str.concat(" Spring");

        System.out.println("After reassignment: " + str);

        System.out.println();

        /* =========================================================================
           STRINGBUFFER EXAMPLE
           ========================================================================= */

        System.out.println("=========== STRINGBUFFER ===========");

        StringBuffer sb = new StringBuffer("Java");

        System.out.println("Before append(): " + sb);

        /*
        append() modifies SAME object.
        No new object created.
        */

        sb.append(" Docker");

        System.out.println("After append(): " + sb);

        /*
        Reverse operation
        */

        sb.reverse();

        System.out.println("After reverse(): " + sb);

        /*
        Capacity details
        */

        System.out.println("Capacity: " + sb.capacity());

        System.out.println();

        /* =========================================================================
           STRINGBUILDER EXAMPLE
           ========================================================================= */

        System.out.println("========== STRINGBUILDER ==========");

        StringBuilder builder =
                new StringBuilder("Java");

        System.out.println("Before append(): " + builder);

        builder.append(" Kubernetes");

        System.out.println("After append(): " + builder);

        /*
        Insert operation
        */

        builder.insert(5, "AWS ");

        System.out.println("After insert(): " + builder);

        /*
        Replace operation
        */

        builder.replace(0, 4, "Python");

        System.out.println("After replace(): " + builder);

        /*
        Delete operation
        */

        builder.delete(0, 7);

        System.out.println("After delete(): " + builder);

        System.out.println();

        /* =========================================================================
           MEMORY COMPARISON DEMO
           ========================================================================= */

        System.out.println("========= MEMORY COMPARISON =========");

        String s1 = "Hello";

        /*
        Creates NEW object every time
        */

        s1 = s1 + " World";
        s1 = s1 + " Java";
        s1 = s1 + " Spring";

        System.out.println("String Result: " + s1);

        /*
        Better alternative:
        StringBuilder
        */

        StringBuilder sb2 = new StringBuilder("Hello");

        sb2.append(" World");
        sb2.append(" Java");
        sb2.append(" Spring");

        System.out.println("StringBuilder Result: " + sb2);

        System.out.println();

        /* =========================================================================
           THREAD SAFETY NOTES
           ========================================================================= */

        System.out.println("========= THREAD SAFETY =========");

        System.out.println("String -> Safe (Immutable)");
        System.out.println("StringBuffer -> Safe (Synchronized)");
        System.out.println("StringBuilder -> Not Safe");

        System.out.println();

        /* =========================================================================
           FINAL SUMMARY
           ========================================================================= */

        System.out.println("========= FINAL SUMMARY =========");

        System.out.println("String -> Immutable");
        System.out.println("StringBuffer -> Mutable + Thread Safe");
        System.out.println("StringBuilder -> Mutable + Fastest");
    }
}