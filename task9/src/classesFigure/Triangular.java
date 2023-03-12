package classesFigure;

import classesFigure.base.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Triangular extends Polygon {
    public Triangular(int sideA, int sideB, int sideC) {
        List<Integer> l = new ArrayList<>();
        l.add(sideA);
        l.add(sideB);
        l.add(sideC);
        if (checkPositiveList(l) && checkSides(sideA, sideB, sideC)) {
            super.name = "Треугольник";
            super.parameters = l;
            super.perimeter = calculationPerimeter();
            super.square = calculateSquare(sideA, sideB, sideC);
        } else {
            super.name = "";
        }

    }

    private double calculateSquare(int a, int b, int c) {
        double p = super.perimeter / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public boolean checkSides(int a, int b, int c) {
        if (a + b > c && a + c > b && a < b + c) {
            return true;
        } else {
            System.out.println("Треугольника с такими сторонами существовать не может");
            return false;
        }
    }
}
