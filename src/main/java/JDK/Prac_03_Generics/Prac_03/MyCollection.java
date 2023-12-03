package JDK.Prac_03_Generics.Prac_03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<V> implements Iterable<V> {
    private Object[] array;
    private static final int INITIAL_CAPACITY = 10;

    private int size;
    private int index;

    public MyCollection() {
        this.array = new Object[INITIAL_CAPACITY];
    }

    public MyCollection(int capacity) {
        this.array = new Object[capacity];
        size = 0;
    }

    public int size() {
        return this.size;
    }


    public V get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (V) this.array[index];
    }

    public void set(int index, V value) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;


    }

    public void add(V value) {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (size * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size);
            this.array = newArray;
        }
        this.array[size] = value;
        size++;
    }


    public V removeValue() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Object bufferValue = array[size - 1];
        array[size - 1] = null;
        size--;
        return (V) bufferValue;
    }


    @Override
    public String toString() {
        return "MyCollection{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        MyCollection<Number> a2 = new MyCollection();
        a2.add(11);
        a2.add(2.3);
        a2.add(4444444443333L);
        a2.set(2, 233.3f);
        System.out.println(a2.removeValue());
        System.out.println(a2.removeValue());
        System.out.println(a2);
        System.out.println(a2.size());
        System.out.println(a2.getClass());
        a2.add(11);
        a2.add(11);
        a2.add(11);
        a2.add(11);
        a2.add(11);
        for (Number number : a2) {
            System.out.println(number);
        }


    }

/*    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public V next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return (V) array[index++];
    }*/

    @Override           // Вариант реализации вложенным классом
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int index = 0;

            @Override
            public boolean hasNext() {

                return index < array.length;
            }

            @Override
            public V next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return (V) array[index++];
            }
        };
    }


/*    @Override
    public Iterator<V> iterator() {
        return new MyArrayIterator(array);
    }*/
}

class MyArrayIterator<V> implements Iterator<V> {
    int index;
    V[] arrayIterator;

    public MyArrayIterator(V[] array) {
        this.index = 0;
        arrayIterator = array;
    }

    @Override
    public boolean hasNext() {

        return index < arrayIterator.length;
    }

    @Override
    public V next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return arrayIterator[index++];
    }
}