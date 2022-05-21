package Island.animals.herbivorous;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;

public class Caterpillar extends Herbivorous {

    private double weight = 0.01;
    private int maxPopulation = 10000;
    private int speed = 1;
    private double amountOfFood = 0.0025;
    private int survivable = 1;
    private int i;
    private int j;

    @Override
    public void eat() {

    }

    @Override
    public void eaten() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void run() {
        move();

    }

    @Override
    public void move() {
        int a = ThreadLocalRandom.current().nextInt(speed + 1);
        int b = ThreadLocalRandom.current().nextInt(4);
        if (a != 0) {
            Field.field[getI()][getJ()].remove(this);

            if (b == 0) {
                setI(getI() - a);
            } else if (b == 1) {
                setJ(getJ() - a);
            } else if (b == 2) {
                setI(getI() + a);
            } else {
                setJ(getJ() + a);
            }

            if (getI() >= Field.HEIGHT) setI(Field.HEIGHT - 1);
            if (getI() < 0) setI(0);
            if (getJ() >= Field.WIDTH) setJ(Field.WIDTH - 1);
            if (getJ() < 0) setJ(0);
            Field.field[this.getI()][this.getJ()].add(this);
        }
    }
}
