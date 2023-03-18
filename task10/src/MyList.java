public class  MyList <T>{
    private Object[] array;
    final private int DEFAULT_LENGTH = 10;
    final private Object[] EMPTY_ARRAY = {};
    private int size;

    // Создание листа заданной длинны
    public MyList(int length) {
        if(length > 0) {
            this.array = new Object[length];
        } else if (length == 0) {
            this.array = new Object[DEFAULT_LENGTH];
        } else {
            System.out.println("Длина меньше нуля. Пока не умею обрабатывать ошибки!");
        }
    }

    //  Создание листа из массива
     public MyList(Object[] arr) {
        int length = arr.length;
        this.array = new Object[(int)(length*1.5)];
         for (int i = 0; i < length; i++) {
             add(arr[i]);
         }
    }

    // дефолтный конструктор листа
    public MyList() {
        this.array = new Object[DEFAULT_LENGTH];
        this.size = 0;
    }

    //  получение массива из листа
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = this.array[i];
        }
        return arr;
    }

    // добавление элемента в лист
    public void add(Object obj) {
        checkLength();
        if(obj != null) {
            array[size] = obj;
            size++;
        } else {
            System.out.println("Нельзя добавить null");
        }
    }

    //  проверяем, надо ли увеличить массив
    private void checkLength(){
        if(this.size == this.array.length) {
            Object[] newArray = new Object[(int)(this.size*1.5)];
            this.array = copy(this.array, newArray);
        }
    }

    // Добавление элемента по индексу
    public void add(int index, T obj) {
        if(checkIndex(index)) {
            checkLength();
            for (int i = this.size; i > index; i--) {
                this.array[i] = this.array[i-1];
            }
            this.array[index] = obj;
            size++;
        }
    }

    //  Присваиваем элементу с индексом нвоое значение
    public void set(int index, T obj) {
        if(checkIndex(index)) {
            this.array[index] = obj;
        }
    }


    // кпирование масивов для увеличение листа, если он заполнен
   private Object[] copy(Object[] arr, Object[] result) {
        for (int i = 0; i < result.length; i++) {
            if (i < arr.length) {
                result[i] = arr[i];
            } else {
                result[i] = null;
            }
        }
        return result;
    }


    public void remove(int index) {
       if(checkIndex(index)) {
           for (int i = index; i < this.size-1; i++) {
                this.array[i] = this.array[i+1];
           }
           this.size--;
           this.array[this.size] = null;
       }

    }
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
            result.append(elementToString(this.array[0]));
        }
        for (int i = 1; i < this.size; i++) {
            result.append(", ");
            result.append(elementToString(this.array[i]));
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
    private boolean checkIndex(int i) {
        if (i > -1 && i < this.size)
            return true;
        else
            System.out.println("Элеменат с таким индексом не существует");
            return false;
    }
    public Object get(int index) {
        if(checkIndex(index)) {
            return this.array[index];
        } else {
            String error = "Элеменат с таким индексом не существует";
            return (Object) error;
        }
    }


}
