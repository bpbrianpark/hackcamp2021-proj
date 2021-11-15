package ui.screens;

import ui.GUI;

import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Represents the GUI for the title screen of Favour for Favour
public class TitleScreen extends JDialog {
    private GUI gui;
    private JPanel titlePanel;

    public TitleScreen(GUI gui) {
        this.gui = gui;
    }

    // MODIFIES: this
    // EFFECTS: initializes the necessary components of title screen
    public void initialize() {
//        System.out.println("title screen here");
        // paying it forward, one favour at a time
        titlePanel = new JPanel();
        JLabel tempLabel = new JLabel("Title Screen here :D");
        tempLabel.setForeground(Color.black);
        titlePanel.add(tempLabel);
        gui.add(titlePanel);
        tempLabel.setVisible(true);
        titlePanel.setVisible(true);
        gui.setVisible(true);

        int delay = 3000; //ms
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titlePanel.setVisible(false);
            }
        };
        new javax.swing.Timer(delay, taskPerformer).start();
    }
}
