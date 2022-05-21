package Island;

import java.util.HashSet;
import java.util.Random;

public class Field {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 20;
    public static Cell[][] field = new Cell[HEIGHT][WIDTH];

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

    public static void draw() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                field[i][j].entities.stream()
                        .forEach(e -> Main.entities.add(e));
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
        }
    }


}
