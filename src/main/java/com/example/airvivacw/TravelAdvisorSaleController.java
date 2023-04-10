package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TravelAdvisorSaleController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label errorMessageLabel;

    private SceneController sceneController = new SceneController();


    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    private Stage stage;
    private Scene scene;
    private Parent root;

    String name;

    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToAdvisorHomePage(e);
    }


    public void ConfirmButtonOnAction(ActionEvent e) throws IOException, SQLException {
        if (firstNameTextField.getText().isBlank() == false && lastNameTextField.getText().isBlank() == false && emailAddressTextField.getText().isBlank() == false && phoneNumberTextField.getText().isBlank() == false) {
            Statement statement = connectDB.createStatement();
            String verifyCustomer = "SELECT * FROM AVcustomer WHERE first_name = '" + firstNameTextField.getText() + "' AND last_name = '" + lastNameTextField.getText() + "' AND email_address ='" + emailAddressTextField.getText() + "' AND phone_number = '" + phoneNumberTextField.getText() + "'";
            ResultSet queryResult = statement.executeQuery(verifyCustomer);

            //to check if customer exists
            if (!queryResult.next()) {
                errorMessageLabel.setText("Customer does not exist");
            } else {
                name = firstNameTextField.getText() + " " +lastNameTextField.getText();
                SalePage1(e);
            }
        } else {
            errorMessageLabel.setText("Please enter all the required details");
        }
    }


    public void SalePage1(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorSalesPage1.fxml"));
        root = loader.load();

        TravelAdvisorSaleController1 cont1 = loader.getController();
        cont1.setCustomer(name);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void NewCustomerButtonOnAction(ActionEvent e) throws SQLException {
        if (firstNameTextField.getText().isBlank() == false && lastNameTextField.getText().isBlank() == false && emailAddressTextField.getText().isBlank() == false && phoneNumberTextField.getText().isBlank() == false) {

            Statement statement = connectDB.createStatement();
            String verifyCustomer = "SELECT * FROM AVcustomer WHERE first_name = '" + firstNameTextField.getText() + "' AND last_name = '" + lastNameTextField.getText() + "' AND email_address ='" + emailAddressTextField.getText() + "' AND phone_number = '" + phoneNumberTextField.getText() + "'";
            ResultSet queryResult = statement.executeQuery(verifyCustomer);

            //to check if customer exists, if not inserting the new customer into the system
            if (queryResult.next()) {
                errorMessageLabel.setText("Customer already exists");
            } else {
                Statement statement1 = connectDB.createStatement();
                String addCustomer = "INSERT INTO `AVcustomer` (`first_name`, `last_name`, `email_address`, `phone_number`) VALUES ('" + firstNameTextField.getText() + "', '" + lastNameTextField.getText() + "', '" + emailAddressTextField.getText() + "', '" + phoneNumberTextField.getText() + "')";

                int rowsInserted = statement1.executeUpdate(addCustomer);
                if (rowsInserted > 0) {
                    errorMessageLabel.setText("Customer added successfully");
                } else {
                    errorMessageLabel.setText("Error adding customer");
                }
            }
        } else {
            errorMessageLabel.setText("Please enter all the required details");
        }
    }
}
