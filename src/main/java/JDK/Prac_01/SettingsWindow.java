package JDK.Prac_01;

import javax.swing.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_POSX = 2970;
    public static final int WINDOW_POSY = 380;

    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindow gameWindow) {
        setTitle("???");
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(e->{
            gameWindow.startNewGame(0,3,3,3);
            setVisible(false);
        });

        add(btnStart);
    }
}