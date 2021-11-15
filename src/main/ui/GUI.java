package ui;

import ui.screens.MainScreen;
import ui.screens.TitleScreen;

import javax.swing.*;
import java.awt.*;

// GUI using Java Swing
public class GUI extends JFrame {
    private static final int MIN_WIDTH = 1920;
    private static final int MIN_HEIGHT = 1080;

    private TitleScreen titleScreen;
    private MainScreen mainScreen;

    public GUI() {
        initializeGUI();
    }

    public void initializeGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Favour for Favour");
        setResizable(true);
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setLocationRelativeTo(null);

        initializeTitle();
        initializeMain();
    }

    private void initializeTitle() {
        titleScreen = new TitleScreen(this);
        mainScreen = new MainScreen(this);
        titleScreen.initialize();
    }

    private void initializeMain() {
        mainScreen.initialize();
    }
}
