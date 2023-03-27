package UI;

public class Menu {
    private String[] menu;
    private int exit = 0;

    public Menu() {
        this.menu = new String[]
                {
                        "1. Найти n-ое триугольное число",
                        String.format("%d. Выходи из программы", exit)
                };
    }

    public String[] getMenu() {
        return menu;
    }

    public int getExit() {
        return exit;
    }
}
