package JDK.Prac_04_Collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskFromPracPresentation {

    public static void main(String[] args) {
        List<String> surnames = new ArrayList<>();
        IntStream
                .range(0, 10)
                .forEach(i -> surnames.add(MakeRandomString.makeRandomSequenceString(3, 12)));

        System.out.println(surnames);
        surnames.stream()
                .sorted()
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        surnames.stream()
                .sorted(Comparator.comparingInt(String::length)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        surnames.stream()
                .sorted((a, b) -> b.length() - a.length())
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        Collections.reverse(surnames);

        System.out.println("--------------------------------");

        List<String> names = new ArrayList<>();
        IntStream
                .range(0, 10)
                .forEach(i -> names.add(MakeRandomString.makeRandomSequenceString(2, 6)));
        names.add(names.get(0));
        names.add(names.get(1));
        System.out.println(names.size());
        Set<String> namesSet = names.stream()
                .collect(Collectors.toSet());
        System.out.println(namesSet.size());
        List<String> namesSet2 = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(namesSet2.size());
        System.out.println(names);
        var minName = names.stream()
                .min(String::compareTo);
        System.out.println(minName);
        var longestName = names.stream()
                .max(Comparator.comparing(String::length));
        System.out.println(longestName);
        List<String> namesWithoutWordA = names.stream()
                .filter(a -> !a.contains("A"))
                .collect(Collectors.toList());
        System.out.println(namesWithoutWordA.size());

        System.out.println("--------------------------------");

        Map<String, String> phoneBook = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Long phone = (long) (Math.random() * 1000000000L) + 89000000000L;
            String name = MakeRandomString.makeRandomSequenceString(2, 6);
            System.out.println(phone + " " + name);
            phoneBook.put(phone.toString(), name);
        }
        System.out.println(phoneBook.keySet().stream()
//                .min((a, b) -> (Long.compare(Long.parseLong(a),Long.parseLong(b))))
                .min(Comparator.comparingLong(Long::parseLong))
                .get() + " minimal phone number");
        System.out.println(phoneBook.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey() + " max name value");
    }
}