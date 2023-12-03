package JDK.Prac_03_Generics.Prac_03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

@Data
@AllArgsConstructor

public class ThreeParameters<T extends Comparable, V extends InputStream & DataInput, K extends Number> {
    private T name;
    private V value;
    private K key;

    public void printAllClass() {
        System.out.println(name.getClass() + " : " + value.getClass() + " : " + key.getClass());
    }

    public static void main(String[] args) {
        ThreeParameters<Comparable, DataInputStream, Number> a = new ThreeParameters(
                "name",
                new DataInputStream(InputStream.nullInputStream()),
                2
        );
        a.printAllClass();
    }
}