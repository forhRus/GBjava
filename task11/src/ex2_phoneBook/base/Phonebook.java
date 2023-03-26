package ex2_phoneBook.base;

import ex2_phoneBook.base.Contact;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Contact> contacts;


    public Phonebook() {
        this.contacts = new ArrayList<>();
    }
    public List<Contact> getContacts(){
        return this.contacts;
    }

   public int count(){
        return contacts.size();
   }

    public boolean addContact(Contact newContact) {
        boolean f = false;
        if(checkContact(newContact)){
            contacts.add(newContact);
            f = true;
        }
        return f;

    }
    public boolean setContact(int index, Contact newContact) {
        boolean f = false;
        if(checkContact(newContact)){
            contacts.set(index, newContact);
            f = true;
        }
        return f;
    }
    public void sort(){

    }


    public boolean deleteContact(int index) {
        boolean f = false;
        if(checkIndex(index)){
            contacts.remove(index);
            f = true;
        }
        return f;
    }

    private boolean checkIndex(int index){
        boolean f = false;
        if (index >= 0 && index < contacts.size()){
            f = true;
        }
        return f;
    }
    private boolean checkContact(Contact contact){
        boolean f = true;
        if(contacts.contains(contact)){
            System.out.println("Контакт уже существует");
            f = false;
        }
        if(f && contact.getPhoneNumber().isEmpty()){
            System.out.println("Не указан номер телефона");
            f = false;
        }
        if(f && contact.getFirstName().isEmpty() && contact.getLastName().isEmpty()){
            System.out.println("Неуказано имя и фамилия");
            f = false;
        }
        return f;
    }
}
