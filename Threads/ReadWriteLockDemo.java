package Threads;

import java.util.concurrent.locks.*;

public class ReadWriteLockDemo {

    static int data = 10;

    /*
        ReadWriteLock object
    */
    static ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();

    public static void main(String[] args) {

        // ==========================
        // READER THREAD
        // ==========================

        Runnable readTask = () -> {

            /*
                readLock()
                ----------

                Multiple readers allowed.
            */
            lock.readLock().lock();

            try {

                System.out.println(
                    Thread.currentThread().getName()
                    + " reading: " + data
                );

                try {
                    Thread.sleep(2000);
                } catch(Exception e) {}

            } finally {

                lock.readLock().unlock();
            }
        };



        // ==========================
        // WRITER THREAD
        // ==========================

        Runnable writeTask = () -> {

            /*
                writeLock()
                -----------

                Only ONE writer allowed.

                No readers allowed simultaneously.
            */
            lock.writeLock().lock();

            try {

                data++;

                System.out.println(
                    Thread.currentThread().getName()
                    + " writing: " + data
                );

            } finally {

                lock.writeLock().unlock();
            }
        };



        new Thread(readTask, "Reader-1").start();
        new Thread(readTask, "Reader-2").start();

        new Thread(writeTask, "Writer-1").start();
    }
}