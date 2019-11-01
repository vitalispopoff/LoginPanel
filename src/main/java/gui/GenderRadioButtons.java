package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.AbstractButton.PRESSED_ICON_CHANGED_PROPERTY;

public class GenderRadioButtons extends MainPanel {
    int tile;
    int elementWidth;

    static JRadioButtonMenuItem female;
    static JRadioButtonMenuItem male;
    static ButtonGroup bg;
    protected static JTextArea gender;
    private String genderName = "fe/male";

    GenderRadioButtons(int tile, int elementWidth) {
        super();
        Action switchSexTitleToFemale = new TextAction("female");
        female = new JRadioButtonMenuItem(switchSexTitleToFemale);
        female.setBounds(tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        Action switchSexTitleToMale = new TextAction("male");
        male = new JRadioButtonMenuItem(switchSexTitleToMale);
        male.setBounds(elementWidth * tile + (tile >> 3), tile + (tile >> 1), tile, tile);

//        bg = new ButtonGroup();

        gender = new JTextArea(genderName);
        gender.setBackground(new Color(238, 238, 238));
        gender.setBounds(((elementWidth * tile) >> 1), tile + (tile >> 1), (tile * elementWidth) >> 1, tile);

/*        add(male);
        add(female);
        bg.add(female);
        bg.add(male);
        add(gender);*/

    }

            class TextAction extends AbstractAction {

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
