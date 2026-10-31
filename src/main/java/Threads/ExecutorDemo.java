package Threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {

        /*
            Fixed thread pool with 3 threads
        */
        ExecutorService service =
                Executors.newFixedThreadPool(3);

        /*
            Submitting 5 tasks
        */
        for(int i = 1; i <= 5; i++) {

            int taskId = i;

            service.submit(() -> {

                System.out.println(
                    Thread.currentThread().getName()
                    + " executing Task "
                    + taskId
                );

                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}
            });
        }

        /*
            Shutdown executor.

            No new tasks accepted.
        */
        service.shutdown();
    }/*
        Main Components
        Component	Purpose
        Executor	basic interface
        ExecutorService	advanced executor
        Executors	factory class
        Future	async result
        Callable	task returning value
        ThreadPool	reusable worker threads
     */
}