package Base;

public class Dog extends Animal {
    public Dog(int height, int weight, String colorEye) {
        super(height, weight, colorEye);

    }
    public Animal() {
        this(0, 0, "empty");
    }
    public void makeSound(){}
    public String getInfo() {
        return String.format("Информация о животном, рост: %f, вес: %f," +
                " цвет глаз: %s", this.height, this.weight, this.colorEye);
    }
}
