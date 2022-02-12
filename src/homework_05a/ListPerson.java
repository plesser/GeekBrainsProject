package homework_05a;

public class ListPerson {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Programmer", "pepetr@mailbox.com", "892312313", 40000, 46);
        persArray[2] = new Person("Alexandrov Alexander", "Driver", "alalex@mailbox.com", "892312314", 50000, 34);
        persArray[3] = new Person("Alexeev Alexey", "Manager", "alalexx@mailbox.com", "892312315", 60000, 56);
        persArray[4] = new Person("Dmitriev Dmitry", "Saler", "dmdima@mailbox.com", "892312316", 70000, 58);

        for (int i = 0; i < persArray.length; i++){
            if (persArray[i].age >= 40){
                persArray[i].printPerson();
            }
        }

    }
}
