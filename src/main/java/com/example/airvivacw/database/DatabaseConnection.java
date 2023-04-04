package com.example.airvivacw.database;
import java.sql.*;
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "in2018g14";
        String databaseUser = "in2018g14_a";
        String databasePassword = "kpq2O4jW";
        String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/" +databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}