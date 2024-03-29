package Island;

import Island.animals.predator.*;
import Island.animals.herbivorous.*;
import Island.plants.Tree;

import java.util.*;
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


    public CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<>();

    public Cell() {
        countCell++;
    }

    public synchronized void remove(Entity entity) {
        switch (entity) {
            case Tree t -> {
                entities.remove(t);
                countTree--;
            }
            case Bear b -> {
                entities.remove(b);
                countBear--;
            }
            case Eagle e -> {
                entities.remove(e);
                countEagle--;
            }
            case Fox f -> {
                entities.remove(f);
                countFox--;
            }
            case Snake s -> {
                entities.remove(s);
                countSnake--;
            }
            case Wolf w -> {
                if (entities.remove(w)) {
                    countWolf--;
                }
            }
            case Caterpillar cat -> {
                if (entities.remove(cat)) {
                    countCaterpillar--;
                }
            }
            case Cow cow -> {
                if (entities.remove(cow)) {
                    countCow--;
                }
            }
            case Deer deer -> {
                if (entities.remove(deer)) {
                    countDeer--;
                }
            }
            case Duck duck -> {
                if (entities.remove(duck)) {
                    countDuck--;
                }
            }
            case Goat goat -> {
                if (entities.remove(goat)) {
                    countGoat--;
                }
            }
            case Hamster hamster -> {
                if (entities.remove(hamster)) {
                    countHamster--;
                }
            }
            case Horse horse -> {
                if (entities.remove(horse)) {
                    countHorse--;
                }
            }
            case Kangaroo kangaroo -> {
                if (entities.remove(kangaroo)) {
                    countKangaroo--;
                }
            }
            case Rabbit rabbit -> {
                if (entities.remove(rabbit)) {
                    countRabbit--;
                }
            }
            case Sheep sheep -> {
                if (entities.remove(sheep)) {
                    countSheep--;
                }
            }

            default -> throw new IllegalStateException("Unexpected value: " + entity);
        }
    }


    public synchronized void add(Object entity) {
        switch (entity) {
            case Tree t -> {
                if (countTree < Tree.getMaxPopulation()) {
                    entities.add(t);
                    countTree++;
                    t.setI(i);
                    t.setJ(j);

                }
                else Tree.count.decrementAndGet();
            }
            case Bear b -> {
                if (countBear < Bear.getMaxPopulation()) {
                    entities.add(b);
                    countBear++;
                    b.setI(i);
                    b.setJ(j);
                }
                else Bear.count.decrementAndGet();
            }
            case Eagle e -> {
                if (countEagle < Eagle.getMaxPopulation()) {
                    entities.add(e);
                    countEagle++;
                    e.setI(i);
                    e.setJ(j);
                }
                else Eagle.count.decrementAndGet();
            }
            case Fox f -> {
                if (countFox < Fox.getMaxPopulation()) {
                    entities.add(f);
                    countFox++;
                    f.setI(i);
                    f.setJ(j);
                }
                else Fox.count.decrementAndGet();
            }
            case Snake s -> {
                if (countSnake < Snake.getMaxPopulation()) {
                    entities.add(s);
                    countSnake++;
                    s.setI(i);
                    s.setJ(j);
                }
                else Snake.count.decrementAndGet();
            }
            case Wolf w -> {
                if (countWolf < Wolf.getMaxPopulation()) {
                    entities.add(w);
                    countWolf++;
                    w.setI(i);
                    w.setJ(j);
                }
                else Wolf.count.decrementAndGet();
            }
            case Caterpillar caterpillar -> {
                if (countCaterpillar < caterpillar.getMaxPopulation()) {
                    entities.add(caterpillar);
                    countCaterpillar++;
                    caterpillar.setI(i);
                    caterpillar.setJ(j);
                }
                else Caterpillar.count.decrementAndGet();
            }
            case Cow cow -> {
                if (countCow < cow.getMaxPopulation()) {
                    entities.add(cow);
                    countCow++;
                    cow.setI(i);
                    cow.setJ(j);
                }
                else Cow.count.decrementAndGet();
            }
            case Deer deer -> {
                if (countDeer < deer.getMaxPopulation()) {
                    entities.add(deer);
                    countDeer++;
                    deer.setI(i);
                    deer.setJ(j);
                }
                else Deer.count.decrementAndGet();
            }
            case Duck duck -> {
                if (countDuck < duck.getMaxPopulation()) {
                    entities.add(duck);
                    countDuck++;
                    duck.setI(i);
                    duck.setJ(j);
                }
                else Duck.count.decrementAndGet();
            }
            case Goat goat -> {
                if (countGoat < Goat.getMaxPopulation()) {
                    entities.add(goat);
                    countGoat++;
                    goat.setI(i);
                    goat.setJ(j);
                }
                else Goat.count.decrementAndGet();
            }
            case Hamster hamster -> {
                if (countHamster < hamster.getMaxPopulation()) {
                    entities.add(hamster);
                    countHamster++;
                    hamster.setI(i);
                    hamster.setJ(j);
                }
                else Hamster.count.decrementAndGet();
            }
            case Horse horse -> {
                if (countHorse < horse.getMaxPopulation()) {
                    entities.add(horse);
                    countHorse++;
                    horse.setI(i);
                    horse.setJ(j);
                }
                else Horse.count.decrementAndGet();
            }
            case Kangaroo kangaroo -> {
                if (countKangaroo < kangaroo.getMaxPopulation()) {
                    entities.add(kangaroo);
                    countKangaroo++;
                    kangaroo.setI(i);
                    kangaroo.setJ(j);
                }
                else Kangaroo.count.decrementAndGet();
            }
            case Rabbit rabbit -> {
                if (countRabbit < rabbit.getMaxPopulation()) {
                    entities.add(rabbit);
                    countRabbit++;
                    rabbit.setI(i);
                    rabbit.setJ(j);
                }
                else Rabbit.count.decrementAndGet();
            }
            case Sheep sheep -> {
                if (countSheep < sheep.getMaxPopulation()) {
                    entities.add(sheep);
                    countSheep++;
                    sheep.setI(i);
                    sheep.setJ(j);
                }
                else Sheep.count.decrementAndGet();
            }
            default -> throw new IllegalStateException("Unexpected value: " + entity);
        }
    }

    public synchronized void findDominate() {
        String d = "—";
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

    public int getCountCaterpillar() {
        return countCaterpillar;
    }

    public int getCountCow() {
        return countCow;
    }

    public int getCountDeer() {
        return countDeer;
    }

    public int getCountDuck() {
        return countDuck;
    }

    public int getCountGoat() {
        return countGoat;
    }

    public int getCountHamster() {
        return countHamster;
    }

    public int getCountHorse() {
        return countHorse;
    }

    public int getCountKangaroo() {
        return countKangaroo;
    }

    public int getCountRabbit() {
        return countRabbit;
    }

    public int getCountSheep() {
        return countSheep;
    }
}
