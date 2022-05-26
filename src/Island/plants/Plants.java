package Island.plants;

import Island.Entity;
import Island.Field;
import Island.interfaces.Growable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Plants extends Entity implements Growable {

    public int countDaysFlow;
    public AtomicInteger flowering;
    public int breedingPow;
    public int seedRate;

    public synchronized void grow(int maxPopulation) {

        if (flowering.get() == 0) {
            int amount = ThreadLocalRandom.current().nextInt(this.breedingPow + 1);


            for (int x = 0; x < amount; x++) {
                int a = ThreadLocalRandom.current().nextInt(seedRate + 1);
                int b = ThreadLocalRandom.current().nextInt(4);
                int setY = i;
                int setX = j;

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

                if (Field.field[setY][setX].getCountTree() < maxPopulation) {
                    flowering.set(countDaysFlow);
                    Tree tree = new Tree();
                    Field.field[setY][setX].add(tree);
                }


            }
        }
        this.flowering.decrementAndGet();
    }

    public int getCountDaysFlow() {
        return countDaysFlow;
    }

    public void setCountDaysFlow(int countDaysFlow) {
        this.countDaysFlow = countDaysFlow;
    }

    public AtomicInteger getFlowering() {
        return flowering;
    }

    public void setFlowering(AtomicInteger flowering) {
        this.flowering = flowering;
    }

    public int getBreedingPow() {
        return breedingPow;
    }

    public void setBreedingPow(int breedingPow) {
        this.breedingPow = breedingPow;
    }

    public int getSeedRate() {
        return seedRate;
    }

    public void setSeedRate(int seedRate) {
        this.seedRate = seedRate;
    }
}
