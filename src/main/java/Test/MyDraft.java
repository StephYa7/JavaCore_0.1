package Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDraft {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int currentThread = 1;

    public static void main(String[] args) {
        Thread thread1 = new MyThread("1", 1);
        Thread thread2 = new MyThread("2", 2);
        Thread thread3 = new MyThread("3", 3);
        Thread thread4 = new MyThread("4", 4);
        Thread thread5 = new MyThread("5", 5);
        Thread thread6 = new MyThread("6", 6);
        Thread thread7 = new MyThread("7", 7);
        Thread thread8 = new MyThread("8", 8);
        Thread thread9 = new MyThread("9", 9);
    }
}

class MyThread extends Thread {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int currentThread = 1;
    private static int maxThread;
    private String inputString;
    private int numberOfThreads;

    public MyThread(String inputString, int numberOfThreads) {
        this.inputString = inputString;
        this.numberOfThreads = numberOfThreads;
        this.maxThread = numberOfThreads;
        start();
    }

    @Override
    public void run() {
        System.out.print(inputString);
        while (true) {
            try {
                lock.lock();
                if (numberOfThreads != maxThread) {
                    while (currentThread != numberOfThreads - 1) {
                        condition.await();
                    }
                } else {
                    while (currentThread != 1) {
                        condition.await();
                    }
                }
                System.out.print(inputString);
                Thread.sleep(500);
                if (currentThread != maxThread) {
                    currentThread++;
                }
                else {
                    currentThread = 1;
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}