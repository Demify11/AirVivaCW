package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;

public class SystemAdminController {

    private SceneController sceneController = new SceneController();

    @FXML
    private TextField createUserText;
    @FXML
    private TextField addFirstNameText;
    @FXML
    private TextField addSurnameText;
    @FXML
    private TextField addEmailText;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label emailLabel;

    public void createAccountAction(ActionEvent e) {

        //create account for someone with specified textfields
        //database connection
        //SQL statement to add to database
    }

    public void launchPHP(ActionEvent e){
        //opens the database
        //brings them to page for them to login
    }

    public void getUserDetails(ActionEvent e){
        //SQL statement that loads users details based on selected userID
        //surnameLabel.setText()

    }

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToLoginPage(e);
    }


}
