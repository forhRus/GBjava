package ex2_phoneBook.UI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String[] menu;

    public Menu() {
        menu = new String[]
                {
                        "Меню:",
                        "1. Показать контакты",
                        "2. Добавить контакт",
                        "3. Удалить контакт",
                        "4. Изменить контакт",
                        "5. Найти контакт",
                        "6. Выход"
                };
    }
    public String[] getMenu(){
        return menu;
    }
}
