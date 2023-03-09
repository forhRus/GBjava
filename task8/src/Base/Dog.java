package Base;
import Interface.*;

public abstract class Dog extends Animal implements IsWool{
    String colorWool;
    public Dog(double height, double weight, String colorEye, String colorWool) {
        super(height, weight, colorEye);
        setColorWool(colorWool);
    }

    public String getInfo() {
        return String.format("%s, Цвет шерсти: %s", super.getInfo(), this.colorWool);
    }


    @Override
    public void setColorWool(String colorWool) {
        this.colorWool = colorWool;
    }
}
