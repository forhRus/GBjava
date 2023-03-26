package ex2_phoneBook.base;

public class Contact  {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String comment;
    public static final int stringLength = 16, numberLength = 12;

    public Contact(String firstName, String secondName, String phoneNumber, String comment) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getComment() {
        return comment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder contact = new StringBuilder();
        if (!firstName.isEmpty()) {
            contact.append(String.format("Имя: %s\n", firstName));
        }
        if (!lastName.isEmpty()) {
            contact.append(String.format("Фамилия: %s\n", lastName));
        }
        if (!phoneNumber.isEmpty()) {
            contact.append(String.format("Номер: %s\n", phoneNumber));
        }
        if (!comment.isEmpty()) {
            contact.append(String.format("Комментарий: %s\n", comment));
        }
        contact.append("--------");
        return contact.toString();
    }
    public String toStringLine() {
        StringBuilder contact = new StringBuilder();
        if (!firstName.isEmpty()) {
            contact.append(String.format("%s", firstName));
            if (!lastName.isEmpty()) {
                contact.append(" ");
            }
        }
        if (!lastName.isEmpty()) {
            contact.append(String.format("%s", lastName));
        }
        if (!phoneNumber.isEmpty()) {
            contact.append(String.format(": %s", phoneNumber));
        }
        if (!comment.isEmpty()) {
            contact.append(String.format(" (%s)", comment));
        }
        return contact.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Contact)) {
            return false;
        }
        Contact c = (Contact) obj;
        if(this.phoneNumber == null) {
            return c.phoneNumber == null;
        } else {
            return this.phoneNumber.equals(c.phoneNumber);
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            result += phoneNumber.charAt(i)*123*(10*i);
        }
        return result;
    }


}
