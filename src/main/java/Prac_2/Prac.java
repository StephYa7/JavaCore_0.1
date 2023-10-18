package Prac_2;

import java.util.Arrays;

public class Prac {
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 5, 6, 1, 2, 3, 4, 5, 22};
        getMinMax(a);

        int[][] kub = new int[7][7];
        for (int[] ints : kub) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("  ");
        grave(kub);
        for (int[] ints : kub) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{2, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{10, 1, 2, 3, 4}));
        System.out.println(checkBalance(new int[]{10, 5, 5}));
        System.out.println(checkBalance(new int[]{10, 5, 6}));


    }

    private static boolean checkBalance(int[] a) {
        int sum = Arrays.stream(a).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = (sum / 2);
        for (int i = 0; i < a.length; i++) {
            sum -= a[i];
            if (sum == half) {
                return true;
            }
        }
        return false;
    }

    private static void grave(int[][] kub) {
        for (int i = 0; i < kub.length; i++) {
            for (int j = 0; j < kub[i].length; j++) {
                if (i == j || i + j == kub[i].length - 1) {
                    kub[i][j] = 1;
                }
            }
        }
    }

    public static void getMinMax(int[] a) {
        System.out.println("Min int from array: " + Arrays.stream(a).min().getAsInt());
        System.out.println("Max int from array: " + Arrays.stream(a).max().getAsInt());
    }

}