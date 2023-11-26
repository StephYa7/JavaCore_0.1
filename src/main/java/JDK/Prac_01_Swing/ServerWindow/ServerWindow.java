package JDK.Prac_01_Swing.ServerWindow;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements Listener {
    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");
    JButton btnExit = new JButton("Exit");
    ChatServerListener server = new Server(this);

    public ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ServerRun");
        setResizable(false);

        JPanel panelServer = new JPanel(new GridLayout(1, 2));
        panelServer.add(btnStart);
        panelServer.add(btnStop);
        add(panelServer, BorderLayout.CENTER);

        JPanel panelExit = new JPanel();
        panelExit.add(btnExit);
        add(panelExit, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(e -> server.ChatServerListener(false));
        btnStop.addActionListener(e -> server.ChatServerListener(true));
        btnExit.addActionListener(e -> setVisible(false));
    }

    @Override
    public void messageRes(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        new ServerWindow();
    }
}