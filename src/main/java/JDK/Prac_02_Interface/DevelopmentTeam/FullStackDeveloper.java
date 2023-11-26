package JDK.Prac_02_Interface.DevelopmentTeam;

public class FullStackDeveloper extends Developer implements FrontendAction, BackendAction {
    @Override
    public void back() {
        System.out.println("BackendFromFullStack");

    }

    @Override
    public void front() {
        System.out.println("FrontendFromFullStack");

    }
}