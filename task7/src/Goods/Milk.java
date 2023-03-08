package Goods;

public class Milk extends ProductWithVolume{
    private int date;
    private double procent;
    public Milk(String name, double price, int quantity, String unit, int volume, double procent, int date) {
        super(name, price, quantity, unit, volume);
        this.date = volume < 0 ? 0 : date;
        this.procent = procent < 0 ? 0 : procent;
    }

    public String toString() {
        return String.format("%s, %%-жир: %.1f, Срок год-ти: %d %s", super.toString(), this.procent, this.date, super.getDay(date));
    }
}
