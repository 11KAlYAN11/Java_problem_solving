package Threads;

/*
    PRODUCER CONSUMER USING
    wait() and notify()

    --------------------------------

    Producer:
    adds item

    Consumer:
    consumes item

    If no item:
    consumer waits

    When producer adds item:
    producer notifies consumer
*/

class SharedResource {

    // shared data
    int item;

    // indicates item availability
    boolean available = false;



    // ==============================
    // PRODUCER METHOD
    // ==============================

    synchronized void produce(int value)
            throws Exception {

        /*
            If already item exists,
            producer should wait.
        */
        while(available) {

            wait();
        }

        item = value;

        System.out.println(
            "Produced: " + item
        );

        // item now available
        available = true;

        /*
            notify()
            --------

            Wake up waiting consumer.
        */
        notify();
    }



    // ==============================
    // CONSUMER METHOD
    // ==============================

    synchronized void consume()
            throws Exception {

        /*
            If no item available,
            consumer waits.
        */
        while(!available) {

            /*
                wait()
                -------

                1. releases lock
                2. enters waiting state
            */
            wait();
        }

        System.out.println(
            "Consumed: " + item
        );

        // item consumed
        available = false;

        /*
            notify producer
        */
        notify();
    }
}



public class ProducerConsumerDemo {

    public static void main(String[] args) {

        SharedResource resource =
            new SharedResource();



        // ==========================
        // PRODUCER THREAD
        // ==========================

        Thread producer = new Thread(() -> {

            for(int i = 1; i <= 5; i++) {

                try {

                    resource.produce(i);

                    Thread.sleep(1000);

                } catch(Exception e) {}
            }
        });



        // ==========================
        // CONSUMER THREAD
        // ==========================

        Thread consumer = new Thread(() -> {

            for(int i = 1; i <= 5; i++) {

                try {

                    resource.consume();

                    Thread.sleep(1000);

                } catch(Exception e) {}
            }
        });



        producer.start();
        consumer.start();
    }
}