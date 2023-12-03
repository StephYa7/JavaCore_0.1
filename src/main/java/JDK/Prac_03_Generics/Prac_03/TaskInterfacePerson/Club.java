package JDK.Prac_03_Generics.Prac_03.TaskInterfacePerson;

public class Club<V extends Person> {
    Person[] persons;

    public Club(V... persons) {
        this.persons = persons;
    }
    public void allGetRest(){
        for (Person person : persons) {
         person.haveRest();
        }
    }
}