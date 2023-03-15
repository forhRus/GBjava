import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int num = 5;
        double numD = 3.15;
        String str = "Строка";
        char c = 88;
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Барсик", 200, 5, 2, "серый");
        Cat cat3 = new Cat("Мурзик", 180, 3, 1, "черный");

        List<Object> myArray = new ArrayList<>();
        myArray.add(num);
        myArray.add(numD);
        myArray.add(str);
        myArray.add(num);
        myArray.add(c);
        myArray.add(cat1);

        CustomArray testArr = new CustomArray(myArray);
        testArr.add(5);
        System.out.printf("Длина массива: %d\n",testArr.size());
        System.out.println(testArr);

        System.out.println(testArr.indexOf(cat1));
        System.out.println(testArr.contain(cat3));

        testArr.remove(1);
        testArr.removeAllContainingElement(5);
        testArr.removeAllContainingElement(cat2);
        System.out.println(testArr);

        System.out.printf("Получение элементак по индексу: %s\n", testArr.get(1));

    }
}
