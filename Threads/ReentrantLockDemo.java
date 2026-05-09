package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    // shared counter
    static int count = 0;

    /*
        Explicit lock object
    */
    static ReentrantLock lock =
            new ReentrantLock();

    public static void main(String[] args)
            throws Exception {

        Thread t1 = new Thread(() -> {

            for(int i = 1; i <= 10000; i++) {

                increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i = 1; i <= 10000; i++) {

                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }



    static void increment() {

        /*
            lock()
            ------

            Acquires lock.

            Other threads must wait.
        */
        lock.lock();

        try {

            count++;

        } finally {

            /*
                VERY IMPORTANT

                unlock() should usually
                be inside finally block.

                So lock always releases.
            */
            lock.unlock();
        }
    }
}
