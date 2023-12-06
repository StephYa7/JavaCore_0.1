package Prac_Vs_ITVDN.Threads;

import java.util.Scanner;

public class TestConcurrent {
    public static void main(String[] args) throws InterruptedException {
        WaitAnsNotify wf = new WaitAnsNotify();
        Thread thread1 = new Thread(() -> {
            try {
                wf.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                wf.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(() -> {

        });

    }
}

class WaitAnsNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producing is starting");
            wait();
            System.out.println("Producing is done");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("waiting for returning key pressed");
            scanner.nextLine();
            Thread.sleep(3000);
            notify();
        }
        System.out.println("good bye");
    }
}