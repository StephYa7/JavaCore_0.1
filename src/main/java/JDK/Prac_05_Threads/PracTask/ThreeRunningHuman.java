package JDK.Prac_05_Threads.PracTask;

import java.util.concurrent.CountDownLatch;

public class ThreeRunningHuman {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch finishSignal = new CountDownLatch(3);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch rdyToStart = new CountDownLatch(3);
        RunningHuman human1 = new RunningHuman(startSignal, finishSignal, rdyToStart, "John");
        RunningHuman human2 = new RunningHuman(startSignal, finishSignal, rdyToStart, "Ivan");
        RunningHuman human3 = new RunningHuman(startSignal, finishSignal, rdyToStart, "Alex");

        rdyToStart.await();
        System.out.println("На старт!");
        Thread.sleep(1000);
        System.out.println("Внимание!");
        Thread.sleep(1000);
        startSignal.countDown();
        System.out.println("Марш!");
        finishSignal.await();
        System.out.println("Гонка завершена");
    }
}

class RunningHuman extends Thread {
    private final CountDownLatch startSignal;
    private final CountDownLatch finishSignal;
    private final CountDownLatch rdyToStart;
    private final String name;

    public RunningHuman(CountDownLatch startSignal, CountDownLatch finishSignal, CountDownLatch rdyToStart, String name) {
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
        this.rdyToStart = rdyToStart;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовится");
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(name + " на старте");
            rdyToStart.countDown();
            startSignal.await();
            System.out.println(name + " побежал");
            Thread.sleep((long) (Math.random() * 5000));
            System.out.println(name + " финишировал");
            finishSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}