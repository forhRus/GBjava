public class Main {
    public static void main(String args[]) {
        int arr[] = {14, 2, 4, 9, 7, 17, 8, 5, 6, 3, 7, 1};
        sort(arr);
        System.out.print("Отсортированный массив: ");
        printArray(arr);
    }

    static void sort(int arr[]) {
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
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
