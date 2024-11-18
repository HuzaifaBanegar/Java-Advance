package DoughnutFactoryProblem.UsingAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDoughnutFactory {
    private AtomicInteger douhgnutCounter;
    public AtomicDoughnutFactory(int num) {
        douhgnutCounter = new AtomicInteger(num);
    }

    public int getDoughnutCount() {
        return douhgnutCounter.get();
    }

    public int consumeDoughnut(int numberOfDoughnuts) {
        return douhgnutCounter.addAndGet(-numberOfDoughnuts);
    }
}
