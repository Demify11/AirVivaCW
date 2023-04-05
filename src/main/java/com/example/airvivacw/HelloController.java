package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;

public class HelloController {

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    private SceneController sceneController = new SceneController();

    public void loginButtonOnAction(ActionEvent e) throws SQLException, IOException {

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {

            Statement statement = connectDB.createStatement();
            String verifyManagerId = "SELECT * FROM AVuser WHERE job_type = 'Manager' AND user_id ='" + usernameTextField.getText() + "'";
            ResultSet queryResult = statement.executeQuery(verifyManagerId);

            Statement statement1 = connectDB.createStatement();
            String verifyAdminId = "SELECT * FROM AVuser WHERE job_type = 'Administrator' AND user_id ='" + usernameTextField.getText() + "'";
            ResultSet queryResult1 = statement1.executeQuery(verifyAdminId);

            Statement statement2 = connectDB.createStatement();
            String verifyAdvisorId = "SELECT * FROM AVuser WHERE job_type = 'Travel Advisor' AND user_id ='" + usernameTextField.getText() + "'";
            ResultSet queryResult2 = statement2.executeQuery(verifyAdvisorId);

            if (queryResult.next()) {
                // User is a manager
                loginMessageLabel.setText("Welcome Manager");
                // Switch to manager homepage
                sceneController.switchToManagerHomePage(e);
            } else if (queryResult1.next()) {
                // User is an admin
                loginMessageLabel.setText("Welcome Admin");
                // Switch to admin homepage
                sceneController.switchToAdminHomePage(e);
            } else if (queryResult2.next()) {
                // User is an admin
                loginMessageLabel.setText("Welcome Advisor");
                // Switch to admin homepage
                sceneController.switchToAdvisorHomePage(e);
            }else {
                // Invalid login
                loginMessageLabel.setText("Invalid login");
            }
            }else{
            loginMessageLabel.setText("please enter user id and password.");
        }
    }
}



