import java.sql.*;

public class DatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/snake_game";
    private final String user = "root";
    private final String password = "your_password";

    public void saveScore(String playerName, int score) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO scores (player_name, score) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, playerName);
            statement.setInt(2, score);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayHighScores() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM scores ORDER BY score DESC LIMIT 10";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Player: " + resultSet.getString("player_name") + ", Score: " + resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
