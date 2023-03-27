package MVP;

import java.util.Scanner;

public class View {
    Scanner scan;
    int input;

    public View(Scanner scan) {
        this.scan = scan;
    }

    public void print(String msg) {
        System.out.print(msg);
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    public void println() {
        System.out.println();
    }

    public boolean inputInt() {
        if (scan.hasNextInt()) {
            input = scan.nextInt();
            scan.nextLine();
            return true;
        }
        scan.nextLine();
        return false;
    }

    public int getInput() {
        return input;
    }

    public void showMenu(String[] menu) {
        for (String p : menu) {
            System.out.println(p);
        }
    }

    public int choiceMenu(int exit) {
        int choice = exit;
        if (inputInt()) {
            choice = getInput();
        }
        return choice;
    }
}
