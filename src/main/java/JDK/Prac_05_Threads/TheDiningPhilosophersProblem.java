package JDK.Prac_05_Threads;

import lombok.Data;

import java.util.Arrays;

public class TheDiningPhilosophersProblem {
    static Object[] philosopher = new Object[]{0, "|", 0, "|", 0, "|", 0, "|", 0, "|"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(philosopher));
        Philosopher philosopher1 = new Philosopher(9, 0, 1);
        Philosopher philosopher2 = new Philosopher(1, 2, 3);
        Philosopher philosopher3 = new Philosopher(3, 4, 5);
        Philosopher philosopher4 = new Philosopher(5, 6, 7);
        Philosopher philosopher5 = new Philosopher(7, 8, 9);
        for (int i = 0; i < 50; i++) {
            sleep(100);
            System.out.println(Arrays.toString(philosopher));
        }
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Data
    static class Philosopher extends Thread {

        private int indexOfPhilosopher, indexOfRightFork, indexOfLeftFork;

        public Philosopher(int indexOfLeftFork, int indexOfPhilosopher, int indexOfRightFork) {
            this.indexOfPhilosopher = indexOfPhilosopher;
            this.indexOfRightFork = indexOfRightFork;
            this.indexOfLeftFork = indexOfLeftFork;
            setDaemon(true);
            start();
        }

        @Override
        public void run() {
            while (true) {
                if (philosopher[indexOfRightFork].equals("|") && philosopher[indexOfLeftFork].equals("|")) {
                    synchronized (philosopher) {
                        philosopher[indexOfRightFork] = "X";
                        philosopher[indexOfLeftFork] = "X";
                    }
                    TheDiningPhilosophersProblem.sleep(500);
                    synchronized (philosopher) {
                        philosopher[indexOfRightFork] = "|";
                        philosopher[indexOfLeftFork] = "|";
                        philosopher[indexOfPhilosopher] = (int) philosopher[indexOfPhilosopher] + 1;
                    }
                }
            }
        }
    }
}