import Goods.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    static List<Good> listOfGood;

    static {
        listOfGood = new ArrayList<>();
    }

    public static void printGood(Good g) {
        System.out.println(g.toString());
    }

    public static void printList() {
        for (Good good: listOfGood) {
            System.out.println(good.toString());
        }
    }

}
