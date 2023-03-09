import Base.*;
public class Cat extends Animal implements IsWool, Home{
    String colorWool;
    String name;
    String breed;
    Vac vac;
    String dateBirthday;
    public Cat(int height, int weight, String colorEye, String colorWool, String name, String breed, Vac vac, String dateBirthday) {
        super(height,weight, colorEye);
        setColorWool(colorWool);
        setName(name);
        setBirthday(breed);
        setIsVaccination(vac);
        setBirthday(dateBirthday);
    }
    @Override
    public void setColorWool(String colorWool) {
        this.colorWool = colorWool;
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
}
