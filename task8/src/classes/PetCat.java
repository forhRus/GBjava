package classes;

import Base.*;
import Interface.Home;

public class PetCat extends Cat implements Home {
    String name;
    String breed;
    Vac vac;
    String dateBirthday;
    public PetCat(double height, double weight, String colorEye, String colorWool, String name, String breed, Vac vac, String dateBirthday) {
        super(height,weight, colorEye, colorWool);
        setName(name);
        setBreed(breed);
        setIsVaccination(vac);
        setBirthday(dateBirthday);
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
        System.out.printf("%s: ^_^ Хозяин, дай пожрать!\n", this.name);}
    public String getInfo() {
        return String.format("Домашняя кошка.\nКличка: %s, Порода: %s, Дата рож: %s," +
                " Вакцицинация: %s,\n%s", this.name, this.breed, this.dateBirthday, this.vac, super.getInfo());
    }
    public void makeSound(){
        System.out.println("Кошка: Мяу");
    }
}
