package Island;

import Island.animals.herbivorous.*;
import Island.animals.predator.*;
import Island.plants.Tree;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityFactory {
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

    public static HashSet<Entity> entities = new HashSet<>();

    public HashSet<Entity> entityFactory(int countTree, int countBear, int countEagle, int countFox, int countSnake, int countWolf, int countCaterpillar, int countCow, int countDeer, int countDuck, int countGoat, int countHamster, int countHorse, int countKangaroo, int countRabbit, int countSheep) {
        this.countTree = countTree;
        this.countBear = countBear;
        this.countEagle = countEagle;
        this.countFox = countFox;
        this.countSnake = countSnake;
        this.countWolf = countWolf;
        this.countCaterpillar = countCaterpillar;
        this.countCow = countCow;
        this.countDeer = countDeer;
        this.countDuck = countDuck;
        this.countGoat = countGoat;
        this.countHamster = countHamster;
        this.countHorse = countHorse;
        this.countKangaroo = countKangaroo;
        this.countRabbit = countRabbit;
        this.countSheep = countSheep;

        for (int i = 0; i < countTree; i++) {
            entities.add(new Tree());
        }

        for (int i = 0; i < countBear; i++) {
            entities.add(new Bear());
        }

        for (int i = 0; i < countEagle; i++) {
            entities.add(new Eagle());
        }

        for (int i = 0; i < countFox; i++) {
            entities.add(new Fox());
        }

        for (int i = 0; i < countSnake; i++) {
            entities.add(new Snake());
        }

        for (int i = 0; i < countWolf; i++) {
            entities.add(new Wolf());
        }

        for (int i = 0; i < countCaterpillar; i++) {
            entities.add(new Caterpillar());
        }

        for (int i = 0; i < countCow; i++) {
            entities.add(new Cow());
        }

        for (int i = 0; i < countDeer; i++) {
            entities.add(new Deer());
        }

        for (int i = 0; i < countDuck; i++) {
            entities.add(new Duck());
        }

        for (int i = 0; i < countGoat; i++) {
            entities.add(new Goat());
        }

        for (int i = 0; i < countHamster; i++) {
            entities.add(new Hamster());
        }

        for (int i = 0; i < countHorse; i++) {
            entities.add(new Horse());
        }

        for (int i = 0; i < countKangaroo; i++) {
            entities.add(new Kangaroo());
        }

        for (int i = 0; i < countRabbit; i++) {
            entities.add(new Rabbit());
        }

        for (int i = 0; i < countSheep; i++) {
            entities.add(new Sheep());
        }

        return entities;
    }


}
