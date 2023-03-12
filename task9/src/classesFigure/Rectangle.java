package classesFigure;

import classesFigure.base.Quadrilateral;

public class Rectangle extends Quadrilateral {
    public Rectangle(int sideA, int sideB) {
        if(isPositive(sideA) && isPositive(sideB)) {
            super.perimeter = (sideA + sideB) * 2;
            super.square = sideA * sideB;
            super.name = "Прямоугольник";
        } else {
            super.name = "";
        }
    }
}
