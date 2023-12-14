package JDK.Prac_04_CollectionsAndServer.ClientServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class SoloThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String fileUrl = scanner.nextLine();
        String fileUrl = "https://cdn.iportal.ru/preview/news/articles/" +
                "3f2e689de714f2e679ac6bb732bc3c790d0fafd7_314_314_c.jpg";
//        String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        String fileName = "12345.jpg";
        try {
            URL url = new URL(fileUrl);
            try (InputStream inputStream = url.openStream();
                 FileOutputStream outputStream = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}