public class MyList<T> {
    private Object[] array;
    final private int DEFAULT_LENGTH = 10;
    final private Object[] EMPTY_ARRAY = {};
    private int size;

    // Создание листа заданной длинны
    public MyList(int length) {
        if (length > 0) {
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
        this.array = new Object[(int) (length * 1.5)];
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
        if (obj != null) {
            array[size] = obj;
            size++;
        } else {
            System.out.println("Нельзя добавить null");
        }
    }

    //  проверяем, надо ли увеличить массив
    private void checkLength() {
        if (this.size == this.array.length) {
            Object[] newArray = new Object[(int) (this.size * 1.5)];
            this.array = copy(this.array, newArray);
        }
    }

    // Добавление элемента по индексу
    public void add(int index, T obj) {
        if (checkIndex(index)) {
            checkLength();
            for (int i = this.size; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = obj;
            size++;
        }
    }

    //  Присваиваем элементу с индексом нвоое значение
    public void set(int index, T obj) {
        if (checkIndex(index)) {
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

    // удаление элемента по индексу
    public void remove(int index) {
        if (checkIndex(index)) {
            for (int i = index; i < this.size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.size--;
            this.array[this.size] = null;
        }

    }

    public void remove(T obj) {
        for (int i = 0; i < this.size; i++) {
            if(this.array[i].equals(obj)){
                remove(i);
                break;
            }
        }
    }

    public void removeAllContainedElements(T obj) {
        while (contain(obj)) {
            remove(obj);
        }
    }

    // размер листа
    public int size() {
        return this.size;
    }

    // очистить лист
    public void clean(Object[] obj) {
        this.array = new Object[DEFAULT_LENGTH];
        this.size = 0;
    }

    // вернуть индекс искомого элемента
    public int indexOf(T obj) {
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    // содержиться ли элемент в списке
    public boolean contain(T obj) {
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    // сортировка пузырьком
    public void bubbleSotr() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                double value = valueElement(array[j]);
                double nextValue = valueElement(array[j + 1]);
                if (value > nextValue) {
                    swapElement(j, j + 1);
                }
            }
        }
    }

    // сортировка простым вставками
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            double value = valueElement(array[i]);
            Object tempO = array[i];
            int index = i - 1;
            while (index >= 0 && value < valueElement(array[index])) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = tempO;
        }
    }

    // сортировка выбором
    public void selectionSort() {

        for (int i = 0; i < this.size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.size; j++) {
                if (valueElement(array[minIndex]) > valueElement(array[j])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swapElement(minIndex, i);
            }
        }
    }

    // свап для сортировок
    private void swapElement(int i, int j) {
        Object temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    //  определение значения для сравнивания объектов и арифметичческих действий
    private double valueElement(Object obj) {
        if (obj instanceof String) {
            return (double) ((String) obj).length();
        } else if (obj instanceof Cat) {
            Cat c = (Cat) obj;
            return (double) c.getWeight();
        } else if (obj instanceof Integer) {
            return (int) obj * 1.;
        } else if (obj instanceof Double) {
            return (double) obj;
        } else {
            return 0.0;
        }
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (this.size > 0) {
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
        if (obj instanceof Integer || obj instanceof Double) {
            return obj.toString();
        } else if (obj instanceof Character) {
            return String.format("'%s'", obj);
        } else if (obj instanceof String) {
            return String.format("\"%s\"", obj);
        } else if (obj instanceof Cat) {
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
        if (checkIndex(index)) {
            return this.array[index];
        } else {
            String error = "Элеменат с таким индексом не существует";
            return (Object) error;
        }
    }


}
