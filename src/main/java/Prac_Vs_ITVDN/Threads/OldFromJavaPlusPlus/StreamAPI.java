package Prac_Vs_ITVDN.Threads.OldFromJavaPlusPlus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI extends Thread {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = Arrays.asList
                (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<String> result = integers.stream().
                filter(i -> i % 2 == 0)
                .skip(2)
                .limit(4)
                .map(i -> i * i)
                .sorted((a, b) -> b - a)
                .map(i -> "Number " + i)
                .collect(Collectors.toList());
        System.out.println(result);

        result.stream().sorted(String::compareTo).forEach(System.out::println);
    }
}