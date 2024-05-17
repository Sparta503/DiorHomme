import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDatabase {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public MySQLDatabase() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Error connecting to the database.");
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error closing the connection.");
        }
    }

    // Example method for executing a query
    public void executeQueryExample() {
        String query = "SELECT * FROM your_table_name";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Process the retrieved data (you can adapt this part based on your requirements)
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing the query.");
        }
    }

    // Add more methods as needed for your specific database operations

    public static void main(String[] args) {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        mySQLDatabase.executeQueryExample(); // Example usage
        mySQLDatabase.closeConnection();
    }
}

