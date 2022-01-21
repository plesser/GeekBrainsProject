package lesson_06;

import javax.swing.*;
import java.awt.*;

public class MyVerticalLayout extends JFrame {
    public Dimension minimumLayoutSize(Container c){
        return calculateBestSize(c);
    }

    public Dimension preferredLayoutSize(Container c){
        return calculateBestSize(c);
    }

    public void layoutContainer(Container container){
        Component list[] = container.getComponents();
        int currentY = 5;
        for (int i=0; i < list.length; i++){
            Dimension pref = list[i].getPreferredSize();
            list[i].setBounds(5, currentY, pref.width, pref.height);
            currentY += 5;
            currentY += pref.height;
        }
    }

    private Dimension calculateBestSize(Container c){
        Dimension size = new Dimension();

        Component list[] = c.getComponents();
        int maxWidth = 0;
        for (int i=0; i < list.length; i++){
            int width = list[i].getWidth();
            if (width > maxWidth){
                maxWidth = width;
            }
        }

        size.width = maxWidth + 5;

        int height = 0;
        for (int i=0; i < list.length; i++){
            height += 5;
            height += list[i].getHeight();
        }

        size.height = height;
        return size;
    }
}
