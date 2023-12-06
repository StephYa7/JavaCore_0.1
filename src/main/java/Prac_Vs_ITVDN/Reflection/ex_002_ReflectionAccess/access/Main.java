package Test.Reflection.ex_002_ReflectionAccess.access;

import java.lang.reflect.Field;

public class Main {
    private static final class Dog {
        private int age = 3;
    }

    public static void main(String[] args) {
        try {
            Class<?> cl = Dog.class;
            Dog dog = new Dog();
            // По имени name получаем класс Field
            Field field = cl.getDeclaredField("age");
            // true - снимаем модификатор до public, false - запрещаем
            field.setAccessible(true);
            // У класса Field, есть различные методы get
            System.out.println("Private field value: " + field.getInt(dog));
            field.setInt(dog, 10);
            System.out.println("New private field value: " + field.getInt(dog));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}