package Prac_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{1, 0, 2, 3, 4, 5, 6, 0, 0, 7, 8, 9};

        System.out.println(countEvens(a));
        System.out.println(countEvens(b));
        System.out.println(MaxMinDifference(a));
        System.out.println(MaxMinDifference(b));
        System.out.println(TwoZeroNeighbors(a));
        System.out.println(TwoZeroNeighbors(b));
    }

    public static int countEvens(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                result += array[i];
            }
        }
        return result;
    }

    public static int MaxMinDifference(int[] array) {
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }

    public static boolean TwoZeroNeighbors(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}