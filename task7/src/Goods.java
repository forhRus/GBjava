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
    protected int id, quantity;
    protected String name, unit;
    protected double price;

    static {
        listId = new ArrayList<>();
        count = 0;
    }


    public void Goods(String name, double price, int quantity, String unit) {
        if(name.isEmpty()) {
            System.out.println("Ошибка ввода. Отсутствует наименование товара.");
        } else {
            this.id = generateId();
            this.name = name;
            setPrice(price);
            this.quantity = quantity < 0 ? 0 : quantity;
            this.unit = unit;
        }
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
        this.Goods("", 0, 0, "not indicated");
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
        }
        return count;
    }

}
