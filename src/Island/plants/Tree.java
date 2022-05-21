package Island.plants;

import Island.Entity;
import Island.EntityFactory;
import Island.Field;
import Island.Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree extends Plants {

    public static AtomicInteger count = new AtomicInteger(0);
    private double weight = 10.0;
    private int i;
    private int j;
    private final int countDaysFlow = 6;
    private AtomicInteger flowering = new AtomicInteger(2);
    private final int breedingPow = 1;
    private final int seedRate = 3;
    private static final int maxPopulation = 3000;
    public static HashSet<Entity> entities = new HashSet<>();

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
        count.incrementAndGet();

    }

    @Override
    public void run() {
        grow();
    }

    public void grow() {
        ingrow(flowering, i, j);
        this.flowering.decrementAndGet();
    }

    private void ingrow(AtomicInteger flowering, int y, int x) {

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
    }
}
