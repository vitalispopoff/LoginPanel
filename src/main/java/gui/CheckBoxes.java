package gui;

import javax.swing.*;

import static javax.swing.SwingConstants.LEFT;

class CheckBoxes extends MainPanel {

    static JCheckBox check_1;
    static JCheckBox check_2;
    static JCheckBox check_3;

    CheckBoxes(int tile, int elementWidth, int elementHeight) {
        super();

        check_1 = new JCheckBox();
        check_1.setText("<html><p align=left><font  size=" + (tile / 6) + ">Python</font></p></html>");
        check_1.setBounds(tile + (tile >> 3), (elementHeight * 3 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_1.setHorizontalAlignment(SwingConstants.RIGHT);
        check_1.setVerticalAlignment(SwingConstants.CENTER);
        check_1.setHorizontalTextPosition(LEFT);
        check_1.setVerticalTextPosition(SwingConstants.CENTER);

        check_2 = new JCheckBox();
        check_2.setBounds(tile + (tile >> 3), (elementHeight * 4 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_2.setText("<html><p align=left><font size=" + (tile / 6) + ">Java</font></p></html>");
        check_2.setHorizontalAlignment(SwingConstants.RIGHT);
        check_2.setVerticalAlignment(SwingConstants.CENTER);
        check_2.setHorizontalTextPosition(LEFT);
        check_2.setVerticalTextPosition(SwingConstants.CENTER);

        check_3 = new JCheckBox();
        check_3.setBounds(tile + (tile >> 3), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
        check_3.setText("<html><p align=left><font size=" + (tile / 6) + ">C</font></p></html>");
        check_3.setHorizontalAlignment(SwingConstants.RIGHT);
        check_3.setVerticalAlignment(SwingConstants.CENTER);
        check_3.setHorizontalTextPosition(LEFT);
        check_3.setVerticalTextPosition(SwingConstants.CENTER);

        check_2.setSelected(true);
    }
}
