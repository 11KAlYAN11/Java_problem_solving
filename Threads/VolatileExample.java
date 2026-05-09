package Threads;

/*
    VOLATILE EXAMPLE
    ----------------

    Problem:
    --------
    One thread changes variable value.

    Another thread may NOT see latest value.

    Why?
    ----
    CPU may use cached copy for performance.

    This is called:
    ----------------
    VISIBILITY PROBLEM

    volatile fixes visibility issue.
*/

public class VolatileExample {

    /*
        volatile
        --------

        Always read latest value
        from MAIN MEMORY.

        Do not use old cached value.
    */
    volatile static boolean running = true; // if we remove volatile the program always keep on running

    public static void main(String[] args)
            throws Exception {

        /*
            Worker Thread
            -------------
            Continuously checks running value.
        */
        Thread worker = new Thread(() -> {

            System.out.println(
                "Worker Started"
            );

            /*
                Without volatile:
                -----------------
                Thread may use OLD cached value.

                So even after:
                    running = false

                loop may continue forever.
            */
            while(running) {

                // doing some work
            }

            /*
                This line executes only when:
                    running becomes false
            */
            System.out.println(
                "Worker Stopped"
            );
        });



        // Starting worker thread
        worker.start();



        /*
            Main thread sleeps for 3 sec
        */
        Thread.sleep(3000);



        System.out.println(
            "Main Thread changing running=false"
        );



        /*
            Updating shared variable.

            Because variable is volatile,
            worker thread immediately sees
            latest value.
        */
        running = false;
    }
}