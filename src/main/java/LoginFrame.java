import gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame windowFrame = new MainFrame(16);
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}


