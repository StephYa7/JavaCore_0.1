package Test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyDraft {

    public static void main(String[] args) {
        var wtf = "r̶".toCharArray();
        for (char c : wtf) {
            System.out.println((int)c);
        }
        System.out.println("--------------------------------");

        System.out.println("r̶".getBytes() + "  это");
        List<String> a1 = new ArrayList<>();
        List<String> a2 = new ArrayList<>();
        List<String> a3 = new ArrayList<>();
        List<Integer> a4 = new ArrayList<>();

        a1.add("123");
        a1.add("12");
        a2.add("321");
        a3.add("132");
        a3.add("132");


        List<String>[] all = new List[]{a1, a2, a3, a4};

        all[1].add("1");

        System.out.println(Arrays.toString(all));


        Pair pair = new Pair("321", "12");
        Pair pair2 = new Pair(321, "12");


        Pair<String, String>[] array = new Pair[3];

        Pair[] pairs = new Pair[3];

        pairs[1] = pair2;

        System.out.println(Arrays.toString(pairs));

        var a = makeHeapPollution();
        System.out.println(a);

        List numbers = new ArrayList<Integer>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);


        try {
            List<String> strings = numbers;
            StringBuffer buffer = new StringBuffer();
            System.out.println(strings);
//            System.out.println("che 1");
            for (var string : strings) {
                buffer.append(string);
                System.out.println(buffer);
//                System.out.println("che 2");
            }
        } catch (Exception e) {
            System.out.println("What?");
        }
//        System.out.println("che 3");


    }

    static List<String> makeHeapPollution() {
        List numbers = new ArrayList<Number>();
        numbers.add(1);
        List<String> strings = numbers;
        strings.add("");
        return strings;
    }


    @Data
    @AllArgsConstructor
    static class Pair<T, E> {
        public T t;
        public E e;


    }

}