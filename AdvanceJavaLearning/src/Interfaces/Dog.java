package Interfaces;

public class Dog implements Animal {
    //It is mandatory to provide implementation for all the methods without it there will be an error
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }


    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        Animal.play();

    }
}
