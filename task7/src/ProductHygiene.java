public class ProductHygiene extends Goods{
    private int count;
    public ProductHygiene(String name, double price, int quantity, String unit, int count) {
        super(name, price, quantity, unit);
        this.count = count < 0 ? 0 : count;
    }

    public String toString() {
        return String.format("%s, Объём: %d шт.", super.toString(), this.count);
    }
}
