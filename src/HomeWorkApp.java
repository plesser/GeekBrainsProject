import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
//        Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
//                Orange
//                Banana
//                Apple.
        printThreeWords();

//        Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
//        и инициализируйте их любыми значениями, которыми захотите.
//        Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
//        то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
        Random rand = new Random();
        int a = rand.nextInt();
        int b = rand.nextInt();
        checkSumSign(a, b);

//        Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
//        Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
//        если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый

        int from = -200;
        int to = 200;
        int color = from + rand.nextInt(to - from + 1);
        printColor(color);

//        Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями,
//        которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
        compareNumbers(a, b);
    }

    private static void compareNumbers(int a, int b) {
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void printColor(int color) {
        if (color <= 0){
            System.out.println("Красный");
        } else if (color > 0 && color <= 100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void checkSumSign(int a, int b) {
        if (a + b >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
}
