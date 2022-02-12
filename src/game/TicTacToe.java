package game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final char DOT_HUMAN = 'X';
    final char DOT_AI = '0';
    final char DOT_EMPTY = '-';

    final int MODE = 2;

    int size;
    int win;

    char[][] field;

    int currentX;
    int currentY;

    Scanner scanner;
    Random rand;

    public TicTacToe(int size, int win, Scanner scanner) {
        this.size = size;
        this.win = win;
        this.scanner = scanner;

        this.field = new char[size][size];
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++){
                field[i][j] = DOT_EMPTY;
            }
        }

        rand = new Random();
    }

    public void running(){
        printGameFields();

        while(true){
            humanTurn();
            printGameFields();
            if (checkWin(DOT_HUMAN)){
                System.out.println("Ты победил человек, но я вернусь в следующий раз и  ̶п̶о̶б̶е̶д̶ю̶ одержу победу!");
                break;
            }
            if (!checkEmptyField()){
                System.out.println("Свободные поля закончились, ничья!");
                break;
            }



            aiTurn();
            printGameFields();
            if (checkWin(DOT_AI)){
                System.out.println("Я победил тебя человек, теперь ты мой!");
                break;
            }
            if (!checkEmptyField()){
                System.out.println("Свободные поля закончились, ничья!");
                break;
            }

        }

    }

    private boolean checkWin(char dot) {
        int cntX = 0;
        int cntY = 0;
        // проверка по горизонтали и вертикали
        for (int i = 0;i < size; i++){
            if (field[currentY-1][i] == dot){
                cntX++;
            } else {
                cntX = 0;
            }
            if (field[i][currentX-1] == dot){
                cntY++;
            } else {
                cntY = 0;
            }
            //System.out.println(cntX + " " + cntY);
            if (cntX == win || cntY == win){
                return true;
            }
        }

        // проверка по диагоналям право вверх - лево низ
        int x = -1;
        int y = -1;

        if (currentX > currentY){
            y = 1;
            x = currentX - currentY + 1;
        }
        if (currentX < currentY){
            x = 1;
            y = currentY - currentX + 1;
        }
        if (currentX == currentY) {
            x = 1;
            y = 1;
        }

        cntX = 0;
        cntY = 0;

        int cntStep = Math.min(size - x, size - y) + 1;
        //System.out.println(x + " " + y + " " + cntStep);
        for (int i=0; i < cntStep; i++){
            if (field[y - 1 + i][x - 1 + i] == dot){
                cntX++;
            } else {
                cntX = 0;
            }
        }
        if (cntX == win){
            return true;
        }

        cntX = 0;
        cntY = 0;

        // верхний треугольник
        if (currentY  < size - currentX + 1){
            //System.out.println("up");
            x = 1;
            y = currentY + currentX - 1;
        }
        // нижний треуголник
        if (currentY > size - currentX + 1){
            //System.out.println("down");
            x = currentX - (size - currentY);
            y = size;
        }

        if (currentY == size - currentX + 1){
            //System.out.println("equals");
            x = 1;
            y = size;
        }

        // не работает, мозги уже не варят почему
        // сделал в лоб
        cntStep = Math.min(x, size - y);
        //System.out.println(x + " " + y + " " + cntStep);

        cntX = 0;

        for (int i = 0; i < size; i++){
            //System.out.println((x + i - 1) + " " + (y - i - 1) + " " + dot);
            if (x + i - 1 >= size || y - i - 1 < 0){
                break;
            }
            if (field[x + i - 1][y - i - 1] == dot){
                cntX++;
            } else {
                cntX = 0;
            }
        }
        //System.out.println(cntX);

        if (cntX == win){
            return true;
        }

        return false;
    }

    private boolean checkEmptyField() {
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++){
                if (field[i][j] == DOT_EMPTY){
                    return true;
                }
            }
        }

        return false;
    }

    private void aiTurn() {
        if (MODE == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (field[i][j] == DOT_EMPTY) {
                        currentX = j + 1;
                        currentY = i + 1;
                        System.out.println("Компьютер решил поставить <" + DOT_AI + "> в координаты " + currentX + " и " + currentY);
                        setPoint(DOT_AI);
                        return;
                    }
                }
            }
        } else {
            do {
                currentX = rand.nextInt(size) + 1;
                currentY = rand.nextInt(size) + 1;
            } while(!isValidDot(currentX, currentY));
            System.out.println("Компьютер решил поставить <" + DOT_AI + "> в координаты " + currentX + " и " + currentY);
            setPoint(DOT_AI);
            return;
        }
    }

    private void humanTurn() {

        do {
            currentX = getCoordinate("Введите координату X ");
            currentY = getCoordinate("Введите координату Y ");
        } while (!isValidDot(currentX, currentY));

        setPoint(DOT_HUMAN);
    }

    private void setPoint(char dot) {
        field[currentY-1][currentX-1] = dot;
    }

    private boolean isValidDot(int currentX, int currentY) {
        if (field[currentY-1][currentX-1] == DOT_EMPTY){
            return true;
        } else {
            System.out.println("Данная ячейка занята");
        }
        return false;
    }

    private int getCoordinate(String query) {
        int res;

        while (true) {
            System.out.print(query);
            if (scanner.hasNextInt()) {
                res =  scanner.nextInt();
                if (res > 0 && res <= size){
                    break;
                } else {
                    System.out.println("Координата представляет собой целое число в диапазоне от 1 до " + size);
                }
            } else {
                System.out.println("Координата должна быть целым числом");
                scanner.next();
            }
        }

        return res;
    }

    private void printGameFields(){
        int space = (size < 10) ? 1 : 2;

        for (int s = 0; s < space+1; s++) {
            System.out.print(" ");
        }

        for (int i=0; i < size; i++){
            System.out.print(i+1);
            if (i < 9) {   // ставим здесь 9 ибо мы печатаем i+1
                for (int s = 0; s < space; s++) {
                    System.out.print(" ");
                }
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();

        for (int i=0; i < size; i++){
            System.out.print(i+1);
            for (int s=0; s < space; s++){
                System.out.print(' ');
            }
            for (int j=0; j < size; j++){
                System.out.print(field[i][j]);
                for (int s=0; s < space; s++){
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }


}
