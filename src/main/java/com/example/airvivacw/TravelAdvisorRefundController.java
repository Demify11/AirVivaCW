package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TravelAdvisorRefundController {
    @FXML
    private AnchorPane refundPane;

    @FXML
    private Label advisorLabel;

    @FXML
    private Label refundLabel;

    @FXML
    private TextField refundTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label refundMessageLabel;

    private SceneController sceneController = new SceneController();

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    public AnchorPane getRefundPane() {
        return refundPane;
    }

    public void setAdvisorLabel(String userId) {
        advisorLabel.setText(userId);
    }

    //double amountLocal1;
    public void SearchOnAction() throws SQLException {
        if (!refundTextField.getText().isBlank()) {
            Statement stm = connectDB.createStatement();
            String checkRefund = "SELECT amount_local FROM AVsale1 WHERE blank_number = '" + refundTextField.getText() + "'";
            ResultSet rs = stm.executeQuery(checkRefund);

            //amountLocal1 = rs.getDouble("amount_local");
            if (rs.next()) {
                String amountLocal = rs.getString("amount_local");
                refundPane.setVisible(true);
                refundLabel.setText(amountLocal);
            } else {
                messageLabel.setText("Blank not found");
            }
        }
    }

    public void RefundOnAction() throws SQLException {
        if (nameTextField.getText().isBlank() == false) {
            Statement statement1 = connectDB.createStatement();
            double refundDouble = Double.parseDouble(refundLabel.getText());
            String addRefund = "INSERT INTO `AVrefunds` (`blank_number`, `refund_amount`, `customer_name`) VALUES ('" + refundTextField.getText() + "', '" + refundDouble + "', '" + nameTextField.getText() + "')";
            int rowsInserted = statement1.executeUpdate(addRefund);
            if (rowsInserted > 0) {
                refundMessageLabel.setText("Refund successful!");
            } else {
                refundMessageLabel.setText("Error processing refund");
            }
        }
    }

    public void DoneOnAction(ActionEvent e) throws IOException {
        sceneController.switchToAdvisorHomePage(e);
    }
}


