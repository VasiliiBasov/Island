package Island.animals.herbivorous;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Hamster extends Herbivorous {

    private double weight = 0.03;
    private int maxPopulation = 500;
    private int speed = 1;
    private double amountOfFood = 0.01;
    private int survivable = 2;
    private int i;
    private int j;
    private boolean isDead = false;
    public static AtomicInteger count = new AtomicInteger(0);


    public void eat() {

    }

    @Override
    public void eaten() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move() {
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
            if (Field.field[y][x].getCountHamster() < maxPopulation) {
                Field.field[getI()][getJ()].remove(this);
                Field.field[y][x].add(this);
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getSpeed() {
        return speed;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public int getSurvivable() {
        return survivable;
    }

    @Override
    public int getI() {
        return i;
    }

    @Override
    public int getJ() {
        return j;
    }

    @Override
    public void run() {
        if (!isDead)
            move();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxPopulation(int maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setSurvivable(int survivable) {
        this.survivable = survivable;
    }

    @Override
    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void setJ(int j) {
        this.j = j;
    }
}
