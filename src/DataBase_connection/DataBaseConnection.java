package DataBase_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    // 1. Параметры подключения
    // Порт по умолчанию для PostgreSQL — 5432
    // Имя базы должно быть в точности как в pgAdmin
    private static final String URL = "jdbc:postgresql://localhost:5432/Music_Database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345"; // Твой пароль от pgAdmin

    /**
     * Метод для получения соединения с БД.
     * Использует DriverManager (требование задания).
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Регистрация драйвера (нужна для корректной работы JDBC)
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Если соединение успешно — можно вывести лог (по желанию)
            // System.out.println("Connected to Music_DataBase successfully!");

            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found. Add it to project libraries.", e);
        }
    }

    /**
     * Тестовый метод main, чтобы ты мог проверить подключение отдельно.
     * Просто нажми на зеленый треугольник рядом с ним.
     */
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("--- CONNECTION TEST: SUCCESS! ---");
                System.out.println("Connected to: " + conn.getMetaData().getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            System.err.println("--- CONNECTION TEST: FAILED! ---");
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Check: Is PostgreSQL running? Is the DB name correct? Is the password 12345?");
        }
    }
}