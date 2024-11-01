package w9.swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// module.info.java
// module w9.swings {requires java.desktop; }

public class GUIMain {
    public void startGUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    static JFrame mainFrame = new JFrame("TableSelectionDemo");
    static GUIMain main = null;
    private void createAndShowGUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = setupBorderPanel();
        mainFrame.setPreferredSize(new Dimension(500, 300));
        mainFrame.getContentPane().add(pane);
        // Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    JPanel setupMainPanel() { return new JPanel(); }

    JPanel setupGridPanel(){
        JPanel mainPane = new JPanel(new GridLayout(1, 2));
        JButton redButton = new JButton("Red");
        redButton.setSize(new Dimension(300, 200));
        JButton blueButton = new JButton("Blue");
        redButton.setSize(new Dimension(300, 200));
        mainPane.add(redButton);
        mainPane.add(blueButton);
        return mainPane;
    }

    JPanel setupBorderPanel() {
        JPanel mainPane = new JPanel(new BorderLayout());
        // Create and set up the content pane.
        JButton redButton = new JButton("Red");
        redButton.setSize(new Dimension(300, 200));
        JButton blueButton = new JButton("Blue");
        redButton.setSize(new Dimension(300, 200));
        mainPane.add(redButton, BorderLayout.PAGE_START);
        mainPane.add(blueButton, BorderLayout.PAGE_END);
        JPanel center = new JPanel();
        center.setBackground(Color.gray);
        JLabel title = new JLabel("Center");
        title.setOpaque(true);
        title.setBackground(Color.GREEN);
        center.add(title);
        mainPane.add(center);
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.setBackground(Color.red);
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.setBackground(Color.blue);
            }
        });
        return mainPane;
    }

    public static void main(String[] args) {
        main = new GUIMain();
        main.startGUI();
    }
}
