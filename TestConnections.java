import java.sql.Connection;

public class TestConnections {

    public static void main(String[] args) {

        Connection con = DatabaseConnection.getConnection();

        if (con != null) {
            System.out.println("Connection Test Successful!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}
