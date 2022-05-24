package Island.plants;

import java.util.concurrent.atomic.AtomicInteger;

public class Tree extends Plants {

    public static AtomicInteger count = new AtomicInteger(0);
    private static final int maxPopulation = 200;

    public Tree() {

        setWeight(1.0);
        setBreedingPow(2);
        setFlowering(new AtomicInteger(2));
        setSeedRate(6);
        setCountDaysFlow(4);

        count.incrementAndGet();
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

    @Override
    public void eaten() {

    }

    @Override
    public void run() {
        super.grow(maxPopulation);
    }
}
