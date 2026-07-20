package multithreading;


// Thread using extends keyword and Thread using runnable interface
public class Thread1 extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is running thread wit extends keyword");
    }
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        t1.start();

        Thread t2 = new Thread(()-> System.out.println(Thread.currentThread().getName()+" is a runnable thread with Lambda function"));
        t2.start();


        System.out.println("Main thread: " + Thread.currentThread().getName());


    }

}

//class RunnableThread implements Runnable{
//    public void run(){
//        System.out.println("RunnableThread is running");
//    }
//}
