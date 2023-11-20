package lesson2;

import java.util.ArrayList;
import java.util.List;

public class BigO {
    public static void main(String[] args) {
        foo();
    }

    public static void test(int... arr) {
        int n = arr.length;

        for (int i = 1; i < n; i *= 2) /*O(logn)*/ {
            System.out.println(arr[i]);
        }
    }

    public static void foo() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
            }
        }

        System.out.println(arrayList.size());
    }


    public static void bar() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            }
        }
    }

    public static void baz() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList.add(i * j);
            }
        }
    }


    public static int fib(int n) {
        if ((n == 1) || (n == 2)) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
