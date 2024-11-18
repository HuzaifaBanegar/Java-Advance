package DoughnutFactoryProblem.UsingInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class DougnutFactory {
    private AtomicInteger dougnutsCounter;
    public DougnutFactory(int num){
        dougnutsCounter = new AtomicInteger(num);
    }

    public int getDoughnutCounter(){
        return dougnutsCounter.get();
    }

    public void setDougnutsCounter(int value) {
        this.dougnutsCounter = new AtomicInteger(value) ;
    }
}
