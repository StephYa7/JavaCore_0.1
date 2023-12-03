package JDK.Prac_03_Generics.Prac_03.TaskInterfacePerson;

public class Workplace<V extends Person> {
    Person[] persons;

    public Workplace(V... persons) {
        this.persons = persons;
    }
    public void allDoWork(){
        for (Person person : persons) {
            person.doWork();
        }
    }
}