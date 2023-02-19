import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//**ввод длинны массива, границ диаозона
//**создание и заполнение массива рандомными числами
//сортировка массива
//**вывод массива на экран
public class Main {
    static int sort = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int lengthArray = getIntByUser("Задайте длину массива случайных чисел: ");
        int[] unsortArray = new int[lengthArray];
        int minNumber = getIntByUser("Задайте минимальную границу диапозона: ");
        int maxNumber = getIntByUser("Задайте максимальную границу диапозона: ");
        fillArrayRandomNumber(unsortArray, minNumber, maxNumber );
        printArray(unsortArray);
        int[] sortedArray = sortByMerge(unsortArray);
        System.out.println("Несортированный массив");
        printArray(unsortArray);
    }

    static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

    static void fillArrayRandomNumber(int[] arr, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {

//          кусок кода, для генерации массива с уникальными значениями. max должно быть больше длины массива
//            while (true) {
//                int num = rand.nextInt(min, max);
//                boolean f = true;
//                for (int item : arr) {
//                    if (item == num) f = false;
//                }
//                if (f) {
//                    arr[i] = num;
//                    break;
//                }
//            }

//            это надо закоментить, чтобы генерировать уникальные значения
            arr[i] = rand.nextInt(min, max);
        }
    }
    static int getIntByUser(String msg) {
        while (true) {
            System.out.print(msg);
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.print("Ошибка ввода.");
            }
        }
    }

    static int[] sortByMerge(int[] arr) {
        if(arr.length == 1) return arr;
        int[] arrLeft = sortByMerge(Arrays.copyOf(arr, arr.length / 2));
        int[] arrRight = sortByMerge(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        System.out.println("Левый");
        printArray(arrLeft);
        System.out.println("Правый");
        printArray(arrRight);
        int ind1 = 0;
        int ind2 = 0;
        int ind3 = 0;
        int[] sortedArray = new int[arrLeft.length+arrRight.length];
        while (true) {
            if (arrLeft[ind1] <= arrRight[ind2]) {
                sortedArray[ind3] = arrLeft[ind1];
                ind1++;
            } else {
                sortedArray[ind3] = arrRight[ind2];
                ind2++;
            }
            ind3++;
            if (ind1 == arrLeft.length) {
                for (int i = ind2; i < arrRight.length ; i++) {
                    sortedArray[ind3] = arrRight[i];
                    ind3++;
                }
                break;
            }
            if (ind2 == arrRight.length) {
                for (int i = ind1; i < arrLeft.length ; i++) {
                    sortedArray[ind3] = arrLeft[i];
                    ind3++;
                }
                break;
            }

        }
        sort++;
        System.out.println("сортировка: " + sort);
        printArray(sortedArray);
        System.out.println();
        return sortedArray;
    }
}