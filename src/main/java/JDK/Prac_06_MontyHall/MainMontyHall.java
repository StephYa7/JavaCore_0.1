package JDK.Prac_06_MontyHall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainMontyHall {
    public static void main(String[] arg) {
        double win = 0;
        double winAfterShift = 0;
        double lose = 0;
        double loseAfterShift = 0;
        for (int i = 0; i < 100; i++) {
            List<String> doors = createMontyHallDoors();
            int choice = new Random().nextInt(3);
            if (doors.get(choice).equals("car")) {
                win++;
                doors.remove(choice);
            } else lose++;
            doors.remove("goat");        // Если меняем выбор, тот удаляем из пула
            if (doors.contains("car")) {   // дверей любую за которой есть козел,
                winAfterShift++;          // это та дверь которую нам открывает ведущий
            } else loseAfterShift++;     // перед предложением изменить выбор.


        }
        double result = win / (win + lose) * 100;
        double resultAfterShift = winAfterShift / (winAfterShift + loseAfterShift) * 100;
        System.out.println(result);
        System.out.printf("Процент побед, без смены выбора - %f%%\n", result);
        System.out.printf("Процент побед, при смене выбора - %s%%", resultAfterShift);
    }

    private static List<String> createMontyHallDoors() {
        List<String> threeDoors = new ArrayList<>();
        Collections.addAll(threeDoors, "goat", "goat", "goat");
        int carIndex = new Random().nextInt(3);
        threeDoors.set(carIndex, "car");
        return threeDoors;
    }


}