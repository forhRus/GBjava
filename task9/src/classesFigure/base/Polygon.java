package classesFigure.base;
import interfaceFigure.Perimeter;


/**
 * perimeter - хранит периметр
 * calculationPerimeter - вычисляет периметр складывая параметры сторон объекта
 */
public abstract class Polygon extends Figure implements Perimeter {
    protected int perimeter;
    public int getPerimeter() {
        return this.perimeter;
    }
    protected int calculationPerimeter() {
        int sum = 0;
        for (int p : super.parameters) {
            sum += p;
        }
        return sum;
    }
}
