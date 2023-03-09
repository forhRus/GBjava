package Base;
import Interface.IsWool;


public abstract class Cat extends Animal implements IsWool {
    String colorWool;
    public Cat(int height, int weight, String colorEye, String colorWool) {
        super(height,weight, colorEye);
        setColorWool(colorWool);
    }
    @Override
    public void setColorWool(String colorWool) {
        this.colorWool = colorWool;
    }
    @Override

    public String getInfo() {
        return String.format("%s, Цвет шерсти: %s", super.getInfo(), this.colorWool);
    }
    public void makeSound(){}
}
