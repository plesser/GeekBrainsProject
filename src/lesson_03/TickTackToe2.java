package lesson_03;

import java.util.Random;
import java.util.Scanner;

public class TickTackToe2 {
    private static char[][] map; //матрица игры
    private static int SIZE = 3; //размер поля

    private static final char DOT_EMPTY = '-';   //символ пустоты
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final boolean SILLY_MODE = true; //включен совсем глупый режим

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while(true) {
            humanTurn();
            if (isTheEnd(DOT_X)) {
                break;
            }
            compTurn();
            if (isTheEnd(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    /**
     * Метод подготовки игрового поля
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    /**
     * Метод вывода игрового поля на экран
     */
    private static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Ходы игрока, компутера
     */
    private static void humanTurn(){
        int x, y;

        do{
            System.out.println("Введите координаты ячейки через пробел (вертикаль-горизонталь)");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        }while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    private static void compTurn(){
        int x = -1;
        int y = -1;

        if(SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
    /*else{                                         //здесь начинается реализация компьютера поумнее
        for (int i = 0; i < SIZE; i++) {
            // проверяем клетки по наравлениям
        }
    }
    */
        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }

    /**
     * Метод валидации заправшивает ячейки на корректность
     * @param x - координаты по горизонтали
     * @param y - координаты по вертикали
     * @return boolian - признак валидации
     */

    private static boolean isCellValid(int x, int y){
        boolean result = true;
        //проверка вводимых координат
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            result = false;
        }
        //проверка заполненности ячейки
        else if (map[y][x] != DOT_EMPTY) {
            result = false;
        }
        return result;
    }

    private static boolean isTheEnd(char playerSymbol){
        boolean result = false;

        printMap();

        //проверяем необходимость следующего хода
        if(checkWin(playerSymbol)){
            System.out.println("Поебдили " +playerSymbol);
            result = true;
        }
        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }
        return  result;
    }

    private static boolean isMapFull(){
        boolean result = true;

        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }

    private static boolean checkWin(char playerSymbol){
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }
        return result;
    }
}
