import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        // Создаём лист определённого размера
        int textLength = 6;
        MyList<Object> myList1 = new MyList<>(textLength);

        //  Заполняем массив элементами разных типов.
        for (int i = 0; i < textLength; i++) {
            if (i % 4 == 0) {
                double a = (double) ((int) (i * 2.12 * 100)) / 100;
                ;
                myList1.add(a);
            } else if (i % 3 == 0) {
                myList1.add(new Cat());
            } else if (i % 2 == 0) {
                myList1.add(String.format("Строка %d", i));
            } else {
                myList1.add(i);
            }
        }

        // делаем из myLista обычный массив
        Object[] arr = myList1.toArray();

        // создаем лист из массива
        MyList<Object> myList2 = new MyList<>(arr);

        //вывод содержимого листа на экран
        System.out.println(myList1);
        // [0.0, 1, "Строка 2", Cat{name="Барсик", color="серый", height=200, weight=5, age=2}, 8.48, 5]

        //тест методов
        myList2.set(0, "myList2.set()");
        myList2.add(2, "myList2.add(index, value)");
        myList2.remove(1);
//        ["set", "addIndex", "Строка 2", Cat{name="Барсик", color="серый", height=200, weight=5, age=2}, 8.48, 5]
//        ["myList2.set()", "myList2.add(index, value)", "Строка 2", Cat{name="Барсик", color="серый", height=200, weight=5, age=2}, 8.48, 5]

        System.out.println(myList2.indexOf("set")); // 0
        System.out.println(myList2.indexOf(1));     // -1
        System.out.println(myList2.indexOf(
                new Cat("Мурзик", 200, 5, 2, "серый"))); //-1
        System.out.println(myList2.indexOf(
                new Cat("Барсик", 200, 5, 2, "серый"))); //3
        System.out.println(myList2.indexOf(8.48));  // 4
        System.out.println(myList2.indexOf(5));     // 5
        System.out.println("___________________");

        System.out.println(myList2.contain("set")); // true
        System.out.println(myList2.contain(1));     // false
        System.out.println(myList2.contain(
                new Cat("Мурзик", 200, 5, 2, "серый"))); //false
        System.out.println(myList2.contain(
                new Cat("Барсик", 200, 5, 2, "серый"))); //true
        System.out.println(myList2.contain(8.48));  // true
        System.out.println(myList2.contain(5));     // true
        System.out.println("___________________");

//        сортирвока пузырьком (работает)
//        myList2.bubbleSotr();

        // сортировка простыми вставками (работает)
//        myList2.insertionSort();

        // сортирвока выбором
//        myList2.selectionSort();

        // удаление объекта по значению
//        myList2.add(4,5);
//        myList2.add(2,5);
//        myList2.remove((Integer) 5);

        // удаление всех объектов с заданным значением
//        myList2.removeAllContainedElements(5);

        System.out.println(myList2);
        System.out.println(myList2.maxElement()); //  myList2.add(index, value)
        System.out.println(myList2.minElement()); // Cat{name="Барсик", color="серый", height=200, weight=5, age=2} - вес 5

//        ["myList2.set()", "myList2.add(index, value)", "Строка 2", Cat{name="Барсик", color="серый", height=200, weight=5, age=2}, 8.48, 5]
//        13.0, 25.0, 8.0, 5.0, 8.48, 5.0
        System.out.println(myList2.sumElements()); // 64.48
        System.out.println(myList2.productElements()); // 551200.0

    }
}
