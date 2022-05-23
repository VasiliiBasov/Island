package Island.animals.herbivorous;

import Island.Field;
import Island.Main;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Goat extends Herbivorous {

    public static AtomicInteger count = new AtomicInteger(0);
    public static int maxPopulation = 140;

    public Goat() {

        setWeight(60.0);
        setSpeed(2);
        setAmountOfFood(10.0);
        setSurvivable(5);

        count.incrementAndGet();
    }


    public void eat() {

    }

    @Override
    public synchronized void eaten() {
        isDead = true;
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
            if (Field.field[y][x].getCountGoat() < maxPopulation) {
                Field.field[getI()][getJ()].remove(this);
                Field.field[y][x].add(this);
            }
        }
    }

    @Override
    public void run() {
        if (!isDead)
            move();
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

    public static void setMaxPopulation(int maxPopulation) {
        Goat.maxPopulation = maxPopulation;
    }
}
