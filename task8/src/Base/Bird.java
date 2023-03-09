package Base;

import Interface.IsFly;

public abstract class Bird extends Animal implements IsFly {
    double altitude;
    public Bird(int height, int weight, String colorEye, double altitude ) {
        super(height, weight, colorEye);
        setFlightAltitude(altitude);
    }
    public void makeSound(){}
    public String getInfo() {
        return super.toString();
    }

    @Override
    public void setFlightAltitude(double altitude) {
        this.altitude = altitude;
    }
    @Override
    public String getInfoFlight(Animal animal) {
        if(animal instanceof IsFly) {
            return String.format("Я взлетаю на %.2f метра", this.altitude);
        } else {
            return animal + "не умеет летать";
        }

    }
}
