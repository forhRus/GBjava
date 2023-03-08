package Goods;

public class Pacifier extends ProductChildren {


    public Pacifier(String name, double price, int quantity, String unit, int minAge, Alergen alergen) {
        super(name, price, quantity, unit, minAge, alergen);
    }

    public String toString() {
        return super.toString();
    }
}
