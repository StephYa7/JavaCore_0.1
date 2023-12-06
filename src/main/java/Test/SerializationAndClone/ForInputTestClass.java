package Test.SerializationAndClone;

import lombok.Data;

import java.io.Serializable;

@Data
public class ForInputTestClass implements Serializable, Cloneable {
    private int def;

    public ForInputTestClass(int def) {
        this.def = def;
    }

    public ForInputTestClass() {
    }

    @Override
    public String toString() {
        return
                " " + def + " ";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}