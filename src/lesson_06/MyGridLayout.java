package lesson_06;

import javax.swing.*;
import java.awt.*;

public class MyGridLayout extends JFrame {
    public MyGridLayout() {
        setSize(320, 320);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(2, 0, 5, 12);
        grid.setLayout(layout);

        for (int i=0; i<8; i++){
            grid.add(new JButton("Кнопка " + i));
        }

        getContentPane().add(grid);
        pack();

        setVisible(true);
    }

    public static void main(String[] args) {
        MyGridLayout layout = new MyGridLayout();
    }
}
