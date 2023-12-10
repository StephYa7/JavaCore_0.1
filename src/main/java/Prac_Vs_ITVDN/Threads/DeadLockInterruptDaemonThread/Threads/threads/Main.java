package Prac_Vs_ITVDN.Threads.DeadLockInterruptDaemonThread.Threads.threads;

public class Main {

    public static void main(String[] args) {
        // Создание потока
        EggVoice eggVoice = new EggVoice();

        System.out.println("Спор начат...");

        // Запуск потока
        eggVoice.start();

        sayChicken();

        isChickenOrEgg(eggVoice);
    }

    private static void isChickenOrEgg(EggVoice eggVoice) {
        // Если оппонент еще не сказал последнее слово
        if (eggVoice.isAlive()) {
            try {
                // Подождать пока оппонент закончит высказываться.
                eggVoice.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Если оппонент уже закончил высказываться
            System.out.println("Первым появилось яйцо!");
        } else {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }

    private static void sayChicken() {
        // Слово «курица» сказано 5 раз
        for (int i = 0; i < 5; i++) {
            try {
                // Приостанавливает поток на 1 секунду
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Курица!");
        }
    }
}

class EggVoice extends Thread {

    @Override
    public void run() {
        // Слово «яйцо» сказано 5 раз
        for (int i = 0; i < 5; i++) {
            try {
                // Приостанавливает поток на 1 секунду
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("яйцо!");
        }
    }
}