import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс товар, содержащий следующие свойства:
 * 1. Название
 * 2. Цена
 * 3. Количество
 * 4. Единица измерения
 */
public class Goods {
    protected static ArrayList <Integer> listId;
    private static int count;
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;
    protected String unit;
    static {
        listId = new ArrayList<>();
        count = 0;
    }


    public void Goods(String name, double price, int quantity, String unit) {
        this.id = 0;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;

    }

    public void Goods(String name, double price, int quantity) {
        Goods(name, price, quantity, "not indicated");
    }
    public void Goods(String name, double price) {
        this.Goods(name, price, 0, "not indicated");
    }
    public void Goods(String name) {
        this.Goods(name, 0, 0, "not indicated");
    }
    public void Goods() {
        this.Goods("no name", 0, 0, "not indicated");
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void addQuantity(int quantity) {
        if(quantity < 0) {
            this.quantity -= quantity;
            if (this.quantity < 0) this.quantity = 0;
        } else {
            this.quantity += quantity;
        }
    }

    @Override
    public String toString() {
        return String.format("id: %d; Наименование т-ра: %s; Цена: %.2f; Кол-во: %d; " +
                "Ед.измерения: %s", this.id, this.name, this.price, this.quantity, this.unit);
    }
    private int generateId() {
        if (listId.size() < count) {
            for (int i = 1; i <= count; i++) {
                if(listId.indexOf(i) == -1)
                    return i;
            }
        } else {
            listId.add(++count);
            return count;
        }
    }
}
