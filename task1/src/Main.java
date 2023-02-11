//Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[]args){
        int number = getNumberByUser("Введите номер триугольного числа: ");
        double triangularNumber = getTriangularNumber(number);
        System.out.printf("Число T%d = %.0f", number, triangularNumber);
    }
    //принимаем число
    public static int getNumberByUser(String text){
        System.out.print(text);
        return input.nextInt();
    }
    //определяем триугольное число
    public static double getTriangularNumber(int n){
        double a = 0.5 * n * (n + 1);
//        int a = (n + 1) * n / 2;
        return  a;
    }
}