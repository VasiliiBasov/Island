package Island.animals.predator;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {

    private Double weight = 500.0;
    private int maxPopulation = 5;
    private int speed = 2;
    private double amountOfFood = 80.0;
    private int survivable = 15;
    private int i;
    private int j;

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
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

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }


    public void eat() {

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
            if (Field.field[y][x].getCountBear() < maxPopulation) {
                Field.field[getI()][getJ()].remove(this);
                Field.field[y][x].add(this);
            }
        }
    }

    @Override
    public void run() {
        move();
    }

    @Override
    public void eaten() {

    }
}
