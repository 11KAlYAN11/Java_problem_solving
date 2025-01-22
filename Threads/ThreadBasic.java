package Threads;

public class ThreadBasic extends Thread {
    public static void main(String[] args) {
        System.out.println("Let's look into Thread's example");

        // Create and start the first thread
        ThreadBasic thread = new ThreadBasic();
        System.out.println("Priority of thread Default: " + thread.getPriority());
        thread.setPriority(6); // Set priority before starting the thread
        thread.start();

        // Create and start the second thread
        Thread thread1 = new Thread(() -> {
            System.out.println("This code is running in thread1");
        });
        System.out.println("Priority of thread1 Default: " + thread.getPriority());
        thread1.setPriority(2); // Set priority before starting the thread
        thread1.start();

        // Main thread operations
        System.out.println("The code is outside of the thread");

        // Display thread details
        System.out.println("Priority of thread: " + thread.getPriority());
        System.out.println("Priority of thread1: " + thread1.getPriority());
        System.out.println("Id of thread: " + thread.getId());
        System.out.println("Id of thread1: " + thread1.getId());
    }

    @Override
    public void run() {
        System.out.println("This code is running in a thread");
    }
}
