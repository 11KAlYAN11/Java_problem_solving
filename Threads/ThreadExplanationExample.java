package Threads;

class MyTaskThread extends Thread {
    private String taskName;

    public MyTaskThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (" + taskName + ") is starting...");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " (" + taskName + ") is processing task step " + i);
                Thread.sleep(1000); // Simulates task processing
            }
            System.out.println(Thread.currentThread().getName() + " (" + taskName + ") has finished.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}

class ThreadTask implements Runnable { //thread3 using instance
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running and will now wait...");
        try {
            Thread.sleep(3000); // Simulate waiting
            System.out.println(Thread.currentThread().getName() + " has resumed after waiting.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}

class InterruptibleTask implements Runnable { // thread4 using instance
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.sleep(5000); // Long wait
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted during sleep.");
        }
    }
}

public class ThreadExplanationExample {
    /*
     *  Main thread is starting...
        Thread 1 ID: 22
        Thread 2 ID: 23
        Default Priority of Thread 1: 5
        Default Priority of Thread 2: 5
        Custom Priority of Thread 1: 10
        Custom Priority of Thread 2: 1
        Thread-1 (Task-2) is starting...
        Thread-0 (Task-1) is starting...
        Thread-1 (Task-2) is processing task step 1
        Thread-0 (Task-1) is processing task step 1
        Thread-1 (Task-2) is processing task step 2
        Thread-0 (Task-1) is processing task step 2
        Thread-1 (Task-2) is processing task step 3
        Thread-0 (Task-1) is processing task step 3
        Thread-1 (Task-2) is processing task step 4
        Thread-0 (Task-1) is processing task step 4
        Thread-1 (Task-2) is processing task step 5
        Thread-0 (Task-1) is processing task step 5

        Thread-1 (Task-2) has finished.
        Thread-0 (Task-1) has finished.

        Thread-0 has completed. Now resuming main thread.
        Thread 3 ID: 24
        Thread-3 is running and will now wait...
        Thread 3 State: BLOCKED
        Thread 3 is Alive: true
        Thread-3 has resumed after waiting.
        Main thread has completed execution.
        Thread-4 is running...
        Thread-4 was interrupted during sleep.
     */
    public static void main(String[] args) {
        System.out.println("Main thread is starting...");

        // Create threads
        MyTaskThread thread1 = new MyTaskThread("Task-1");
        MyTaskThread thread2 = new MyTaskThread("Task-2");

        // Display thread IDs and default priorities
        System.out.println("Thread 1 ID: " + thread1.getId());
        System.out.println("Thread 2 ID: " + thread2.getId());
        System.out.println("Default Priority of Thread 1: " + thread1.getPriority());
        System.out.println("Default Priority of Thread 2: " + thread2.getPriority());

        // Set custom priorities
        thread1.setPriority(Thread.MAX_PRIORITY); // Priority 10
        thread2.setPriority(Thread.MIN_PRIORITY); // Priority 1

        System.out.println("Custom Priority of Thread 1: " + thread1.getPriority());
        System.out.println("Custom Priority of Thread 2: " + thread2.getPriority());

        // Start the threads
        thread1.start(); // Start Task-1
        thread2.start(); // Start Task-2

        try {
            // Main thread waits for thread1 to complete
            thread1.join();
            System.out.println(thread1.getName() + " has completed. Now resuming main thread.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Create and start thread3
        ThreadTask threadTask = new ThreadTask();
        Thread thread3 = new Thread(threadTask, "Thread-3");
        thread3.start();

        // Display useful thread information
        System.out.println("Thread 3 ID: " + thread3.getId());
        System.out.println("Thread 3 State: " + thread3.getState());
        System.out.println("Thread 3 is Alive: " + thread3.isAlive());
        /*
         *  Thread-0 has completed. Now resuming main thread.
            Thread 3 ID: 24
            Thread-3 is running and will now wait...
            Thread 3 State: BLOCKED
            Thread 3 is Alive: true
            Thread-3 has resumed after waiting.
            Main thread has completed execution.
            Thread-4 is running...
            Thread-4 was interrupted during sleep.
         */

        try {
            // Wait for thread3 to complete
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Demonstrate thread interruption
        InterruptibleTask interruptibleTask = new InterruptibleTask();
        Thread thread4 = new Thread(interruptibleTask, "Thread-4");
        thread4.start();
        thread4.interrupt(); // Interrupt thread4 during its execution

        System.out.println("Main thread has completed execution.");
    }
}
