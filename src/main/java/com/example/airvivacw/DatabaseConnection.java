package com.example.airvivacw;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "in2018g14";
        String databaseUser = "in2018g14_a";
        String databasePassword = "kpq2O4jW";
        String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk" +databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
