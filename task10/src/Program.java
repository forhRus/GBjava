import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        // Создаём лист определённого размера
        int textLength = 6;
        MyList<Object> myList1 = new MyList<>(textLength);

        //  Заполняем массив элементами разных типов.
        for (int i = 0; i < textLength; i++) {
            if (i % 4 == 0) {
                double a = (double) ((int) (i * 2.12 * 100)) / 100;;
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
        myList2.set(0, "set");
        myList2.add(2, "addIndex");
        myList2.remove(1);
//        ["set", "addIndex", "Строка 2", Cat{name="Барсик", color="серый", height=200, weight=5, age=2}, 8.48, 5]


        System.out.println(myList2.indexOf("set")); // 0
        System.out.println(myList2.indexOf(1));     // -1
        System.out.println(myList2.indexOf(
                new Cat("Мурзик", 200, 5, 2, "серый"))); //-1
        System.out.println(myList2.indexOf(
                new Cat("Барсик", 200, 5, 2, "серый"))); //3
        System.out.println(myList2.indexOf(8.48));  // 4
        System.out.println(myList2.indexOf(5));     // 5



        System.out.println(myList2);





    }
}
