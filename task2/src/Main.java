//+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//        Пример 1: а = 3, b = 2, ответ: 9
//        Пример 2: а = 2, b = -2, ответ: 0.25
//        Пример 4: а = 0, b = 0, ответ: не определено
// 1. ввод числа
// 2. ввод степени
// функция возведения в степень
// функция чтения из файла
// функция записи в файл
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int a, b;
        a = getNumberByUser("Веведите число: ");
        b = getNumberByUser("Веведите степень: ");
        printPower(a, b);
    }
    public static void printPower(int a, int b) {
        if (a == 0 && b == 0) System.out.println("Не определено");
        else if (b < 0) System.out.println(1 / getPower(a, b));
        else System.out.printf("Число %d в степени %d: %d", a, b, getPower(a, b));
    }
    public static int getNumberByUser(String text) {
        System.out.print(text);
        return input.nextInt();
    }
    public static int getPower(int a, int n){
        if (n == 0) return 1;
        else if (n % 2 == 0) return getPower(a * a, n / 2);
        else return a * getPower(a, n - 1);
    }

}
