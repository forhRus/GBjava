public class ToiletPaper extends ProductHygiene {
    private int numberOfLayers;
    public ToiletPaper(String name, double price, int quantity, String unit, int count, int numberOfLayers) {
        super(String.format("%s (%dсл)",name, numberOfLayers), price, quantity, unit, count);
        this.numberOfLayers = numberOfLayers;
    }


    public String toString() {
        return super.toString();
    }
}
