package Island.plants;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree extends Plants {

    public static AtomicInteger count = new AtomicInteger(0);
    private static final int maxPopulation = 200;

    public Tree() {

        setWeight(ThreadLocalRandom.current().nextDouble(0.1, 70.0));
        setBreedingPow(4);
        setFlowering(new AtomicInteger(2));
        setSeedRate(6);
        setCountDaysFlow(4);

        count.incrementAndGet();
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

    @Override
    public synchronized void eaten() {
        if (!isDead)
            count.decrementAndGet();
        isDead = true;
        Field.field[i][j].remove(this);
    }

    @Override
    public void run() {
        super.grow(maxPopulation);
    }
}
