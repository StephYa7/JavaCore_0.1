package Prac_Vs_ITVDN.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Callable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        var aa = executorService.submit(() -> {
            return 22;
        });
    }
}