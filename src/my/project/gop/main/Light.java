package my.project.gop.main;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Light {

    public Vector2F lightPos = new Vector2F();
    private int radius;
    private int lightPower;
    private BufferedImage image;

    public Light(float xpos, float ypos, int radius, int lightpower) {
        this.lightPos.xPos = xpos;
        this.lightPos.yPos = ypos;
        this.radius = radius;
        this.lightPower = lightpower;

        Point2D center = new Point(radius, radius);
        Point2D focus = new Point(radius, radius);

        float[] dist = {0F, 1F};
        Color[] colors = {new Color(0, 0, 0, lightPower), new Color(0, 0, 0, 0)};

        image = new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = (Graphics2D) image.getGraphics();

        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);
        g2.setPaint(rgp);

        g2.fillOval(0, 0, radius*2, radius*2);
    }

    public void render(Graphics2D g) {
        g.drawImage(image, (int)lightPos.xPos, (int)lightPos.yPos, null);
    }
}
