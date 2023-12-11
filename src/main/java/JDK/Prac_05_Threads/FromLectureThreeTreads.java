package JDK.Prac_05_Threads;

import lombok.Data;

public class FromLectureThreeTreads {
    public static void main(String[] args) {
        Thread first = new Thread(new MyThread("A"));
        Thread second = new Thread(new MyThread("o"));
        Thread third = new Thread(new MyThread("."));

    }
}

@Data
class MyThread extends Thread {
    private final String stream;
    private final Object lock;

    public MyThread(String stream) {
        this.stream = stream;
        this.lock = MyThread.class;
        start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.print(stream);
                try {
                    lock.notify();
                    Thread.sleep(300);
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}