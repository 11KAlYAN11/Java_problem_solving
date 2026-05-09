package Threads;

/*
    DIFFERENT WAYS TO CREATE THREADS IN JAVA
*/

public class ThreadWays {

    public static void main(String[] args) {

        // =====================================================
        // 1. BY EXTENDING THREAD CLASS
        // =====================================================

        Thread t1 = new Thread() {

            @Override
            public void run() {

                System.out.println(
                    "Thread using Thread class"
                );
            }
        };

        t1.start();


        // =====================================================
        // 2. BY IMPLEMENTING RUNNABLE INTERFACE
        // =====================================================

        Runnable task = new Runnable() {

            @Override
            public void run() {

                System.out.println(
                    "Thread using Runnable"
                );
            }
        };

        Thread t2 = new Thread(task);

        t2.start();


        // =====================================================
        // 3. USING LAMBDA EXPRESSION
        // =====================================================

        Thread t3 = new Thread(() -> {

            System.out.println(
                "Thread using Lambda"
            );
        });

        t3.start();

        // Creating a runnable via lambda expression
        Runnable taskr = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread tr = new Thread(taskr);
        tr.start();

        // Even shorter version
        new Thread(() -> {
            System.out.println("Thread using Lambda");
        }).start();


        // =====================================================
        // MAIN THREAD
        // =====================================================

        System.out.println(
            "Main Thread: "
            + Thread.currentThread().getName()
        );
    }
}