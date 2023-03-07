public class Bread extends ProductWithBestBeforeDate {
    private String typeFlour;

    public Bread(String name, double price, int quantity, String unit, int date, String typeFlour) {
        super(name, price, quantity, unit, date);
        this.typeFlour = typeFlour;
    }

    public String toString() {
        return String.format("%s Вид муки: %s", super.toString(), typeFlour);
    }
}
