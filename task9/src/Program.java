import classesFigure.*;
import classesFigure.base.Figure;


public class Program {
    public static void main(String[] args) {
        System.out.println("Создание фигур, добавление в коллекцию");
        Collection col = new Collection();
        Figure f1 = new Quadrate(1);
        col.addFigure(f1); // успешно добавили квадрат (индекс 1)
        Figure fdel = new Quadrate(2);
        col.addFigure(fdel); // успешно добавили квадрат,а потом удалили(индекс 2)
        Figure f2 = new Rectangle(1, 2);
        col.addFigure(f2); // успешно добавили прямоугольник (индекс 2)
        Figure fErrorNegative = new Triangular(5, -1, 3);
        col.addFigure(fErrorNegative); // отрицательное значение, фигура не добавлена в коллекцию, но по имени доступна
        Figure f3 = new Triangular(4, 3, 4);
        col.addFigure(f3); // успешно добавили треугольник (индекс 3)
        Figure fErrosSide = new Triangular(3, 3, 7);
        col.addFigure(fErrosSide);  // сумма двух сторон у треугольника всегда больше чем третья. Фигура не добавлена
        Figure f4 = new Circle(3);
        col.addFigure(f4); // добавили окружность (индекс 4)
        col.printInfoAllFigures();

        System.out.println("Удаление, изменение фигур");
        col.removeFigure(2); //  Фигура "Квадрат" - удалёна
        col.changeFigure(1, 4);
        col.changeFigure(2, 2, 3);
        col.changeFigure(3, 2, 2, 2);
        col.changeFigure(4, 2, 3, 4);
        col.printInfoAllFigures();

        System.out.println("Сортировка");
        col.sortSquare();
        col.printInfoAllFigures();
    }
}
