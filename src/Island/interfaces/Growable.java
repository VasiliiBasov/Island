package Island.interfaces;

import Island.Entity;
import Island.Field;
import Island.plants.Tree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public interface Growable {
    default void grow(AtomicInteger flowering, int breedingPow, Class<?> clazz, int y, int x, int seedRate) {

        if (flowering.get() == 0) {
            int amount = ThreadLocalRandom.current().nextInt(breedingPow + 1);

            Constructor<?> constructor = null;
            try {
                constructor = clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


            for (int i = 0; i < amount; i++) {
                int a = ThreadLocalRandom.current().nextInt(seedRate+1);
                int b = ThreadLocalRandom.current().nextInt(4);
                int setY = y;
                int setX = x;

                if (b == 0) {
                    setY -= a;
                }
                else if (b == 1){
                    setX -= a;
                }
                else if (b == 2){
                    setY += a;
                }
                else {
                    setX += a;
                }

                if (setY >= Field.HEIGHT) setY = Field.HEIGHT-1;
                if (setY < 0) setY = 0;
                if (setX >= Field.WIDTH) setX = Field.WIDTH-1;
                if (setX < 0) setX = 0;

                try {
                        assert constructor != null;
                        Field.field[setY][setX].add(constructor.newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
