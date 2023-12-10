package Prac_Vs_ITVDN;

import java.util.Optional;
import java.util.stream.Stream;

public class MyOptional {
    public static void main(String[] args) {
        Optional<Integer> opt1 = Optional.empty();
        Optional<Integer> opt2 = Optional.of(10);
        Optional<Integer> opt3 = Optional.ofNullable(null);

        String str ;

//        Objects.isNull()

/*
        if (getString().isPresent()) {
            str = getString().get();
            str = getString().orElseGet(String::new);
            System.out.println(str);
        }
*/

//        str = getString().orElse(null);
        str = getString().orElse(null);
        Stream.of(str).forEach(System.out::println);

//        System.out.println(opt1);
//        System.out.println(opt2);
//        System.out.println(opt3);
    }

    public static Optional<String> getString() {
        if (false) {
            return Optional.of("Simple value");
        }
        return Optional.empty();
    }
}