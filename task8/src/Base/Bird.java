package Base;

import Interface.IsFly;

public abstract class Bird extends Animal implements IsFly{
    double altitude;


    public Bird(double height, double weight, String colorEye, double altitude) {
        super(height, weight, colorEye);
        setFlightAltitude(altitude);
    }



    public String getInfo() {
        return super.getInfo();
    }


    @Override
    public void setFlightAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public void getInfoFlight() {
        System.out.printf("Эта птица взлетает на %.1f метров\n",  this.altitude);
    }
}
