package utils;

import controllers.home.table.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class db_config {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking_project";
    private static final String DATABASE_USERNAME = "root";
    public static ArrayList<String[]> list = new ArrayList<>();
    private static final String DATABASE_PASSWORD = "";



    public static Object executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String password = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();
            if (query.toLowerCase().startsWith("select")) {
                resultSet = statement.executeQuery(query);
                if(query.contains("SELECT password FROM users")) {
                        return login(resultSet);
                } else if(query.contains("select * from lot")) {
                    return table_data(resultSet);
                }
                else{
                    return null;
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
        return null;
    }

    public static Object table_proxy() {
        System.out.println(list);;
        return list;
    }

    public static String login(ResultSet rs) throws SQLException {
    String password="";
    while (rs.next()) {
        password = rs.getString("password");
    }
    return password;
}



public static ObservableList<Vehicle> table_data(ResultSet rs) throws SQLException {

    ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    while (rs.next()) {
        String date = rs.getString("date_");
        String plate_number = rs.getString("plate_number");
        String slot_number = rs.getString("slot_number");
        String entry_time= rs.getString("entry_time");
        String departure_time= rs.getString("departure_time");
        String payment_id= rs.getString("payment_id");
        String charge = rs.getString("charge");
        Vehicle vehicle = new Vehicle(date, plate_number, slot_number, entry_time, departure_time, payment_id, charge);
        vehicleList.add(vehicle);
    }
    return vehicleList;
}

}


