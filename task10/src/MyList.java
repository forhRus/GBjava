public class  MyList <T>{
    private Object[] list;
    final private int DEFAULT_LENGTH = 10;
    final private Object[] EMPTY_ARRAY = {};
    private int size;

    public MyList(int length) {
        if(length > 0) {
            this.list = new Object[length];
        } else if (length == 0) {
            this.list = new Object[DEFAULT_LENGTH];
        } else {
            System.out.println("Длина меньше нуля. Пока не умею обрабатывать ошибки!");
        }
    }

//     public MyList(List<Object> list) {
//         for (int i = 0; i < list.size(); i++) {
//             add(list.get(i));
//         }
//    }

    public MyList() {
        this.list = new Object[DEFAULT_LENGTH];
        this.size = 0;
    }

    public void add(Object obj) {
        if(obj != null) {
            list[size] = obj;
            size++;
        } else {
            System.out.println("Нельзя добавить null");
        }
    }

//    public void add(int index, T obj) {
//        if(checkIndex(index)) {
//            this.customArr.add(index, obj);
//        } else {
//            String error = "Элеменат с таким индексом не существует";
//        }
//
//    }
//    public void set(int index, T obj) {
//        if(checkIndex(index)) {
//            this.customArr.set(index, obj);
//        } else {
//            String error = "Элеменат с таким индексом не существует";
//        }
//
//    }
//    public void remove(int index) {
//        if (index > -1 && index < customArr.size() ){
//            customArr.remove(index);
//            size--;
//        }
//        else
//            System.out.println("Элемента с таким индексом не существует");
//    }
    public int size(){
        return this.size;
    }
//    public void removeAllContainingElement(T obj){
//        while (customArr.contains(obj)) {
//            customArr.remove(obj);
//        }
//    }
//    public int indexOf(T obj) {
//        for (int i = 0; i < customArr.size(); i++) {
//            if(customArr.get(i).equals(obj)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    public boolean contain(T obj) {
//        for (int i = 0; i < customArr.size(); i++) {
//            if(customArr.get(i).equals(obj)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if(this.size > 0) {
            result.append(elementToString(this.list[0]));
        }
        for (int i = 1; i < this.size; i++) {
            result.append(", ");
            result.append(elementToString(this.list[i]));
        }
        result.append("]");
        return result.toString();
    }
    private String elementToString(Object obj) {
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
//    private boolean checkIndex(int i) {
//        if (i > -1 && i < customArr.size() )
//            return true;
//        else
//            return false;
//    }
//    public T get(int index) {
//        if(checkIndex(index)) {
//            return customArr.get(index);
//        } else {
//            String error = "Элеменат с таким индексом не существует";
//            return (T)error;
//        }
//    }


}
