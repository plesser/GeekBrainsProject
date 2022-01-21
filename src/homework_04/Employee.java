package homework_04;

public class Employee {
    String fio;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.println("FIO: " + fio);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivanov@nail.ru", "89031234567", 30000, 30);
        empArray[1] = new Employee("Petrov Petr", "Driver", "petrov@nail.ru", "89032345678", 10000, 41);
        empArray[2] = new Employee("Nikolaev Nikolay", "Driver", "nikilaev@nail.ru", "89033456789", 20000, 51);
        empArray[3] = new Employee("Petrova Luba", "Manager", "petrova@nail.ru", "89034567890", 30000, 40);
        empArray[4] = new Employee("Nikolayeva Elena", "Engineer", "nikilaeva@nail.ru", "89039876543", 30000, 32);

        for (Employee employee : empArray){
            if (employee.age > 40) {
                employee.info();
                System.out.println("-----------------------------");
            }
        }

    }
}
