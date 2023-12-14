package JDK.Prac_04_CollectionsAndServer.ClientServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String fileUrl = scanner.nextLine();
        String fileUrl = "https://cdn.iportal.ru/preview/news/articles/" +
                "3f2e689de714f2e679ac6bb732bc3c790d0fafd7_314_314_c.jpg";
        String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
//        int numThreads = scanner.nextInt();
        int numThreads = 2;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();
            FileOutputStream outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                int finalBytesRead = bytesRead;
                executor.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "");
                    try {
                        outputStream.write(buffer, 0, finalBytesRead);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            while (!executor.isTerminated()) {
                executor.shutdown();
            }
            outputStream.close();
            inputStream.close();
            System.out.println("Файл успешно загружен.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}