//+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//        Пример 5
//        входные данные находятся в файле input.txt в виде
//        b 3
//        a 10
//        Результат нужно сохранить в файле input.txt
//        1000

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
public class task2_1 {
    public static void main(String[] args) throws FileNotFoundException{
        String pathLoad = "input.txt";
        String pathSave = "output.txt";
        int[] arrayWithAB = getArgsFromFile(pathLoad);
        int a = arrayWithAB[0];
        int b = arrayWithAB[1];
        String result = String.format("Число %s в степени %s: %s\n", a, b, getPowerString(a, b));
        saveFile(pathSave, result);
    }

    //функция записывает результат в файл
    public static void saveFile(String path, String data) {
        File f = new File(path);
        FileWriter fw = null;
        try {
            fw = new FileWriter(f,true);
            fw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace(); //бессовестно скопипастил
            }
        }
    }

    //  Проверка переменных для вычисления
    public static String getPowerString(int a, int b) {
        String result = "";
        if (a == 0 && b == 0) {
            result = "Не определено";
        } else if (b < 0) {
            result = String.valueOf(1 / power(a, b));
        } else {
            result = String.valueOf(power(a, b));
        }
        return result;
    }

    //  Получение числа и степени из файла
    public static int[] getArgsFromFile(String path) throws FileNotFoundException {
        File f = new File(path);
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

    //  возведение числа в степень
    public static int power(int a, int n){
        if (n == 0) return 1;
        else if (n % 2 == 0) return power(a * a, n / 2);
        else return a * power(a, n - 1);
    }
}