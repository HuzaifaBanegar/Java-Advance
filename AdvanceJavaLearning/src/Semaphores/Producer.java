package Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue <Object> queue;
    private Semaphore producer;
    private Semaphore consumer;

    public Producer(Queue queue, Semaphore producer, Semaphore consumer){
        this.queue = queue;
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while(true){
            try{
                producer.acquire();
                if(queue.size()<6){
                    System.out.println("Producing");
                    queue.add(new Object());
                }
                consumer.release();
            }catch(InterruptedException e){
                throw  new RuntimeException();
            }
        }
    }
}
