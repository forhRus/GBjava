// * Продукты питания, содержащие следующие свойства:
//      * Срок годности
public class ProductWithBestBeforeDate extends Goods{
    protected int date;

    public ProductWithBestBeforeDate(String name, double price, int quantity, String unit, int date) {
        super(name, price, quantity, unit);
        this.date = date < 0 ? 0 : date;
    }
    public String toString() {
        return String.format("%s, Срок год-ти: %d %s", super.toString(), this.date, getDay(this.date));
    }
    private String getDay(int date) {
        int d = date % 10;
        if(d == 1)
            return "день";
        else if (d > 1 && d < 5)
            return "дня";
        else
            return "дней";
    }

}
