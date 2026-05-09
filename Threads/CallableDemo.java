package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(2);

        /*
            Callable returns value
        */
        Callable<Integer> task = () -> {

            return 10 + 20;
        };

        Callable<String> task2 = () -> {
            return "Hello" + " world!";
        };

        /*
            submit() returns Future
        */
        Future<Integer> future =
                service.submit(task);

        Future<String> future2 = service.submit(task2);        

        /*
            get()
            -----

            waits for result
        */
        Integer result = future.get();

        System.out.println(result);
        System.out.println(future2.get());

        service.shutdown();
    }
}
