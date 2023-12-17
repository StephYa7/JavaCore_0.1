package Test;

import java.util.Random;

class MyDraft {
    public static void main(String[] arg) {


        double win = 0;
        double lose = 0;
        for (int i = 0; i < 5000; i++) {
            boolean[] doors = createMontyHallDoors();
            int choice = new Random().nextInt(3);
//            if (doors[choice]) win++;
//            else lose++;


        }

        double result = win / (win + lose) * 100;
        System.out.println(result);


    }

    private static boolean[] createMontyHallDoors() {
        boolean[] threeDoors = {false, false, false};
        int carIndex = new Random().nextInt(3);
        threeDoors[carIndex] = true;
        return threeDoors;
    }
}