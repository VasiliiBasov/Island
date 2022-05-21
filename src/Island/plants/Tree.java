package Island.plants;

import Island.Entity;
import Island.Field;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree extends Plants {

    public static AtomicInteger count = new AtomicInteger(0);
    private double weight = 10.0;
    private int i;
    private int j;
    private final int countDaysFlow = 2;
    private AtomicInteger flowering = new AtomicInteger(1);
    private final int breedingPow = 2;
    private final int seedRate = 6;
    private static final int maxPopulation = 100;

    public Tree() {
        count.incrementAndGet();
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public double getWeight() {
        return weight;
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


    @Override
    public void eaten() {

    }

    @Override
    public void run() {
        grow(flowering, i, j);
    }


    public synchronized void grow(AtomicInteger flowering, int y, int x) {

        if (flowering.get() == 0) {
            int amount = ThreadLocalRandom.current().nextInt(this.breedingPow + 1);


            for (int i = 0; i < amount; i++) {
                int a = ThreadLocalRandom.current().nextInt(this.seedRate + 1);
                int b = ThreadLocalRandom.current().nextInt(4);
                int setY = y;
                int setX = x;

                if (b == 0) {
                    setY -= a;
                } else if (b == 1) {
                    setX -= a;
                } else if (b == 2) {
                    setY += a;
                } else {
                    setX += a;
                }

                if (setY >= Field.HEIGHT) setY = Field.HEIGHT - 1;
                if (setY < 0) setY = 0;
                if (setX >= Field.WIDTH) setX = Field.WIDTH - 1;
                if (setX < 0) setX = 0;

                if (Field.field[setY][setX].getCountTree() < getMaxPopulation()) {
                    this.flowering.set(this.countDaysFlow);
                    Tree tree = new Tree();
                    Field.field[setY][setX].add(tree);
                }


            }
        }
        this.flowering.decrementAndGet();
    }

}
