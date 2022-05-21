package Island;

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

        Field.start();
        Field.distribute(new EntityFactory().entityFactory(1000, 1000, 3000, 3000, 4000, 2500, 10000, 1000, 3000, 8000, 4000, 9000, 2000, 3000, 6000, 4000));
        //Field.distribute(new EntityFactory().entityFactory(10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        Field.draw();
        TimeUnit.SECONDS.sleep(2);


        while (step < 100) {
            executorService = Executors.newCachedThreadPool();
            System.out.println(Tree.count.get());
            System.out.println(entities.size());
            for (Entity entity : entities) {
                if (entity != null) {
                    executorService.submit(entity);
                }
            }

            Field.draw();
            TimeUnit.MILLISECONDS.sleep(1000);
            step++;
        }
        executorService.shutdownNow();

    }
}
