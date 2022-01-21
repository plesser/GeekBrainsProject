package lesson_06;

import javax.swing.*;
import java.awt.*;

public class ContentPaneTest extends JFrame {

    public ContentPaneTest() {
        super("Test ContentPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();
        contents.add(new JButton("Java"));
        contents.add(new JButton("PHP"));

        setContentPane(contents);
        setSize(200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ContentPaneTest();
    }
}
