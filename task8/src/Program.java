import Base.*;
import Interface.Home;
import Interface.IsTraining;
import Interface.LeaderOfThePack;
import classes.*;

import java.util.ArrayList;


public class Program {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal tiger = new Tiger(80, 170, "страшные, не разглядывал",
                "полосатый", "индия (задний двор)", "вчера, утащил ослёнка");
        zoo.addAnimal(tiger);
        Animal dog = new PetDog(50, 68, "чёрный",
                "бешевый", "Шарик", "Лабрадор", Home.Vac.No,"05.2021",IsTraining.Training.No);
        zoo.addAnimal(dog);
        Animal wolf = new Wolf(60, 80, "страшные не разглядывал",
                "серый", "тайга", "давно не объявлялся", LeaderOfThePack.Leader.Yes);
        zoo.addAnimal(wolf);
        Animal chicken = new Chicken(30, 4, "коричневый", 2);
        zoo.addAnimal(chicken);
        Animal stork = new Stork(60, 3, "жёлтый",
                37);
        zoo.addAnimal(stork);
        System.out.println("Зоопарк создан. Количество животных: " + zoo.countAnimals());
        zoo.printList();

        System.out.println("---------удаление\\добавление----------\n");

        zoo.removeAnimal(1);
        Animal cat2 = new PetCat(22, 6, "зелёный",
                "серый", "васёк", "руская голубая", Home.Vac.Yes,
                "24.02.2022");
        zoo.addAnimal(2, cat2);
        System.out.println("Добавлено новое животное");
        zoo.printInfo(2);
        System.out.println("\n---------дресеровка----------\n");
        System.out.println("Тренеруем собак");
        zoo.trainingAnimal(dog);
        zoo.trainingAnimal(wolf);
        Animal dog2 = new PetDog(50, 68, "чёрный",
                "бешевый", "Беляк", "двор-стайл", Home.Vac.No,"07.2021",IsTraining.Training.No);
        zoo.addAnimal(dog2);
        zoo.trainingAnimal(6);
        zoo.printInfo(1);
        zoo.printInfo(6);
        System.out.println("\n---------крик----------\n");
        System.out.println("одиночный\n");
        zoo.animalVoice(2);
        System.out.println();
        System.out.println("хор\n");
        zoo.animalVoices();
        System.out.println("\n--------Полёт-----------\n");
        zoo.printInfoFlight(stork);
        zoo.printInfoFlight(4);
        zoo.printInfoFlight(cat2);
        System.out.println("\n---------ласка----------\n");
        zoo.printLaska(cat2);
        zoo.printLaska(3);
        zoo.printLaska(6);


    }


}
