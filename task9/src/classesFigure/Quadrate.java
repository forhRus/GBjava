package classesFigure;

import classesFigure.base.Quadrilateral;

/**
 * count - для уникального имени
 * имя и площадь отправляем
 */
public class Quadrate extends Quadrilateral {
    public Quadrate(int sideA) {
        if(isPositive(sideA)) {
            super.perimeter = sideA * 4;
            super.square = Math.pow(sideA, 2);
            super.name = "Квадрат";
        } else {
            super.name = "";
        }
    }
}
