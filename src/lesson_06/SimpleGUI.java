package lesson_06;

import javax.swing.*;
import java.awt.*;

public class SimpleGUI {
    public static void main(String[] args) {
        createGUI();
    }

    public static void createGUI(){
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Test label");
        frame.getContentPane().add(label);
        frame.setPreferredSize(new Dimension(200, 100));
        frame.pack();
        frame.setVisible(true);
    }
}
