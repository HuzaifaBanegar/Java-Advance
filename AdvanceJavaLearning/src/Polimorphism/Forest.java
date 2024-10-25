package Polimorphism;

public class Forest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();
        for(Animal a : animals){
            a.speak();
        }

        Animal dog = new Dog();
        dog.walk("Dog");

        Animal cat = new Cat();
        cat.walk();
    }
}
