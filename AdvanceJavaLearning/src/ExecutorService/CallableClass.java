package ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClass {
    // A callable class returns a value and it is stored in class named Future
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future futureValue =  executorService.submit(new Callable<Object>() {
            public Integer call() throws Exception {
                return 10+20;
            }
        });

        try {
            System.out.println(futureValue.get());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        executorService.shutdown();
    }
}
