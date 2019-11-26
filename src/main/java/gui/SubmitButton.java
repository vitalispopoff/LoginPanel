package gui;

import pass.Password;
import user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static gui.AboutField.aboutField;
import static gui.CheckBoxes.*;
import static gui.GenderRadioButtons.TextAction.getGender;
import static gui.LoginField.loginField;
import static java.util.Arrays.binarySearch;

public class SubmitButton extends MainPanel {

    static JButton submit;

    SubmitButton(int tile, int elementWidth, int elementHeight) {

        Action submitAction = new SubmitAction();

        submit = new JButton(submitAction);
        submit.setText("<html><p align=left><font size=" + (tile / 6) + ">Submit</font></p></html>");
        submit.setBounds(
                ((elementWidth * 2 + 3) * tile),
                (elementHeight * 5 + 4) * tile,
                elementWidth * tile,
                elementHeight * tile
        );
    }

    static class SubmitAction extends AbstractAction {

        SubmitAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder message = new StringBuilder();
            boolean loginStatus = true;
            {
                int[] allowedChars = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68,
                        69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                        81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99,
                        100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
                        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121,
                        122, 211, 243, 260, 261, 262, 263, 280, 281, 321, 322,
                        323, 324, 346, 347, 377, 378, 379, 380};

                loginStatus &= (loginField.getText().length() <= 32 & loginField.getText().length() >2);
                for (int i = 0; i < loginField.getText().length(); i++)
                    loginStatus &= Arrays.binarySearch(allowedChars, (int)(loginField.getText().charAt(i))) >= 0;
            }       // login status

            boolean passStatus = true;
            {
                passStatus &= PassButton.passField.getText().length() >= Password.getPasswordLength()
                        & PassButton.passField.getText().length() <= 32;
                for (int i = 0; i < PassButton.passField.getText().length(); i++) {
                    loginStatus &= (
                            PassButton.passField.getText().charAt(i) >= Password.getCharts()[0][0][0]
                                    && PassButton.passField.getText().charAt(i) <= Password.getCharts()[0][0][0]
                                    + Password.getCharts()[0][0][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[1][0][0]
                            && PassButton.passField.getText().charAt(i) <= Password.getCharts()[1][0][0]
                            + Password.getCharts()[1][0][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[2][0][0]
                            && PassButton.passField.getText().charAt(i) <= Password.getCharts()[2][0][0]
                            + Password.getCharts()[2][0][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[3][0][0]
                            && PassButton.passField.getText().charAt(i) <= Password.getCharts()[3][0][0]
                            + Password.getCharts()[3][0][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[3][1][0]
                            && PassButton.passField.getText().charAt(i) <= Password.getCharts()[3][1][0]
                            + Password.getCharts()[3][1][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[3][2][0]
                            && PassButton.passField.getText().charAt(i) <= Password.getCharts()[3][2][0]
                            + Password.getCharts()[3][2][1])

                            || (PassButton.passField.getText().charAt(i) >= Password.getCharts()[3][3][0]
                            & PassButton.passField.getText().charAt(i) <= Password.getCharts()[3][3][0]
                            + Password.getCharts()[3][3][1]);
                }
            }       // pass status

            /*            if (!loginStatus || !passStatus) {
             *//*String*//* message = loginStatus ? "" : "Nieprawidłowy format loginu.\n";
                message = passStatus ? message : message + "Nieprawidłowy format hasła";*/

            if(!loginStatus)message.append("Nieprawidłowy format loginu.");
            if(!loginStatus & !passStatus)message.append("\n");
            if(!passStatus)message.append("Nieprawidłowy format hasła.");
            if(loginStatus&passStatus)message.append("Bez paniki.\nWszystko w porzo.");

            JOptionPane.showMessageDialog(null,message,"Popraw poniższe błędy:",JOptionPane.ERROR_MESSAGE);
    }
}
}
