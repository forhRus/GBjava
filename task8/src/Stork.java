import Base.Bird;

public class Stork extends Bird {
    public Stork(int height, int weight, String colorEye, double altitude) {
        super(height, weight, colorEye, altitude);
    }
    public void makeSound(){
        System.out.println("Qwic-Qwic");
    }

}
