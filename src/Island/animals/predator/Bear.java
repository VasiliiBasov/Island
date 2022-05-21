package Island.animals.predator;

import Island.Field;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {

    private double weight = 250.0;
    private int maxPopulation = 7;
    private int speed = 2;
    private double amountOfFood = 38.0;
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

    @Override
    public void eat() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move() {
        int a = ThreadLocalRandom.current().nextInt(speed+1);
        int b = ThreadLocalRandom.current().nextInt(4);
        if (a != 0) {
            Field.field[getI()][getJ()].remove(this);

            if (b == 0) {
                setI(getI() - a);
            }
            else if (b == 1){
                setJ(getJ() - a);
            }
            else if (b == 2){
                setI(getI() + a);
            }
            else if (b == 3){
                setJ(getJ() + a);
            }

            if (getI() >= Field.HEIGHT) setI(Field.HEIGHT-1);
            if (getI() < 0) setI(0);
            if (getJ() >= Field.WIDTH) setJ(Field.WIDTH-1);
            if (getJ() < 0) setJ(0);
            Field.field[this.getI()][this.getJ()].add(this);
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
