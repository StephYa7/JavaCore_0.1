package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.Threads.runnable;

public class Main implements Runnable {

    private String word;
    private int delay;

    private Main(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.print(word + " ");

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main ping = new Main("ping", 33);
        Main pong = new Main("PONG", 100);

        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);

        t1.start();
        t2.start();
    }
}