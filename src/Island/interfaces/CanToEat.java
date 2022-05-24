package Island.interfaces;

import Island.Entity;
import Island.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public interface CanToEat {
    default double eat(HashMap<Class<?>, Integer> chanceToEat, int i, int j) {
        int a = ThreadLocalRandom.current().nextInt(100);
        final Entity[] animal = new Entity[1];
        double food = 0.0;
        int chance = 0;

        for (Class<?> e : chanceToEat.keySet()) {

            for (Entity ent : Field.field[i][j].entities) {
                if (ent.getClass() == e) {
                    animal[0] = ent;
                    chance = chanceToEat.get(e);
                    break;
                }
            }
            if (animal[0] != null) break;
        }
        if (a < chance) {
            Class<? extends Entity> clazz = animal[0].getClass();
            java.lang.reflect.Field field = null;
            Method method = null;
            try {
                field = Entity.class.getField("weight");
                method = clazz.getMethod("eaten");
            } catch (NoSuchFieldException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            try {
                assert field != null;
                food = (double) field.get(animal[0]);
                assert method != null;
                method.invoke(animal[0]);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
            return food;
        }

        return food;
    }
}
