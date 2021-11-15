package ui.screens;

import javax.swing.*;
import java.awt.*;

public class PopUpScreen extends JFrame {
    private String title;
    private int WIDTH = 500;
    private int HEIGHT = 500;
    private static Color BACKGROUND_COLOR= new Color(42, 34, 74);

    public PopUpScreen(String title) {
        this.title = title;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
    }

    // EFFECTS: creates a new pop-up frame with information about the request favour
    public void loadReqFavour(String reqTitle) {
        setVisible(true);
        if (reqTitle.equals("Please pick up my groceries")) {
            JEditorPane textPanel = new JEditorPane();
            textPanel.setText("Please pick up my groceries\n\n" +
                    "Description: I cannot pick up my groceries\nthis week because I fell down the stairs.\n" +
                    "I can order groceries for pick up at \nWalmart on XYZ street!\n\n" +
                    "Estimated completion time: 20 minutes");
            add(textPanel);
            textPanel.setBackground(BACKGROUND_COLOR);
            textPanel.setEditable(false);
            setTextFont(textPanel, Color.white, 25);
            textPanel.setVisible(true);
        } else if (reqTitle.equals("Walk my dog")) {
            JEditorPane textPanel = new JEditorPane();
            textPanel.setText("Walk my dog\n\n" +
                    "Description: I fell down the stairs, \nso I cannot walk my dog. \nHe is a very gentle and well-behaved \nGolden Retriever who needs to be walked\ntwice a day.Larger dog owner preferred.\n\n" +
                    "Estimated completion time: 10 minutes");
            add(textPanel);
            textPanel.setBackground(BACKGROUND_COLOR);
            textPanel.setEditable(false);
            setTextFont(textPanel, Color.white, 25);
            textPanel.setVisible(true);
        } else if (reqTitle.equals("Tell me a story")) {
            JEditorPane textPanel = new JEditorPane();
            textPanel.setText("Tell me a story\n\n" +
                    "Description: Bored. Just tell me a story.\n\n" +
                    "Estimated completion time: undetermined");
            add(textPanel);
            textPanel.setBackground(BACKGROUND_COLOR);
            textPanel.setEditable(false);
            setTextFont(textPanel, Color.white, 25);
            textPanel.setVisible(true);
        }
    }

    // MODIFIES: label
    // EFFECTS: changes the font colour and size of the given label to the given colour and size
    public void setTextFont(JEditorPane textPanel, Color color, int size) {
        textPanel.setFont(new Font(textPanel.getFont().toString(), Font.PLAIN, size));
        textPanel.setForeground(color);
    }


}
