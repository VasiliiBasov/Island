package Island;

import Island.animals.herbivorous.*;
import Island.animals.predator.*;
import Island.plants.Tree;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    public static int step = 0;

    public static HashSet<Entity> entities = new HashSet<>();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("start!");
        Field.start();
        Field.distribute(new EntityFactory().entityFactory(1000, 19, 30, 50, 40, 40, 700, 27, 30, 80, 40, 400, 200, 30, 60, 40));
        //Field.distribute(new EntityFactory().entityFactory(1000, 30, 0, 0, 0, 0, 10000, 0, 0, 0, 0, 1000, 0, 0, 0, 0));
        TimeUnit.SECONDS.sleep(2);


        while (step < 100) {
            executorService = Executors.newCachedThreadPool();
            for (Entity entity : entities) {
                if (entity != null) {
                    executorService.submit(entity);
                }
            }
            Field.draw();
            Field.print();

            TimeUnit.MILLISECONDS.sleep(1000);
            step++;
        }
        executorService.shutdown();



    }
}
