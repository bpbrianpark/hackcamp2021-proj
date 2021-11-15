package ui.screens;

import ui.GUI;

import javax.imageio.ImageIO;
import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


// Represents the GUI for the title screen of Favour for Favour
public class TitleScreen extends JDialog {
    private GUI gui;
    private JPanel titlePanel;
    private JLabel picLabel;
    private static String titleImgPath = "./data/image/titleImg.jpg";

    public TitleScreen(GUI gui) {
        this.gui = gui;
        titlePanel = new JPanel();
    }

    // MODIFIES: this
    // EFFECTS: initializes the necessary components of title screen
    public void initialize() {
//        try {
//            ImageIcon icon = new ImageIcon(ImageIO.read(new File(titleImgPath)));
//            picLabel = new JLabel();
//            picLabel.setIcon(icon);
//            gui.add(picLabel);
//            picLabel.setVisible(true);
//            gui.setVisible(true);
//        } catch (Exception e) {
//            System.err.println("No image found at " + titleImgPath);
//            e.printStackTrace();
//        }

//        try {
//            ImageIcon icon;
//            icon = new ImageIcon(ImageIO.read(new File(titleImgPath)));
//            JLabel picLabel = new JLabel(icon, JLabel.CENTER);
//            titlePanel.add(picLabel);
//            this.add(titlePanel);
//            picLabel.setVisible(true);
//            titlePanel.setVisible(true);
//            gui.setVisible(true);
////            ImageIcon checkmark = new ImageIcon(titleImgPath);
////            JLabel imageLabel = new JLabel(checkmark);
////            this.add(imageLabel);
////            imageLabel.setVisible(true);
//
//        } catch (IOException e) {
//            System.err.println("No image found at " + titleImgPath);
//            e.printStackTrace();
//        }

//        try {
//            ImageIcon icon;
//            icon = new ImageIcon(ImageIO.read(new File(titleImgPath)));
//            JLabel picLabel = new JLabel(icon, JLabel.CENTER);
//            picLabel.setVerticalTextPosition(JLabel.BOTTOM);
//            picLabel.setHorizontalTextPosition(JLabel.CENTER);
//            panel.add(picLabel);
//            picLabel.setVisible(true);
//        } catch (IOException e) {
//            System.err.println("No image found at " + profilePicPath);
//            e.printStackTrace();
//        }

//        titlePanel = new JPanel();
//        JLabel tempLabel = new JLabel("Title Screen here :D");
//        tempLabel.setForeground(Color.black);
//        titlePanel.add(tempLabel);
//        gui.add(titlePanel);
//        tempLabel.setVisible(true);
//        titlePanel.setVisible(true);
//        gui.setVisible(true);

        int delay = 3000; //ms
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titlePanel.setVisible(false);
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
