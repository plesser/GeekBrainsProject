package homework_11;

public class WorkWithPB {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addUser("Oleg");
        phoneBook.addUser("Oleg");
        phoneBook.displayPhone();

        phoneBook.addUser("Timophey");
        phoneBook.addUser("Igor");
        phoneBook.displayPhone();

        phoneBook.addPhoneToUser("Unknown user", "012", 0);
        phoneBook.addPhoneToUser("Natasha", "012", 1);
        phoneBook.displayPhone();

        phoneBook.addPhoneToUser("Oleg", "123");
        phoneBook.addPhoneToUser("Oleg", "124");
        phoneBook.addPhoneToUser("Oleg", "124");
        phoneBook.displayPhone();

        phoneBook.addPhoneToUser("Igor", "223");
        phoneBook.addPhoneToUser("Igor", "224");
        phoneBook.displayPhone();

        // поиск по номеру телефона
        System.out.println("Ищем телефонный номер " + " 567 -> " + phoneBook.getName("567"));
        System.out.println("Ищем телефонный номер " + " 124 -> " + phoneBook.getName("124"));
    }
}
