import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray<T> {
    private List<T> customArr;
    private int size;

    public CustomArray(List<T> arr) {
        size = 0;
        this.customArr = new ArrayList<>();
        for (T el: arr) {
            this.customArr.add(el);
            size++;
        }
    }

    public CustomArray() {
        size = 0;
        this.customArr = new ArrayList<>();
    }

    public void add(T o) {
        if(o != null) {
            customArr.add(o);
            size++;
        } else {
            System.out.println("Нельзя добавить null");
        }
    }
    public void remove(int index) {
        if (index > -1 && index < customArr.size() ){
            customArr.remove(index);
            size--;
        }
        else
            System.out.println("Элемента с таким индексом не существует");
    }
    public int size(){
        return this.size;
    }
    public void removeAllContainingElement(T o){
        while (customArr.contains(o)) {
            customArr.remove(o);
        }
    }
    public int indexOf(T o) {
        for (int i = 0; i < customArr.size(); i++) {
            if(customArr.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contain(T o) {
        for (int i = 0; i < customArr.size(); i++) {
            if(customArr.get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if(customArr.size() > 0) {
            res.append(elementToString(customArr.get(0)));
        }
        for (int i = 1; i < customArr.size(); i++) {
            res.append(", ");
            res.append(elementToString(customArr.get(i)));
        }
        res.append("]");
        return res.toString();
    }
    private String elementToString(T o) {
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
    public T get(int index) {
        if(checkIndex(index)) {
            return customArr.get(index);
        } else {
            String error = "Элеменат с таким индексом не существует";
            return (T)error;
        }
    }
//    public void setElement(int index, T obj) {
//        if (checkIndex(index)) {
//            customArr.get(index) = obj;
//        }
//    }
}
