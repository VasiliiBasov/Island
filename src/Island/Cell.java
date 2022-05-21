package Island;

import Island.animals.predator.*;
import Island.animals.herbivorous.*;
import Island.plants.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cell {
    public String dominate;

    private int countTree;
    private int countBear;
    private int countEagle;
    private int countFox;
    private int countSnake;
    private int countWolf;
    private int countCaterpillar;
    private int countCow;
    private int countDeer;
    private int countDuck;
    private int countGoat;
    private int countHamster;
    private int countHorse;
    private int countKangaroo;
    private int countRabbit;
    private int countSheep;
    private int i;
    private int j;
    public static int countCell = 0;


    public HashSet<Entity> entities = new HashSet<>();

    public Cell() {
        countCell++;
    }

    public synchronized void remove(Entity entity) {
        switch (entity) {
            case Tree t -> {
                entities.remove(t);
//                allEntities.remove(t);
                countTree--;
            }
            case Bear b -> {
                entities.remove(b);
//                allEntities.remove(b);
                countBear--;
            }
            case Eagle e -> {
                entities.remove(e);
//                allEntities.remove(e);
                countEagle--;
            }
            case Fox f -> {
                entities.remove(f);
//                allEntities.remove(f);
                countFox--;
            }
            case Snake s -> {
                entities.remove(s);
//                allEntities.remove(s);
                countSnake--;
            }
            case Wolf w -> {
                if (entities.remove(w)) {
//                    allEntities.remove(w);
                    countWolf--;
                }
            }
            case Caterpillar cat -> {
                if (entities.remove(cat)) {
//                    allEntities.remove(cat);
                    countCaterpillar--;
                }
            }
            case Cow cow -> {
                if (entities.remove(cow)) {
//                    allEntities.remove(cow);
                    countCow--;
                }
            }
            case Deer deer -> {
                if (entities.remove(deer)) {
//                    allEntities.remove(deer);
                    countDeer--;
                }
            }
            case Duck duck -> {
                if (entities.remove(duck)) {
//                    allEntities.remove(duck);
                    countDuck--;
                }
            }
            case Goat goat -> {
                if (entities.remove(goat)) {
//                    allEntities.remove(goat);
                    countGoat--;
                }
            }
            case Hamster hamster -> {
                if (entities.remove(hamster)) {
//                    allEntities.remove(hamster);
                    countHamster--;
                }
            }
            case Horse horse -> {
                if (entities.remove(horse)) {
//                    allEntities.remove(horse);
                    countHorse--;
                }
            }
            case Kangaroo kangaroo -> {
                if (entities.remove(kangaroo)) {
//                    allEntities.remove(kangaroo);
                    countKangaroo--;
                }
            }
            case Rabbit rabbit -> {
                if (entities.remove(rabbit)) {
//                    allEntities.remove(rabbit);
                    countRabbit--;
                }
            }
            case Sheep sheep -> {
                if (entities.remove(sheep)) {
//                    allEntities.remove(sheep);
                    countSheep--;
                }
            }

            default -> throw new IllegalStateException("Unexpected value: " + entity);
        }
    }


    public synchronized void add(Object entity) {
        switch (entity) {
            case Tree t -> {
//                allEntities.add(t);
                if (countTree < t.getMaxPopulation()) {
                    entities.add(t);
                    countTree++;
                    t.setI(i);
                    t.setJ(j);

                }
            }
            case Bear b -> {
                entities.add(b);
//                allEntities.add(b);
                countBear++;
                b.setI(i);
                b.setJ(j);
            }
            case Eagle e -> {
                entities.add(e);
//                allEntities.add(e);
                countEagle++;
                e.setI(i);
                e.setJ(j);
            }
            case Fox f -> {
                entities.add(f);
//                allEntities.add(f);
                countFox++;
                f.setI(i);
                f.setJ(j);
            }
            case Snake s -> {
                entities.add(s);
//                allEntities.add(s);
                countSnake++;
                s.setI(i);
                s.setJ(j);
            }
            case Wolf w -> {
                if (entities.add(w)) {
//                    allEntities.add(w);
                    countWolf++;
                    w.setI(i);
                    w.setJ(j);
                }
            }
            case Caterpillar cat -> {
                if (entities.add(cat)) {
//                    allEntities.add(cat);
                    countCaterpillar++;
                    cat.setI(i);
                    cat.setJ(j);
                }
            }
            case Cow cow -> {
                if (entities.add(cow)) {
//                    allEntities.add(cow);
                    countCow++;
                    cow.setI(i);
                    cow.setJ(j);
                }
            }
            case Deer deer -> {
                if (entities.add(deer)) {
//                    allEntities.add(deer);
                    countDeer++;
                    deer.setI(i);
                    deer.setJ(j);
                }
            }
            case Duck duck -> {
                if (entities.add(duck)) {
//                    allEntities.add(duck);
                    countDuck++;
                    duck.setI(i);
                    duck.setJ(j);
                }
            }
            case Goat goat -> {
                if (entities.add(goat)) {
//                    allEntities.add(goat);
                    countGoat++;
                    goat.setI(i);
                    goat.setJ(j);
                }
            }
            case Hamster hamster -> {
                if (entities.add(hamster)) {
//                    allEntities.add(hamster);
                    countHamster++;
                    hamster.setI(i);
                    hamster.setJ(j);
                }
            }
            case Horse horse -> {
                if (entities.add(horse)) {
//                    allEntities.add(horse);
                    countHorse++;
                    horse.setI(i);
                    horse.setJ(j);
                }
            }
            case Kangaroo kangaroo -> {
                if (entities.add(kangaroo)) {
//                    allEntities.add(kangaroo);
                    countKangaroo++;
                    kangaroo.setI(i);
                    kangaroo.setJ(j);
                }
            }
            case Rabbit rabbit -> {
                if (entities.add(rabbit)) {
//                    allEntities.add(rabbit);
                    countRabbit++;
                    rabbit.setI(i);
                    rabbit.setJ(j);
                }
            }
            case Sheep sheep -> {
                if (entities.add(sheep)) {
//                    allEntities.add(sheep);
                    countSheep++;
                    sheep.setI(i);
                    sheep.setJ(j);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + entity);
        }
    }

    public synchronized void findDominate() {
        String d = "пусто";
        int max = 0;
        if (countBear > max) {
            max = countBear;
            d = "\uD83D\uDC3B";
        }
        if (countEagle > max) {
            max = countEagle;
            d = "\uD83E\uDD85";
        }
        if (countFox > max) {
            max = countFox;
            d = "\uD83E\uDD8A";
        }
        if (countSnake > max) {
            max = countSnake;
            d = "\uD83D\uDC0D";
        }
        if (countWolf > max) {
            max = countWolf;
            d = "\uD83D\uDC3A";
        }
        if (countTree > max) {
            max = countTree;
            d = "\uD83C\uDF3F";
        }
        if (countSheep > max) {
            max = countSheep;
            d = "\uD83D\uDC11";
        }
        if (countRabbit > max) {
            max = countRabbit;
            d = "\uD83D\uDC07";
        }
        if (countKangaroo > max) {
            max = countKangaroo;
            d = "\uD83E\uDD98";
        }
        if (countHorse > max) {
            max = countHorse;
            d = "\uD83D\uDC0E";
        }
        if (countHamster > max) {
            max = countHamster;
            d = "\uD83D\uDC01";
        }
        if (countGoat > max) {
            max = countGoat;
            d = "\uD83D\uDC10";
        }
        if (countDuck > max) {
            max = countDuck;
            d = "\uD83E\uDD86";
        }
        if (countDeer > max) {
            max = countDeer;
            d = "\uD83E\uDD8C";
        }
        if (countCow > max) {
            max = countCow;
            d = "\uD83D\uDC04";
        }
        if (countCaterpillar > max) {
            max = countCaterpillar;
            d = "\uD83D\uDC1B";
        }
        dominate = d;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getDominate() {
        return dominate;
    }

    public int getCountTree() {
        return countTree;
    }

    public int getCountBear() {
        return countBear;
    }

    public int getCountEagle() {
        return countEagle;
    }

    public int getCountFox() {
        return countFox;
    }

    public int getCountSnake() {
        return countSnake;
    }

    public int getCountWolf() {
        return countWolf;
    }
}
