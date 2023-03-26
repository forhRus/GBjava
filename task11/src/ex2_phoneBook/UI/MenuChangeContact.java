package ex2_phoneBook.UI;

import java.util.ArrayList;

public class MenuChangeContact {
   private  String[] field;

    public MenuChangeContact() {
        this.field = new String[]
                {
                        "1. Имя",
                        "2. Фамилия",
                        "3. Номер",
                        "4. Комментарий",
                        "5. Всё",
                        "6. Отмена"

                };
    }

    public String[] getField() {
        return field;
    }
}
