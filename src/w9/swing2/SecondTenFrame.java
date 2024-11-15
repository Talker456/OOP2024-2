package w9.swing2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondTenFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static JLabel scoreLabel;

    CardLayout cards = new CardLayout();
    Container cardPanel;
    JPanel gamePanel;
    JPanel infoPanel;

    public void setupCardLayout() {
        setTitle("Make Ten Game");
        JPanel myContentPane = new JPanel(new BorderLayout());
        cardPanel = new JPanel(cards); // 여기서만 쓰이는 것은 지역변수로

        gamePanel = setupGamePanel();

        infoPanel = new JPanel();
        infoPanel.setBackground(Color.cyan);
        infoPanel.add(new ClockComponent());
        cardPanel.add(infoPanel, "info");
        cardPanel.add(gamePanel, "game");

        JPanel bottom = new JPanel();
        JButton next = new JButton("게임");
        JButton prev = new JButton("설정보기");
        bottom.add(next);
        bottom.add(prev);
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "game");
            }
        });
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "info");
            }
        });
        myContentPane.add(cardPanel, BorderLayout.CENTER);
        myContentPane.add(bottom, BorderLayout.PAGE_END);

        getContentPane().add(myContentPane);
    }

    public JPanel setupGamePanel() {
        JPanel gamePanel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(1, 3));

        top.setPreferredSize(new Dimension(750, 50));
        Board board = null;
        board = new Board();
        JLabel topLabel = new JLabel("Make Ten");
        topLabel.setFont(topLabel.getFont().deriveFont(24.0f));
        scoreLabel = new JLabel("점수: 0");
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(24.0f));
        top.add(scoreLabel, BorderLayout.CENTER);
        top.add(topLabel);

        JPanel posPane = new JPanel(new BorderLayout());
        posLabel = new JLabel("<html>현재위치 (0, 0)&nbsp</html>");
        posLabel.setFont(posLabel.getFont().deriveFont(28.0f));
        posPane.add(posLabel, BorderLayout.LINE_END);
        top.add(posPane, BorderLayout.LINE_END);

        gamePanel.add(top, BorderLayout.PAGE_START);
        board.init();
        gamePanel.add(board, BorderLayout.CENTER);
        gamePanel.setPreferredSize(new Dimension(750, 500));
        return gamePanel;
    }

    static void addScore() {
        String scoreText = scoreLabel.getText().substring(4);
        scoreLabel.setText("점수: " + (Integer.parseInt(scoreText) + 10));
    }

    static JLabel posLabel;

    static void setPosLabel(int x, int y) {
        posLabel.setText("<html>현재위치 (" + x + ", " + y + ")&nbsp</html>");
    }

    private void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupCardLayout();
        setPreferredSize(new Dimension(800, 600));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SecondTenFrame frame = new SecondTenFrame();
        frame.createAndShowGUI();
    }
}
