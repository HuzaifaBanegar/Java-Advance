package Polimorphism;

public class Animal {
    public static String name = "Animal";
    public void speak(){
        System.out.println("Animal is making sound");
    }

    public void walk(String animal_name){
        System.out.println( animal_name+ " is walking");
    }

    //Method overloading ----------------------------
    public static void walk(){
        System.out.println( name+ " is walking");
    }
}
