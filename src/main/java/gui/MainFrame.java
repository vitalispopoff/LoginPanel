package gui;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    int tile;


    public MainFrame(int tile) throws HeadlessException {
        this.tile = tile;
        setLocation(50, 50);
        setResizable(false);

        MainPanel windowPanel = new MainPanel(tile);
        windowPanel.setBackground(new Color(238, 238, 238));
        add(windowPanel);
        pack();


    }
}
