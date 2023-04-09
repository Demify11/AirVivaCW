package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

    private Stage stage;
    private Scene scene;
    private Parent root;

    private SceneController sceneController = new SceneController();

    String userId;

    public void loginButtonOnAction(ActionEvent e) throws SQLException, IOException {
        userId = usernameTextField.getText();

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
                AdvisorPage(e);
            }else {
                // Invalid login
                loginMessageLabel.setText("Invalid login");
            }
            }else{
            loginMessageLabel.setText("please enter user id and password.");
        }
    }

    public void AdvisorPage(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorHomePage.fxml"));
        root = loader.load();

        SceneController scene1 = loader.getController();
        scene1.setAdvisorUserId(userId);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
