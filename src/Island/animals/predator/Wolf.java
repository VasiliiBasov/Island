package Island.animals.predator;

import Island.Field;
import Island.animals.herbivorous.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Predator {

    private static final int maxPopulation = 30;
    public static AtomicInteger count = new AtomicInteger(0);

    public static final HashMap<Class<?>, Integer> chanceToEat = new HashMap<>();

    static {
        chanceToEat.put(Sheep.class, 70);
        chanceToEat.put(Goat.class, 60);
        chanceToEat.put(Rabbit.class, 60);
        chanceToEat.put(Deer.class, 15);
        chanceToEat.put(Kangaroo.class, 15);
        chanceToEat.put(Cow.class, 10);
        chanceToEat.put(Horse.class, 10);
        chanceToEat.put(Duck.class, 40);
        chanceToEat.put(Hamster.class, 80);
    }

    public Wolf() {

        setWeight(50.0);
        setSpeed(3);
        setAmountOfFood(8.0);
        setSurvivable(10);
        setAmountOfFoodNow(8.0);

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
            if (Field.field[y][x].getCountWolf() < maxPopulation) {
                if (!isDead) {
                    Field.field[getI()][getJ()].remove(this);
                    Field.field[y][x].add(this);
                }
            }
        }
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void run() {
        eat(chanceToEat);
        if (!isDead)
        move();
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

}
