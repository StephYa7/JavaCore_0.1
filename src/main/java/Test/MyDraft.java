package Test;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyDraft {
    public static void main(String[] args) {
        String fileUrl = "https://cdn.iportal.ru/preview/news/articles/2d71a5f9f25cff20b35349377dfcc93b0bc9d888_666_444_c.jpg"; // Замените URL на нужный вам файл
        int numThreads = 1; // Количество потоков для загрузки

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();

            String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
            FileOutputStream outputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                executor.execute(new DownloadTask(outputStream, buffer, bytesRead));
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                // Ждем завершения всех потоков
            }

            outputStream.close();
            inputStream.close();

            System.out.println("Файл успешно загружен.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class DownloadTask implements Runnable {
        private final FileOutputStream outputStream;
        private final byte[] buffer;
        private final int bytesRead;

        public DownloadTask(FileOutputStream outputStream, byte[] buffer, int bytesRead) {
            this.outputStream = outputStream;
            this.buffer = buffer;
            this.bytesRead = bytesRead;
        }

        @Override
        public void run() {
            try {
                outputStream.write(buffer, 0, bytesRead);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}