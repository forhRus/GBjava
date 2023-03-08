package Goods;

import java.util.ArrayList;

/**
 * Класс товар, содержащий следующие свойства:
 * 1. Название
 * 2. Цена
 * 3. Количество
 * 4. Единица измерения
 */
public class Good {
    private static ArrayList<Integer> listId;
    private static int count;
    private int id, quantity;
    private String name, unit;
    private double price;

    static {
        listId = new ArrayList<>();
        count = 0;
    }

    public Good(String name, double price, int quantity, String unit) {
        this.id = generateId();
        this.name = name;
        setPrice(price);
        this.quantity = quantity < 0 ? 0 : quantity;
        this.unit = unit;

    }

    public Good(String name, double price, int quantity) {
        this(name, price, quantity, "not indicated");
    }

    public Good(String name, double price) {
        this(name, price, 0, "not indicated");
    }

    public Good(String name) {
        this(name, 0, 0, "not indicated");
    }

    public Good() {
        this("", 0, 0, "not indicated");
    }


    public void setPrice(double price) {
        this.price = price < 0 ? 0 : price;
    }

    public void addQuantity(int quantity) {
        this.quantity = quantity < 0 ?
                this.quantity - quantity :
                this.quantity + quantity;
    }

    @Override
    public String toString() {

        String p = String.format("%d руб %02d коп", (int)this.price, (int)this.price%1*100);
        return String.format("id: %d, Наименование: %s, Цена: %s, Кол-во: %d %s",
                this.id, this.name, p, this.quantity, this.unit);
    }

    private int generateId() {
        if (listId.size() < count) {
            for (int i = 1; i <= count; i++) {
                if (listId.indexOf(i) == -1)
                    return i;
            }
        } else {
            listId.add(++count);
        }
        return count;
    }

    public String getDay(int date) {
        int d = date % 10;
        if(d == 1)
            return "день";
        else if (d > 1 && d < 5)
            return "дня";
        else
            return "дней";
    }
}
