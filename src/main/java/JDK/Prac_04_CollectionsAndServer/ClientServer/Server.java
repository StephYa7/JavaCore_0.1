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
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String request = phone.readLine();
                    DecimalFormat decimalFormat = new DecimalFormat("+#;-#");
                    int temperature = (int) (Math.random() * 70 - 40);
                    String response = String.format("In %s %s°C ", request, decimalFormat.format(temperature));
                    try {
                        Thread.sleep(3000);
                        phone.writeLine(response);
                        System.out.println(response);
                        phone.close();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}