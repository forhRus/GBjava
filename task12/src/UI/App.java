package UI;

import MVP.Model;
import MVP.Presenter;
import MVP.View;
import db.Config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static View view;
    private static Model model;
    private static Presenter presenter;
    private static Menu menu;

    public static void start() {
        Config c = new Config();
        scanner = new Scanner(System.in);
        view = new View(scanner);
        model = new Model(c);
        presenter = new Presenter(view, model);
        menu = new Menu();

        System.out.println("Программа считывает из файла два числа\n" +
                "Определяеn, которое из них надо возвести в степень\n" +
                "Возводит в степень\n" +
                "Записивает результат в другой файл.\n");
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
            choice = view.inputInt();
            switch (choice) {
                case 1:
                    presenter.powerNumber();
                    f = true;
                    System.out.println();
                    break;
            }
        } while (choice != exit);
    }

    private static void endProgramm() {
        scanner.close();
        view.println("Программа завершена");
    }
}
