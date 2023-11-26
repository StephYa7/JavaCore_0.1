package JDK.Prac_02_Interface.DevelopmentTeam;

public class BackendDeveloper extends Developer implements BackendAction {
    @Override
    public void back() {
        System.out.println("Backend");

    }
}