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
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;
    protected String unit;


    public void Goods(int id, String name, double price, int quantity, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
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
}
