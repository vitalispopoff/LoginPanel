package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    int tile;
    public static MainPanel windowPanel;
    private static boolean visibility = true;

    public MainFrame(int tile) throws HeadlessException {
        setVisible(visibility);
        this.tile = tile;
        setLocation(50, 50);
        setResizable(false);

        windowPanel = new MainPanel(tile);
        windowPanel.setBackground(new Color(238, 238, 238));
        add(windowPanel);
        pack();
    }

    public static void shutDown() {
        visibility = false;
    }
}
