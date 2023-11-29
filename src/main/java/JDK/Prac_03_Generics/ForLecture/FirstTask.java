package JDK.Prac_03_Generics.ForLecture;

public class FirstTask {

    public <T> void swapElement(T[] array, int firstIndex, int secondIndex) {
        if ((array == null) || (firstIndex > array.length) || (secondIndex > array.length)
                || (secondIndex < 0) || (firstIndex < 0) || (firstIndex == secondIndex)) {
            return;
        }
        T buff = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buff;

    }
}