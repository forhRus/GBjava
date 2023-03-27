package UI;

import MVP.Model;
import MVP.Presenter;
import MVP.View;

import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static View view;
    private static Model model;
    private static Presenter presenter;
    private static Menu menu;

    public static void start() {
        scanner = new Scanner(System.in);
        view = new View(scanner);
        model = new Model<>();
        presenter = new Presenter(view, model);
        menu = new Menu();

        menu();
        endProgramm();
    }

    private static void menu() {
        int exit = menu.getExit();
        int choice = exit;
        boolean f = true;
        do {
            if (f) {
                view.showMenu(menu.getMenu());
                f = false;
            }
            choice = view.choiceMenu(exit);
            switch (choice) {
                case 1:
                    presenter.printTriangularNumber();
                    f = true;
                    break;
            }
        } while (choice != exit);
    }

    private static void endProgramm() {
        scanner.close();
        view.println("Программа завершена");
    }
}
