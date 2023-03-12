package classesFigure.base;

import interfaceFigure.Square;

import java.util.ArrayList;
import java.util.List;

public class Figure implements Square, Comparable<Figure> {
    protected List<Integer> parameters = new ArrayList<>();
    protected String name;
    protected double square;

    @Override
    public double getSquare() {
        return this.square;
    }

    public String getName() {
        return this.name;
    }

    protected boolean checkPositiveList(List<Integer>lp) {
        for (Integer n:lp) {
            if(!isPositive(n)) {
                return false;
            }
        }
        return true;
    }

    protected boolean isPositive(int n)    {
        if (n > 0) {
            return true;
        } else {
            System.out.println("Возможны только положительные значения");
            return false;
        }
    }

    @Override
    public int compareTo(Figure o) {
        if(this.square > o.square) {
            return 1;
        } else if (this.square < o.square){
            return -1;
        } else {
            return 0;
        }
    }
}
