package JDK.Prac_01_Swing.ChatWindow;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Test extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_POSX = 2900;
    public static final int WINDOW_POSY = 200;

    JLabel lbl1 = new JLabel("1111111111111");
    JLabel lbl2 = new JLabel("2222222222222");
    JLabel lbl3 = new JLabel("3333333333333");
    JLabel lbl4 = new JLabel("4444444444444");
    JLabel lbl5 = new JLabel("5555555555555");
    JLabel lbl6 = new JLabel("6666666666666");
    JLabel lblPassword = new JLabel("Password: ");
    JLabel lblIP = new JLabel("IP: ");
    JLabel lblMessage = new JLabel("Message: ");
    JTextField textFieldLogin = new JTextField();
    JTextField textFieldPassword = new JTextField();
    JTextField textFieldIP = new JTextField();
    JTextField textFieldMessage = new JTextField();
    JTextArea textAreaMessage = new JTextArea();

    JScrollPane scrollPanel = new JScrollPane(textAreaMessage);
    String login;
    String password;
    String ip;
    String message;
    JButton btnSend = new JButton("Send msg:");
    JButton btnConnect = new JButton("Connect");

    Test() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);


        setLayout(new GridLayout(2, 2));
        JPanel pan1 = new JPanel(new GridLayout(2, 1));
        JPanel pan2 = new JPanel(new GridLayout(2, 1));
        JPanel pan3 = new JPanel(new GridLayout(2, 1));
        JPanel pan4 = new JPanel(new GridLayout(2, 1));

        add(pan1);
        pan1.add(lbl1);
        pan1.add(lbl2);
        pan1.add(lbl3);
        pan1.add(lbl4);
        add(pan2);
        add(pan3);
        add(pan4);
        pan2.add(lbl5);
        pan3.add(lbl6);
        setVisible(true);

    }

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("1");
            writer.append("\n");
            writer.append("e");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}