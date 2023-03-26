package ex2_phoneBook.UI;

import ex2_phoneBook.DB.Config;
import ex2_phoneBook.MVP.Model;
import ex2_phoneBook.MVP.Presenter;
import ex2_phoneBook.MVP.View;
import ex2_phoneBook.base.Phonebook;

import java.util.Scanner;

public class App {
    private static Scanner scan;
    private static Model model;
    private static View view;
    private static Phonebook phoneBook;
    private static Presenter presenter;
    private static Menu menu;


    public static void start() {
        scan = new Scanner(System.in);
        model = new Model(Config.pathPhoneBook);
        view = new View(scan);
        phoneBook = new Phonebook();
        presenter = new Presenter(model, view, phoneBook);
        menu = new Menu();
        presenter.load();
        menu();
    }

    public static void menu() {
        String[] m = menu.getMenu();
        while (true) {
//            System.out.print("\033[H\033[J"); // не работает
            int choice = presenter.choiceMenu(m);
            if (choice == 6) {
                presenter.saveContacts();
                scan.close();
                System.out.println("Пока");
                break;
            }
            switch (choice) {
                case 1:
                    presenter.showContacts();
                    break;
                case 2:
                    presenter.addContact();
                    break;
                case 3:
                    presenter.deleteContact();
                    break;
                case 4:
                    presenter.changeContact();
                    break;
                case 5:
                    presenter.searchContact();
                    break;
                default:
                    System.out.println("Выберите пункт меню.");
            }
            System.out.println();
        }
    }
}
