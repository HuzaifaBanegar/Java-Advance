package Synchronization;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        c.val = 0;
        Adder a = new Adder(c);
        Subtractor subtractor = new Subtractor(c);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.val);


    }
}
