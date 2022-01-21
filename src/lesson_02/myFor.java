package lesson_02;

import java.util.Scanner;

public class myFor {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Введите ограничение: ");
        int limit = userInput.nextInt();
        int counter = 0;
        System.out.println("Список четных числел из заданного промежутка:");
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.println(counter);
            }
            counter++;
        }

        System.out.println("begin");
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("end");

        int x;
        // Объявление управляющей переменной вынесено до начала цикла
        for (x = 10; x >= 0; x -= 5) { // Шаг -5
            System.out.print(x + " ");
        }

        for (int count = 10; count < 5; count++) {
            x += count; // Этот оператор не будет выполнен, так как 10 > 5
            System.out.println(count);
        }

        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i-j: " + i + "-" + j);
        }

        for(int i = 0; i < 10; i++) {
            if (i > 3) {
                break;
            }
            System.out.println("i = " + i);
        }

        String[] sm = {"A", "B", "C", "D"};
        for (int i = 0; i < sm.length; i++) {
            System.out.print(sm[i] + " ");
        }

        System.out.println();

        for (String o : sm) {
            System.out.print(o + " ");
        }

        System.out.println();

        int[][] table = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                table[i][j] = counter;
                System.out.print(table[i][j] + " ");
                counter++;
            }
            System.out.println();
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
