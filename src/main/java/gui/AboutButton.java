package gui;

import javax.swing.*;
import java.awt.*;

public class AboutButton extends MainPanel {

    static JButton about;
    static JTextArea aboutField;
    static String infoName = "a few words about Yourself";

    AboutButton(int tile, int elementWidth, int elementHeight, int textElementWidth) {
        super();

        aboutField = new JTextArea(infoName);
        aboutField.setBounds((elementWidth + 2) * tile, (elementHeight * 2 + 3) * tile, textElementWidth * tile, elementHeight * 3 * tile);
        aboutField.setLineWrap(true);

//        System.out.println(aboutField.getRegisteredKeyStrokes().toString());
    }
}

/*        about = new JButton("<html><p align=left><font size=" + (tile / 6) + ">About</font></p></html>");
        about.setBounds(tile, (elementHeight * 2 + 3) * tile, elementWidth * tile, elementHeight * tile);*/ //  unused textfield button