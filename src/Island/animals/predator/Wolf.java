package Island.animals.predator;

import Island.Entity;
import Island.Field;
import Island.Main;
import Island.animals.herbivorous.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Predator {

    private double weight = 50.0;
    private int maxPopulation = 30;
    private int speed = 3;
    private final double amountOfFood = 8.0;
    private double amountOfFoodNow = 8.0;
    private int survivable = 10;
    private int i;
    private int j;
    public static int count = 0;
    private boolean isDead = false;

    public static final HashMap<Class<?>, Integer> chanceToEat = new HashMap<>();
    //public static final ArrayList<Class<?>> animalForEat = new ArrayList<>();

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

        //animalForEat.addAll(chanceToEat.keySet());
    }

    public Wolf() {
        count++;
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

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public synchronized void eat() {
        if (amountOfFoodNow < amountOfFood) {
            amountOfFoodNow += super.eat(chanceToEat, i, j);
            if (amountOfFoodNow > amountOfFood) amountOfFoodNow = amountOfFood;
        }
        if (amountOfFoodNow == 0) {
            eaten();
            Wolf.count--;
            Field.field[i][j].remove(this);
            return;
        }

        amountOfFoodNow -= amountOfFood/survivable;
        if (amountOfFoodNow < 0) amountOfFoodNow = 0;
    }

    @Override
    public synchronized void eaten() {
        isDead = true;
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
                Field.field[getI()][getJ()].remove(this);
                Field.field[y][x].add(this);
            }
        }
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void run() {
        eat();
        if (!isDead)
        move();
    }

}
