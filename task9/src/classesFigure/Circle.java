package classesFigure;


import classesFigure.base.Figure;
import interfaceFigure.LengthCircle;


public class Circle extends Figure implements LengthCircle {
    private double length;

    public Circle(int radius) {
        if (isPositive(radius)) {
            super.name = "Окружность";
            this.length = 2 * Math.PI * radius;
            super.square = Math.PI * Math.pow(radius, 2);
        } else {
            super.name = "";
        }
    }

    @Override
    public double getLength() {
        return this.length;
    }

}
