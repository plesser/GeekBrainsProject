import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HomeWork08 extends JFrame {
    JButton startButton;
    JButton field[];


    final boolean SILLY_MODE = false;
    Random random = new Random();

    int SIZE = 3;
    String[][] mapa = new String[SIZE][SIZE];

    String DOT_EMPTY = ".";
    String DOT_X = "X";
    String DOT_O = "O";


    public JPanel getKeyboard() {
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(3, 3, 12, 12);
        grid.setLayout(layout);

        field = new JButton[9];

        JButton button_0 = new JButton(""); // 1 1
        JButton button_1 = new JButton(""); // 2 1
        JButton button_2 = new JButton(""); // 3 1

        JButton button_3 = new JButton(""); // 1 2
        JButton button_4 = new JButton(""); // 2 2
        JButton button_5 = new JButton(""); // 3 2

        JButton button_6 = new JButton(""); // 1 3
        JButton button_7 = new JButton(""); // 2 3
        JButton button_8 = new JButton(""); // 3 3

        grid.add(button_0);
        grid.add(button_1);
        grid.add(button_2);
        grid.add(button_3);
        grid.add(button_4);
        grid.add(button_5);
        grid.add(button_6);
        grid.add(button_7);
        grid.add(button_8);

        field[0] = button_0;
        field[1] = button_1;
        field[2] = button_2;
        field[3] = button_3;
        field[4] = button_4;
        field[5] = button_5;
        field[6] = button_6;
        field[7] = button_7;
        field[8] = button_8;

        for (int i=0; i<field.length; i++){
            field[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int x = 0; int y = 0;
                    JButton buttonClick = null;

                    if (actionEvent.getSource().equals(button_0)){
                        buttonClick = button_0;
                        System.out.println("button 0");
                        x = 1;
                        y = 1;
                    } else if (actionEvent.getSource().equals(button_1)){
                        buttonClick = button_1;
                        System.out.println("button 1");
                        x = 2;
                        y = 1;
                    } else if (actionEvent.getSource().equals(button_2)){
                        buttonClick = button_2;
                        System.out.println("button 2");
                        x = 3;
                        y = 1;
                    } else if (actionEvent.getSource().equals(button_3)){
                        buttonClick = button_3;
                        System.out.println("button 3");
                        x = 1;
                        y = 2;
                    } else if (actionEvent.getSource().equals(button_4)){
                        buttonClick = button_4;
                        System.out.println("button 4");
                        x = 2;
                        y = 2;
                    } else if (actionEvent.getSource().equals(button_5)){
                        buttonClick = button_5;
                        System.out.println("button 5");
                        x = 3;
                        y = 2;
                    } else if (actionEvent.getSource().equals(button_6)){
                        buttonClick = button_6;
                        System.out.println("button 6");
                        x = 1;
                        y = 3;
                    } else if (actionEvent.getSource().equals(button_7)){
                        buttonClick = button_7;
                        System.out.println("button 7");
                        x = 2;
                        y = 3;
                    } else if (actionEvent.getSource().equals(button_8)){
                        buttonClick = button_8;
                        System.out.println("button 8");
                        x = 3;
                        y = 3;
                    }

                    if (isValidDot(x, y)) {
                        setPoint(x, y, DOT_X);
                        buttonClick.setEnabled(false);
                        buttonClick.setText(DOT_X);
                        if (checkWin(DOT_X)){
                            System.out.println("Победил человек");
                            disabledAllButtons();
                        }
                        if (getCntDot(DOT_EMPTY) == 0){
                            System.out.println("Ничья");
                            disabledAllButtons();
                        }

                        runComputer();
                        printMap();
                        if (checkWin(DOT_O)){
                            System.out.println("Победил компьютер");
                            disabledAllButtons();
                        }

                        if (getCntDot(DOT_EMPTY) == 0){
                            System.out.println("Ничья");
                            disabledAllButtons();
                        }


                    } else {
                        System.out.println("button is not valid");
                    }
                    printMap();
                }
            });
        }

        return grid;
    }

    private void disabledAllButtons() {
        for (JButton button : field){
            button.setEnabled(false);
        }
    }

    public HomeWork08() {
        setTitle("Крестики нолики");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 480);


        JPanel grid = new JPanel();
        BorderLayout layout = new BorderLayout(12, 12);
        grid.setLayout(layout);

        startButton = new JButton("Новая игра");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initMap();
                enabledAllButtons();
            }
        });

        grid.add(startButton, BorderLayout.NORTH);
        grid.add(getKeyboard(), BorderLayout.CENTER);

        //grid.getComponents()[0].setSize(128, 2);

        getContentPane().add(grid);

        initMap();


        setVisible(true);
    }

    private void enabledAllButtons() {
        for (JButton button : field){
            button.setEnabled(true);
        }
    }


    private void setPoint(int x, int y, String dot) {
        mapa[y-1][x-1] = dot;
    }

    private void initMap() {
        int step = 0;
        for (int i=1; i <= SIZE; i++){
            for (int j=1; j <= SIZE; j++){
                setPoint(i, j, DOT_EMPTY);
                field[step].setText(DOT_EMPTY);
                step++;
            }
        }
    }

    private boolean isValidDot(int x, int y) {
        //System.out.println("running isValidDot...." + x + " " + y + " " + getPoint(x, y));
        boolean res = true;
        if (x < 1 || x > SIZE || y < 1 || y > SIZE || getPoint(x, y) != DOT_EMPTY) {
            res = false;
        }

        return res;
    }


    private String getPoint(int x, int y){
        return mapa[y-1][x-1];
    }


    private void printMap() {
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

    private boolean checkWin(String playerSymbol) {
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

    private int getCntDot(String dot) {
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

    private void runComputer() {
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

        int button = (y - 1) * SIZE + x - 1;
        System.out.println("Компьютер выбрал ячейку " + x + " " + y + " кнопка " + button);
        field[button].setText(DOT_O);
        field[button].setEnabled(false);
        setPoint(x, y, DOT_O);

    }

    private int getRandomNumber(int min, int max) {
        int res = 0;
        do{
            res = random.nextInt(max+1);
        } while(!(res >= min && min <= max));

        return res;
    }


    public static void main(String[] args) {
        HomeWork08 game = new HomeWork08();
    }
}
