package JDK.Prac_03_Generics.Prac_03.TaskInterfacePerson;

public class Main {
    public static void main(String[] args) {
        Workplace workplace = new Workplace(new Worker(), new Worker(), new Slacker());
        Club club = new Club(new Worker(), new Worker(), new Slacker());

        System.out.println("In Office");
        workplace.allDoWork();

        System.out.println("In Club");
        club.allGetRest();
    }
}