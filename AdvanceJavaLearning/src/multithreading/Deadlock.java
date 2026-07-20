package multithreading;


class BookTicket extends Thread{
    Object train, compartmemnt;
    BookTicket(Object train, Object compartmemnt){
        this.train = train;
        this.compartmemnt = compartmemnt;
    }

    @Override
    public void run(){
        synchronized (train){
            System.out.println("Book ticket for train has aquired Lock");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){}
            System.out.println("BookTicket is now trying to secure Compartment");
            synchronized (compartmemnt){
                System.out.println("BookTicket has secured Compartment");
            }
        }

    }

}

class Compartment extends Thread{
    Object train, compartment;
    Compartment(Object train, Object compartmemnt){
        this.train= train;
        this.compartment = compartmemnt;
    }

    @Override
    public void run(){
        synchronized (compartment){
            System.out.println("CancelTicket has aquired Lock in compartment");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){}
            System.out.println("CancelTicket is now trying to secure Train");
            synchronized (train){
                System.out.println("CancelTicket has secured Train");
            }
        }

        // BELOW IS THE LOGIC TO AVOID DEADLOCK
//        synchronized (train){
//            System.out.println("CancelTicket has aquired Lock in train");
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException ex){}
//            System.out.println("CancelTicket is now trying to secure compartment");
//            synchronized (compartment){
//                System.out.println("CancelTicket has secured compartment");
//            }
//        }
    }

}

public class Deadlock {
    public static void main(String[] args) {
        Object train = new Object();
        Object compartmemnt = new Object();
        BookTicket bookTicket = new BookTicket(train, compartmemnt);
        Compartment compartment = new Compartment(train, compartmemnt);
        Thread t1 = new Thread(bookTicket);
        Thread t2 = new Thread(compartment);
        t1.start();
        t2.start();
    }
}
