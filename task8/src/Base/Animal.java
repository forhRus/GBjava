package Base;

public abstract class Animal {
    int height;
    int weight;
    String colorEye;
    public Animal(int height, int weight, String colorEye) {
        this.height = height;
        this.weight = weight;
        this.colorEye = colorEye;
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
