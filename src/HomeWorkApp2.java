public class HomeWorkApp2 {
    public static void main(String[] args) {
        // Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
        int a = 12;
        int b = 7;
        System.out.println("Проверяем лежит ли в диапазоне от 10 до 20 сумма двух чисел " + a + " и " + b);
        System.out.println(checkSum2Num(a, b));

        // Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
        int c = -15;
        positiveOrNegative(c);

        // Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        System.out.println("Проверяем число " + c + " положительное или отрицательное");
        System.out.println(isPositiveNumber(c));


        // Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
        String str = "Какая то строка";
        int d = 4;
        System.out.println("Выводим строку: " + str + " - " + d + " раз(а)");
        printNumCnt(str, d);


        // Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        int year = 2017;
        System.out.println("Определяем какой год " + year);
        System.out.println(checkVisocosYear(year));

    }

    private static boolean checkSum2Num(int a, int b) {

        if ( a + b >= 10 && a + b <= 20){
            return true;
        } else {
            return false;
        }
    }


    private static void positiveOrNegative(int c) {
        System.out.println("Проверяем число " + c + " положительное или отрицательное");
        if (c >= 0){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }

    }

    private static boolean isPositiveNumber(int c) {
        if (c >= 0){
            return true;
        } else {
            return false;
        }

    }

    private static void printNumCnt(String str, int d) {
        for (int i = 0; i < d; i++){
            System.out.println(str);
        }
    }

    private static boolean checkVisocosYear(int year){
            if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)){
                return true;
            } else {
                return false;
            }
    }
}
