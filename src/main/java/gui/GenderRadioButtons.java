package gui;

import static javax.swing.AbstractButton.PRESSED_ICON_CHANGED_PROPERTY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class GenderRadioButtons extends MainPanel {

    static JRadioButtonMenuItem female;
    static JRadioButtonMenuItem male;
    static JTextArea gender;

    GenderRadioButtons(int tile, int elementWidth) {
        super();
        Action switchSexTitleToFemale = new TextAction("female");
        female = new JRadioButtonMenuItem(switchSexTitleToFemale);
        female.setBounds(tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        Action switchSexTitleToMale = new TextAction("male");
        male = new JRadioButtonMenuItem(switchSexTitleToMale);
        male.setBounds(elementWidth * tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        String genderName = "fe/male";
        gender = new JTextArea(genderName);
        gender.setBackground(new Color(238, 238, 238));
        gender.setBounds(((elementWidth * tile) >> 1), tile + (tile >> 1), (tile * elementWidth) >> 1, tile);
    }

    static class TextAction extends AbstractAction {

        String text;

        TextAction(String text) {
            this.text = text;
            putValue(PRESSED_ICON_CHANGED_PROPERTY, text);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gender.setText(text);
        }
    }
}
