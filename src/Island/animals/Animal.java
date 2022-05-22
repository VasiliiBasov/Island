package Island.animals;

import Island.*;
import Island.interfaces.CanToEat;
import Island.interfaces.Moveable;
import Island.interfaces.Reproducable;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements CanToEat, Moveable, Reproducable {
    public int speed;
    public double amountOfFood;
    public int survivable;

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
}
