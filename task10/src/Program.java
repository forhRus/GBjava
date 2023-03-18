import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(123);
        myList.add(22);
        myList.add(33);
        System.out.println(myList.size());


    }
}
