package Callable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(3,4,2,1,5,8,7,6);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(list, executorService );


        Future<List<Integer>> sortedArray = executorService.submit(sorter);

        System.out.println(sortedArray.get());
        executorService.shutdown();



    }
}
