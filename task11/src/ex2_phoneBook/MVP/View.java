package ex2_phoneBook.MVP;

import ex2_phoneBook.base.Contact;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scan;

    public View(Scanner scan) {
        this.scan = scan;
    }

    public void printContacts(List<Contact> pb) {
        int size = pb.size();
        if (size == 0) {
            System.out.println("пусто");
        } else {
            for (int i = 0; i < pb.size(); i++) {
                System.out.println(pb.get(i));
            }
        }
    }

    public String inputDataContact(String msg, int length) {
        System.out.print(msg);
        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (input.length() > length) {
                return input.substring(0, length);
            } else {
                return input;
            }
        } else {
            return "";
        }
    }

    public void showContactLine(List<Contact> pb) {
        int size = pb.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d. %s\n", i + 1, pb.get(i).toStringLine());
        }
    }

    public int inputInt() {
        int choice = -1;
        if (scan.hasNextInt()) {
            choice = scan.nextInt();
            scan.nextLine();
        }
        return choice;
    }

    public String inputString() {
        String search = "";
        if (scan.hasNextLine()) {
            search = scan.nextLine();
        }
        return search;
    }

    public void print(String msg) {
        System.out.println(msg);
    }

    public void showMenu(String[] m) {
        for (String p : m) {
            System.out.println(p);
        }
    }

    public boolean checkChoice(int input, int size) {
        if (input > 0 && input <= size) {
            return true;

        } else {
            System.out.println("Не допустимое значение");
            return false;
        }
    }
}
