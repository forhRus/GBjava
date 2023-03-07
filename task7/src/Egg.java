public class Egg extends ProductWithBestBeforeDate{
    private int count;
    public Egg(String name, double price, int quantity, String unit, int date, int count) {
        super(name, price, quantity, String.format("%s х%d шт", unit, count), date);
        this.count = count;
    }


    public String toString() {
        return super.toString();
    }
}
