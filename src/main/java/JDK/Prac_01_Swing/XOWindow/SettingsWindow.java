package JDK.Prac_01_Swing.XOWindow;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 250;
    JSlider fieldSlider = new JSlider(3, 10);
    JSlider winLengthSlider = new JSlider(3, 10);
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel("Установленный размер поля:");
    JLabel winCount = new JLabel("Установленная длина:");
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup gameModeButtonsGroup = new ButtonGroup();
    JPanel panel;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel = new JPanel(new GridLayout(8, 1));
        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        panel.add(gameMode);
        panel.add(humanVsAi);
        panel.add(humanVsHuman);
        panel.add(gameField);
        panel.add(fieldSlider);
        panel.add(winCount);
        panel.add(winLengthSlider);
        panel.add(btnStart);
        humanVsAi.setSelected(true);
        fieldSlider.addChangeListener(e -> gameField.setText("Установленный размер поля: " + fieldSlider.getValue()));
        winLengthSlider.addChangeListener(e -> winCount.setText("Установленная длина: " + winLengthSlider.getValue()));
        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(humanVsAi.isSelected() ? 0 : 1,
                    fieldSlider.getValue(),
                    fieldSlider.getValue(),
                    winLengthSlider.getValue());
            setVisible(false);
        });
        add(panel);
    }
}