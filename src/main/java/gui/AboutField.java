package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AboutField extends MainPanel {

    static JButton about;
    static JTextArea aboutField;
    static String infoName = "a few words about Yourself";

    AboutField(int tile, int elementWidth, int elementHeight, int textElementWidth) {
        super();

        aboutField = new JTextArea();
        aboutField.setText(infoName);
        aboutField.setBounds((elementWidth + 2) * tile, (elementHeight * 2 + 3) * tile, textElementWidth * tile, elementHeight * 3 * tile);
        aboutField.setBorder(new LineBorder(new Color(0,0,0),1,true));
        aboutField.setLineWrap(true);

//        System.out.println(aboutField.getRegisteredKeyStrokes().toString());
    }
}

/*        about = new JButton("<html><p align=left><font size=" + (tile / 6) + ">About</font></p></html>");
        about.setBounds(tile, (elementHeight * 2 + 3) * tile, elementWidth * tile, elementHeight * tile);*/ //  unused textfield button