package Threads;

import java.util.concurrent.atomic.AtomicInteger;

/*
    RACE CONDITION EXAMPLE
    ----------------------

    count++ is NOT thread-safe.

    Internally:
    -------------
    count++

    actually becomes:

    1. READ count
    2. INCREMENT
    3. WRITE back

    Multiple threads can interfere
    between these steps.
*/

public class CountProblem { // CountProblem 

    // Shared variable
    static int count = 0;
    // To Avoid that race condition we ahve to sync, concurHashMap or AtomicInteger
    static AtomicInteger atomicCount1 = new AtomicInteger();

    // Here as 2nd way we are using the Synchronized way to prevent the race condition
    static int syncCount = 0;
    public static synchronized void increment() {
        syncCount++;
    }

    public static void main(String[] args)
            throws Exception {

        /*
            Thread-1
        */
        Thread t1 = new Thread(() -> {

            for(int i = 1; i <= 100000; i++) {

                count++;
                atomicCount1.incrementAndGet(); // this will prevent race conditions
                increment(); // via sync way incrementoing the count
            }
        });

        /*
            Thread-2
        */
        Thread t2 = new Thread(() -> {

            for(int i = 1; i <= 100000; i++) {

                count++;
                atomicCount1.incrementAndGet(); // this will prevent race conditions
                increment(); // via sync way incrementoing the count
            }
        });

        // Starting both threads
        t1.start();
        t2.start();

        /*
            join()
            -------
            Main thread waits until
            both threads finish.
        */
        t1.join();
        t2.join();

        /*
            Expected:
            ----------
            2000

            But often output becomes:
            1834
            1921
            1977

            Because of race condition.
        */
        System.out.println("Normal count: (Race Condition): "+count);
        System.out.println("Atomic Count: "+atomicCount1);
        System.out.println("Sync Count: "+syncCount);
    }
}