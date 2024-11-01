package Interfaces;

public interface Animal {
    void eat();
    void sleep();
    void makeSound();

    //Cannot be called by instantiated object by the class that implements interface Animal.
    //Should directly be called as Animal.play()
    public static void play(){
        System.out.println("Animal is playing");
    }
}
