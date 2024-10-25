package Generics;


public class Main {
    public static void main(String[] args) {
        // Generics
        Pair<Integer, String> pair1 = new Pair<>(2, "Hello");

        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());

        Pair<Double, Boolean> pair2 = new Pair<>(3.0, true);

        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());




    }
}

