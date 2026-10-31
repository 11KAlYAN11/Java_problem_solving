package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

    public static void main(String[] args)
            throws Exception {

        /*
            Thread pool
        */
        ExecutorService service =
                Executors.newFixedThreadPool(2);



        /*
            Callable task
            --------------

            Returns Integer result.
        */
        Callable<Integer> task = () -> {

            System.out.println(
                "Task Executing..."
            );

            Thread.sleep(3000);

            return 10 + 20;
        };



        /*
            submit()
            --------

            Task submitted to thread pool.

            Returns Future object.
        */
        Future<Integer> future =
                service.submit(task);



        System.out.println(
            "Main thread continues..."
        );



        /*
            get()
            -----

            Waits until task completes.

            Then returns result.
        */
        Integer result = future.get();



        System.out.println(
            "Result = " + result
        );



        service.shutdown();
    }
}
