package Island;

import Island.animals.herbivorous.Rabbit;
import Island.animals.predator.Wolf;
import Island.plants.Tree;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    public static int step = 0;
    //public static CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<>();
    //public static HashSet<Entity> entities = new HashSet<Entity>();
    public static HashSet<Entity> entities = new HashSet<>();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("start!");
        //entities = new EntityFactory().entityFactory(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Field.start();
        Field.distribute(new EntityFactory().entityFactory(10000, 1000, 3000, 3000, 4000, 2500, 10000, 1000, 3000, 8000, 4000, 9000, 2000, 3000, 6000, 4000));
        Field.draw();
        TimeUnit.SECONDS.sleep(2);
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(entities.size());
//                System.out.println(Tree.count.get());
//                System.out.println(Tree.count);
//                //System.out.println("case 0: " + Wolf.aa + " case 1: " + Wolf.bb + " case 2: " + Wolf.cc + " case 3: " + Wolf.dd);
//                for (Entity entity : Main.entities) {
//                    if (entity != null) {
//                        executorService.submit(entity);
//                        //executorService.submit(entity);
//                    }
//                }
//                Field.draw();
//                step++;
//            }
//        },3, 3, TimeUnit.SECONDS);
        while (step < 100) {
            //System.out.println(Rabbit.count);
            System.out.println(entities.size());
            System.out.println(Tree.count.get());
            //System.out.println("case 0: " + Wolf.aa + " case 1: " + Wolf.bb + " case 2: " + Wolf.cc + " case 3: " + Wolf.dd);
            for (Entity entity : entities) {
                if (entity != null) {
                    executorService.submit(entity);
                }
            }
//            for (int i = 0; i < Field.HEIGHT; i++) {
//                for (int j = 0; j < Field.WIDTH; j++) {
//                    Field.field[i][j].entities.stream()
//                            .forEach(t -> {
//                                executorService.submit(t);
//                            });
//                }
//            }
            Field.draw();
            TimeUnit.MILLISECONDS.sleep(1000);
            step++;
        }
        executorService.shutdownNow();

    }
}
