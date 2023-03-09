package Base;

import classes.PetCat;

public abstract class Animal {
    double height;
    double weight;
    String colorEye;
    public Animal(double height, double weight, String colorEye) {
        this.height = height;
        this.weight = weight;
        this.colorEye = colorEye;
    }
    public Animal() {
        this(0, 0, "empty");
    }

    public String getInfo() {
        return String.format("Информация о животном. рост: %.1f см, вес: %.1f кг, " +
                "цвет глаз: %s", this.height, this.weight, this.colorEye);
    }
    public void makeSound(){}
}
