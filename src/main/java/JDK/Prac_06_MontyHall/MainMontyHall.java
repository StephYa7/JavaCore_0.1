package JDK.Prac_06_MontyHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMontyHall {
    public static void main(String[] arg) {


        double win = 0;
        double winWithoutShift = 0;
        double winAfterShift = 0;
        double lose = 0;
        double loseWithoutShift = 0;
        double loseAfterShift = 0;
        for (int i = 0; i < 5000; i++) {
            String[] doors = createMontyHallDoors();
            int choice = new Random().nextInt(3);
            if (doors[choice].equals("car")) win++;
            else lose++;




        }

        double result = win / (win + lose) * 100;
        System.out.println(result);


    }

    private static String[] createMontyHallDoors() {
        String[] threeDoors = {"goat", "goat", "goat"};
        int carIndex = new Random().nextInt(3);
        threeDoors[carIndex] = "car";
        return threeDoors;
    }

}