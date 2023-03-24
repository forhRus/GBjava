package ex1_calc.menu;

public class MenuStart implements Menu {
    String[] menu = {"Комплексные числа", "Рациональные числа"};
    @Override
    public String[] getMenu() {
        return menu;
    }
}
