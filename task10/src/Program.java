import java.math.RoundingMode;

public class Program {
    public static void main(String[] args) {
        int textLength = 15;
        MyList<Object> myList1 = new MyList<>(textLength);
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
        System.out.println(myList1);


        MyList<Object> myList2 = new MyList<>();
        myList2.add(123);
        myList2.add(22);
        myList2.add(33);
        System.out.println(myList2.size());


    }
}
