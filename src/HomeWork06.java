import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWork06 extends JFrame{

    JTextField textField;

    Double number1;
    Double number2;

    String operator;
    boolean clear = false;

    public JPanel getKeyboard(){
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(0, 4, 5, 12);
        grid.setLayout(layout);

        JButton digits[] = new JButton[10];

        JButton button_0 = new JButton("0");
        JButton button_1 = new JButton("1");
        JButton button_2 = new JButton("2");
        JButton button_3 = new JButton("3");

        JButton button_4 = new JButton("4");
        JButton button_5 = new JButton("5");
        JButton button_6 = new JButton("6");
        JButton button_7 = new JButton("7");

        JButton button_8 = new JButton("8");
        JButton button_9 = new JButton("9");

        digits[0] = button_0;
        digits[1] = button_1;
        digits[2] = button_2;
        digits[3] = button_3;
        digits[4] = button_4;
        digits[5] = button_5;
        digits[6] = button_6;
        digits[7] = button_7;
        digits[8] = button_8;
        digits[9] = button_9;

        JButton button_plus = new JButton("+");
        JButton button_minus = new JButton("-");
        JButton button_div = new JButton("/");
        JButton button_multi = new JButton("*");
        JButton button_pow = new JButton("^");

        JButton button_clear = new JButton("C");
        JButton button_dot = new JButton(".");
        JButton button_ready = new JButton("=");
        JButton button_backspace = new JButton("<");

        grid.add(button_1);
        grid.add(button_2);
        grid.add(button_3);
        grid.add(button_plus);

        grid.add(button_4);
        grid.add(button_5);
        grid.add(button_6);
        grid.add(button_minus);

        grid.add(button_7);
        grid.add(button_8);
        grid.add(button_9);
        grid.add(button_div);

        grid.add(button_0);
        grid.add(button_clear);
        grid.add(button_ready);
        grid.add(button_multi);
        grid.add(button_pow);
        grid.add(button_dot);

        for (int i=0; i<10; i++){
            int finalI = i;
            digits[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (textField.getText().length() <= 10) {
                        if (!clear) {
                            textField.setText(textField.getText() + "" + finalI);
                        } else {
                            textField.setText("" + finalI);
                            clear = false;
                        }
                    }
                }
            });
        }

        button_backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText(textField.getText().substring(0, textField.getText().length()-1));
            }
        });

        button_dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField.getText().length() <= 9) {
                    textField.setText(textField.getText() + "." );
                }
            }
        });

        button_plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number1 = res;
                operator = "+";
                //textField.setText("");
                clear = true;
            }
        });

        button_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number1 = res;
                operator = "-";
                //textField.setText("");
                clear = true;
            }
        });

        button_multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number1 = res;
                operator = "*";
                //textField.setText("");
                clear = true;
            }
        });

        button_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number1 = res;
                operator = "/";
                //textField.setText("");
                clear = true;
            }
        });

        button_pow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number1 = res;
                operator = "^";
                //textField.setText("");
                clear = true;
            }
        });

        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("");
            }
        });

        button_ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double res = getNumber(textField.getText());
                number2 = res;
                res = operation(number1, number2, operator);
                textField.setText(Double.toString(res));
                clear = true;
            }
        });


        return grid;
    }

    private double operation(Double number1, Double number2, String operator) {
        double res = 0;

        switch (operator){
            case "+":
                res = number1 + number2;
                break;
            case "-":
                res = number1 - number2;
                break;
            case "*":
                res = number1 * number2;
                break;
            case "/":
                res = number1 / number2;
                break;
            case "^":
                res = Math.pow(number1 , number2);
                break;
        }
        return res;
    }

    private double getNumber(String numbers) {
        return Double.parseDouble(numbers);
    }

    public JPanel getDisplay() {
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(0, 1);
        grid.setLayout(layout);

        Font font = new Font("Times", Font.BOLD,64);

        textField = new JTextField("", 128);
        textField.setEditable(false);
        textField.setFont(font);
        //textField.setSize(128, 12);
        grid.add(textField);

        grid.setSize(128, 1280);


        return grid;
    }

    public HomeWork06() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 480);


        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(0, 1, 5, 12);
        grid.setLayout(layout);

        grid.add(getDisplay());
        grid.add(getKeyboard());

        //grid.getComponents()[0].setSize(128, 2);

        getContentPane().add(grid);

        setVisible(true);
    }

    public static void main(String[] args) {
        HomeWork06 frame = new HomeWork06();
    }
}
