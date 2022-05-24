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

    public synchronized void eat(HashMap<Class<?>, Integer> chanceToEat) {
        if (amountOfFoodNow < amountOfFood) {
            amountOfFoodNow += CanToEat.super.eat(chanceToEat, i, j);
            if (amountOfFoodNow > amountOfFood) amountOfFoodNow = amountOfFood;
        }
        if (amountOfFoodNow == 0) {
            eaten();
            return;
        }

        amountOfFoodNow -= amountOfFood/survivable;
        if (amountOfFoodNow < 0) amountOfFoodNow = 0;
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
}
