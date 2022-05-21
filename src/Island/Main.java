package Island;

import Island.animals.herbivorous.Goat;
import Island.animals.predator.Wolf;
import Island.plants.Tree;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    public static int step = 0;

    public static HashSet<Entity> entities = new HashSet<>();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("start!");
        Entity wolf = new Wolf();
        System.out.println(wolf.getClass().getSimpleName());
        Field.start();
        //Field.distribute(new EntityFactory().entityFactory(100, 100, 300, 300, 200, 200, 10000, 100, 300, 800, 400, 2000, 200, 300, 600, 400));
        Field.distribute(new EntityFactory().entityFactory(0, 0, 0, 0, 0, 1000, 0, 0, 0, 0, 10000, 0, 0, 0, 0, 0));
        Field.draw();
        TimeUnit.SECONDS.sleep(2);


        while (step < 100) {
            executorService = Executors.newCachedThreadPool();
            System.out.println(Wolf.count.get());
            System.out.println(Goat.count.get());
            System.out.println(entities.size());
            for (Entity entity : entities) {
                if (entity != null) {
                    executorService.submit(entity);
                }
            }

            Field.draw();
            TimeUnit.MILLISECONDS.sleep(500);
            step++;
        }
        executorService.shutdownNow();

    }
}
