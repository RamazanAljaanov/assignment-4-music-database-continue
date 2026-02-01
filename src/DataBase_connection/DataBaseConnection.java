package DataBase_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/Music_Database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);



            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("ERROR!!!.", e);
        }
    }


    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("CONNECTION SUCCESS");
            }
        } catch (SQLException e) {
            System.err.println("CONNECTION FAILED!");
        }
    }
}