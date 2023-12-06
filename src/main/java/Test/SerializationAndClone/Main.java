package Test.SerializationAndClone;

import java.io.*;

public class Main implements Externalizable {
    public static void main(String[] args) throws CloneNotSupportedException {
        ForInputTestClass f = new ForInputTestClass(5);
        TestClass test = new TestClass("2", 1, f);

        File file = new File("src/main/java/Test/SerializationAndClone/saveObject.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            oos.writeObject(test);

            TestClass newTest = (TestClass) ois.readObject();

            System.out.println(newTest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");

        TestClass forTestCloning = new TestClass("2", 1, f);
        TestClass cloningTest = (TestClass) forTestCloning.clone();
        System.out.println(forTestCloning);
        System.out.println(cloningTest);

        cloningTest.getInputTestClass().setDef(33);

        System.out.println(forTestCloning);
        System.out.println(cloningTest);

        TestClass gaga = new TestClass();

        TestClass gagaCopy1 = TestClass.deepCopy(gaga);
        TestClass gagaCopy2 = new TestClass(gaga);


    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

}