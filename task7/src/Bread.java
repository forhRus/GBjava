public class Bread extends ProductWithBestBeforeDate{
    private String typeFlour;
    public Bread(String name, double price, int quantity, String unit, int date, String typeFlour) {
        super(String.format("%s (%s)", name, typeFlour), price, quantity, unit, date);
        this.typeFlour = typeFlour;
    }


    public String toString() {
        return super.toString();
    }
}
