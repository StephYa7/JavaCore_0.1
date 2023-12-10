package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.DeadLock;

public class Main {
    public static void main(String[] args) {
        MyThreadOne t1 = new MyThreadOne();
        MyThreadTwo t2 = new MyThreadTwo();

        t1.setThread2(t2);
        t2.setThread1(t1);

        t1.start();
        t2.start();
    }
}

class MyThreadOne extends Thread {

    private Thread t1;

    MyThreadOne() {
        System.out.println("MyThreadOne create");
    }

    public void setThread2(Thread t) {
        this.t1 = t;
    }

    @Override
    public void run() {
        System.out.println("MyThreadOne start");

        try {
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("MyThreadOne interrupt MyThreadTwo finish…");

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThreadOne finished");
    }
}

class MyThreadTwo extends Thread {

    private Thread t2;

    MyThreadTwo() {
        System.out.println("MyThreadTwo create");
    }

    public void setThread1(Thread t) {
        this.t2 = t;
    }

    @Override
    public void run() {
        System.out.println("MyThreadTwo start");

        System.out.println("MyThreadTwo interrupt MyThreadOne finish…");

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThreadTwo finished");
    }
}