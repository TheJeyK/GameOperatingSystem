package my.project.gop.main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    boolean fse = false;
    int fsm = 0;
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public GameWindow(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setfullscreen() {
        switch (fsm) {
            case 0:
                System.out.println("No Fullscreen");
                setUndecorated(false);
                break;
            case 1:
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setUndecorated(false);
                break;
            case 2:
                device.setFullScreenWindow(this);
                setUndecorated(true);
                break;
        }
    }

    public void setFullscreen(int fsnm)
    {
        fse=true;
        if (fsm <= 2)
        {
            this.fsm = fsnm;
            setfullscreen();
        }
        else
        {
            System.err.println("Error " + fsnm + " is not supported");
        }
    }
}