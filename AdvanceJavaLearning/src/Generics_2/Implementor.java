package Generics_2;

public class Implementor<A, B> implements Pair<A, B>{
    private A a;
    private B b;
    public Implementor(A a, B b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public A getValueofA() {
        return a;
    }

    @Override
    public B getValueofB() {
        return b;
    }
}
