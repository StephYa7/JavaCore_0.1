package JDK.Prac_04_CollectionsAndServer.ClientServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.DecimalFormat;

public class Server {
    public static void main(String[] args) {

        try (
                ServerSocket server = new ServerSocket(8000);
        ) {
            System.out.println("Server started");
            while (true)
                try (Phone phone = new Phone(server);
                ) {

                    String request = phone.readLine();
                    DecimalFormat decimalFormat = new DecimalFormat("+#;-#");
                    int temperature = (int) (Math.random() * 70 - 40);
                    String response = String.format("In %s %s°C ", request, decimalFormat.format(temperature));
                    System.out.println(response);
                    phone.writeLine(response);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}