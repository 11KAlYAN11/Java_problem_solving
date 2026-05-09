/*
    DEADLOCK EXAMPLE
    ----------------

    Deadlock happens when:

    Thread-1 holds Lock-1
    and waits for Lock-2

    Thread-2 holds Lock-2
    and waits for Lock-1

    Both wait forever.
*/

package Threads;

public class DeadLockExample { // DeadLockExample

    // Shared lock objects
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {

        // ==============================
        // THREAD - 1
        // ==============================

        Thread t1 = new Thread(() -> {

            /*
                synchronized(lock1)
                -------------------

                Thread-1 acquires lock1.

                Now no other thread can use lock1
                until Thread-1 exits this block.
            */
            synchronized(lock1) {

                System.out.println(
                    "Thread-1 holding lock1"
                );

                try {

                    /*
                        Sleep added only to increase
                        chance of deadlock.

                        IMPORTANT:
                        sleep() DOES NOT release lock.
                    */
                    Thread.sleep(100);

                } catch(Exception e) {}

                System.out.println(
                    "Thread-1 waiting for lock2"
                );

                /*
                    Thread-1 STILL HOLDS lock1
                    and now tries to get lock2.
                */
                synchronized(lock2) {

                    System.out.println(
                        "Thread-1 acquired lock2"
                    );
                }
            }
        });



        // ==============================
        // THREAD - 2
        // ==============================

        Thread t2 = new Thread(() -> {

            /*
                Thread-2 acquires lock2 first.
            */
            synchronized(lock2) {

                System.out.println(
                    "Thread-2 holding lock2"
                );

                try {

                    // sleep does not release lock
                    Thread.sleep(100);

                } catch(Exception e) {}

                System.out.println(
                    "Thread-2 waiting for lock1"
                );

                /*
                    Thread-2 STILL HOLDS lock2
                    and now tries to get lock1.
                */
                synchronized(lock1) {

                    System.out.println(
                        "Thread-2 acquired lock1"
                    );
                }
            }
        });



        // Starting both threads
        t1.start();
        t2.start();
    }
}