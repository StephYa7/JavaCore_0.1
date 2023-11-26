package JDK.Prac_02_Interface.FromTheLecture.circles;

import JDK.Prac_02_Interface.FromTheLecture.common.Interactable;
import JDK.Prac_02_Interface.FromTheLecture.common.MainCanvas;

import java.awt.*;

public class Background implements Interactable {
    private float time;
    public static final float AMPLITUDE = 225f / 2f;
    private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }


}