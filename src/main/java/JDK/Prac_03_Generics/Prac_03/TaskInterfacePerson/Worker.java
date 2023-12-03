package JDK.Prac_03_Generics.Prac_03.TaskInterfacePerson;

public class Worker implements Person {
    @Override
    public void doWork() {
        System.out.println("work");

    }

    @Override
    public void haveRest() {

    }
}