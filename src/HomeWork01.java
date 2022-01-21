import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        // Создать переменные всех пройденных типов данных, и инициализировать их значения;
        task_2();

        //Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
        task_3();

        // Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
        task_4();

        // Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
        task_5();

        // Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        task_6();

        // Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        task_7();

        // Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        task_8();

        //Не набирая код в IDE, ответьте на следующий вопрос. Есть два метода:
        //void myMethod(int a, String b) {}
        //void myMethod(String b, int a) {}

        System.out.println("Ну и в завершении");
        System.out.println("void myMethod(int a, String b) {}");
        System.out.println("void myMethod(String b, int a) {}");
        System.out.println("Как это не странно, но это два разных метода с двумя разными сигнатурами");
        System.out.println("Ибо Java не поддерживает именнованые методы");
    }

    private static void task_2() {
        byte a_byte = 5;
        short b_short = 25;
        int c_int = 125;
        long d_long = 625;

        float pi = 3.1415926f;

        double euler = 2.71828182845;

        char symbol = 'a';

        String name = "Меня зовут Олег";
    }

    private static void task_3() {
        System.out.println("Расчитываем формулу a * (b + (c / d)):");

        double a = readDoubleArgument("Введите аргумент a: ");
        double b = readDoubleArgument("Введите аргумент b: ");
        double c = readDoubleArgument("Введите аргумент c: ");
        double d = readDoubleArgument("Введите аргумент d: ");

        double result = a * (b + (c / d));

        System.out.println("Ваш результат: " + result );
    }


    private static void task_4() {
        System.out.println("Проверяем лежит ли в диапазоне от 10 до 20 сумма двух первых чисел");
        double num1 = readDoubleArgument("Введите первый аргумент: ");
        double num2 = readDoubleArgument("Введите второй аргумент: ");

        if (validate10_20(num1, num2)){
            System.out.println("Число лежит в диапазоне [10, 20]");
        } else {
            System.out.println("Число выходит из диапазона [10, 20]");
        }
    }

    private static void task_5() {
        System.out.println("Проверяем число положительное или отрицательное");
        int num3 = readIntArgument("Введите аргумент: ");
        checkPositiveNumber(num3);
    }

    private static void task_6() {
        System.out.println("И снова Проверяем число положительное или отрицательное");
        int num3 = readIntArgument("Введите аргумент: ");
        if (checkPositiveNumber2(num3)){
            System.out.println("Введенное число положительное");
        } else {
            System.out.println("Введенное число отрицательное");
        }
    }

    private static void task_7() {
        System.out.println("А теперь давайте познакомимся");
        String yourName = readStringArgument("Введите свое имя: ");
        hello(yourName);
    }


    private static void task_8() {
        System.out.println("проверяем какой год");
        int year = readIntArgument("Введите интересующий Вас год: ");
        checkYear(year);
    }

    private static void checkYear(int year) {
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)){
            System.out.println("Это високосный год");
        } else {
            System.out.println("Это обычный год");
        }
    }

    private static void checkPositiveNumber(int num) {
        if (num >= 0){
            System.out.println("Введенное число положительное");
        } else {
            System.out.println("Введенное число отрицательное");
        }

    }

    private static boolean checkPositiveNumber2(int num) {
        if (num >= 0){
            return true;
        } else {
            return false;
        }

    }


    private static boolean validate10_20(double num1, double num2) {
        if (num1 + num2 >= 10 && num1 + num2 <=20){
            return true;
        } else {
            return false;
        }
    }


    static double readDoubleArgument(String userText){
        Scanner userInput = new Scanner(System.in);

        System.out.print(userText);
        double argument = userInput.nextDouble();
        //userInput.close();

        return argument;
    }

    static int readIntArgument(String userText){
        Scanner userInput = new Scanner(System.in);

        System.out.print(userText);
        int argument = userInput.nextInt();
        //userInput.close();

        return argument;
    }

    static String readStringArgument(String userText){
        Scanner userInput = new Scanner(System.in);

        System.out.print(userText);
        String argument = userInput.nextLine();
        //userInput.close();

        return argument;
    }

    private static void hello(String yourName) {
        System.out.println("Привет " + yourName + "!");
    }

}
