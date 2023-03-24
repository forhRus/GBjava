package ex1_calc.menu;

public class MenuRac implements Menu {
    private String[] operations;


    public MenuRac() {
        this.operations = new String[]{"+", "-", "*", "/"};
    }

    @Override
    public String[] getMenu() {
        return operations;
    }
}
