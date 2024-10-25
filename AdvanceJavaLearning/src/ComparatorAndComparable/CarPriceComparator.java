package ComparatorAndComparable;

import java.util.Comparator;


//Comparator is used to define custom ordering for a class.
//It's a separate class that implements the comparison logic.
//It has a method: compare(T o1, T o2).
//Used when you want multiple ways to compare objects or when you can't modify the original class.
//Allows for external definition of comparison logic.
public class CarPriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2){
        return Double.compare(car2.getPrice(), car1.getPrice());
    }
}
