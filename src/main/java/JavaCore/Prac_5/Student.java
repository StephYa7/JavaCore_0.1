package JavaCore.Prac_5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
1 Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
        Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5,
         отсортированных по убыванию среднего балла.
        В решении не использовать циклы! Только StreamAPI
*/
@Data
@AllArgsConstructor
class Student {
    static String[] specialityList = {"Информатика", "Математика", "Астрономия"};
    private String name;
    private List<Double> grades;
    private String specialty;

    public static void main(String[] args) {
        List<Student> students = randomStudent();
        List<Student> result = students.stream()
                .filter(s -> s.getSpecialty().equals(specialityList[0]))
                .filter(s -> s.getAverageGrade() > 4.5)
                .sorted(Comparator.comparingDouble(s -> -s.getAverageGrade()))
                .limit(5)
                .collect(Collectors.toList());

        result.stream()
                .map(a -> a.getName() + " " + a.getAverageGrade())
                .forEach(System.out::println);
    }

    public static List<Student> randomStudent() {
        List<Student> result = IntStream.range(0, 100)
                .mapToObj(i -> new Student(String.valueOf((char) (i + 65))
                        , randomGrade()
                        , specialityList[(int) (Math.random() * 3)]))
                .collect(Collectors.toList());
        return result;
    }

    public double getAverageGrade() {
        double result = Math.round(grades.stream()
                .reduce((a, b) -> a + b)
                .get() / grades.size() * 100.0) / 100.0;
        return result;
    }

    public static List<Double> randomGrade() {
        List<Double> result = new Random()
                .doubles(3, 5.5)
                .limit(10)
                .map(i -> Math.round(i * 10.0) / 10.0)
                .boxed()
                .collect(Collectors.toList());
        return result;
    }
}