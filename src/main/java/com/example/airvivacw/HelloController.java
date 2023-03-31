package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    public void loginButtonOnAction(ActionEvent e) {

        if (usernameTextField.getText().isBlank()== false && passwordTextField.getText().isBlank() == false){
            loginMessageLabel.setText("login attempted");
            validateLogin();
        }else {
            loginMessageLabel.setText("please enter username and password.");
        }
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM Staff WHERE FirstName ='"+usernameTextField.getText()+"' AND Password ='" + passwordTextField.getText() +"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    loginMessageLabel.setText("welcome");
                }else{
                    loginMessageLabel.setText("invalid login");
                }
            }

        } catch(Exception e){

        }
    }


}