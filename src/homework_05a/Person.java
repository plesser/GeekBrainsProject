package homework_05a;

public class Person {
    String fio;
    String position;
    String email;
    String phone;
    int income;
    int age;

    public Person(String fio, String position, String email, String phone, int income, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.income = income;
        this.age = age;
    }

    public void printPerson(){
        System.out.println("Full name: " + this.fio);
        System.out.println("Position: " + this.position);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Income: " + this.income);
        System.out.println("Age: " + this.age);
        System.out.println("------------------------------------------------------------------------------");
    }
}
