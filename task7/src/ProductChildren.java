public class ProductChildren extends Goods{
    private int minAge;
    private Alergen alergen;
    enum Alergen {
        Да, Нет;
    }
    public ProductChildren(String name, double price, int quantity, String unit, int minAge, Alergen alergen) {
        super(name, price, quantity, unit);
        this.minAge = minAge < 0 ? 0 : minAge;
        this.alergen = alergen;
    }

    public String toString() {
        return String.format("%s, Мин. возраст: %d Гипоаллер-ть: %s", super.toString(), this.minAge, this.alergen);
    }
}
