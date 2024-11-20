package Semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
class Consumer implements Runnable {
    private Queue<Object> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Consumer (Queue queue, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
           try{
               consumerSemaphore.acquire();
               if(!queue.isEmpty()){
                   System.out.println("Consuming....");
                    queue.remove();
               }
               producerSemaphore.release();

           }catch (InterruptedException e){
               throw new RuntimeException();
           }
        }

    }
}