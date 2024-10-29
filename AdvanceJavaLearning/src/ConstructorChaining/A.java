package ConstructorChaining;

public class A {
    public A(){
        System.out.println("Calling constructor A");
    }
}


class B extends A{
    B(){
        System.out.println("Calling constructor B");
    }
}

class Main{
    public static void main(String[] args) {
        // This will first call A and then B , which is called constructor chaining
        B b = new B();

    }
}
