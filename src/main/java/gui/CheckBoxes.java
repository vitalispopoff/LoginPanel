package gui;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.SwingConstants.LEFT;

class CheckBoxes extends MainPanel {

    static JCheckBox check_0;
    static JCheckBox check_1;
    static JCheckBox check_2;
    static boolean language_0;
    static boolean language_1;
    static boolean language_2;

    ActionListener listener = event -> {
        language_0 = check_0.isSelected() ? true : false;
        language_1 = check_1.isSelected() ? true : false;
        language_2 = check_2.isSelected() ? true : false;
    };

    CheckBoxes(int tile, int elementWidth, int elementHeight) {
        super();

        check_0 = new JCheckBox();
        check_0.addActionListener(listener);
        check_0.setText("<html><p align=left><font  size=" + (tile / 6) + ">Python</font></p></html>");
        check_0.setBounds(tile + (tile >> 3), (elementHeight * 3 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_0.setHorizontalAlignment(SwingConstants.RIGHT);
        check_0.setVerticalAlignment(SwingConstants.CENTER);
        check_0.setHorizontalTextPosition(LEFT);
        check_0.setVerticalTextPosition(SwingConstants.CENTER);

        check_1 = new JCheckBox();
        check_1.addActionListener(listener);
        check_1.setBounds(tile + (tile >> 3), (elementHeight * 4 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_1.setText("<html><p align=left><font size=" + (tile / 6) + ">Java</font></p></html>");
        check_1.setHorizontalAlignment(SwingConstants.RIGHT);
        check_1.setVerticalAlignment(SwingConstants.CENTER);
        check_1.setHorizontalTextPosition(LEFT);
        check_1.setVerticalTextPosition(SwingConstants.CENTER);

        check_2 = new JCheckBox();
        check_2.addActionListener(listener);
        check_2.setBounds(tile + (tile >> 3), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_2.setText("<html><p align=left><font size=" + (tile / 6) + ">C</font></p></html>");
        check_2.setHorizontalAlignment(SwingConstants.RIGHT);
        check_2.setVerticalAlignment(SwingConstants.CENTER);
        check_2.setHorizontalTextPosition(LEFT);
        check_2.setVerticalTextPosition(SwingConstants.CENTER);

        check_1.setSelected(true);
    }



/*    static class CheckBoxAction extends AbstractAction {

        CheckBoxAction(){}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }*/
}
