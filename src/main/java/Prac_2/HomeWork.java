package Prac_2;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] b = new int[]{1, 0, 2, 3, 4, 5, 6, 0, 0, 7, 8, 9};

        System.out.println(countEvens(a));
        System.out.println(countEvens(b));
        System.out.println(maxMinDifference(a));
        System.out.println(maxMinDifference(b));
        System.out.println(twoZeroNeighbors(a));
        System.out.println(twoZeroNeighbors(b));
    }

    public static long countEvens(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).count();
    }

    public static int maxMinDifference(int[] array) {
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }

    public static boolean twoZeroNeighbors(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0 && array[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }
}