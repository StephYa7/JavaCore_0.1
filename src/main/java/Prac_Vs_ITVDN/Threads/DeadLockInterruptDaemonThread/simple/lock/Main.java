package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.simple.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        SimpleCounterThread[] counterThread = new SimpleCounterThread[100];

        fillingArrayOfCounterThread(counter, counterThread);
        startingEachThread(counterThread);
        joinEveryThread(counterThread);

        System.out.println(counter.getCounter());
    }

    private static void joinEveryThread(SimpleCounterThread[] counterThread) {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            try {
                simpleCounterThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startingEachThread(SimpleCounterThread[] counterThread) {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            simpleCounterThread.start();
        }
    }

    private static void fillingArrayOfCounterThread(Counter counter, SimpleCounterThread[] counterThread) {
        for (int i = 0; i < 100; i++) {
            counterThread[i] = new SimpleCounterThread(counter, 1000);
        }
    }
}


class Counter {
    private long counter = 0;
    private Lock reentrantLock = new ReentrantLock();

    public void incrementCurrentValue() {
        reentrantLock.lock();
        try {
            counter++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}

class SimpleCounterThread extends Thread {
    private Counter counter;
    private int number;

    SimpleCounterThread (Counter counter, int number) {
        this.counter = counter;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            counter.incrementCurrentValue();
        }
    }
}