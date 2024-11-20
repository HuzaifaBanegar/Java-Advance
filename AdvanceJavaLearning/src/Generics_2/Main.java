package Generics_2;

public class Main {
    public static void main(String[] args) {
        Implementor<Integer, String> implementor = new Implementor<>(100, "Hello");
        System.out.println("Value of A is: "+implementor.getValueofA());
        System.out.println("Value of B is: "+implementor.getValueofB());

    }
}
