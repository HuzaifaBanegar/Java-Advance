package Polimorphism;

public class Dog extends Animal {
    //Method overriding----------------------------
    @Override
    public void speak(){
        System.out.println("Dog is barking");
    }
}
