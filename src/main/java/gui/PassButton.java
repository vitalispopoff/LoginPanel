package gui;

import static pass.Password.generatePass;

import pass.Password;

import javax.swing.*;
import java.awt.event.ActionEvent;


class PassButton extends MainPanel {

    static JButton pass;
    static JTextField passField;
    protected static String passName = "type or generate pass";
    private static String text;


    PassButton(int tile, int elementWidth, int elementHeight, int textElementWidth) {
        super();
        Action passGenerate = new PassGenerate();
        pass = new JButton(passGenerate);
        pass.setText("<html><p align=left><font size=" + (tile / 6) + ">Pass</font></p></html>");
        pass.setBounds(tile, (elementHeight + 2) * tile, elementWidth * tile, elementHeight * tile);

        passField = new JTextField(passName, Password.getPasswordLength());
        passField.setBounds((elementWidth + 2) * tile, (elementHeight + 2) * tile, textElementWidth * tile, elementHeight * tile);
    }

    static class PassGenerate extends AbstractAction {


        PassGenerate() {
            text = generatePass();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            passField.setText(text);
        }
    }
}



