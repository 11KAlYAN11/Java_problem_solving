package OPPS_ADV;

/*
    VIRTUAL THREADS DEMO
    ====================

    Introduced in:
    ----------------
    Java 21

    Virtual Threads are:
    ---------------------
    Lightweight JVM-managed threads.

    Used for:
    ----------
    Massive concurrent blocking tasks.

    Examples:
    ----------
    - REST API calls
    - DB calls
    - File I/O
    - Microservices

    --------------------------------------
    PLATFORM THREAD vs VIRTUAL THREAD
    --------------------------------------

    Platform Thread:
    ----------------
    1 Java Thread = 1 OS Thread

    Heavyweight
    Expensive
    Limited scalability

    Virtual Thread:
    ----------------
    Many Java Threads share few OS threads.

    Lightweight
    Cheap creation
    Massive scalability

    --------------------------------------
    IMPORTANT IDEA
    --------------------------------------

    Virtual threads make BLOCKING code scalable.

    Earlier:
    ----------
    blocking operation wasted expensive OS thread.

    Now:
    -----
    blocking only pauses lightweight virtual thread.

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadsZeroToHero {

    public static void main(String[] args)
            throws Exception {



        // =====================================================
        // 1. NORMAL PLATFORM THREAD
        // =====================================================

        /*
            Traditional Java thread.

            Uses OS thread internally.
        */

        Thread platformThread = new Thread(() -> {

            System.out.println(
                "\n1. PLATFORM THREAD"
            );

            System.out.println(
                "Thread Type: "
                + Thread.currentThread()
            );
        });

        platformThread.start();

        platformThread.join();



        // =====================================================
        // 2. SIMPLE VIRTUAL THREAD
        // =====================================================

        /*
            startVirtualThread()
            --------------------

            Creates lightweight virtual thread.
        */

        Thread virtualThread =
                Thread.startVirtualThread(() -> {

            System.out.println(
                "\n2. VIRTUAL THREAD"
            );

            System.out.println(
                "Thread Type: "
                + Thread.currentThread()
            );
        });

        virtualThread.join();



        // =====================================================
        // 3. MULTIPLE VIRTUAL THREADS
        // =====================================================

        /*
            Virtual threads are VERY lightweight.

            We can create huge number of threads
            efficiently.
        */

        System.out.println(
            "\n3. MULTIPLE VIRTUAL THREADS"
        );

        for(int i = 1; i <= 5; i++) {

            int taskId = i;

            Thread.startVirtualThread(() -> {

                System.out.println(

                    "Task "
                    + taskId
                    + " running in "
                    + Thread.currentThread()
                );

                try {

                    /*
                        Simulating blocking task
                        like:
                        - DB call
                        - API call
                        - File read
                    */
                    Thread.sleep(2000);

                } catch(Exception e) {}

                System.out.println(

                    "Task "
                    + taskId
                    + " completed"
                );
            });
        }

        Thread.sleep(3000);



        // =====================================================
        // 4. VIRTUAL THREAD EXECUTOR
        // =====================================================

        /*
            Creates:

            ONE virtual thread
            PER TASK
        */

        System.out.println(
            "\n4. VIRTUAL THREAD EXECUTOR"
        );

        ExecutorService service =

                Executors
                .newVirtualThreadPerTaskExecutor();



        /*
            Submitting multiple tasks
        */

        for(int i = 1; i <= 10; i++) {

            int taskId = i;

            service.submit(() -> {

                System.out.println(

                    "Executor Task "
                    + taskId
                    + " -> "
                    + Thread.currentThread()
                );

                try {

                    /*
                        Simulating blocking operation.

                        Virtual threads handle this efficiently.
                    */
                    Thread.sleep(1000);

                } catch(Exception e) {}
            });
        }



        /*
            Graceful shutdown
        */
        service.shutdown();



        // =====================================================
        // 5. WHY VIRTUAL THREADS POWERFUL
        // =====================================================

        /*
            Traditional platform threads:
            --------------------------------

            Too many blocking tasks
            => memory issues
            => thread exhaustion
            => scalability problems

            Virtual threads:
            -----------------

            JVM pauses lightweight thread
            and frees OS thread.

            Better scalability.
        */

        System.out.println(
            "\n5. WHY VIRTUAL THREADS IMPORTANT"
        );

        Thread.startVirtualThread(() -> {

            System.out.println(
                "Simulating API Call..."
            );

            try {

                /*
                    Blocking operation.

                    Virtual thread pauses cheaply.
                */
                Thread.sleep(3000);

            } catch(Exception e) {}

            System.out.println(
                "API Response Received"
            );
        });



        // Waiting for demo completion
        Thread.sleep(5000);



        // =====================================================
        // PROGRAM END
        // =====================================================

        System.out.println(
            "\n===== VIRTUAL THREAD DEMO COMPLETED ====="
        );
    }
}