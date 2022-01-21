package lesson_06;

import javax.swing.*;
import java.awt.*;

public class MyFlowLayout extends JFrame {
    public MyFlowLayout() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 120);

        Container container = getContentPane();

        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(new JButton("Школа"));
        container.add(new JButton("ИНститут"));
        container.add(new JButton("Академия"));

        setVisible(true);
    }

    public static void main(String[] args) {
        MyFlowLayout layout = new MyFlowLayout();
    }
}
