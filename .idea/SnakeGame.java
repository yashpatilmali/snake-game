import javax.swing.*;

public class SnakeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
