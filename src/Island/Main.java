package Island;

import Island.animals.herbivorous.Cow;
import Island.animals.herbivorous.Deer;
import Island.animals.herbivorous.Duck;
import Island.animals.herbivorous.Goat;
import Island.animals.predator.Wolf;
import Island.plants.Tree;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    //public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    public static int step = 0;

    public static HashSet<Entity> entities = new HashSet<>();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("start!");
        Field.start();
        //Field.distribute(new EntityFactory().entityFactory(100, 100, 300, 300, 200, 200, 10000, 100, 300, 800, 400, 2000, 200, 300, 600, 400));
        Field.distribute(new EntityFactory().entityFactory(100, 0, 0, 0, 0, 10, 100, 6000, 100, 100, 100, 100, 100, 100, 100, 100));
        Field.draw();
        TimeUnit.SECONDS.sleep(2);


        while (step < 100) {
            executorService = Executors.newCachedThreadPool();
            System.out.print("Волки: " + Wolf.count);
            System.out.print(" Козы: " + Goat.count.get());
            System.out.print(" Коровы: " + Cow.count.get());
            System.out.print(" Утки: " + Duck.count.get());
            System.out.print(" Олени: " + Deer.count.get());
            System.out.println(" Количество существ: " + entities.size());
            for (Entity entity : entities) {
                if (entity != null) {
                    executorService.submit(entity);
                }
            }

            Field.draw();
            TimeUnit.MILLISECONDS.sleep(1000);
            step++;
        }
        executorService.shutdown();



    }
}
