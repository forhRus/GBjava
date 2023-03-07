import java.net.PasswordAuthentication;

public class Program {
    public static void main(String[] args) {
        Goods chocolate = new ProductWithBestBeforeDate("Шоколад \"Алёнка\"" , 17.5, 10, "шт", 5);
        System.out.println(chocolate);
        Goods blanket = new ProductHygiene("Салфетки \"К/д\"" , 17.5, 4, "уп", 80);
        System.out.println(blanket);
        Goods milk = new Milk("Молоко \"Домик в деревне\"", 100, 3, "уп", 1, -5, 17);
        System.out.println(milk);
        Goods cola = new Lemonade("Напиток \"Coca-Cola\"", 120, 6, "шт", 2);
        System.out.println(cola);
        Goods bread = new Bread("Хлеб", 120, 6, "шт", 5, "Ржаной");
        System.out.println(bread);
        Goods egg = new Egg("Яйцо", 115, 100, "уп", 24, 10);
        System.out.println(egg);
        Goods paper = new ToiletPaper("т/б \"Zewa\"", 185, 41, "уп", 4, 3);
        System.out.println(paper);
        Goods diaper = new Diaper("Подгузники \"Хагис\"" , 900, 10, "уп", 0, ProductChildren.Alergen.Да, 2, 3, 6);
        System.out.println(diaper);
        Goods pacifier = new Pacifier("Соска (китайская)" , 5, 1000, "шт", 1, ProductChildren.Alergen.Да);
        System.out.println(pacifier);
    }
}
