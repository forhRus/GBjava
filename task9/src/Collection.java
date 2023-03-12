import classesFigure.Circle;
import classesFigure.Quadrate;
import classesFigure.Rectangle;
import classesFigure.Triangular;

import classesFigure.base.Figure;
import interfaceFigure.LengthCircle;
import interfaceFigure.Perimeter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Коллекция
 * figures - создаём коллекцию фигур при создании объекта
 * addFigure - добавить фигуру
 * printInfoFigure - вывод инфо (периметр или длина окружности в зависимости от интерфейса)
 * printInfoAllFigures - вывод информации о всех фигурах в коллекции
 * removeFigure - удалить фигуру из коллеции по индексу
 *
 * checkIndex - проверка на наличие элемента в коллекции
 */
public class Collection {
    private List<Figure> figures;

    public Collection() {
        this.figures = new ArrayList<>();
    }
    public void addFigure(Figure figure) {
        if(figure.getName().isEmpty()){
            System.out.println("Не удалось добавить фигуру");
        } else {
            this.figures.add(figure);
        }
    }
    private void addChangeFigure(int index, Figure figure) {
        if(figure.getName().isEmpty()){
            System.out.println("Не удалось изменить фигуру");
        } else {
            this.figures.remove(index);
            this.figures.add(index, figure);
        }
    }

    private void printInfoFigure(Figure figure) {
        System.out.printf("%s\nПлощадь: %.1f\n", figure.getName(), figure.getSquare());
        if (figure instanceof LengthCircle) {
            System.out.printf("Длина: %.1f\n", ((LengthCircle) figure).getLength());
        } else if (figure instanceof Perimeter) {
            System.out.printf("Периметр: %d\n", ((Perimeter) figure).getPerimeter());
        }
        System.out.println();
    }

    public void printInfoAllFigures() {
        int n = 0;
        String f = "Фигура";
        for (Figure figure : this.figures) {
            System.out.printf("%s №%d\n", f, ++n);
            printInfoFigure(figure);
        }
        System.out.println("___________________");
    }

    public void removeFigure(int index) {
        if (checkIndex(index)) {
            figures.remove(--index);
        }
    }

    public void changeFigure(int index, int value1, int value2, int value3) {
        index--;
        Figure f = figures.get(index);
        if (f instanceof Circle) {
            f = new Circle(value1);
        } else if(f instanceof Quadrate){
            f = new Quadrate(value1);
        }else if(f instanceof Rectangle){
            f = new Rectangle(value1, value2);
        }else if(f instanceof Triangular){
            f = new Triangular(value1, value2, value3);
        } else {
            System.out.println("Нет типа");
        }
        addChangeFigure(index, f);
    }
    public void changeFigure(int index, int value1, int value2) {
        changeFigure(index, value1, value2, 0);
    }
    public void changeFigure(int index, int value1) {
        changeFigure(index, value1, 0, 0);
    }


    private boolean checkIndex(int i) {
        if (i > 0 && i <= figures.size()) {
            return true;
        } else {
            System.out.println("Ошибка. Элемента с таким индексом не существует.");
            return false;
        }
    }

    private int inputParameter(Scanner sc) {
        int n;
        while (true) {
            if(sc.hasNextInt()) {
                n = sc.nextInt();
                if(isPositive(n)) {
                    return n;
                }
            } else {
                System.out.println("Введите число");
            }
        }
    }
    private boolean isPositive(int n)    {
        if (n > 0) {
            return true;
        } else {
            System.out.println("Возможны только положительные значения");
            return false;
        }
    }
    public void sortSquare(){
        Collections.sort(figures);
    }
}
