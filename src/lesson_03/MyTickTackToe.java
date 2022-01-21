package lesson_03;

import java.util.Random;
import java.util.Scanner;

public class MyTickTackToe {
    static final boolean SILLY_MODE = false;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static char[][] mapa;
    static int SIZE = 3;

    static char DOT_EMPTY = '.';
    static char DOT_X = 'X';
    static char DOT_O = 'O';

    public static void main(String[] args) {
        mapa = new char[SIZE][SIZE];
        initMapa();

        printMapa();

        do {
            runHuman();
            printMapa();
            if (checkWin(DOT_X)){
                System.out.println("Победил человек");
                break;
            }

            if (!isEmptyDot()){
                System.out.println("Ничья");
                break;
            }

            runComputer();
            printMapa();
            if (checkWin(DOT_O)){
                System.out.println("Победил компьютер");
                break;
            }

            if (!isEmptyDot()){
                System.out.println("Ничья");
                break;
            }

        } while(true);
    }

    private static void runComputer() {
        int x = -1;
        int y = -1;

        int cntDotO = getCntSymbol(DOT_O);

        if (SILLY_MODE || cntDotO == 0){
            do {
                y = random.nextInt(SIZE);
                x = random.nextInt(SIZE);
            } while (isValidDot(y, x));
        } else {
            int strategy[][] = {
                                    {0, 1},
                                    {1, 1},
                                    {1, 0},
                                    {0, -1},
                                    {-1, -1},
                                    {-1, 0},
                                    {-1, 1}
                                };
            boolean res = false;
            for (int i=0; i < SIZE; i++){
                for (int j=0; j < SIZE; j++){
                    if (mapa[j][i] == DOT_O){
                        System.out.println((j) + " " + (i));
                        for (int s=0; s < 7; s++){
                            System.out.println("    " + s + " " + (j + strategy[s][0]) + " " + (i + strategy[s][1]));
                            if (isValidDot(j + strategy[s][0], i + strategy[s][1])){
                                System.out.println("Умный режим");
                                x = j + strategy[s][0];
                                y = i + strategy[s][1];
                                res = true;
                                break;
                            }
                        }
                    }
                    if (res){
                        break;
                    }
                }
                if (res){
                    break;
                }
            }
            if (res == false){
                // свободных ячеек рядом нет, придется импровизировать
                System.out.println ("Глупый режим");
                do {
                    y = random.nextInt(SIZE);
                    x = random.nextInt(SIZE);
                } while (!isValidDot(y, x));

            }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x +1));
        mapa[x][y] = DOT_O;

    }

    private static int getCntSymbol(char dot) {
        int res = 0;
        for (int i=0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == dot){
                    res++;
                }
            }
        }
        return res;
    }

    private static void runHuman() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел (горизонталь - вертикаль)");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isValidDot(y, x));

        mapa[x][y] = DOT_X;

    }

    private static boolean checkWin(char playerSymbol) {
        boolean result = false;
        int win_1 = 0;
        int win_2 = 0;
        // Проверка по горизонтали и вертикали
        for (int i=0; i < mapa.length; i++){
            for (int j=0; j < mapa.length; j++){
                if (mapa[i][j] == playerSymbol){
                    win_1++;
                }
                if (mapa[j][i] == playerSymbol){
                    win_2++;
                }
            }
            if (win_1 == mapa.length || win_2 == mapa.length ){
                result = true;
                break;
            }
            win_1 = 0;
            win_2 = 0;
        }

        // Проверка диагоналей

        win_1 = 0;
        for (int i=0; i < mapa.length; i++){
            if (mapa[i][i] == playerSymbol){
                win_1++;
            }
            if (mapa[mapa.length-i-1][i] == playerSymbol){
                win_2++;
            }
        }
        if (win_1 == mapa.length || win_2 == mapa.length){
            result = true;
            return result;
        }


        return result;
    }

    private static boolean isEmptyDot() {
        boolean res = false;
        for (int i=0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == DOT_EMPTY){
                    res = true;
                    break;
                }
            }
            if (res){
                break;
            }
        }
        return res;
    }

    private static void printMapa() {
        System.out.print("  ");
        for (int i=0; i < mapa.length; i ++){
            System.out.print((i+1) + " ");
        }
        System.out.println();

        for (int i=0; i < mapa.length; i++){
            System.out.print((i+1) + " ");
            for (int j=0; j < mapa[i].length; j++){
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static boolean isValidDot(int x, int y){
        boolean res = true;
        System.out.println(x + " " + y + " " + mapa[x][y] );
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || mapa[x][y] != DOT_EMPTY) {
            res = false;
        }
        //System.out.println(x + " " + y);
        //if (res == true && mapa[y][x] != DOT_EMPTY){
        //    //System.out.print("-");
        //   res = false;
        //}
        System.out.println(res);
        return res;
    }


    private static void initMapa() {
        for (int i=0; i < mapa.length; i++){
            for (int j=0; j < mapa[i].length; j++){
                mapa[i][j] = DOT_EMPTY;
            }
        }
    }
}
