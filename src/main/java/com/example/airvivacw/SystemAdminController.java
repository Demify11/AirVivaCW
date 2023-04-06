package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.sql.*;

public class SystemAdminController {

    private SceneController sceneController = new SceneController();


    @FXML
    private TextField userPass;
    @FXML
    private TextField fullNameText;
    @FXML
    private TextField userIDText;
    @FXML
    private TextField jobType;


    DatabaseConnection currentDB = new DatabaseConnection();
    Connection connectDB = currentDB.getConnection();


    public void createAccountAction(ActionEvent e) throws SQLException, IOException{

        if(fullNameText.getText().isBlank() == false && userIDText.getText().isBlank() == false
                && jobType.getText().isBlank() == false && userPass.getText().isBlank() == false)
        {
           // Statement statement = connectDB.createStatement();
           // String addUserDB = "";
            //adds all new users info to DB
            //ResultSet queryResult = statement.executeQuery(addUserDB);
        }
        //database connection
        //SQL statement to add to database
    }

    public void launchPHP(ActionEvent e){
        try{
            Desktop.getDesktop().browse(new URI("https://smcse.city.ac.uk/phpmyadmin/"));
        } catch(Exception c){
            c.printStackTrace();
        }

    }

    public void getUserDetails(ActionEvent e){
        //SQL statement that loads users details based on selected userID
        //surnameLabel.setText()

    }

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToLoginPage(e);
    }


}
