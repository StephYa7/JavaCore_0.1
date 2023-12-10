package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.Interrupt;

class Main extends Thread {
    private int counter;
    private String word;
    private Thread thread;

    private Main(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    private void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            thread.interrupt();

            for (int i = 0; i < counter; i++) {
                System.out.println(word + i);
            }
        }
    }

    public static void main(String[] args) {
//        Thread currentThread = currentThread();
//        currentThread.setPriority(Thread.MAX_PRIORITY);

        Main th1 = new Main("Did", 5);
        Main th2 = new Main("Did Not", 5);

        th1.setThread(th2);
        th2.setThread(th1);

        th1.setName("Second Thread");
        th2.setName("First Thread");

        th1.start();
        th2.start();
    }
}