package JDK.Prac_02_Interface.FromTheLecture.circles;

import JDK.Prac_02_Interface.FromTheLecture.common.Interactable;
import JDK.Prac_02_Interface.FromTheLecture.common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private final Interactable[] sprites = new Interactable[30];
    int count = 0;

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");


        sprites[0] = new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }


    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }


    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }


    public static void main(String[] args) {
        new MainWindow();
    }

}