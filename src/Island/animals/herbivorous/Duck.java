package Island.animals.herbivorous;

import Island.Field;
import Island.plants.Tree;

import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Duck extends Herbivorous {

    public static AtomicInteger count = new AtomicInteger(0);
    private static final int maxPopulation = 200;
    public static final LinkedHashMap<Class<?>, Integer> chanceToEat = new LinkedHashMap<>();

    static {
        chanceToEat.put(Tree.class, 100);
        chanceToEat.put(Caterpillar.class, 100);
    }

    public Duck() {

        setWeight(1.0);
        setSpeed(4);
        setAmountOfFood(0.15);
        setAmountOfFoodNow(0.15);
        setSurvivable(4);

        count.incrementAndGet();
    }

    @Override
    public void eaten() {
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
            if (Field.field[y][x].getCountDuck() < maxPopulation) {
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
