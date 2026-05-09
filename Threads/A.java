package Threads;

import java.util.concurrent.*;;

public class A {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        // producer
        Thread producer = new Thread( () -> {
            for(int i=1; i<=5; i++) {
                try {
                    System.out.println("Producing: "+ i);

                
                    queue.put(i);
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
           while (true) { 
               try {
                    int value = queue.take();
                    System.out.println("Consumes: "+value);

                    Thread.sleep(2000);
               } catch (Exception e) {
               }
           }
        });

        producer.start();
        consumer.start();

    }
}
