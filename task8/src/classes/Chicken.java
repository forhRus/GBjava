package classes;

import Base.Bird;

public class Chicken extends Bird{
    public Chicken(double height, double weight, String colorEye, double altitude) {
        super(height, weight, colorEye, altitude);
    }
    public String getInfo() {
        return String.format("Курица.\n%s", super.getInfo());
    }
    public void makeSound(){
        System.out.println("Курица: Kudah - kudah");
    }

}
