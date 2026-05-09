package Threads;

/*
    IMPLEMENTING RUNNABLE
    ---------------------

    Recommended approach in Java.

    Runnable represents TASK only.
    Thread executes that task.

    Better because:
    - loose coupling
    - better design
    - supports inheritance
*/

public class ThreadViaRunnable implements Runnable {

    @Override
    public void run() {

        // This code runs in separate thread
        for(int i = 1; i <= 5; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " -> " + i
            );

            try {

                // Pause thread
                Thread.sleep(1000);

            } catch (Exception e) {

                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        // Creating task object
        ThreadViaRunnable task = new ThreadViaRunnable();

        /*
            Passing task to Thread.

            Thread will execute run().
        */
        Thread t1 =
            new Thread(task);

        // Setting custom name
        t1.setName("Worker-Thread");

        // Starting thread
        t1.start();

        // Main thread executes separately
        for(int i = 1; i <= 3; i++) {

            System.out.println(
                "Main Thread -> " + i
            );
        }
    }
}