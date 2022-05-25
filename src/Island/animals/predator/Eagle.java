package Island.animals.predator;

import Island.Field;
import Island.animals.herbivorous.*;

import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Eagle extends Predator {

    private static final int maxPopulation = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static final LinkedHashMap<Class<?>, Integer> chanceToEat = new LinkedHashMap<>();

    static {
        chanceToEat.put(Rabbit.class, 90);
        chanceToEat.put(Duck.class, 80);
        chanceToEat.put(Hamster.class, 90);
        chanceToEat.put(Fox.class, 10);
    }

    public Eagle() {

        setWeight(6.0);
        setSpeed(5);
        setAmountOfFood(1.0);
        setSurvivable(5);
        setAmountOfFoodNow(1.0);
        setAmountOfChild(2);

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
            if (Field.field[y][x].getCountEagle() < maxPopulation) {
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

    public static int getMaxPopulation() {
        return maxPopulation;
    }

}
