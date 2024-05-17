import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class MainClass {

    private static DriverManager DatabaseConnector;
    private static Connection connection;

    public static void main(String[] args) {
        // Attempt to get a connection to the database
        try (Connection connection = getConnection()) {
            // Your code that interacts with the database goes here
            // For example, executing SQL queries, updating records, etc.

            // Example 1: execute a simple SELECT query
            executeSelectQuery(connection);

            // Example 2: update a record
            updateRecord(connection, 1, "New Name");

            // Example 3: insert a new record
            insertRecord(connection, "New Person");
        } catch (SQLException e) {
            // Handle any exceptions related to database access
            e.printStackTrace();
        }
    }

    private static void executeSelectQuery(Connection connection) throws SQLException {
        String sql = "SELECT * FROM your_table_name";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n===== Results from SELECT query =====");
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Do something with the data (print it as an example)
                System.out.println("ID: " + id + ", Name: " + name);
            }
        }
    }

    private static void updateRecord(Connection connection, int id, String newName) throws SQLException {
        String sql = "UPDATE your_table_name SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\n===== Record updated successfully =====");
            } else {
                System.out.println("\n===== No record found for update =====");
            }
        }
    }

    private static void insertRecord(Connection connection, String newName) throws SQLException {
        String sql = "INSERT INTO your_table_name (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\n===== New record inserted successfully =====");
            } else {
                System.out.println("\n===== Failed to insert a new record =====");
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MainClass.connection = connection;
    }
}
