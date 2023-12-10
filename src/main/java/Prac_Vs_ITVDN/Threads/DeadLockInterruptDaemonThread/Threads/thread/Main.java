package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.Threads.thread;

class Main extends Thread {

    private String word;
    private int delay; // длительность паузы

    private Main(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.print(word + " ");

            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main ping = new Main("ping", 50);  // 1/33 секунды
        Main pong = new Main("PONG", 100); // 1/100 секунды

        ping.start();
        pong.start();
    }
}