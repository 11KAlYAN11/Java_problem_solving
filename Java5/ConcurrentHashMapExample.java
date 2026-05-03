package Java5;

/*
========================================
CONCURRENTHASHMAP EXAMPLE
========================================

HashMap:
--------
- Not thread-safe
- Faster
- Unsafe in multithreading

Hashtable:
-----------
- Thread-safe
- Entire table locked
- Slower

ConcurrentHashMap:
------------------
- Thread-safe
- Better performance
- Partial locking / bucket locking

Preferred in modern applications.

HashMap -> Fast but unsafe
Hashtable -> Safe but slow
ConcurrentHashMap -> Safe and optimized

========================================
*/

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        Map<Integer, String> map =
                new ConcurrentHashMap<>();

        // Map<Integer, String> map1 = new ConcurrentHashMap<>();

        map.put(1, "Java");
        map.put(2, "Spring");
        map.put(3, "Docker");

        System.out.println(map);

        // ConcurrentHashMap does NOT allow null

        // map.put(null, "ABC"); // Exception
        // map.put(4, null);     // Exception
    }
}