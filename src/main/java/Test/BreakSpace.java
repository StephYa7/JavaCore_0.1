package Test;

import java.util.List;
import java.util.stream.Collectors;

public class BreakSpace {
    public static void main(String[] args) {
        String a1 = "ab#c", a2 = "ad#c", // true
                b1 = "ab##", b2 = "c#d#", // true
                c1 = "#r3", c2 = "#rr";   // false

        System.out.println(check(a1, a2));
        System.out.println(check(b1, b2));
        System.out.println(check(c1, c2));
    }


    public static boolean check(String a, String b) {
        List<Character> listA = a.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> listB = b.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        while (listA.contains('#')) {
            for (int i = 0; i < listA.size(); i++) {
                if (listA.get(i) == '#') {
                    listA.remove(i);
                    if (i > 0) {
                        listA.remove(i - 1);
                    }
                }
            }
        }
        while (listB.contains('#')) {
            for (int i = 0; i < listB.size(); i++) {
                if (listB.get(i) == '#') {
                    listB.remove(i);
                    if (i > 0) {
                        listB.remove(i - 1);
                    }
                }
            }
        }
        String result = listA.stream().map(String::valueOf).collect(Collectors.joining());
        String result2 = listB.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(result);
        System.out.println(result2);
        return result2.equals(result);
    }
}