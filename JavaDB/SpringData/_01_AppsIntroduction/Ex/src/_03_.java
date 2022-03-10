import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _03_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Properties props = new Properties();
        props.setProperty("user", "user");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        int villainId = Integer.parseInt(scan.nextLine());
        PreparedStatement villainStmt = connection.prepareStatement("SELECT name FROM villains " +
                "WHERE id = ?");
        villainStmt.setInt(1, villainId);
        ResultSet villainName = villainStmt.executeQuery();
        if (!villainName.next()){
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        } else {
            System.out.println("Villain: " + villainName.getString("name"));
        }
        PreparedStatement stmt =
                connection.prepareStatement("SELECT m.name, m.age FROM minions AS m " +
                        "JOIN minions_villains mv ON m.id = mv.minion_id " +
                        "WHERE mv.villain_id = ?;");

        stmt.setInt(1,villainId);
        ResultSet rs = stmt.executeQuery();

        int i = 0;
        while (rs.next()) {
            System.out.println(++i + ". " + rs.getString("name") + " " + rs.getString("age"));
        }
        connection.close();
    }
}
