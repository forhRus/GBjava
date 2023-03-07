public class ProductHygiene extends Goods{
    private int countInPack;
    public ProductHygiene(String name, double price, int quantity, String unit, int countInPack) {
        super(name, price, quantity, unit);
        this.countInPack = countInPack < 0 ? 0 : countInPack;
    }

    public String toString() {
        return String.format("%s, в упаковке %dшт.", super.toString(), this.countInPack);
    }
}
