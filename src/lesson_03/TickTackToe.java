package lesson_03;

import java.util.Random;
import java.util.Scanner;

public class TickTackToe {

    static final boolean SILLY_MODE = true;
    static char[][] map; // матрица игры
    static int SIZE = 3; // размерность поля
    static Random random = new Random();

    static char DOT_EMPTY = '.';
    static char DOT_X = 'X';
    static char DOT_O = 'O';

    static String winner;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();

        do {
            humanTurn();
            if (checkWin(DOT_X)){
                System.out.println("Winner X");
                break;
            }
            computerTurn();
            if ((checkWin(DOT_X))){
                System.out.println("Winner O");
                break;
            }
            printMap();
        } while (checkEmptyCells());
        printMap();


    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i=0; i < SIZE; i++){
            for (int j=0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел (вертикаль-горизонталь)");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if (SILLY_MODE){
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(y, x));
        } else {
            for (int i=0; i < SIZE; i++){
                for (int j=0; j < SIZE; j++){

                }
            }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x +1));
        map[y][x] = DOT_O;
    }


    private static boolean isCellValid(int x, int y) {
        boolean result = true;
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            result = false;
        } else if (map[x][y] != DOT_EMPTY){
            result = false;
        }

        return result;
    }

    private static boolean checkEmptyCells(){
        boolean result = false;
        for (int i =0; i < SIZE; i++){
            for (int j=0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY){
                    result = true;
                    break;
                }
            }
            if (result == true){
                break;
            }
        }

        return result;
    }

    private static boolean checkWin(char playerSymbol){
        boolean result = false;

        if (
                (map[0][0] ==  playerSymbol && map[0][1] ==  playerSymbol && map[0][2] ==  playerSymbol)
                        || (map[1][0] ==  playerSymbol && map[1][1] ==  playerSymbol && map[1][2] ==  playerSymbol)
                        || (map[2][0] ==  playerSymbol && map[2][1] ==  playerSymbol && map[2][2] ==  playerSymbol)
                        || (map[0][0] ==  playerSymbol && map[1][0] ==  playerSymbol && map[2][0] ==  playerSymbol)
                        || (map[0][1] ==  playerSymbol && map[1][1] ==  playerSymbol && map[2][1] ==  playerSymbol)
                        || (map[0][2] ==  playerSymbol && map[1][2] ==  playerSymbol && map[2][2] ==  playerSymbol)
                        || (map[0][0] ==  playerSymbol && map[1][1] ==  playerSymbol && map[2][2] ==  playerSymbol)
                        || (map[2][0] ==  playerSymbol && map[1][1] ==  playerSymbol && map[0][2] ==  playerSymbol)
        ){
            result = true;
        }

        return result;
    }


    private static void printMap(){
        for(int i=0; i <= SIZE; i++){
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i=0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for (int j=0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
