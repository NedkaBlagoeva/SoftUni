import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _04_ {
    private static Connection connection;
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        connection = ConnectionDB.getConnection();
        //PreparedStatement prepStmt = connection.prepareStatement("");
        String[] input1 = scan.nextLine().split("\\s+");
        String minionName = input1[1];
        int minionAge = Integer.parseInt(input1[2]);;
        String minionTown = input1[3];
        String villainName = scan.nextLine().split("\\s+")[1];

        boolean minionExist = findIfEntityExist("minions", minionName);
        System.out.println();

    }

    private static boolean findIfEntityExist(String tableName, String entityName) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE name = ?;", tableName);
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, entityName);
        ResultSet resultSet = stmt.executeQuery();
        return resultSet.next();
    }
}
