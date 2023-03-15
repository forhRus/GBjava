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

        CustomArray customArr = new CustomArray<>(num, numD, num,  cat1);
        customArr.add(c);
        customArr.add(str);
        System.out.println(customArr);

        System.out.println(customArr.indexOf(cat1));
        System.out.println(customArr.contain(cat3));

        customArr.remove(0);
        customArr.removeAllContainingElement(5);

        System.out.println(customArr);








    }
}
