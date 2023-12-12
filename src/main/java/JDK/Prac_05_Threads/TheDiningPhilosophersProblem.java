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
        for (int i = 0; i < 100; i++) {
            sleep(105);
            System.out.println(Arrays.toString(philosopher)
                    + philosopher1 + " " + philosopher2 + " " + philosopher3 + " " + philosopher4 + " " + philosopher5);
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
        private boolean leftForkInHand, rightForkInHand;
        private static int maxCount;
        private int count;


        public Philosopher(int indexOfLeftFork, int indexOfPhilosopher, int indexOfRightFork) {
            this.indexOfPhilosopher = indexOfPhilosopher;
            this.indexOfRightFork = indexOfRightFork;
            this.indexOfLeftFork = indexOfLeftFork;
            leftForkInHand = false;
            rightForkInHand = false;
            setDaemon(true);
            start();
        }

        @Override
        public void run() {
            while (true) {
                synchronized (philosopher) {
                    if (philosopher[indexOfRightFork].equals("|") && philosopher[indexOfLeftFork].equals("|")) {
                        philosopher[indexOfRightFork] = "X";
                        philosopher[indexOfLeftFork] = "X";
                        leftForkInHand = true;
                        rightForkInHand = true;
                    }
                }
                if (leftForkInHand == true && rightForkInHand == true) {
                    TheDiningPhilosophersProblem.sleep(100);
                    synchronized (philosopher) {
                        count++;
                        philosopher[indexOfPhilosopher] = count;
                        philosopher[indexOfRightFork] = "|";
                        philosopher[indexOfLeftFork] = "|";
                        leftForkInHand = false;
                        rightForkInHand = false;
                        if (count > maxCount) maxCount = count;
                    }
                    if (count == maxCount) {
                        TheDiningPhilosophersProblem.sleep(105);
                    }
                }
            }
        }

        @Override
        public String toString() {
            return
                    " L " + leftForkInHand +
                            " H " + rightForkInHand;
        }
    }
}