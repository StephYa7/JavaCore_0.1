package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Имеются 2 вектора.
 * Требуется написать функцию, которая считает количество общих чисел между двумя векторами и
 * возвращает результат в виде вектора. В ответе необходимо исключить кратность при дубликации*/
public class Vectors {
    public static List<Integer> countCommonNumbers(List<Integer> list1, List<Integer> list2) {

        List<Integer> list = new ArrayList<>();


        return null;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 0, 1, 3);

        List<Integer> result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]

        list1 = Arrays.asList(1, 1, 2, 3);
        list2 = Arrays.asList(2, 1, 3, 1);

        result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]
    }
}
