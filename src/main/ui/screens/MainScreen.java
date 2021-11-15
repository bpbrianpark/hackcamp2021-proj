package ui.screens;

import ui.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Represents a main screen for the GUI
public class MainScreen {
    protected static final Color MAIN_CONTAINER_COLOR = new Color(42, 34, 74);
    protected static final Color TOP_PANEL_COLOR = new Color(255, 252, 171);
    protected static final Color LEFT_PANEL_COLOR = new Color(243, 0, 198);
    protected static final Color RIGHT_PANEL_COLOR = new Color(0, 220, 230);
    protected static final Color SIDE_PANEL_FONT_COLOR = Color.white;
    protected static final int TOP_PANEL_FONT_SIZE = 30;
    private static final int HGAP = 8;
    private static final int VGAP = 6;
    protected Container mainContainer;
    protected GUI gui;

    private String profilePicPath = "./data/image/elmo.jpg";

    // EFFECTS: initializes the MainScreen's GUI as the current GUI
    public MainScreen(GUI gui) {
        this.gui = gui;
    }

    // MODIFIES: this
    // EFFECTS: sets up components for the main screen.
    public void initialize() {
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        loadDataFromJson();

        setupMainContainer();
        setupTopPanel(mainContainer);
        setupLeftPanel(mainContainer);
        setupRightPanel(mainContainer);
    }

    // MODIFIES: this
    // EFFECTS: initializes the value of the mainContainer and sets the layout and background
    private void setupMainContainer() {
        mainContainer = gui.getContentPane();
        mainContainer.setLayout(new BorderLayout(HGAP, VGAP));
        mainContainer.setBackground(MAIN_CONTAINER_COLOR);
    }

    // MODIFIES: mainContainer
    // EFFECTS: constructs the top panel of the main container passed in as param
    private void setupTopPanel(Container mainContainer) {
        JPanel topPanel = new JPanel();
        JPanel topLabelPanel = new JPanel();
        setupTopLabelPanel(topLabelPanel);
        setupSidePanel(topPanel, topLabelPanel, "top");
        mainContainer.add(topPanel, BorderLayout.NORTH);
    }

    // MODIFIES: panel
    // EFFECTS: creates a new label with the title and adds the label to the given panel
    private void setupTopLabelPanel(JPanel panel) {
        JLabel label = new JLabel("Favour for Favour: pay it forward a favour at a time", SwingConstants.CENTER);
        setLabelFont(label, label.getForeground(), TOP_PANEL_FONT_SIZE);
        label.setBackground(TOP_PANEL_COLOR);
        panel.setBackground(TOP_PANEL_COLOR);
        panel.add(label);
    }

    // MODIFIES: mainContainer
    // EFFECTS: constructs the left panel of the main container passed in as param
    private void setupLeftPanel(Container mainContainer) {
        JPanel leftPanel = new JPanel();
        JPanel leftLabelPanel = new JPanel();
//        setupSidePanelGrid(leftLabelPanel, "left");
        setupSidePanel(leftPanel, leftLabelPanel, "left");
//        setupPanelButtons(leftPanel, "left");
        mainContainer.add(leftPanel, BorderLayout.WEST);
        leftPanel.setLayout(new GridBagLayout());

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(new File(profilePicPath)));
            JLabel picLabel = new JLabel();
            picLabel.setIcon(icon);
            leftPanel.add(picLabel);
            picLabel.setVisible(true);
        } catch (IOException e) {
            System.err.println("No image found at " + profilePicPath);
            e.printStackTrace();
        }
    }

    // MODIFIES: mainContainer
    // EFFECTS: constructs the right panel of the mainContainer passed in as a parameter
    private void setupRightPanel(Container mainContainer) {
        JPanel rightPanel = new JPanel();
        JPanel rightLabelPanel = new JPanel();
//        setupSidePanelGrid(rightLabelPanel, "right");
        setupSidePanel(rightPanel, rightLabelPanel, "right");
//        setupPanelButtons(rightPanel, "right");
        mainContainer.add(rightPanel, BorderLayout.EAST);
    }

    // MODIFIES: panel, labelPanel
    // EFFECTS: sets up the panel and label's background colour to the default panel colour for the side (top or side)
    //          and adds the label to the panel
    private void setupSidePanel(JPanel panel, JPanel labelPanel, String side) {
        Color panelColor;
        if (side.equals("top")) {
            panelColor = TOP_PANEL_COLOR;
        } else if (side.equals("left")){
            panelColor = LEFT_PANEL_COLOR;
        } else { // "right"
            panelColor = RIGHT_PANEL_COLOR;
        }
        panel.setBackground(panelColor);
        labelPanel.setBackground(panelColor);
        panel.add(labelPanel);
    }

    // MODIFIES: label
    // EFFECTS: changes the font colour and size of the given label to the given colour and size
    public void setLabelFont(JLabel label, Color color, int size) {
        label.setFont(new Font(label.getFont().toString(), Font.PLAIN, size));
        label.setForeground(color);
    }
}
