package com.parking.parking.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConfig {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking_project?useSSL=false"   ;
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public List executeQuery(String query) throws SQLException {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if(query.contains("select * from places")){
                return selectStreets(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return null;
    }

    private List selectStreets(ResultSet resultSet) throws SQLException {
        System.out.println("----------------------------------------------------------____");
        List<String[]> streets = new ArrayList<>();
        while(resultSet.next()){
            String lotName =resultSet.getString("lotName");
            String city =resultSet.getString("city");
            String position =resultSet.getString("position");
            String lotId =resultSet.getString("lotId");
            String streetName =resultSet.getString("street");
            streets.add(new String[]{lotName,city,lotId,streetName,position});
        }
        System.out.println(streets.get(0)[0]);

        return streets;
    }
}
