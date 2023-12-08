package Prac_Vs_ITVDN.Threads.OldFromJavaPlusPlus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableIDontKnowWhatItIsExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        var aa = executorService.submit(() -> {
            return 22;
        });
        System.out.println(aa);
    }
}