package Threads;
/*
    EXTENDING THREAD CLASS
    ----------------------

    Our class itself becomes a thread.

    Steps:
    1. Extend Thread class
    2. Override run()
    3. Call start()

    IMPORTANT:
    start() -> creates new thread
    run()   -> contains task
*/

public class ThreadExtendDemo extends Thread {

    @Override
    public void run() {

        // Code inside run() executes in separate thread
        for(int i = 1; i <= 5; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " -> " + i
            );

            try {

                // Pause thread for 1 second
                Thread.sleep(1000);

            } catch (Exception e) {

                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        // Creating thread object
        ThreadExtendDemo t1 = new ThreadExtendDemo();

        // Custom thread name
        t1.setName("Worker-Thread");

        /*
            start()
            -------
            Creates NEW THREAD internally.

            JVM automatically calls run().
        */
        t1.start();

        // Main thread runs separately
        for(int i = 1; i <= 3; i++) {

            System.out.println(
                "Main Thread -> " + i
            );
        }
    }
}