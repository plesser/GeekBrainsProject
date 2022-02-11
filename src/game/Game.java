package game;

import java.util.Locale;
import java.util.Scanner;

public class Game {

    static Scanner scanner = new Scanner(System.in);
    static int size = -1;  // диапазон игрового поля
    static int min = 3;    // минимальный размер линии победы
    static int max = 15;   // максимальный размер линии побед
    static int win = -1;   // размер линии для победы

    public static void main(String[] args) {
        while (true){

            inputSizeField();
            inputSizeWin();

            System.out.println("Играем на поле размерностью " + size + " и для победы необходимо выстроить линию размером " + win);

            TicTacToe ttt = new TicTacToe(size, win, scanner);
            ttt.running();

            System.out.print("Сыграем еще раз? (Y/N) ");
            if (scanner.next().toLowerCase().equals("n")) {
                System.out.println("Goodbye cry world!");
                break;
            }
            System.out.println("Поехали :)");
        }

        scanner.close();
    }

    private static void inputSizeWin() {
        while(true){
            System.out.print("Введите размер линии необходимый для победы: ");
            if (scanner.hasNextInt()){
                win = scanner.nextInt();
                if (win <= size) {
                    break;
                } else {
                    System.out.println("Размер линии необходимый для победы должен быть меньше или равен размерности игрового поля (в нашем случае " + size + ")");
                }
            } else {
                System.out.println("Размер линии должен иметь целый ответ");
                scanner.next();
            }
        }
    }

    private static void inputSizeField() {
        while (true) {
            System.out.print("Введите размерность игрового поля (3..15): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= 3 && size <= 15) {
                    break;
                } else {
                    System.out.println("Размерность игрового поля должна лежать в диапазоне " + min + " и " + max);
                }
            } else {
                System.out.println("Размерность игрового поля должно быть целым числом");
                scanner.next();
            }
        }
    }
}
