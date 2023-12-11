package JDK.Prac_05_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FromLect2 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int currentThread = 1;

    public static void main(String[] args) {
        Thread thread1 = new MyThread2("1", 1);
        Thread thread2 = new MyThread2("2", 2);
        Thread thread5 = new MyThread2("5", 5);
        Thread thread4 = new MyThread2("4", 4);
        Thread thread6 = new MyThread2("6", 6);
        Thread thread3 = new MyThread2("3", 3);
        Thread thread7 = new MyThread2("7", 7);
        Thread thread8 = new MyThread2("8", 8);
        Thread thread9 = new MyThread2("9", 9);
    }
}

class MyThread2 extends Thread {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int currentThread = 1;
    private static int maxThread;
    private String inputString;
    private int numberOfThreads;

    public MyThread2(String inputString, int numberOfThreads) {
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