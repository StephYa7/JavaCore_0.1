package JDK.Prac_02_Interface.FromTheLecture.common;

import JDK.Prac_02_Interface.FromTheLecture.circles.MainWindow;

import javax.swing.*;
import java.awt.*;


public class MainCanvas extends JPanel {
    private final MainWindow controller;
    private long lastFrameTime;

    public MainCanvas(MainWindow controller) {
        setBackground(Color.BLUE);
        this.controller = controller;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);

        lastFrameTime = System.nanoTime();
        repaint();

    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

}