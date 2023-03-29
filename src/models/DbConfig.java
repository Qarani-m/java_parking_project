package models;

import controllers.home.table.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DbConfig {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking_project?useSSL=false"   ;
    private static final String DATABASE_USERNAME = "root";
    public static ArrayList<String[]> list = new ArrayList<>();
    private static final String DATABASE_PASSWORD = "";

    public static Object executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();
            if (query.toLowerCase().startsWith("select")) {
                resultSet = statement.executeQuery(query);
                if(query.contains("SELECT password FROM users")) {
                        return login(resultSet);
                } else if(query.contains("select * from slots")) {

                    return slotsHandler(resultSet);
                } else if(query.contains("select count(id) from")) {
                    return reservation_count(resultSet);
                }else if(query.contains("SELECT charge FROM lot WHERE date_ BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE()")) {
                    return weekly(resultSet);
                }else if(query.contains("SELECT count(*) FROM lot WHERE date_ = CURDATE();")) {
                    return turnover(resultSet);
                }else if(query.contains("SELECT * FROM lot WHERE date_ = CURDATE();")) {
                    return todays_income(resultSet);
                }else if(query.contains("select count(*) from lot where size_")) {
                    barchart(resultSet);
                }else if(query.contains("select * from lot") || query.contains("select * from reservations")) {
                    return table_data(resultSet);
                } if(query.contains("SELECT SEC_TO_TIME((AVG(TIME_TO_SEC(entry_time)) + AVG(TIME_TO_SEC(departure_time))) / 2) AS avg_time")) {
                    return avg_time(resultSet);
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
            System.out.println("Exception---: " + ex.getMessage());
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
            try {
                connection.close();
            }catch(Exception e){
                System.out.println("-----"+e);
            }
        }
        return null;
    }

    private static ArrayList<String>[] slotsHandler(ResultSet resultSet) throws SQLException {
        boolean reserved = Boolean.parseBoolean(null);
        boolean occupied = Boolean.parseBoolean(null);
        ArrayList<String >occupied_values= new ArrayList<String>();
        ArrayList<String >reserved_values= new ArrayList<String>();
        String id = null;

        while (resultSet.next()) {
            reserved = resultSet.getBoolean("reserved");
            occupied = resultSet.getBoolean("occupied");
            id = resultSet.getString("slot_id");
            if(occupied==true){
                occupied_values.add(id);
            }
            if(reserved==true){
                reserved_values.add(id);
            }
        }
        ArrayList<String>[] arrayLists = new ArrayList[2];
        arrayLists[0]= occupied_values;
        arrayLists[1]= reserved_values;
        return arrayLists;
    }

    private static String barchart(ResultSet resultSet) throws SQLException {
        int count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt("count(*)");
//            System.out.println(count);

        }

        return "count";
    }
    private static float turnover(ResultSet resultSet) throws SQLException {
         int count1 = 0;
        while(resultSet.next()){
             count1 =resultSet.getInt("count(*)");
        }
        return count1;
    }
    private static Object weekly(ResultSet resultSet) throws SQLException {
        int weekly_sum = 0;
        ArrayList<Integer> weekly_values = new ArrayList<Integer>();
        while(resultSet.next()){
            weekly_values.add(parseInt(resultSet.getString("charge")));
        }
        for (int i = 0; i < weekly_values.size(); i++) {
            weekly_sum += weekly_values.get(i);
        }
        return String.valueOf(weekly_sum);
    }
    private static String todays_income(ResultSet resultSet) throws SQLException {
        int todays_sum = 0;
        ArrayList<Integer> todays_vals = new ArrayList<Integer>();
        while(resultSet.next()){
            todays_vals.add(parseInt(resultSet.getString("charge")));
        }
        for (int i = 0; i < todays_vals.size(); i++) {
            todays_sum += todays_vals.get(i);
        }
        return String.valueOf(todays_sum);
    }
    private static Object avg_time(ResultSet resultSet) throws SQLException {
        String avg_time  = null;
                while (resultSet.next()) {
                    avg_time  = resultSet.getString("avg_time");
        }
        return avg_time;
    }
    private static Object reservation_count(ResultSet resultSet) throws SQLException {
        String count = null;
        while (resultSet.next()) {
            count = resultSet.getString("count(id)");
        }
        return count;
    }







    public static String login(ResultSet rs) throws SQLException {
    String password="";
    while (rs.next()) {password = rs.getString("password");}
        System.out.println("password");
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
    } return vehicleList;
}


































}


