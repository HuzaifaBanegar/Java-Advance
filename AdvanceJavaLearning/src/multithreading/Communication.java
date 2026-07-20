package multithreading;


class Producer2 implements Runnable {
    StringBuffer sb;

    Producer2() {
        sb = new StringBuffer();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (sb) {
                try {
                    sb.append(i);
                    System.out.println("Produced: " + sb.toString() + "");
                    Thread.sleep(1000);
                    sb.notify();
                } catch (InterruptedException e){}
            }

        }

    }
}

class Consumer2 implements Runnable{
    Producer2 p;
    Consumer2(Producer2 p){
        this.p = p;
    }
    @Override
    public void run() {
        synchronized (p.sb){
            try{
                System.out.println("Consumer is waiting for Producer to produce");
                p.sb.wait();
            }catch (InterruptedException e){}
            System.out.println("Consumed: "+p.sb.toString()+"");
        }
    }

}


public class Communication {
    public static void main(String[] args) {
        Producer2 producer = new Producer2();
        Consumer2 consumer = new Consumer2(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t2.start();
        t1.start();
    }
}
