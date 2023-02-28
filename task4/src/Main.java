import java.util.Random;
import java.util.Scanner;

public class Main {
    static int sort = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int lengthArray = getIntByUser("Задайте длину массива случайных чисел: ");
        int[] unsortArray = new int[lengthArray];
        int minNumber = getIntByUser("Задайте минимальную границу диапозона: ");
        int maxNumber = getIntByUser("Задайте максимальную границу диапозона: ");
        fillArrayRandomNumber(unsortArray, minNumber, maxNumber );
        System.out.println();

        System.out.println("Несортированный массив");
        printArray(unsortArray);

        heapSort(unsortArray);

        System.out.println("Отсортированный массив: ");
        printArray(unsortArray);
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

    static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--){
            swap(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            swap(arr, i, 0);
        }
    }

    // Строим дерево
    static void swap(int arr[], int n, int i) {
        int indexRoot = i;  //  Корень
        int indexB1 = 2 * i + 1;  //  Ветка 1
        int indexB2 = 2 * i + 2;  //  Ветка 2

        if (indexB1 < n && arr[indexB1] > arr[indexRoot]){
            indexRoot = indexB1;
        }

        if (indexB2 < n && arr[indexB2] > arr[indexRoot]){
            indexRoot = indexB2;
        }

        if (indexRoot != i) {
            int swap = arr[i];
            arr[i] = arr[indexRoot];
            arr[indexRoot] = swap;
            swap(arr, n, indexRoot);
        }
    }

    static void printArray(int arr[]) {
        for (int item:arr) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
