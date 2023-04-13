package com.example.airvivacw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



public class ManagerController {

    @FXML
    private TextField searchCustomerField;
    @FXML
    private TextField fixedDiscountField;
    @FXML
    private Label updateDiscountLabel;
    @FXML
    private ComboBox usersDropDown;
    @FXML
    private TextField enterBlankAssignField;

    @FXML
    TableView<ViewSales> salesReport;
    @FXML
    TableColumn<ViewSales,Integer> id;
    @FXML
    TableColumn<ViewSales,String> blankNo;
    @FXML
    TableColumn<ViewSales,String> customerName;
    @FXML
    TableColumn<ViewSales,Integer> advisorId;
    @FXML
    TableColumn<ViewSales, Double> discount;
    @FXML
    TableColumn<ViewSales,Double> commission;
    @FXML
    TableColumn<ViewSales,Double> amountUsd;
    @FXML
    TableColumn<ViewSales,Double> amountLocal;
    @FXML
    TableColumn<ViewSales,String> cardHolder;
    @FXML
    TableColumn<ViewSales,String> expirationDate;
    @FXML
    TableColumn<ViewSales,Integer> lastFourDigits;

    @FXML
    private TableView<ViewBlanks> viewblankstable;
    @FXML
    private TableColumn<ViewBlanks, Integer> numbers;
    @FXML
    private TableColumn<ViewBlanks, Integer> ids;
    @FXML
    private TableColumn<ViewBlanks, String> owners;
    @FXML
    private TableColumn<ViewBlanks, String> types;

    ObservableList<ViewBlanks> blanksList = FXCollections.observableArrayList();

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    private SceneController sceneController = new SceneController();

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToLoginPage(e);
    }

    public void updateFixedDiscount(ActionEvent e) throws SQLException {
        if (!searchCustomerField.getText().isBlank()) {
            Statement statement = connectDB.createStatement();
            String ar = fixedDiscountField.getText();
            double ar2 = Integer.parseInt(ar);
            ar2 = ar2/100;
            String findDiscount = "UPDATE AVcustomer SET fixed_discount ='" + ar2 + "' WHERE email_address ='" + searchCustomerField.getText() + "'";
            int queryResult = statement.executeUpdate(findDiscount);
            if (queryResult > 0) {
                updateDiscountLabel.setText("You Updated The Discount Rate");
            }
        }
    }



    public void loadBlanksOnAction(ActionEvent e) throws SQLException {

        ObservableList<ViewBlanks> listblank = FXCollections.observableArrayList();

        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM AVblank");

        ids.setCellValueFactory(new PropertyValueFactory<ViewBlanks,Integer>("ids"));
        numbers.setCellValueFactory(new PropertyValueFactory<ViewBlanks,Integer>("numbers"));
        types.setCellValueFactory(new PropertyValueFactory<ViewBlanks,String>("types"));
        owners.setCellValueFactory(new PropertyValueFactory<ViewBlanks,String>("blankowners"));

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String number = resultSet.getString("number");
            String type = resultSet.getString("type");
            String blankowner = resultSet.getString("blankowner");

            ViewBlanks viewblanks = new ViewBlanks(id, number, type, blankowner);
            listblank.add(viewblanks);
        }

        viewblankstable.setItems(listblank);

        Statement statement1 = connectDB.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("SELECT name FROM AVuser");
        ObservableList data = FXCollections.observableArrayList();
        while (resultSet1.next()){
            data.add(new String(resultSet1.getString(1)));
        }
        usersDropDown.setItems(data);



    }




    public void assignBlankOnAction(ActionEvent e) throws SQLException {
        Statement statement2 = connectDB.createStatement();
        String assignblankfunc = "UPDATE AVblank SET blankowner ='" + usersDropDown.getSelectionModel().getSelectedItem().toString() + "' WHERE number ='" + enterBlankAssignField.getText() + "'";
        int queryResult2 = statement2.executeUpdate(assignblankfunc);
        if (queryResult2 > 0) {
            updateDiscountLabel.setText("You Updated The Discount Rate");
        }

    }

    public void generateTicketReportOnAction(ActionEvent e) throws SQLException {

        ObservableList<ViewSales> listsales2 = FXCollections.observableArrayList();

        Statement statement2 = connectDB.createStatement();
        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM AVsale1");

        id.setCellValueFactory(new PropertyValueFactory<ViewSales,Integer>("id"));
        blankNo.setCellValueFactory(new PropertyValueFactory<ViewSales,String>("blankNo"));
        customerName.setCellValueFactory(new PropertyValueFactory<ViewSales,String>("customerName"));
        advisorId.setCellValueFactory(new PropertyValueFactory<ViewSales,Integer>("advisorId"));
        discount.setCellValueFactory(new PropertyValueFactory<ViewSales,Double>("discount"));
        commission.setCellValueFactory(new PropertyValueFactory<ViewSales,Double>("commission"));
        amountUsd.setCellValueFactory(new PropertyValueFactory<ViewSales,Double>("amountUsd"));
        amountLocal.setCellValueFactory(new PropertyValueFactory<ViewSales,Double>("amountLocal"));
        cardHolder.setCellValueFactory(new PropertyValueFactory<ViewSales,String>("cardHolder"));
        expirationDate.setCellValueFactory(new PropertyValueFactory<ViewSales,String>("expirationDate"));
        lastFourDigits.setCellValueFactory(new PropertyValueFactory<ViewSales,Integer>("LastFourDigits"));

        while (resultSet2.next()) {
            int id = resultSet2.getInt("id");
            String blankNo = resultSet2.getString("blank_number");
            String customerName = resultSet2.getString("customer_name");
            Integer advisorId = resultSet2.getInt("advisor_id");
            Double discount = resultSet2.getDouble("discount");
            Double commission = resultSet2.getDouble("commission");
            Double amountUsd = resultSet2.getDouble("amount_usd");
            Double amountLocal = resultSet2.getDouble("amount_local");
            String cardHolder = resultSet2.getString("cardholder_name");
            String expirationDate = resultSet2.getString("expiration_date");
            Integer lastFourDigits = resultSet2.getInt("Last4Digits");

            ViewSales viewsales = new ViewSales(id, blankNo, customerName,  advisorId,  discount,  commission,  amountUsd,  amountLocal,  cardHolder,  expirationDate,  lastFourDigits);
            listsales2.add(viewsales);
        }

        salesReport.setItems(listsales2);



    }


}
