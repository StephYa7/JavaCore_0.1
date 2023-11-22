package JDK.Prac_01.ChatWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ChatWindow extends JFrame {

    Path filePath = Path.of("src/main/java/JDK/Prac_01/ChatWindow/log.txt");
    private static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_POSX = 2900;
    public static final int WINDOW_POSY = 200;

    JLabel lblLogin = new JLabel("Login: ");
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
    JPanel panServer = new JPanel(new GridLayout(10, 1));
    JPanel panChat = new JPanel(new GridLayout(1, 1));

    ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);

        panServer.add(lblLogin);
        panServer.add(textFieldLogin);
        panServer.add(lblPassword);
        panServer.add(textFieldPassword);
        panServer.add(lblIP);
        panServer.add(textFieldIP);
        panServer.add(btnConnect);

        panServer.add(lblMessage);
        panServer.add(textFieldMessage);
        panServer.add(btnSend);
        panChat.add(scrollPanel);

        btnConnect.addActionListener(e -> {
            writeMessagesFromLog();
        });

        textFieldMessage.addActionListener(e -> {
            messageSend();
        });
        btnSend.addActionListener(e -> {
            messageSend();
        });
        setLayout(new GridLayout(1, 2));
        add(panServer);
        add(panChat);
        setVisible(true);

    }

    private void messageSend() {
        message = textFieldLogin.getText() + ": " + textFieldMessage.getText() + "\n";
        textAreaMessage.append(message);
        textFieldMessage.setText("");
        saveMessage();
    }

    public void writeMessagesFromLog() {
        List<String> messages;
        try {
            messages =  Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s : messages) {
            textAreaMessage.append(s);
            textAreaMessage.append("\n");
        }
    }

    public void saveMessage() {
        try {
            Files.writeString(filePath,message, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}