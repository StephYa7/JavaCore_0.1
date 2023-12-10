package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.DaemonThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Daemon daemon1 = new Daemon();
        Daemon daemon2 = new Daemon();

        daemon1.setDaemon(true);

        daemon1.start();
        daemon2.start();
    }
}

class Daemon extends Thread {

    @Override
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Старт потока-демона");
                sleep(1000);
            } else {
                System.out.println("Старт обычного потока");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!isDaemon()) {
                System.out.println("Завершение работы обычного потока");
            } else {
                System.out.println("Завершение работы потока-демона");
            }
        }
    }
}