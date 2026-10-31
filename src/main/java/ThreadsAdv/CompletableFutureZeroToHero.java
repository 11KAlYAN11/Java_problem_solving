package ThreadsAdv;

/*
    COMPLETABLE FUTURE
    ==================

    Package:
    --------
    java.util.concurrent

    CompletableFuture is used for:
    --------------------------------
    1. Asynchronous Programming
    2. Parallel Execution
    3. Non-blocking Tasks
    4. Chaining Async Operations

    --------------------------------
    VERY IMPORTANT METHODS
    --------------------------------

    runAsync()      -> async task WITHOUT return value
    supplyAsync()   -> async task WITH return value

    thenApply()     -> transform result
    thenAccept()    -> consume/use result
    thenRun()       -> run another task

    thenCombine()   -> combine 2 futures

    allOf()         -> wait for ALL futures
    anyOf()         -> wait for FIRST completed future

    exceptionally() -> exception handling

    --------------------------------
    REAL TIME USAGE
    --------------------------------

    Parallel API calls
    Microservices
    Payment systems
    Notification systems
    Dashboard aggregations

*/

import java.util.concurrent.CompletableFuture;

public class CompletableFutureZeroToHero { 

    public static void main(String[] args)
            throws Exception {

        // =====================================================
        // 1. runAsync()
        // =====================================================

        /*
            runAsync()
            -----------

            Runs task asynchronously.

            DOES NOT return result.

            Similar to Runnable.
        */

        CompletableFuture<Void> runAsyncFuture =
                CompletableFuture.runAsync(() -> {

            System.out.println(
                "\n1. runAsync() Example"
            );

            System.out.println(
                "Running in thread: "
                + Thread.currentThread().getName()
            );
        });

        /*
            get()
            -----

            Wait until async task completes.
        */
        runAsyncFuture.get();



        // =====================================================
        // 2. supplyAsync()
        // =====================================================

        /*
            supplyAsync()
            --------------

            Executes task asynchronously
            AND RETURNS result.

            Similar to Callable.
        */

        CompletableFuture<String> supplyFuture =
                CompletableFuture.supplyAsync(() -> {

            System.out.println(
                "\n2. supplyAsync() Example"
            );

            return "Hello CompletableFuture";
        });

        /*
            Fetching returned result
        */
        String supplyResult = supplyFuture.get();

        System.out.println(
            "Result: " + supplyResult
        );



        // =====================================================
        // 3. thenApply()
        // =====================================================

        /*
            thenApply()
            ------------

            Takes previous result
            and TRANSFORMS it.
        */

        CompletableFuture<Integer> applyFuture =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n3. thenApply() Example"
                    );

                    return 10;
                })

                .thenApply(num -> {

                    /*
                        Previous result = 10

                        Transforming:
                        10 * 2 = 20
                    */
                    return num * 2;
                });

        System.out.println(
            "thenApply Result: "
            + applyFuture.get()
        );



        // =====================================================
        // 4. thenAccept()
        // =====================================================

        /*
            thenAccept()
            -------------

            Consumes result.

            DOES NOT return anything.
        */

        CompletableFuture<Void> acceptFuture =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n4. thenAccept() Example"
                    );

                    return "Java";
                })

                .thenAccept(result -> {

                    /*
                        Using result directly
                    */
                    System.out.println(
                        "Consumed Result: "
                        + result
                    );
                });

        acceptFuture.get();



        // =====================================================
        // 5. thenRun()
        // =====================================================

        /*
            thenRun()
            ----------

            Executes another task AFTER completion.

            Does NOT use previous result.
        */

        CompletableFuture<Void> runFuture =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n5. thenRun() Example"
                    );

                    return 100;
                })

                .thenRun(() -> {

                    System.out.println(
                        "Previous Task Completed"
                    );
                });

        runFuture.get();



        // =====================================================
        // 6. CHAINING MULTIPLE OPERATIONS
        // =====================================================

        /*
            Multiple thenApply()
            chain together.
        */

        CompletableFuture<Void> chainFuture =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n6. Chaining Example"
                    );

                    return 5;
                })

                .thenApply(num -> {

                    /*
                        5 * 2 = 10
                    */
                    return num * 2;
                })

                .thenApply(num -> {

                    /*
                        10 + 5 = 15
                    */
                    return num + 5;
                })

                .thenAccept(finalResult -> {

                    System.out.println(
                        "Final Chain Result: "
                        + finalResult
                    );
                });

        chainFuture.get();



        // =====================================================
        // 7. thenCombine()
        // =====================================================

        /*
            Combining TWO async tasks.
        */

        CompletableFuture<Integer> future1 =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n7. thenCombine() Example"
                    );

                    return 10;
                });

        CompletableFuture<Integer> future2 =
                CompletableFuture
                .supplyAsync(() -> {

                    return 20;
                });

        /*
            Combining both results.
        */
        CompletableFuture<Integer> combinedFuture =
                future1.thenCombine(

                    future2,

                    (a, b) -> {

                        /*
                            a = 10
                            b = 20

                            result = 30
                        */
                        return a + b;
                    }
                );

        System.out.println(
            "Combined Result: "
            + combinedFuture.get()
        );



        // =====================================================
        // 8. allOf()
        // =====================================================

        /*
            allOf()
            --------

            Waits for ALL futures to complete.
        */

        CompletableFuture<String> all1 =
                CompletableFuture
                .supplyAsync(() -> "Service-A");

        CompletableFuture<String> all2 =
                CompletableFuture
                .supplyAsync(() -> "Service-B");

        CompletableFuture<String> all3 =
                CompletableFuture
                .supplyAsync(() -> "Service-C");

        CompletableFuture<Void> allFuture =
                CompletableFuture.allOf(
                        all1,
                        all2,
                        all3
                );

        /*
            Wait until ALL complete
        */
        allFuture.get();

        System.out.println(
            "\n8. allOf() Example"
        );

        System.out.println(
            all1.get()
        );

        System.out.println(
            all2.get()
        );

        System.out.println(
            all3.get()
        );



        // =====================================================
        // 9. anyOf()
        // =====================================================

        /*
            anyOf()
            --------

            Returns FIRST completed future.
        */

        CompletableFuture<String> any1 =
                CompletableFuture
                .supplyAsync(() -> {

                    try {
                        Thread.sleep(3000);
                    } catch(Exception e) {}

                    return "Slow Service";
                });

        CompletableFuture<String> any2 =
                CompletableFuture
                .supplyAsync(() -> {

                    return "Fast Service";
                });

        CompletableFuture<Object> anyFuture =
                CompletableFuture.anyOf(
                        any1,
                        any2
                );

        System.out.println(
            "\n9. anyOf() Example"
        );

        /*
            Fast Service returns first
        */
        System.out.println(
            "First Completed: "
            + anyFuture.get()
        );



        // =====================================================
        // 10. exceptionally()
        // =====================================================

        /*
            Exception handling for async tasks.
        */

        CompletableFuture<Integer> exceptionFuture =
                CompletableFuture
                .supplyAsync(() -> {

                    System.out.println(
                        "\n10. exceptionally() Example"
                    );

                    /*
                        Exception occurs here
                    */
                    int result = 10 / 0;

                    return result;
                })

                .exceptionally(ex -> {

                    /*
                        Handles exception.

                        Provides fallback value.
                    */

                    System.out.println(
                        "Exception Occurred: "
                        + ex.getMessage()
                    );

                    return -1;
                });

        System.out.println(
            "Exception Result: "
            + exceptionFuture.get()
        );



        // =====================================================
        // PROGRAM END
        // =====================================================

        System.out.println(
            "\n===== CompletableFuture Completed ====="
        );
    }
}