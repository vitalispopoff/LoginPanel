package gui;


import javax.swing.*;

public class SubmitButton extends MainPanel {

    static JButton submit;

    SubmitButton(int tile, int elementWidth, int elementHeight) {
        super();

        submit = new JButton("<html><p align=left><font size=" + (tile / 6) + ">Submit</font></p></html>");
        submit.setBounds(((elementWidth * 2 + 3) * tile), (elementHeight * 5 + 4) * tile, elementWidth * tile, elementHeight * tile);
    }
}
