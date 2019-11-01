package gui;

import javax.swing.*;

class LoginField extends MainPanel {

    static JTextField loginField;
    static String logName = "type login...";

    LoginField(int tile, int elementWidth, int elementHeight, int textElementWidth) {

        loginField = new JTextField(logName, 32);
        loginField.setBounds((elementWidth + 2) * tile, tile, textElementWidth * tile, elementHeight * tile);

    }
}
