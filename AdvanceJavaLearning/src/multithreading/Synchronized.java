package multithreading;

class Counter{
    public int count = 0;
}

class Adder implements Runnable{
    private Counter counter;

    Adder(Counter counter){
        this.counter = counter;

    }
    @Override
    public void run(){
        for(int i=1; i<=1000; i++){
                synchronized (counter){
                    counter.count += i;
                }



        }
    }
}

class Subtractor implements Runnable{
    private Counter counter;

    Subtractor(Counter counter){
        this.counter = counter;

    }
    @Override
    public void run(){
        for(int i=1; i<=1000; i++){
            synchronized (counter) {
                counter.count -= i;
            }


        }
    }
}
public class Synchronized  {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count value is => "+ counter.count);

    }
}
