package JDK.Prac_02_Interface.DevelopmentTeam;

public class Main {
    public static void main(String[] args) {
        Developer[] developers = new Developer[3];
        developers[0] = new BackendDeveloper();
        developers[1] = new FrontendDeveloper();
        developers[2] = new FullStackDeveloper();

        for (Developer dev : developers) {
            if (dev instanceof FrontendAction) {
                ((FrontendAction) dev).front();
            }
        }
    }
}