package gui;

import pass.Password;

import static pass.Password.generatePass;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PassButton extends MainPanel {

    private Action passGenerate;
    static int tile;
    static JButton pass;
    static JTextField passField;
    static String passName = "type or generate pass";


    PassButton(int tile, int elementWidth, int elementHeight, int textElementWidth) {
        super();
        passGenerate = new PassGenerate();
        pass = new JButton(passGenerate);
        pass.setText("<html><p align=left><font size=" + (tile / 6) + ">Pass</font></p></html>");
        pass.setBounds(tile, (elementHeight + 2) * tile, elementWidth * tile, elementHeight * tile);

        passField = new JTextField(passName, Password.getPasswordLength());
        passField.setBounds((elementWidth + 2) * tile, (elementHeight + 2) * tile, textElementWidth * tile, elementHeight * tile);
    }

    class PassGenerate extends AbstractAction {
        String text;

        PassGenerate() {
            this.text = generatePass();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            passField.setText(text);
        }
    }
}
