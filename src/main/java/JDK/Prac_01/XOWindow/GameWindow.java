package JDK.Prac_01.XOWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 507;
    public static final int WINDOW_POSX = 2900;
    public static final int WINDOW_POSY = 200;

    JButton btnNewGame = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("XO");
        setResizable(false);

        this.map = new Map();


        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        btnNewGame.addActionListener(e -> {
            settings.setVisible(true);
        });


        JPanel panBottom = new JPanel(new GridLayout(2, 1));
        panBottom.add(btnNewGame);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
        settings = new SettingsWindow(this);

    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

}