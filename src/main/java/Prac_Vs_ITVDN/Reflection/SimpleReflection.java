package Test.Reflection;

/**
 * Created by Yevhenii Tykhonov.
 */
public class SimpleReflection {
    public static void main(String[] args) throws ClassNotFoundException {
//         1. getClass()
        SimpleReflection simpleReflection = new SimpleReflection();
        Class cl = simpleReflection.getClass();

        int[] arr = new int[10];
        Class cl2 = arr.getClass();
        Class cl3 = "world".getClass();
        Class cl4 = Integer.valueOf(5).getClass();
        System.out.println(cl);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);

////         2. String.class
//        Class<?> cl = SimpleReflection.class;
//        Class<?> cl2 = int[].class;
//
////         3. Class.forName()
//        Class<?> cl = Class.forName("java.lang.String");
//        System.out.println(cl);
//
//        Class<?> cl2 = Class.forName("[I");
//        Class<?> cl2 = Class.forName("[D");
//        System.out.println(cl2);
//
////         4.
//        Class<?> cl = Integer.class.getSuperclass();
//        System.out.println(cl);
//
//        Class<?> cl2 = Map.Entry.class.getEnclosingClass();
//        System.out.println(cl2);
    }
}