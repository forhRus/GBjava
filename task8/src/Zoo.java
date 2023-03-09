import Base.Animal;
import Interface.Home;
import Interface.IsFly;
import Interface.IsTraining;

import java.util.ArrayList;

public class Zoo {
    private static ArrayList<Animal> zooList;

    static {
        zooList = new ArrayList<>();
    }

    public int countAnimals() {
        return zooList.size();
    }

    public void addAnimal(int number, Animal animal) {
        if (checkIndex(number)) {
            zooList.add(number - 1, animal);
        }
    }

    public void addAnimal(Animal animal) {
        zooList.add(animal);
    }

    public void removeAnimal(int number) {
        if(checkIndex(number)){
            zooList.remove(number - 1);
            System.out.println("Животное удалено.\n");
        }
    }

    public void printList() {
        for (int i = 0; i < zooList.size(); i++) {
            System.out.println(i + 1 + ". " + zooList.get(i).getInfo());
            System.out.println();
        }
    }

    public void printInfo(int number) {
        if(checkIndex(number)) {
            System.out.println(zooList.get(number-1).getInfo());
        }
    }

    public void animalVoices() {
        for (int i = 0; i < zooList.size(); i++) {
            zooList.get(i).makeSound();
        }
    }
    public void animalVoice(int number) {
        if(checkIndex(number)) {
            zooList.get(number-1).makeSound();
        }
    }
    public void trainingAnimal(Animal animal) {
        if (animal instanceof IsTraining) {
            ((IsTraining) animal).setTraining(IsTraining.Training.Yes);
        } else {
            System.out.println("Этот не обучаемый");
        }
    }
    public void trainingAnimal(int number) {
        if(checkIndex(number)) {
            trainingAnimal(zooList.get(number-1));
        }

    }
    public void printInfoFlight(Animal animal) {
        if(animal instanceof IsFly) {
            ((IsFly) animal).getInfoFlight();
        } else {
            System.out.println("Это животное не летает");
        }
    }
    public void printInfoFlight(int number) {
        if(checkIndex(number)) {
            printInfoFlight(zooList.get(number-1));
        }
    }
    public void printLaska(Animal animal) {
        if(animal instanceof Home) {
            ((Home) animal).weasel();
        } else {
            System.out.println("Осторожно дикое животное.");
        }
    }
    public void printLaska(int number) {
        if(checkIndex(number)) {
            printLaska(zooList.get(number-1));
        } else {
            System.out.println("Осторожно дикое животное.");
        }
    }

    private boolean checkIndex(int number) {
        if (zooList.size() >= number && number > 0) {
            return true;
        } else {
            System.out.println("Ошибка ввода");
            countAnimals();
            return false;
        }
    }

}
