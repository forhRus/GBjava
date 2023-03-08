package Goods;

// * Продукты питания, содержащие следующие свойства:
//      * Срок годности
public class ProductWithBestBeforeDate extends Good {
    protected int date;

    public ProductWithBestBeforeDate(String name, double price, int quantity, String unit, int date) {
        super(name, price, quantity, unit);
        this.date = date < 0 ? 0 : date;
    }
    public String toString() {
        return String.format("%s, Срок год-ти: %d %s", super.toString(), this.date, super.getDay(this.date));
    }
}
