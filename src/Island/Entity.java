package Island;

import Island.interfaces.Eatable;

public abstract class Entity implements Eatable, Runnable {

    private int i;
    private int j;
    public boolean isDead;

    @Override
    public void run() {

    }

    @Override
    public void eaten() {

    }

}
