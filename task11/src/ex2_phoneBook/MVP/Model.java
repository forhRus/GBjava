package ex2_phoneBook.MVP;

import ex2_phoneBook.base.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    String pathPhoneBook;

    public Model(String pathPhoneBook) {
        this.pathPhoneBook = pathPhoneBook;
    }

    public void load(List<Contact> pb) {
        File file = new File(pathPhoneBook);
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {
            String l = reader.readLine();
            while (l != null) {
                StringBuilder line = new StringBuilder(l);
                pb.add(cutLine(line));
                l = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Contact cutLine(StringBuilder line) {
        String fName = cutField(line);
        String lName = cutField(line);
        String pNumber = cutField(line);
        String comment = cutField(line);
        return new Contact(fName, lName, pNumber, comment);
    }

    private String cutField(StringBuilder line) {
        int endIndex = line.indexOf(";");
        String field = line.substring(0, endIndex);
        line.delete(0, endIndex + 1);
        return field;
    }

    public void save(List<Contact> contacts) {
        try (FileWriter fw = new FileWriter(pathPhoneBook, false)) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < contacts.size(); i++) {
                String fName = contacts.get(i).getFirstName();
                String lName = contacts.get(i).getLastName();
                String pNumber = contacts.get(i).getPhoneNumber();
                String comment = contacts.get(i).getComment();
                fw.write(String.format("%s;%s;%s;%s;\n", fName, lName, pNumber, comment));
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public List<Contact> search(List<Contact> pb, String search) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : pb) {
            if (c.getLastName().toLowerCase().contains(search)
                    || c.getFirstName().toLowerCase().contains(search)
                    || c.getPhoneNumber().toLowerCase().contains(search)
                    || c.getComment().toLowerCase().contains(search)){
                result.add(c);
            }
        }
        return result;
    }
}
