package Island.animals.herbivorous;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivorous {

    private double weight = 3.0;
    private int maxPopulation = 750;
    private int speed = 3;
    private double amountOfFood = 0.45;
    private int survivable = 7;
    private int i;
    private int j;
    public static int count = 0;

    public Rabbit() {
        count++;
    }

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

    @Override
    public void run() {
        move();
    }
}
