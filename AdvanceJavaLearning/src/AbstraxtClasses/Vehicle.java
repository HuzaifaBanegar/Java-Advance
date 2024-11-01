package AbstraxtClasses;

abstract public class Vehicle {
    //For all the abstract methods it is necessary to provide implementation in the child class when created
    abstract void startEngine();

    void stopEngine(){
        System.out.println("Engine stopped");
    }

}
