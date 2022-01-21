package lesson_06;

import javax.swing.*;
import java.awt.*;

public class MyBorderLayout extends JFrame {

    public MyBorderLayout() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        Container container = getContentPane();

        container.add(new JButton("Север"), "North");
        container.add(new JButton("Юг"), "South");
        container.add(new JButton("Запад"), BorderLayout.WEST);
        container.add(new JButton("Восток"), BorderLayout.EAST);

        container.add(new JButton("Центр"));
        setVisible(true);
    }

    public static void main(String[] args) {
        MyBorderLayout layout = new MyBorderLayout();
    }
}
