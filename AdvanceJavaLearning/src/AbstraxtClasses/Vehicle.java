package AbstraxtClasses;

abstract public class Vehicle {
    //For all the abstract methods it is necessary to provide implementation in the child class when created
    abstract void startEngine();

    // Abstract class can have its own members
    private boolean created;

    //Abstract method can have constrctor
    public Vehicle(){
        System.out.println("A vehicle is being constructed");
        created = true;
        System.out.println("Is Vehicle constructed? "+ created);
    }

    //It can also have complete methods
    void stopEngine(){
        System.out.println("Engine stopped");
    }

}
