package DoughnutFactoryProblem.UsingAtomicInteger;



public class AtomicConsumer {
    private AtomicDoughnutFactory doughnutFactory;
    public AtomicConsumer(AtomicDoughnutFactory doughnutFactory) {
        this.doughnutFactory = doughnutFactory;
    }

    synchronized public void consume(int numberOfDoughnuts) {
        System.out.println("Doughnut number "+doughnutFactory.getDoughnutCount()+" is being consumed by consumer on Thread: " + Thread.currentThread().getName());
        doughnutFactory.consumeDoughnut(numberOfDoughnuts);
        System.out.println("Doughnuts left:"+ doughnutFactory.getDoughnutCount());
    }
}
