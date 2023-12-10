package Prac_Vs_ITVDN.Threads;

public class PingPong extends Thread {
    String message ;
    int delay ;

    public PingPong(String message, int delay) {
        this.message = message;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(message);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        PingPong ping = new PingPong("ping",333);
        PingPong pong = new PingPong("PONG",999);

        ping.start();
        pong.start();
//        Thread thread1= new Thread(ping);
//        Thread thread2= new Thread(pong);
//        thread1.start();
//        thread2.start();
    }
}