package JDK.Prac_01.ServerWindow;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 507;
    public static final int WINDOW_POSX = 2900;
    public static final int WINDOW_POSY = 200;
    JButton btnStart = new JButton("Start server");
    JButton btnStop = new JButton("Stop server");
    boolean serverIsRunning;

    ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server panel");
        setResizable(false);
        btnStart.addActionListener(e -> {
            if (!serverIsRunning) {
                serverIsRunning = true;
            }
        });
        btnStop.addActionListener(e -> {
            if (serverIsRunning) {
                serverIsRunning = false;
            }
        });
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }
}