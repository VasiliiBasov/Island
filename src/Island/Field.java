package Island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Field {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 20;
    public static Cell[][] field = new Cell[HEIGHT][WIDTH];
    public static ArrayList<Entity> trash = new ArrayList<>();

    public static void start() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = new Cell();
                cell.setI(i);
                cell.setJ(j);
                field[i][j] = cell;
            }
        }
    }

    public synchronized static void draw() {
        Main.entities = new HashSet<>();
//        trash.forEach(t -> {
//            t.eaten();
//        });
//        for (int b = 0; b < Field.trash.size(); b++) {
//            //Field.trash.get(b).eaten();
//            Main.entities.remove(trash.get(b));
//        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                for (int a = 0; a < field[i][j].entities.size(); a++){
                    Main.entities.add(field[i][j].entities.get(a));
                }
//                field[i][j].entities.stream()
//                        .forEach(e -> Main.entities.add(e));
                field[i][j].findDominate();
                System.out.print(field[i][j].dominate + " ");
            }
            System.out.println();
        }
    }

    public static void distribute(HashSet<Entity> entities) {


        for (Entity entity : entities) {
            int i = new Random().nextInt(HEIGHT);
            int j = new Random().nextInt(WIDTH);
            field[i][j].add(entity);
            for (int a = 0; a < field[i][j].entities.size(); a++) {
                Main.entities.add(field[i][j].entities.get(a));
            }
        }
    }


}
