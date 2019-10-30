package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.AbstractButton.PRESSED_ICON_CHANGED_PROPERTY;

import pass.Password;

import static javax.swing.SwingConstants.*;

public class MainPanel extends JPanel {


    int tile;
    private static int elementWidth = 5;
    private static int elementHeight = 2;
    private static int textElementWidth = 11;
    private static JTextArea gender;
    private String genderName;
    private String passName;
    private String logName;
    private String infoName;

    MainPanel(int tile) {
        this.tile = tile;
        setLayout(null);

        Action actionPassGenerate;


        Action switchSexTitleToFemale = new TextAction("female");
        JRadioButtonMenuItem female = new JRadioButtonMenuItem(switchSexTitleToFemale);
        female.setBounds(tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        Action switchSexTitleToMale = new TextAction("male");
        JRadioButtonMenuItem male = new JRadioButtonMenuItem(switchSexTitleToMale);
        male.setBounds(elementWidth * tile + (tile >> 3), tile + (tile >> 1), tile, tile);

        add(male);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(female);
        bg.add(male);

        gender = new JTextArea(genderName = "fe/male");
        gender.setBackground(new Color(238, 238, 238));
        gender.setBounds(((elementWidth * tile) >> 1), tile + (tile >> 1), (tile * elementWidth) >> 1, tile);


        JButton pass = new JButton("<html><p align=left><font size=" + (tile / 6) + ">Pass</font></p></html>");
        pass.setBounds(tile, (elementHeight + 2) * tile, elementWidth * tile, elementHeight * tile);

        JButton about = new JButton("<html><p align=left><font size=" + (tile / 6) + ">About</font></p></html>");
        about.setBounds(tile, (elementHeight * 2 + 3) * tile, elementWidth * tile, elementHeight * tile);

        JButton reset = new JButton("<html><p align=left><font size=" + (tile / 6) + ">Reset</font></p></html>");
        reset.setBounds(((elementWidth + 2) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
//        reset.addActionListener(new );

        JButton submit = new JButton("<html><p align=left><font size=" + (tile / 6) + ">Submit</font></p></html>");
        submit.setBounds(((elementWidth * 2 + 3) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);

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

        JTextField loginFieled = new JTextField(logName = "type login...", 32);
        loginFieled.setBounds((elementWidth + 2) * tile, tile, textElementWidth * tile, elementHeight * tile);

        JTextField passField = new JTextField(passName = "type or generate pass", Password.getPasswordLength());
        passField.setBounds((elementWidth + 2) * tile, (elementHeight + 2) * tile, textElementWidth * tile, elementHeight * tile);

        JTextField aboutField = new JTextField(infoName = "your short description");
        aboutField.setBounds((elementWidth + 2) * tile, (elementHeight * 2 + 3) * tile, textElementWidth * tile, elementHeight * 3 * tile);


        add(gender);
        add(pass);
        add(about);
        add(reset);
        add(submit);

        add(check_1);
        add(check_2);
        add(check_3);
        add(loginFieled);
        add(passField);
        add(aboutField);

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


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(19 * tile, 17 * tile);
    }

/*    @Override
    public void actionPerformed(ActionEvent e) {

    }*/
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

