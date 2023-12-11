package JDK.Prac_05_Threads.PracTask;

import java.util.concurrent.atomic.AtomicInteger;

public class Switcher { //Зачем тут атомик интеджер???

    static Boolean switcher;
    static volatile AtomicInteger count;

    public static void main(String[] args) {
        switcher = true;
        count = new AtomicInteger(100);

        Thread A = new Thread(() -> {
            while (count.get() > 0) {
                if (switcher) switcher = false;
                else switcher = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread B = new Thread(() -> {
            while (count.get() > 0) {
                if (switcher == true)
                    System.out.println(count.decrementAndGet());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        A.start();
        B.start();
        while (count.get() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}