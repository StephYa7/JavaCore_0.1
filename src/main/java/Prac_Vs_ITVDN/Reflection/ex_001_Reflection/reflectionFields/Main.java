package Test.Reflection.ex_001_Reflection.reflectionFields;


import java.lang.reflect.Field;

public class Main {
    private static final class CatFields {
        public String name;
        private int age;
        short ears;
        protected long chepuha;
    }

    public static void main(String[] args) {
        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";
        // Получаем класс, который описывает класс CatMethods
        Class cl = CatFields.class;

        System.out.println(s + "Public Reflection fields:");

        Field[] fields = cl.getFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println(s2 + "\tName: " + s1 + field.getName());
            System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
        }

        System.out.println(s + "All Modifiers Reflection fields:");

        fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            System.out.println(s2 + "\tName: " + s1 + field.getName());
            System.out.println(s2 + "\tType: " + s1 + fieldType.getName());
        }
    }
}