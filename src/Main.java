import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {
    private static final String WAITING = "waiting";
    private static final String GAME = "game";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createWindow);
    }

    private static void createWindow() {
        JFrame frame = new JFrame("산성비 게임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);

        // 대기 화면
        JPanel waitingPanel = new JPanel(new BorderLayout());
        waitingPanel.add(new JLabel("대기 화면", SwingConstants.CENTER), BorderLayout.CENTER);
        JButton startButton = new JButton("게임 화면으로");
        startButton.addActionListener(event -> cardLayout.show(screens, GAME));
        waitingPanel.add(startButton, BorderLayout.SOUTH);

        // 게임 화면
        JPanel gamePanel = new JPanel(new BorderLayout());
        gamePanel.add(new JLabel("게임 화면", SwingConstants.CENTER), BorderLayout.CENTER);
        JButton backButton = new JButton("대기 화면으로");
        backButton.addActionListener(event -> cardLayout.show(screens, WAITING));
        gamePanel.add(backButton, BorderLayout.SOUTH);

        screens.add(waitingPanel, WAITING);
        screens.add(gamePanel, GAME);
        cardLayout.show(screens, WAITING);

        frame.setContentPane(screens);
        frame.setVisible(true);
    }
}
