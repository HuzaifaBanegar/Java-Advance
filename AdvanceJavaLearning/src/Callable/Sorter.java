package Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable <List<Integer>> {

    private List<Integer> arrayToSort;

    private  ExecutorService executorService;

    public Sorter(List<Integer> array, ExecutorService executorService){
        arrayToSort = array;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        int mid = arrayToSort.size() / 2;

        List<Integer> rightArr = new ArrayList<>();
        List<Integer> leftArr = new ArrayList<>();

        for(int i=0; i< mid; i++){
            leftArr.add(arrayToSort.get(i));
        }

        for(int j=mid; j<arrayToSort.size(); j++){
            rightArr.add(arrayToSort.get(j));
        }

        Sorter leftSorter = new Sorter(leftArr, executorService);
        Sorter rightSorter = new Sorter(rightArr, executorService);

        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightSorter);

        //Merge Logic
        int i=0;
        int j=0;
        List<Integer> sortedArray = new ArrayList<>();

        // Blocking call only run when we need the data, till then i can run the business logic as i need which doesnt need futureArrays
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();


        while(i<leftSortedArray.size() && j<rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }else{
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i<leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j<rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return sortedArray;

    }
}
