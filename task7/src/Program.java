public class Program {
    public static void main(String[] args) {
        Goods chocolate = new ProductWithBestBeforeDate("Шоколад \"Алёнка\"" , 17.5, 10, "шт", 5);
        System.out.println(chocolate);
        Goods blanket = new ProductHygiene("Салфетки \"К/д\"" , 17.5, 4, "уп", 80);
        System.out.println(blanket);
        Goods child = new ProductChildren("Подгузники" , 900, 10, "уп", 0, ProductChildren.Alergen.Да);
        System.out.println(child);
        Goods milk = new Milk("Молоко \"Домик в деревне\"", 100, 3, "уп", 1, 3.57, 17);
        System.out.println(milk);
        Goods milk = new Milk("Молоко \"Домик в деревне\"", 100, 3, "уп", 1, 3.57, 17);
        System.out.println(milk);
    }
}
