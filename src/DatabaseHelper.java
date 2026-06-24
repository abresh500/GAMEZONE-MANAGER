import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:gamezone.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        String customers = "CREATE TABLE IF NOT EXISTS customers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "sessions INTEGER);";

        String sessions = "CREATE TABLE IF NOT EXISTS sessions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "customer_name TEXT," +
                "price REAL);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(customers);
            stmt.execute(sessions);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertSession(String name, double price) {
        String sql = "insert into sessions(customer_name, price) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}