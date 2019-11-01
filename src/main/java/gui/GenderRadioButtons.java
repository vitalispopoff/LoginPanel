package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.AbstractButton.PRESSED_ICON_CHANGED_PROPERTY;

public class GenderRadioButtons extends MainPanel {

    int tile;
    int elementWidth;

    JRadioButtonMenuItem female;
    JRadioButtonMenuItem male;
    ButtonGroup bg;
    private static JTextArea gender;
    private String genderName = "fe/male";


    GenderRadioButtons() {
        super();

        Action switchSexTitleToFemale = new TextAction("female");
        female = new JRadioButtonMenuItem(switchSexTitleToFemale);
        female.setBounds(tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        Action switchSexTitleToMale = new TextAction("male");
        male = new JRadioButtonMenuItem(switchSexTitleToMale);
        male.setBounds(elementWidth * tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        add(male);
        add(female);

        bg = new ButtonGroup();
        bg.add(female);
        bg.add(male);

        gender = new JTextArea(genderName);
        gender.setBackground(new Color(238, 238, 238));
        gender.setBounds(((elementWidth * tile) >> 1), tile + (tile >> 1), (tile * elementWidth) >> 1, tile);

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
            System.out.println(bg.getSelection().toString());
        }
    }

}
