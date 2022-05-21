package Island.interfaces;

import Island.Entity;
import Island.Field;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public interface CanToEat {
    default double eat(HashMap<Class<?>, Integer> chanceToEat, int i, int j) {
        int a = ThreadLocalRandom.current().nextInt(100);
        final Entity[] animal = new Entity[1];
        double food = 0.0;

        for (Class<?> e : chanceToEat.keySet()) {

//            animal[0] = Field.field[i][j].entities
//                    .stream()
//                    .filter(e2 -> (e == e2.getClass()))
//                    .findFirst().get();
            Field.field[i][j].entities.forEach(ent -> {
                if (ent.getClass() == e) {
                    animal[0] = ent;
                }
            });
            if (!(animal[0] == null)) {
                if (a < chanceToEat.get(e)) {
                    Class clazz = animal[0].getClass();
                    java.lang.reflect.Field field = null;
                    try {
                        field = clazz.getDeclaredField("weight");
                        field.setAccessible(true);
                    } catch (NoSuchFieldException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        food = (double) field.get(animal[0]);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    Field.field[i][j].remove(animal[0]);
                    return food;
                }
            }
        }

//        double food = 0.0;
//        chanceToEat.forEach((entity, integer) -> {
//        Field.field[i][j].entities
//                .stream()
//                .filter(entity1 -> (entity.getClass()==entity1.getClass()))
//                .findFirst().get();
//            if (a < integer) {
//                Class clazz = animal.getClass();
//                java.lang.reflect.Field field = null;
//                try {
//                    field = clazz.getField("weight");
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    food = field.get(animal);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                this.
//                return (Entity) animal;
//            }
//        });
//        return 0.0;
        return food;
    }
}
