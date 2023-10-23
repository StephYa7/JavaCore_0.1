package lesson3;

import lombok.*;

import java.util.Objects;

@Data // + @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private int salary;

    public Person(int age) {
        this.age = age;
    }
}
