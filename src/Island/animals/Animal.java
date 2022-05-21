package Island.animals;

import Island.*;
import Island.interfaces.CanToEat;
import Island.interfaces.Moveable;
import Island.interfaces.Reproducable;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity implements CanToEat, Moveable, Reproducable{
    private int speed;
    private int i;
    private int j;

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

}
