package ex2_phoneBook;

import java.util.List;

public class Presenter {
    private Model model;
    private View view;
    private Phonebook pb;


    public Presenter(Model m, View v, Phonebook pb) {
        this.model = m;
        this.view = v;
        this.pb = pb;

    }

    public void load() {
        model.load(pb.getContacts());
    }

    public void showContacts() {
        List<Contact> contacts = pb.getContacts();
        view.print("Телефонная книга: ");
        view.printContacts(contacts);
    }

    public void addContact() {
        Contact newContact = createContact();
        if (pb.addContact(newContact)) {
            pb.sort();
        }
    }

    private Contact createContact() {
        String fName = view.inputDataContact("Имя: ", Contact.stringLength);
        String lName = view.inputDataContact("Фамилия: ", Contact.stringLength);
        String pNumber = view.inputDataContact("Номер: ", Contact.numberLength);
        String comment = view.inputDataContact("Комментарий: ", Contact.stringLength);
        Contact newContact = new Contact(fName, lName, pNumber, comment);
        return newContact;
    }

    public void searchContact() {
        view.print("Найти: ");
        String search = view.inputString().toLowerCase();
        List<Contact> searchedList = model.search(pb.getContacts(), search);
        if(searchedList.size() == 0){
            view.print("Ничего не найдено");
        } else {
            view.print("Найденный контакты");
            view.showContactLine(searchedList);
        }
    }

    public void saveContacts() {
        model.save(pb.getContacts());
    }

    public void deleteContact() {
        int index = choiceContact("Удалить контакт: ");
        if (pb.deleteContact(index - 1)) {
            view.print("Контакт удалён");
        } else {
            view.print("Не допустимое значение");
        }
    }

    public void changeContact() {
        MenuChangeContact m = new MenuChangeContact();
        int index = choiceContact("Изменить контакт: ");
        if (view.checkChoice(index, pb.count())) {
            Contact contact = pb.getContacts().get(index - 1);
            while (true) {
                view.showMenu(m.getField());
                view.print("Какое поле хотите изменить: ");
                int choiceField = view.inputInt();
                if (choiceField == 6) {
                    break;
                }
                switch (choiceField) {
                    case 1:
                        String fName = view.inputDataContact("Новое имя: ", Contact.stringLength);
                        contact.setFirstName(fName);
                        break;
                    case 2:
                        String lName = view.inputDataContact("Новая фамилия: ", Contact.stringLength);
                        contact.setLastName(lName);
                        break;
                    case 3:
                        String pNumber = view.inputDataContact("Новый номер: ", Contact.numberLength);
                        Contact newContact = new Contact(contact.getFirstName(),
                                contact.getLastName(),
                                pNumber,
                                contact.getComment());
                        pb.setContact(index - 1, newContact);
                        break;
                    case 4:
                        String comment = view.inputDataContact("Новый комментарий: ", Contact.stringLength);
                        contact.setComment(comment);
                        break;
                    case 5:
                        pb.setContact(index - 1, createContact());
                        break;
                }
            }
        }
    }

    public int choiceMenu(String[] menu) {
        view.showMenu(menu);
        return view.inputInt();
    }

    private int choiceContact(String msg) {
        view.showContactLine(pb.getContacts());
        System.out.print(msg);
        return view.inputInt();
    }

}
