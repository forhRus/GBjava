package Goods;

public class Egg extends ProductWithBestBeforeDate{
    private int count;
    public Egg(String name, double price, int quantity, String unit, int date, int count) {
        super(name, price, quantity, unit, date);
        this.count = count;
    }

    public String toString() {
        return String.format("%s, x%dшт ", super.toString(), this.count);
    }
}
