//+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//        Пример 5
//        входные данные находятся в файле input.txt в виде
//        b 3
//        a 10
//        Результат нужно сохранить в файле input.txt
//        1000

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class task2_1 {
    public static void main(String[] args) throws FileNotFoundException {
        String pathLoad = "input.txt";
        File fileLoad = new File(pathLoad);
        String pathSave = "output.txt";
        File fileSave = new File(pathSave);
        Scanner scan = new Scanner(fileLoad);
        int[] arrayWithAB = getAb(fileLoad);
        String result = getPowerString(arrayWithAB);
        System.out.println(result);
        PrintWriter pw = new PrintWriter(fileSave);
        pw.println(result);
        pw.close();
    }
    public static String getPowerString(int[] ab) {
        String result = "";
        if (ab[0] == 0 && ab[1] == 0) {
            result = "Не определено";
        } else if (ab[1] < 0) {
            result = String.valueOf(1 / power(ab[0], ab[1]));
        } else {
            result = String.valueOf(power(ab[0], ab[1]));
        }
        return result;
    }
    public static int[] getAb(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        int[] ab = new int[2];
        while(scan.hasNextLine()) {
            String[] temp = scan.nextLine().trim().split(" +");
            for (String el:temp) {
                if ("a".equalsIgnoreCase(temp[0])) {
                    ab[0] = Integer.valueOf(temp[1]);
                } else {
                    ab[1] = Integer.valueOf(temp[1]);
                }
            }
        }
        scan.close();
        return ab;
    }
    public static int power(int a, int n){
        if (n == 0) return 1;
        else if (n % 2 == 0) return power(a * a, n / 2);
        else return a * power(a, n - 1);
    }
}