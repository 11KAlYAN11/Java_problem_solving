package Threads;
import java.util.concurrent.*;
import java.util.*;

public class InvokeAllDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(3);



        /*
            List of Callable tasks
        */
        List<Callable<Integer>> tasks =
                Arrays.asList(

            () -> 10,
            () -> 20,
            () -> 30
        );



        /*
            invokeAll()
            -----------

            Executes all tasks.

            Waits until ALL complete.
        */
        List<Future<Integer>> results =
                service.invokeAll(tasks);



        /*
            Reading all results
        */
        for(Future<Integer> f : results) {

            System.out.println(f.get());
        }



        service.shutdown();
    }
}