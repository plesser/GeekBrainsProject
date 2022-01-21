import java.util.Random;
import java.util.Scanner;

public class HomeWork03 {

    static final boolean SILLY_MODE = false;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int SIZE = 3;
    static char[][] mapa = new char[SIZE][SIZE];

    static char DOT_EMPTY = '.';
    static char DOT_X = 'X';
    static char DOT_O = 'O';


    public static void main(String[] args) {
        initMap();
        printMap();

        do{
            runHuman();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил человек");
                break;
            }
            if (getCntDot(DOT_EMPTY) == 0){
                System.out.println("Ничья");
                break;
            }
            System.out.println(getCntDot(DOT_EMPTY));
            runComputer();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("Победил компьютер");
                break;
            }

            if (getCntDot(DOT_EMPTY) == 0){
                System.out.println("Ничья");
                break;
            }

        } while(true);
    }

    private static void runComputer() {
        int x = 0, y = 0;

        int cntDot = getCntDot(DOT_O);

        if (SILLY_MODE || cntDot == 0){
            do {
                y = getRandomNumber(1, SIZE);
                x = getRandomNumber(1, SIZE);
            } while (!isValidDot(x, y));
        }else{
            int strategy[][] = {
                    {0, 1},
                    {1, 1},
                    {1, 0},
                    {1, -1},
                    {0, -1},
                    {-1, -1},
                    {-1, 0},
                    {-1, 1}
            };
            int newx;
            int newy;
            boolean flag = false;
            for (int i=1; i <= SIZE; i++){
                for (int j=1; j <= SIZE; j++){
                    if (getPoint(i, j) == DOT_O){
                        for (int st=0; st < strategy.length; st++){
                            newx = i + strategy[st][0];
                            newy = j + strategy[st][1];
                            if (isValidDot(newx, newy)){
                                //System.out.println("Умная стратегия");
                                x = newx;
                                y = newy;
                                flag = true;
                            }
                        }
                    }
                }
            }
            // нет ходов удовлетворяющих нашей стратегии
            if (!flag){
                do {
                    //System.out.println("Случайная стратегия");
                    y = getRandomNumber(1, SIZE);
                    x = getRandomNumber(1, SIZE);
                } while (!isValidDot(x, y));
            }
        }

        System.out.println("Компьютер выбрал ячейку " + x + " " + y);
        setPoint(x, y, DOT_O);

    }

    private static int getCntDot(char dot) {
        int res = 0;
        for (int i = 1; i <= SIZE; i++){
            for (int j = 1; j <= SIZE; j++) {
                if (getPoint(i, j) == dot){
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
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!isValidDot(x, y));

        setPoint(x, y, DOT_X);

    }



    private static boolean checkWin(char playerSymbol) {
        //System.out.println("running checkWin....");
        boolean result = false;
        int win_1 = 0;
        int win_2 = 0;
        // Проверка по горизонтали и вертикали
        for (int i=1; i <= SIZE; i++){
            for (int j=1; j <= SIZE; j++){
                if (getPoint(i, j) == playerSymbol){
                    win_1++;
                }
                if (getPoint(j, i) == playerSymbol){
                    win_2++;
                }
            }
            if (win_1 == SIZE || win_2 == SIZE ){
                result = true;
                break;
            }
            win_1 = 0;
            win_2 = 0;
        }

        // Проверка диагоналей

        win_1 = 0;
        for (int i=1, j=SIZE; i <= SIZE && j >=1;  i++, j--){
            if (getPoint(i, i)== playerSymbol){
                win_1++;
            }
            if (getPoint(j, i) == playerSymbol){
                win_2++;
            }
        }
        if (win_1 == SIZE || win_2 == SIZE){
            result = true;
            return result;
        }


        return result;
    }

    private static boolean isValidDot(int x, int y) {
        //System.out.println("running isValidDot...." + x + " " + y + " " + getPoint(x, y));
        boolean res = true;
        if (x < 1 || x > SIZE || y < 1 || y > SIZE || getPoint(x, y) != DOT_EMPTY) {
            res = false;
        }

        return res;
    }

    private static int getRandomNumber(int min, int max) {
        int res = 0;
        do{
            res = random.nextInt(max+1);
        } while(!(res >= min && min <= max));

        return res;
    }

    private static char getPoint(int x, int y){
        return mapa[y-1][x-1];
    }

    private static void setPoint(int x, int y, char dot) {
        mapa[y-1][x-1] = dot;
    }

    private static void printMap() {
        System.out.print("  ");
        for (int s=1; s <= SIZE; s++){
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i=1; i <= SIZE; i++){
            System.out.print(i + " ");
            for (int j=1; j <= SIZE; j++){
                System.out.print(getPoint(j, i) + " ");
            }
            System.out.println();
        }

    }

    private static void initMap() {
        for (int i=1; i <= SIZE; i++){
            for (int j=1; j <= SIZE; j++){
                setPoint(i, j, DOT_EMPTY);
            }
        }
    }

}
