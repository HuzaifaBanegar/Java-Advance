package LambdasAndStreams.streams;

import ConstructorChaining.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {
    // Intermediate method: Do not end the stream. You can chain the operation
    // Terminal methods: Ends the stream. You cannot chain this methods
    // Streams does not affect the original data
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(22);
        list.add(31);
        list.add(10);
        list.add(14);
        list.add(59);
        System.out.println("Printing element from list:");
        example1(list);
        System.out.println("Printing square of elements from list:");
        example2(list);
        System.out.println("Printing square of even numbers from list:");
        example3(list);
        System.out.println("Printing sum of all the integers list:");
        example4(list);
        System.out.println("Printing sorted list:");
        example5(list);
        System.out.println("Finding first square element from the list:");
        example6(list);
        System.out.println("Print elements in list on different threads:");
        example7(list);
        System.out.println("Check if all elements are even in the list:");
        example8(list);


        //You are given a list of strings having different fruit names. You need to filter out the names of the fruits whose name starts from the character A.
        //
        //Use streams to execute the operations and return a List of String containing the fruit names whose name starts with A.
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Orange");
        fruitList.add("Pear");
        fruitList.add("Avocado");
        System.out.println("Print All Fruits name starting with letter A:");
        example9(fruitList);


        //You are given a list of integers, and you need to use streams and lambdas to return all the distinct numbers (distinct()) that are present in the given list.
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(3);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(5);
        System.out.println("Print All unique elements from list:");
        example10(list2);
    }

    // For each - returns void (Terminal methods)
    public static void example1(List<Integer> list) {
        list.stream().forEach((ele)->{
            System.out.print(ele+" ");
        });
        System.out.println();

    }

    //Map - return Streams (Intermediate method)
    public static void example2(List<Integer> list) {
        list.stream().map((ele)->{
           return  ele*ele;
        }).forEach((el)->{
            System.out.print(el+" ");
        });
        System.out.println();
    }

    public static void example3(List<Integer> list) {
        list.stream().filter((el)->{
            return el % 2 == 0;
        }).map((el)->{
            return el*el;
        }).forEach((el)->{
            System.out.print(el+ " ");
        });
        System.out.println();
    }

    public static void example4(List<Integer> list) {
        int finalsum = list.stream().reduce(0, (ac, el)->{
            return ac+el;
        });

        System.out.println(finalsum);
    }

    public static void example5(List<Integer> list) {
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public static void example6(List<Integer> list) {
        //Lazy evaluation - Stream does not go beyond the first integer when it seez that we are only interested in first element
        Optional<Integer> optionalI = list.stream().map((el)-> el*el).findFirst();
        System.out.println(optionalI.get());
    }

    public static void example7(List<Integer> list) {
        list.parallelStream().forEach((el)-> System.out.println(el+" is printed by thread: "+Thread.currentThread().getName()));
    }

    public static void example8(List<Integer> list) {
        Boolean ans = list.stream().allMatch((el)->{
            return el % 2 ==0;
        });

        System.out.println(ans);
    }

    public static void example9(List<String> fruitList) {
        List<String> fruitNameStartsWithA = fruitList.stream().filter((fruit)->{
            return fruit.startsWith("A");
        }).toList();

        System.out.println(fruitNameStartsWithA);
    }

    public static void example10(List<Integer> list) {
        Set<Integer> uniqueList = list.stream().collect(Collectors.toSet());
        System.out.println(uniqueList);

//       Another method -  numbers.stream().distinct().toList()

    }

}
