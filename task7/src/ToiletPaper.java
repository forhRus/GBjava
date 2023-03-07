public class ToiletPaper extends ProductHygiene {
    private int numberOfLayers;
    public ToiletPaper(String name, double price, int quantity, String unit, int count, int numberOfLayers) {
        super(name, price, quantity, unit, count);
        this.numberOfLayers = numberOfLayers;
    }


    public String toString() {
        return String.format("%s, x%dсл", super.toString(), this.numberOfLayers);
    }
}
