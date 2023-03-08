package Goods;

public class ProductWithVolume extends Good {
    protected int volume;

    public ProductWithVolume(String name, double price, int quantity, String unit, int volume) {
        super(name, price, quantity, unit);
        this.volume = volume < 0 ? 0 : volume;
    }

    public String toString() {
        return String.format("%s, Объём: %d л.", super.toString(), this.volume);
    }
}
