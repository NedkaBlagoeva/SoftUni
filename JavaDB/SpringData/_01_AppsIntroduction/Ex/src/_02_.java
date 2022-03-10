import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _02_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "user");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT v.name, count(DISTINCT mv.minion_id) AS minion_count FROM villains AS v " +
                        "JOIN minions_villains AS mv ON v.id = mv.villain_id " +
                        "JOIN minions AS m ON m.id = mv.minion_id " +
                        "GROUP BY v.name " +
                        "HAVING minion_count > ? " +
                        "ORDER BY minion_count DESC;");
        stmt.setInt(1, 15);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getString("minion_count"));
        }
        connection.close();
    }
}
