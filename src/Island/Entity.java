package Island;

import Island.interfaces.Eatable;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Entity implements Eatable, Runnable {

    public double weight;
    public int i;
    public int j;
    public boolean isDead = false;

    @Override
    public void run() {

    }

    @Override
    public void eaten() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
