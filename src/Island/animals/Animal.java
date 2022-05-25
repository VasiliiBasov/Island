package Island.animals;

import Island.*;
import Island.interfaces.CanToEat;
import Island.interfaces.Moveable;
import Island.interfaces.Reproducable;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements CanToEat, Moveable, Reproducable {
    public int speed;
    public double amountOfFood;
    public double amountOfFoodNow;
    public int survivable;
    public int amountOfChildren;

    public synchronized void eat(HashMap<Class<?>, Integer> chanceToEat) {
        if (amountOfFoodNow <= amountOfFood) {
            double food;
            food = CanToEat.super.eat(chanceToEat, i, j, amountOfFood - amountOfFoodNow);
            amountOfFoodNow += food;
            if (amountOfFoodNow > amountOfFood * 1.1) {
                this.reproduce();
                amountOfFoodNow = amountOfFood;
            }
        }
        if (amountOfFoodNow == 0) {
            eaten();
            return;
        }

        amountOfFoodNow -= amountOfFood/survivable;
        if (amountOfFoodNow < 0) amountOfFoodNow = 0;
    }

    @Override
    public synchronized void reproduce() {
        if (pairSearch(this)) {
            for (int k = 0; k < amountOfChildren; k++) {
                int y = getI() - 1;
                int x = getJ() - 1;
                int z = getI() + 1;
                int w = getJ() + 1;

                if (y >= Field.HEIGHT) y = Field.HEIGHT - 1;
                if (y < 0) y = 0;
                if (x >= Field.WIDTH) x = Field.WIDTH - 1;
                if (x < 0) x = 0;
                if (z >= Field.HEIGHT) z = Field.HEIGHT - 1;
                if (z < 0) z = 0;
                if (w >= Field.WIDTH) w = Field.WIDTH - 1;
                if (w < 0) w = 0;
                try {
                    Field.field[ThreadLocalRandom.current().nextInt(y, z+1)][ThreadLocalRandom.current().nextInt(x, w+1)].add(this.getClass().newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean pairSearch(Animal animal) {
        final boolean[] flag = new boolean[1];
        int y = getI() - 1;
        int x = getJ() - 1;
        int z = getI() + 1;
        int w = getJ() + 1;

            if (y >= Field.HEIGHT) y = Field.HEIGHT - 1;
            if (y < 0) y = 0;
            if (x >= Field.WIDTH) x = Field.WIDTH - 1;
            if (x < 0) x = 0;
            if (z >= Field.HEIGHT) z = Field.HEIGHT - 1;
            if (z < 0) z = 0;
            if (w >= Field.WIDTH) w = Field.WIDTH - 1;
            if (w < 0) w = 0;

        for (int k = y; k < z; k++) {
            for (int l = x; l < w; l++) {
                Field.field[k][l].entities.forEach(entity -> {
                    if (entity.getClass() == animal.getClass() && !entity.equals(animal)) {
                        flag[0] = true;
                    }
                });
                if (flag[0]) return true;
            }
        }
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getSurvivable() {
        return survivable;
    }

    public void setSurvivable(int survivable) {
        this.survivable = survivable;
    }

    public double getAmountOfFoodNow() {
        return amountOfFoodNow;
    }

    public void setAmountOfFoodNow(double amountOfFoodNow) {
        this.amountOfFoodNow = amountOfFoodNow;
    }

    public int getAmountOfChild() {
        return amountOfChildren;
    }

    public void setAmountOfChild(int amountOfChild) {
        this.amountOfChildren = amountOfChild;
    }
}
