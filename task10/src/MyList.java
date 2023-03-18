import java.util.ArrayList;

public class  MyList <T>{
    private Object[] arr;
    final private int DEFAULT_LENGTH = 10;
    private int size;

    public MyList(int length) {
        if(length > 0) {
            this.arr = new Object[length];
        } else if (length == 0) {
            this.arr = new Object[DEFAULT_LENGTH];
        } else {
            System.out.println("Длина меньше нуля. Пока не умею обрабатывать ошибки!");
        }
    }

    public MyList(T[] arr) {
        size = arr.length;
        this.arr = new Object[(int)(size*1.5)];
        for (int i = 0; i < size; i++) {
            this.arr[i] = arr[i];
        }
    }

    public MyList() {
        this.arr = new T[10];
        this.size = 0;
    }

    public void add(T obj) {
        if(obj != null) {
            customArr.add(obj);
            size++;
        } else {
            System.out.println("Нельзя добавить null");
        }
    }
    public void add(int index, T obj) {
        if(checkIndex(index)) {
            this.customArr.add(index, obj);
        } else {
            String error = "Элеменат с таким индексом не существует";
        }

    }
    public void set(int index, T obj) {
        if(checkIndex(index)) {
            this.customArr.set(index, obj);
        } else {
            String error = "Элеменат с таким индексом не существует";
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
    public void removeAllContainingElement(T obj){
        while (customArr.contains(obj)) {
            customArr.remove(obj);
        }
    }
    public int indexOf(T obj) {
        for (int i = 0; i < customArr.size(); i++) {
            if(customArr.get(i).equals(obj)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contain(T obj) {
        for (int i = 0; i < customArr.size(); i++) {
            if(customArr.get(i).equals(obj)) {
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
    private String elementToString(T obj) {
        String res = "";
        if(obj instanceof Integer || obj instanceof Double){
            return obj.toString();
        } else if (obj instanceof Character) {
            return String.format("'%s'", obj);
        }else if (obj instanceof String) {
            return String.format("\"%s\"", obj);
        }else if (obj instanceof Cat) {
            Cat cat = (Cat) obj;
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


}
