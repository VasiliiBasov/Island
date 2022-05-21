package Island.animals.herbivorous;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;

public class Kangaroo extends Herbivorous {

    private double weight = 47.0;
    private int maxPopulation = 150;
    private int speed = 2;
    private double amountOfFood = 7.0;
    private int survivable = 5;
    private int i;
    private int j;


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
            if (Field.field[y][x].getCountKangaroo() < maxPopulation) {
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
        move();
    }
}
