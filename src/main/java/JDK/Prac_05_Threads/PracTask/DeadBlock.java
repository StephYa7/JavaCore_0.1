package JDK.Prac_05_Threads.PracTask;

public class DeadBlock {
    public static void main(String[] args) {
        Object lockFirst = new Object();
        Object lockSecond = new Object();
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lockFirst) {
                    synchronized (lockSecond) {
                        System.out.print("1");
                        try {
                            Thread.sleep(111);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lockSecond) {
                    synchronized (lockFirst) {
                        System.out.print("2");
                        try {
                            Thread.sleep(111);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}