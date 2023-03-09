import Base.*;
import Interface.Home;

public class PetCat extends Cat implements Home {
    String name;
    String breed;
    Vac vac;
    String dateBirthday;
    public PetCat(int height, int weight, String colorEye, String colorWool, String name, String breed, Vac vac, String dateBirthday) {
        super(height,weight, colorEye, colorWool);
        setName(name);
        setBirthday(breed);
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
    public String weasel() {
        return "=^_^= Хозяин, дай жрать!";
    }
    public String getInfo() {
        return String.format("%s, Домашний питомец: %s, Порода: %s, Дата рож: %s," +
                " Вакцицинация: %s", super.getInfo(), this.name, this.breed, this.dateBirthday, this.vac);
    }
    public void makeSound(PetCat cat){
        System.out.println("Мяу");
    }
}
