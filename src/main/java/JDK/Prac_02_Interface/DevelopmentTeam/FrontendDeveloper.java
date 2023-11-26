package JDK.Prac_02_Interface.DevelopmentTeam;

public class FrontendDeveloper extends Developer implements FrontendAction {
    @Override
    public void front() {
        System.out.println("Frontend");

    }
}