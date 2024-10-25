package ComparatorAndComparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(350, "Honda civic", 2000000.12));
        cars.add(new Car(450, "Mercedes Benz", 3500000.12));
        cars.add(new Car(400, "BMW", 2950000.12));
        cars.add(new Car(250, "MG Hector", 3040000.00));

        System.out.println("Before Sorting:");

        for(Car car: cars){
            System.out.print( car + "");
        }


        System.out.println();

        Collections.sort(cars);

        System.out.println("After natural Sorting:");
        for(Car car: cars){
            System.out.print( car + "");
        }


        System.out.println("After comparator sorting");
        Collections.sort(cars, new CarPriceComparator());
        for(Car car: cars){
            System.out.print( car + "");
        }


    }
}

