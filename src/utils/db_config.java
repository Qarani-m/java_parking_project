package utils;

import java.sql.*;

public class db_config {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking_project";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";


    public static String executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String password = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();
            if (query.toLowerCase().startsWith("select")) {
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    password = resultSet.getString("password");
                    return password;

                }
            } else {
                int rowsAffected = statement.executeUpdate(query);
                System.out.println(rowsAffected + " rows affected.");
                return "stuff";
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close result set: " + e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close statement: " + e);
                }
            }

        }
        return password;
    }
}
