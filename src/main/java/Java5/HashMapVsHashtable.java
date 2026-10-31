package Java5;

/*
========================================
HASHMAP vs HASHTABLE
========================================

Both store key-value pairs.

Main Differences:
-----------------
1. Thread Safety
2. Synchronization
3. Null Handling
4. Performance
5. Legacy vs Modern

========================================
HASHMAP
========================================

- Not synchronized
- Faster
- Allows:
    1 null key
    multiple null values

Preferred in modern applications.

========================================
HASHTABLE
========================================

- Synchronized
- Thread-safe
- Slower
- Does NOT allow null

Legacy class.

========================================
INTERVIEW IMPORTANT
========================================

If thread safety needed:
Use ConcurrentHashMap instead of Hashtable.

========================================
*/

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapVsHashtable {

    public static void main(String[] args) {

        /* ========================================
           HASHMAP EXAMPLE
           ======================================== */

        System.out.println("===== HASHMAP =====");

        HashMap<Integer, String> map =
                new HashMap<>();

        map.put(1, "Java");

        // null key allowed
        map.put(null, "Spring");
        map.put(null, "Yes that was null");

        // null value allowed
        map.put(2, null);

        map.put(4, null);

        System.out.println(map);

        System.out.println();

        /* ========================================
           HASHTABLE EXAMPLE
           ======================================== */

        System.out.println("===== HASHTABLE =====");

        Hashtable<Integer, String> table =
                new Hashtable<>();

        table.put(1, "Docker");

        table.put(2, "Kubernetes");
        // table.put(5, null);
        // table.put(null, "Hai");

        System.out.println(table);

        System.out.println();

        /* ========================================
           NULL INSERT IN HASHTABLE
           ======================================== */

        System.out.println(
                "Trying null in Hashtable..."
        );

        // Uncomment to see exception

        // table.put(null, "Error");

        /*
        Exception:
        ----------
        java.lang.NullPointerException
        */
    }
}
