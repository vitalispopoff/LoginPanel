package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private int tile;
    int elementWidth = 5;
    int elementHeight = 2;
    private static int textElementWidth = 11;

    public static GenderRadioButtons gender;
    static ButtonGroup bg;

    MainPanel(int tile) {
        this.tile = tile;
        setLayout(null);

//  * * *   RADIOBUTTONS : GENDER   * * *

        gender = new GenderRadioButtons(tile, elementWidth);
        add(GenderRadioButtons.male);
        add(GenderRadioButtons.female);
        bg = new ButtonGroup();
        bg.add(GenderRadioButtons.female);
        bg.add(GenderRadioButtons.male);
        add(GenderRadioButtons.gender);

//  * * *   CHECKBOXES : LANGUAGES  * * *

        new CheckBoxes(tile, elementWidth, elementHeight);
        add(CheckBoxes.check_0);
        add(CheckBoxes.check_1);
        add(CheckBoxes.check_2);

//  * * *   BUTTON/FIELD : PASSWORD * * *

        new PassButton(tile, elementWidth, elementHeight, textElementWidth);
        add(PassButton.pass);
        add(PassButton.passField);

//  * * *   BUTTON/FIELD : ABOUT    * * *

        new AboutField(tile, elementWidth, elementHeight, textElementWidth);
//        add(AboutButton.about);
        add(AboutField.aboutField);

//  * * *   BUTTON      : RESET     * * *

        new ResetButton(tile, elementWidth, elementHeight);
        add(ResetButton.reset);

//  * * *   FIELD       : LOGIN     * * *

        new LoginField(tile, elementWidth, elementHeight, textElementWidth);
        add(LoginField.loginField);

        new SubmitButton(tile, elementWidth, elementHeight);
        add(SubmitButton.submit);
    }

    MainPanel() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(19 * tile, 17 * tile);
    }

}

