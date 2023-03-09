package classes;

import Base.Bird;

public class Stork extends Bird{

    public Stork(int height, int weight, String colorEye, double altitude) {
        super(height, weight, colorEye, altitude);

    }

    public void makeSound(){
        System.out.println("Аист: Qwic-Qwic");
    }

    public String getInfo() {
        return String.format("Аист.\n%s", super.getInfo());
    }
}
