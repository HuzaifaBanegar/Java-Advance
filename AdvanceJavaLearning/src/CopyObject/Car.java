package CopyObject;

//SHALLOW COPY
public class Car {
    private String name;
    private double price;

    public  Car (String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Car: { name: "+ name + ", price: "+ price +"}";
    }


    public static void main(String[] args) {
        Car original = new Car("Volkswagon", 2550000.23);
        Car cloned = original;

        System.out.println("Before Modifying------ ");
        System.out.println("Original Car: "+ original);
        System.out.println("Cloned Car: "+ cloned);

        //Modify
        cloned.name = "Mercedes";
        cloned.price = 3000000.59;

        System.out.println("After Modifying------ ");
        System.out.println("Original Car: "+ original);
        System.out.println("Cloned Car: "+ cloned);
    }
}
