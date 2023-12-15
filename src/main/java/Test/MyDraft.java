package Test;

import java.util.concurrent.atomic.AtomicInteger;

class MyDraft {
    public static int aa = 0;

    public static void main(String args[]) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);


//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        IntStream.range(0, 50000).forEach(i -> {
//            aa++;
//            Thread task = new Thread(() ->
//                    atomicInteger.updateAndGet(n -> n + 2));
//            executor.submit(task);
//        });
//        executor.shutdown();
//        executor.isTerminated();
//        System.out.println(aa + "int");
        System.out.println(atomicInteger.get());
        Thread t = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                aa++;
                atomicInteger.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                aa++;
                atomicInteger.incrementAndGet();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                aa++;
                atomicInteger.incrementAndGet();
            }
        });
        t.start();
        t2.start();
        t3.start();
        System.out.println(t.isDaemon());
//        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
        System.out.println(aa);
    }
}