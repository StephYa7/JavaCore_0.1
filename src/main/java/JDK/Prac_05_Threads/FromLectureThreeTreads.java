import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FromLectureThreeTreads {

    public static void main(String[] args) {
        Thread thread1 = new MyThread("1");
        Thread thread2 = new MyThread("2");
        Thread thread3 = new MyThread("3");
        Thread thread4 = new MyThread("4");
        Thread thread5 = new MyThread("5");
        Thread thread6 = new MyThread("6");
        Thread thread7 = new MyThread("7");
        Thread thread8 = new MyThread("8");
        Thread thread9 = new MyThread("9");
    }
}

@Data
class MyThread extends Thread {
    private static Lock lock = new ReentrantLock();
    private static int maxThread;
    private String inputString;
    private int numberOfThreads;

    private static int currentThread = 1;

    public MyThread(String inputString) {
        this.inputString = inputString;
        this.numberOfThreads = ++maxThread;
        this.maxThread = numberOfThreads;
        start();
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (currentThread == numberOfThreads && currentThread != maxThread) {
                System.out.print(inputString);
                sleepThread(500);
                currentThread++;
            } else if (currentThread == numberOfThreads && currentThread == maxThread) {
                System.out.print(inputString);
                sleepThread(500);
                currentThread = 1;
            }
            lock.unlock();
        }
    }

    private static void sleepThread(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}