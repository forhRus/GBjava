import Goods.*;

public class Main {
    public static void main(String[] args) {
        Good chocolate = new ProductWithBestBeforeDate("Шоколад \"Алёнка\"" , 17.5, 10, "шт", 5);
        Program.listOfGood.add(chocolate);
        Good blanket = new ProductHygiene("Салфетки \"К/д\"" , 17.5, 4, "уп", 80);
        Program.listOfGood.add(blanket);
        Good milk = new Milk("Молоко \"Домик в деревне\"", 100, 3, "уп", 1, -5, 17);
        Program.listOfGood.add(milk);
        Good cola = new Lemonade("Напиток \"Coca-Cola\"", 120, 6, "шт", 2);
        Program.listOfGood.add(cola);
        Good bread = new Bread("Хлеб", 120, 6, "шт", 5, "Ржаной");
        Program.listOfGood.add(bread);
        Good egg = new Egg("Яйцо", 115, 100, "уп", 24, 10);
        Program.listOfGood.add(egg);
        Good paper = new ToiletPaper("т/б \"Zewa\"", 185, 41, "уп", 4, 3);
        Program.listOfGood.add(paper);
        Good diaper = new Diaper("Подгузники \"Хагис\"" , 900, 10, "уп", 0, ProductChildren.Alergen.Да, 2, 3, 6);
        Program.listOfGood.add(diaper);
        Good pacifier = new Pacifier("Соска (китайская)" , 5, 1000, "шт", 1, ProductChildren.Alergen.Да);
        Program.listOfGood.add(pacifier);
        System.out.println("Метод печатает через Program информацию от товаре. " +
                "Main имеет доступ к Good, поэтмоу может и сам распечатать. " +
                "Не хватает знаний, как сделать красиво.");
        Program.printGood(pacifier);
        System.out.println("---------------------");
        System.out.println("Выводим весь список добавленных товаров");
        Program.printList();

    }
}
