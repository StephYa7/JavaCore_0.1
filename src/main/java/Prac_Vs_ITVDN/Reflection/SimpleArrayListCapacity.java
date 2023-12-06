package Test.Reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yevhenii Tykhonov.
 */
public class SimpleArrayListCapacity {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(getCapacity(arrayList));
        for (int i = 0; i <= 39; i++) {
            arrayList.add(i);
        }
        System.out.println(getCapacity(arrayList));
//        System.out.println(getCapacity(arrayList));
//        arrayList.add(1);
//        arrayList.remove(0);
//        System.out.println(getCapacity(arrayList));

    }

    public static int getCapacity(ArrayList al) throws NoSuchFieldException, IllegalAccessException {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        System.out.println(Arrays.toString((Object[]) dataField.get(al)));
        return ((Object[]) dataField.get(al)).length;
    }
}