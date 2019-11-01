package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

class ResetButton extends MainPanel {

    static JButton reset;

    ResetButton(int tile, int elementWidth, int elementHeight) {

        Action resetAction = new ResetAction();
        reset = new JButton(resetAction);
        reset.setText("<html><p align=left><font size=" + (tile / 6) + ">Reset</font></p></html>");
        reset.setBounds(((elementWidth + 2) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
    }

    static class ResetAction extends AbstractAction {

        ResetAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            PassButton.passField.setText(PassButton.passName = "type or generate pass");
            GenderRadioButtons.gender.setText(GenderRadioButtons.genderName = "fe/male");
            LoginField.loginField.setText(LoginField.logName = "type login...");
            AboutButton.aboutField.setText(AboutButton.infoName = "a few words about Yourself");
            MainPanel.bg.clearSelection();
            CheckBoxes.check_1.setSelected(false);
            CheckBoxes.check_2.setSelected(true);
            CheckBoxes.check_3.setSelected(false);
        }
    }
}
