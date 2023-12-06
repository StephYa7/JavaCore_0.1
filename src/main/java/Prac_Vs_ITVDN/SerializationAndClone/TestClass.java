package Prac_Vs_ITVDN.SerializationAndClone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TestClass implements Serializable, Cloneable {

    private static final long serialVersionUID = 8308977719846644360L;

    private String stringProperty;
    private int intProperty;
    transient private ForInputTestClass inputTestClass;

    public TestClass(TestClass other) {
        this(other.stringProperty, other.intProperty, other.inputTestClass);
    }

    public static TestClass deepCopy(TestClass other) {

        return new TestClass(other.stringProperty, other.intProperty, other.inputTestClass);
    }

    public TestClass() {
    }

    ;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}