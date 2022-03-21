package homework_11;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String, ArrayList<String>> phoneBooks;

    public PhoneBook() {
        phoneBooks = new HashMap<>();
    }

    void addUser(String name) {
        if (!phoneBooks.containsKey(name)){
            phoneBooks.put(name, new ArrayList<>());
            System.out.println("Пользователь " + name + " добавлен в телефонную книгу");
        } else {
            System.out.println("Пользователь " + name + " уже есть в телефонной книге");
        }
    }

    void addPhoneToUser(String name, String phone){
        addPhoneToUser(name, phone, 0);
    }

    void addPhoneToUser(String name, String phone, int flag){
        if (phoneBooks.containsKey(name)) {
            ArrayList<String> phones = phoneBooks.get(name);
            if (phones.contains(phone)){
                System.out.println("Телефон " + phone + " уже есть у пользователя " + name);
            } else {
                phones.add(phone);
                System.out.println("Пользователю " + name + " добавлен номер " + phone);
            }
        } else {
            if (flag == 0) {
                System.out.println("Пользователя " + name + " нет в телефонной книге");
            } else {
                addUser(name);
                ArrayList<String> phones = phoneBooks.get(name);
                phones.add(phone);
                System.out.println("Пользователю " + name + " добавлен номер " + phone);
            }
        }
    }

    void displayPhone(){
        for (String name : phoneBooks.keySet()){
            System.out.println("User: " + name);
            if (phoneBooks.get(name).size() == 0){
                System.out.println("\t Телефонов нет");
                continue;
            }
            for (String phone : phoneBooks.get(name)){
                System.out.println("\t " + phone);
            }
        }
    }

    String getName(String phone){
        for (String name : phoneBooks.keySet()){
            if (phoneBooks.get(name).contains(phone)){
                return name;
            }
        }

        System.out.println("Телефонный номер " + phone+ " не найден в базе данных");
        return "";
    }
}
