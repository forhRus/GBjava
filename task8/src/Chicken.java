import Base.Bird;

public class Chicken extends Bird {
    public Chicken(int height, int weight, String colorEye, double altitude) {
        super(height, weight, colorEye, altitude);
    }
    public void makeSound(){
        System.out.println("Kudah - kudah");
    }
}
