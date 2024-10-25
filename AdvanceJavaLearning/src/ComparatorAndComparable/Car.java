package ComparatorAndComparable;

//Comparable is used to define a "natural ordering" for a class.
//It's implemented by the class whose objects are being compared.
//It has a single method: compareTo(T o).
//Used when you want to define a default comparison method for objects of a class.
//The class itself knows how it should be ordered.

public class Car implements  Comparable <Car>{
    private int topSpeed;

    private String name;
    private double price;

    Car(int topSpeed, String name, double price){
        this.price= price;
        this.name = name;
        this.topSpeed = topSpeed;
    }

    @Override
    public int compareTo ( Car car2 ){
        return Integer.compare(this.topSpeed, car2.topSpeed);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Car: {" +
                "name='" + name + '\'' +
                ", topSpeed=" + topSpeed +
                ", price=" + price +
                '}' + ", ";
    }

    public double getPrice() {
        return price;
    }
}
