package ex1_calc;

import ex1_calc.*;
import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    public double inputNumber(String title) {
        System.out.print(title);
        double number = 0;
        try{
            number = sc.nextDouble();

        } catch (Exception e){
            System.out.println("Ошибка");
        }
        return number;
    }
    public void print(String message) {
        System.out.println(message);
    }

    int choiceMenu(String[] arr, String message){
        System.out.println(message);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d. %s\n", i+1, arr[i]);
        }
        int i = -1;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("ошибка ввода");
        }
        return i;
    }
    public void printComplex (Complex number) {// используется для форматирования вывода
        System.out.printf("Ответ: %s\n", number);
    }

}
