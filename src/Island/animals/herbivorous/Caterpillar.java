package Island.animals.herbivorous;

import Island.Field;
import Island.plants.Tree;

import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Caterpillar extends Herbivorous {

    public static AtomicInteger count = new AtomicInteger(0);
    private static final int maxPopulation = 1000;

    public static final LinkedHashMap<Class<?>, Integer> chanceToEat = new LinkedHashMap<>();

    static {
        chanceToEat.put(Tree.class, 100);
    }

    public Caterpillar() {

        setWeight(0.01);
        setSpeed(1);
        setAmountOfFood(0.0025);
        setAmountOfFoodNow(0.0025);
        setSurvivable(2);

        count.incrementAndGet();
    }

    @Override
    public synchronized void eaten() {
        if (!isDead)
            count.decrementAndGet();
        isDead = true;
        Field.field[i][j].remove(this);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public synchronized void move() {
        int y = getI();
        int x = getJ();
        int a = ThreadLocalRandom.current().nextInt(speed + 1);
        int b = ThreadLocalRandom.current().nextInt(4);
        if (a != 0) {

            if (b == 0) {
                y -= a;
            } else if (b == 1) {
                x -= a;
            } else if (b == 2) {
                y += a;
            } else {
                x += a;
            }

            if (y >= Field.HEIGHT) y = Field.HEIGHT - 1;
            if (y < 0) y = 0;
            if (x >= Field.WIDTH) x = Field.WIDTH - 1;
            if (x < 0) x = 0;
            if (Field.field[y][x].getCountCaterpillar() < maxPopulation) {
                if (!isDead) {
                    Field.field[getI()][getJ()].remove(this);
                    Field.field[y][x].add(this);
                }
            }
        }
    }

    @Override
    public void run() {
        eat(chanceToEat);
        move();
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }
}
