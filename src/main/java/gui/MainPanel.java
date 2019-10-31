package gui;

import static javax.swing.SwingConstants.*;
import static pass.Password.generatePass;
import static javax.swing.AbstractButton.PRESSED_ICON_CHANGED_PROPERTY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;

import pass.Password;

public class MainPanel extends JPanel {

    int tile;
    private static int elementWidth = 5;
    private static int elementHeight = 2;
    private static int textElementWidth = 11;
    JRadioButtonMenuItem female;
    JRadioButtonMenuItem male;
    ButtonGroup bg;
    private static JTextArea gender;
    private static JTextField passField;
    private static JTextField loginField;
    private static JTextArea aboutField;
    private String genderName = "fe/male";
    private String passName = "type or generate pass";
    private String logName = "type login...";
    private String infoName = "a few words about Yourself";

    MainPanel(int tile) {
        this.tile = tile;
        setLayout(null);

        Action actionPassGenerate;

/*        Action switchSexTitleToFemale = new TextAction("female");
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

        JButton about = new JButton("<html><p align=left><font size=" + (tile / 6) + ">About</font></p></html>");
        about.setBounds(tile, (elementHeight * 2 + 3) * tile, elementWidth * tile, elementHeight * tile);*/

        Action passGenerate = new PassGenerate();
        JButton pass = new JButton(passGenerate);
        pass.setText("<html><p align=left><font size=" + (tile / 6) + ">Pass</font></p></html>");
        pass.setBounds(tile, (elementHeight + 2) * tile, elementWidth * tile, elementHeight * tile);

        Action resetAction = new ResetAction();
        JButton reset = new JButton(resetAction);
        reset.setText("<html><p align=left><font size=" + (tile / 6) + ">Reset</font></p></html>");
        reset.setBounds(((elementWidth + 2) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);

        JButton submit = new JButton("<html><p align=left><font size=" + (tile / 6) + ">Submit</font></p></html>");
        submit.setBounds(((elementWidth * 2 + 3) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
/*
        JCheckBox check_1 = new JCheckBox();
        check_1.setText("<html><p align=left><font  size=" + (tile / 6) + ">Python</font></p></html>");
        check_1.setBounds(tile + (tile >> 3), (elementHeight * 3 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_1.setHorizontalAlignment(SwingConstants.RIGHT);
        check_1.setVerticalAlignment(SwingConstants.CENTER);
        check_1.setHorizontalTextPosition(LEFT);
        check_1.setVerticalTextPosition(SwingConstants.CENTER);

        JCheckBox check_2 = new JCheckBox();
        check_2.setBounds(tile + (tile >> 3), (elementHeight * 4 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_2.setText("<html><p align=left><font size=" + (tile / 6) + ">Java</font></p></html>");
        check_2.setHorizontalAlignment(SwingConstants.RIGHT);
        check_2.setVerticalAlignment(SwingConstants.CENTER);
        check_2.setHorizontalTextPosition(LEFT);
        check_2.setVerticalTextPosition(SwingConstants.CENTER);

        JCheckBox check_3 = new JCheckBox();
        check_3.setBounds(tile + (tile >> 3), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_3.setText("<html><p align=left><font size=" + (tile / 6) + ">C</font></p></html>");
        check_3.setHorizontalAlignment(SwingConstants.RIGHT);
        check_3.setVerticalAlignment(SwingConstants.CENTER);
        check_3.setHorizontalTextPosition(LEFT);
        check_3.setVerticalTextPosition(SwingConstants.CENTER);

        check_2.setSelected(true);

        loginField = new JTextField(logName, 32);
        loginField.setBounds((elementWidth + 2) * tile, tile, textElementWidth * tile, elementHeight * tile);*/

        passField = new JTextField(passName, Password.getPasswordLength());
        passField.setBounds((elementWidth + 2) * tile, (elementHeight + 2) * tile, textElementWidth * tile, elementHeight * tile);

/*        aboutField = new JTextArea(infoName);
        aboutField.setBounds((elementWidth + 2) * tile, (elementHeight * 2 + 3) * tile, textElementWidth * tile, elementHeight * 3 * tile);
        aboutField.setLineWrap(true);

        aboutField.setColumns(5);

        add(gender);
        add(about);
        add(loginField);
        add(aboutField);
        add(check_1);
        add(check_2);
        add(check_3);*/

        add(pass);

        add(reset);
        add(submit);

        add(passField);

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
//            System.out.println("male "+male.isSelected()+"; female"+female.isSelected());
            System.out.println(bg.getSelection().toString());
        }
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

    class ResetAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            passField.setText(passName = "type or generate pass");
/*            gender.setText(genderName = "fe/male");
            loginField.setText(logName = "type login...");
            aboutField.setText(infoName = "a few words about Yourself");
            bg.clearSelection();*/

        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(19 * tile, 17 * tile);
    }

}










/*
 *   ============================================
 *       sources:
 *
 *       https://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
 *
 *
 *
 *
 *
 *
 *   ============================================
 */  //notes

