package lesson3;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Timofei", 99, 100);

        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person);

        System.out.println(person.equals(person));
        System.out.println(person.hashCode());
    }
}
