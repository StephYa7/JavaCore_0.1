package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.simple.deadlock;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) {
        SimpleThread1 simpleThread1 = new SimpleThread1();
        SimpleThread2 simpleThread2 = new SimpleThread2();

        simpleThread1.start();
        simpleThread2.start();
    }

    private static class SimpleThread1 extends Thread {
        @Override
        public void run() {
            synchronized (SimpleThread1.class) {
                System.out.println("Thread 1: Hold SimpleThread1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Waiting SimpleThread2");

                synchronized (SimpleThread2.class) {
                    System.out.println("Thread 1: Hold SimpleThread1 and SimpleThread2");
                }
            }
        }
    }

    private static class SimpleThread2 extends Thread {
        @Override
        public void run() {
            synchronized (SimpleThread2.class) {
                System.out.println("Thread 1: Hold SimpleThread2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting SimpleThread1");

                synchronized (SimpleThread1.class) {
                    System.out.println("Thread 2: Hold SimpleThread1 and SimpleThread2");
                }
            }
        }
    }
}