package Island;

import Island.animals.herbivorous.*;
import Island.animals.predator.*;
import Island.plants.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Field {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 20;
    public static Cell[][] field = new Cell[HEIGHT][WIDTH];
    public static String[][] pictures = new String[HEIGHT][WIDTH];

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

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                for (int a = 0; a < field[i][j].entities.size(); a++){
                    if (field[i][j].entities.get(a).isDead) field[i][j].remove(field[i][j].entities.get(a));
                    else Main.entities.add(field[i][j].entities.get(a));
                }
                field[i][j].findDominate();
                pictures[i][j] = (field[i][j].dominate + "");
            }
        }
    }

    public static void print() {
        System.out.print("Медведи: " + Bear.count.get());
        System.out.print(" Орлы: " + Eagle.count.get());
        System.out.print(" Лисы: " + Fox.count.get());
        System.out.print(" Волки: " + Wolf.count);
        System.out.println(" Змеи: " + Snake.count);
        System.out.print("Козы: " + Goat.count.get());
        System.out.print(" Коровы: " + Cow.count.get());
        System.out.print(" Утки: " + Duck.count.get());
        System.out.print(" Олени: " + Deer.count.get());
        System.out.print(" Гусеницы: " + Caterpillar.count.get());
        System.out.print(" Хомяки: " + Hamster.count.get());
        System.out.print(" Лошади: " + Horse.count.get());
        System.out.print(" Кенгуру: " + Kangaroo.count.get());
        System.out.print(" Кролики: " + Rabbit.count.get());
        System.out.println(" Овцы: " + Sheep.count.get());
        System.out.print("Деревья: " + Tree.count.get());
        System.out.println(" Количество существ: " + Main.entities.size());
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(pictures[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void distribute(HashSet<Entity> entities) {

        for (Entity entity : entities) {
            int i = new Random().nextInt(HEIGHT);
            int j = new Random().nextInt(WIDTH);
            field[i][j].add(entity);
            Main.entities.addAll(field[i][j].entities);
        }
    }


}
