package Test.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<? extends Number> producer = new ArrayList();
        List<? super Number> consumer = new ArrayList();

        consumer.add(2);
        consumer.add(2.2);
        consumer.add(2.2);
        Object obj = new Object();
        System.out.println(consumer);
        System.out.println(producer);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 30; i++) {
            executor.submit(new Test(i));
        }


        Thread.sleep(2000);
        executor.shutdown();
        System.out.println("all tasks ready");

        executor.awaitTermination(1, TimeUnit.SECONDS);


    }
}

class Test implements Runnable {
    private int id;

    public Test(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connect" + id);
    }
}