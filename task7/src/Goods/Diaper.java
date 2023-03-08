package Goods;

public class Diaper extends ProductChildren{
    private int size;
    private int minWeight;
    private int maxWeight;

    public Diaper(String name, double price, int quantity, String unit, int minAge, Alergen alergen, int size, int minWeight, int maxWeight) {
        super(name, price, quantity, unit, minAge, alergen);
        this.size = size;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public String toString() {
        return String.format("%s, Размер: %d, Вес: %d-%d",
                super.toString(), this.size, this.minWeight, this.maxWeight);
    }
}
