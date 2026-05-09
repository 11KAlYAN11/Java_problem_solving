package Threads;


public class ThreadGroupExample implements Runnable {

    @Override
    public void run() {

        System.out.println(
            Thread.currentThread().getName()
        );
    }

    public static void main(String[] args) {

        ThreadGroupExample runnable =
            new ThreadGroupExample();

        // Creating thread group
        ThreadGroup tg1 =
            new ThreadGroup("ParentThread");

        // Threads inside group
        Thread t1 =
            new Thread(tg1, runnable, "One");

        Thread t2 =
            new Thread(tg1, runnable, "Two");

        Thread t3 =
            new Thread(tg1, runnable, "Three");

        t1.start();
        t2.start();
        t3.start();

        System.out.println(
            "ThreadGroup name: "
            + tg1.getName()
        );

        // Displays group info
        tg1.list();
    }
}