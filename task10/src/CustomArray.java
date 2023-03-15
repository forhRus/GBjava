import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray<T> {
    private List<T> customArr;

    public CustomArray(T o, T o1, T o2, T o3) {
        this.customArr = new ArrayList<>();
        add(o);
        add(o1);
        add(o2);
        add(o3);
    }
    public CustomArray(T o, T o1, T o2) {
        this(o, o1, o2, null);
    }
    public CustomArray(T o, T o1) {
        this(o, o1, null, null);
    }
    public CustomArray(T o) {
        this(o, null, null, null);
    }

    public CustomArray() {
    }

    public void add(T o) {
        if(o != null) {
            customArr.add(o);
        } else {
            System.out.println("Нельзя добавить null");
        }
    }
    public void remove(int index) {
        if (index > -1 && index < customArr.size() )
            customArr.remove(index);
        else
            System.out.println("Элемента с таким индексом не существует");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if(customArr.size() > 0) {
            res.append(checkElement(customArr.get(0)));
        }
        for (int i = 1; i < customArr.size(); i++) {
            res.append(", ");
            res.append(checkElement(customArr.get(i)));
        }
        res.append("]");
        return res.toString();
    }
    private String checkElement(T o) {
        String res = "";
        if(o instanceof Integer || o instanceof Double){
            return o.toString();
        } else if (o instanceof Character) {
            return String.format("'%s'", o);
        }else if (o instanceof String) {
            return String.format("\"%s\"", o);
        }else if (o instanceof Cat) {
            Cat cat = (Cat)o;
            return cat.toString();
        } else {
            return null;
        }
    }
    private boolean checkIndex(int i) {
        if (i > -1 && i < customArr.size() )
            return true;
        else
            return false;
    }
}
