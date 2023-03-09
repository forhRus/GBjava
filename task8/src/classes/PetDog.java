package classes;

import Base.Animal;
import Base.Dog;
import Interface.*;

public class PetDog extends Dog implements IsTraining, Home {
    String name;
    String breed;
    Vac vac;
    String dateBirthday;
    Training training;

    public PetDog(double height, double weight, String colorEye, String colorWool, String name, String breed, Vac vac, String dateBirthday, Training training) {
        super(height, weight, colorEye, colorWool);
        setName(name);
        setBreed(breed);
        setIsVaccination(vac);
        setBirthday(dateBirthday);
        setTraining(training);
    }

    @Override
    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public void training(Animal animal) {
        if (animal instanceof IsTraining) {
            this.training = Training.Yes;
        }
    }

    public String getInfo() {
        return String.format("Домашний собакен.\n%s, Дресировка: %s", super.getInfo(), this.training);
    }

    public void makeSound() {
        System.out.println("Собакен: Bow wow wow");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void setIsVaccination(Vac vac) {
        this.vac = vac;
    }

    @Override
    public void setBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    @Override
    public void weasel() {
        System.out.printf("%s: ^_^ Хозяин, дай пожрать!\n", this.name);
    }
}
