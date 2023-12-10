package Prac_Vs_ITVDN.Threads;

public class MyFirstMemoryAboutThreads implements Runnable {
    public int count;
    public int count2;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            if (i % 10000 == 0) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }
    public synchronized void  increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyFirstMemoryAboutThreads a = new MyFirstMemoryAboutThreads();
        Object lock = new Object();

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    a.count2++;
                }
                a.increment();
                if (i % 10000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        }, "firstThread");
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    a.count2++;
                }
                a.increment();
                if (i % 10000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);

                }
            }
        }, "secondThread");
//        firstThread.setPriority(10);
//        secondThread.setPriority(1);

        firstThread.start();
        secondThread.start();
/*        Thread threadThread = new Thread(new MyFirstMemoryAboutThreads(),"threadThread");
        threadThread.start();

        for (int i = 0; i < 100000; i++) {
            if (i % 10000 == 0) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
            ref.count++;
        }*/
        Thread.sleep(1000);

        System.out.println(a.count);
        System.out.println(a.count2);


    }
}