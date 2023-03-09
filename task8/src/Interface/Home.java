package Interface;

public interface Home {
    public enum Vac{
        Yes, No;
    }
    void setName(String name);
    void setBreed(String breed);
    void setIsVaccination(Vac vac);
    void setBirthday(String dateBirthday);
    String weasel();
}
