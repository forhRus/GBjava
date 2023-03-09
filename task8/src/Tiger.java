import Base.Cat;
import Interface.Wild;

public class Tiger extends Cat implements Wild {
    String local;
    String date;
    public Tiger(int height, int weight, String colorEye, String colorWool, String local, String date) {
        super(height, weight, colorEye, colorWool);
        setHabitat(local);
        setLocationDate(date);
    }

    @Override
    public void setHabitat(String local) {
        this.local = local;
    }

    @Override
    public void setLocationDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return String.format("%s, Место обитания: %s, Последняя дата: %s", super.getInfo(), this.local, this.date);
    }
    public void makeSound(){
        System.out.println("Rrrrrr-rr");
    }
}
