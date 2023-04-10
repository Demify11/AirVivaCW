package com.example.airvivacw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.*;

public class TravelAdvisorController {

    @FXML
    private Label blankLabel;

    @FXML
    private Label typeLabel1;

    @FXML
    private Label fromLabel1;

    @FXML
    private Label toLabel1;

    @FXML
    private TableView<Blanks> BlankTable;

    @FXML
    private TableColumn<Blanks, Integer> idCol;

    @FXML
    private TableColumn<Blanks, String> numCol;

    @FXML
    private TableColumn<Blanks, String> typeCol;

    @FXML
    private TableColumn<Blanks, String> dateCol;

    @FXML
    private TableColumn<Blanks, Void> voidCol;

    @FXML
    private TextField searchBlankTextField;

    @FXML
    private Label discountLabel;

    @FXML
    private Label CommLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Label nameLabel1;

    @FXML
    private VBox addDetails;

    @FXML
    private VBox cashAmount;

    @FXML
    private Label balanceLabel;

    @FXML
    private TextField amountText;

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();



    private SceneController sceneController = new SceneController();


    public void HomeButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToAdvisorHomePage(e);
    }

    public void AllBlankOnAction() throws SQLException {

        ObservableList<Blanks> blanksList = FXCollections.observableArrayList();

        Statement statement = connectDB.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM AVblank");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String number = resultSet.getString("number");
            String type = resultSet.getString("type");
            int date_received = resultSet.getInt("date_received");

            Blanks blanks = new Blanks(id, number, type, date_received);
            blanksList.add(blanks);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

        BlankTable.setItems(blanksList);
    }

    public void InterlineBlankOnAction() throws SQLException {

        ObservableList<Blanks> blanksList1 = FXCollections.observableArrayList();

        Statement statement1 = connectDB.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM AVblank where type = 'Interline'");

        while (resultSet1.next()) {
            int id = resultSet1.getInt("id");
            String number = resultSet1.getString("number");
            String type = resultSet1.getString("type");
            int date_received = resultSet1.getInt("date_received");

            Blanks blanks = new Blanks(id, number, type, date_received);
            blanksList1.add(blanks);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

        BlankTable.setItems(blanksList1);
    }

    public void DomesticBlankOnAction() throws SQLException {

        ObservableList<Blanks> blanksList2 = FXCollections.observableArrayList();

        Statement statement2 = connectDB.createStatement();
        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM AVblank where type = 'Domestic'");

        while (resultSet2.next()) {
            int id = resultSet2.getInt("id");
            String number = resultSet2.getString("number");
            String type = resultSet2.getString("type");
            int date_received = resultSet2.getInt("date_received");

            Blanks blanks = new Blanks(id, number, type, date_received);
            blanksList2.add(blanks);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

        BlankTable.setItems(blanksList2);
    }

    public void SearchOnAction() throws SQLException {


        if (searchBlankTextField.getText().isBlank() == false) {
            ObservableList<Blanks> blanksList3 = FXCollections.observableArrayList();

            Statement statement3 = connectDB.createStatement();
            String searchBlank = "SELECT * FROM AVblank where number = '" + searchBlankTextField.getText() + "'";
            ResultSet resultSet3 = statement3.executeQuery(searchBlank);

            while (resultSet3.next()) {
                int id = resultSet3.getInt("id");
                String number = resultSet3.getString("number");
                String type = resultSet3.getString("type");
                int date_received = resultSet3.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList3.add(blanks);
            }

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("dateReceived"));

            BlankTable.setItems(blanksList3);
        }
    }



    public void BackOnAction(ActionEvent e) throws IOException {
        sceneController.switchToAdvisorSalesPage1(e);
    }


    public void setBlankNum(String number) {
        blankLabel.setText(number);
    }
    public void setBlankType(String type) {
        typeLabel1.setText(type);
    }
    public void setFlightFrom(String from){
        fromLabel1.setText(from);
    }
    public void setFlightTo(String to){
        toLabel1.setText(to);
    }
    public void setTotalAmount(String price){
        totalLabel.setText("Total amount : " +price);
    }
    public void setNameLabel1(String name){
        nameLabel1.setText(name);
    }

    double calc1;

    public void InterlineCommissionOnAction() throws SQLException {
        Statement stm = connectDB.createStatement();
        String commRate = "SELECT percentage from AVcommission where type = '"+typeLabel1.getText()+"'";
        ResultSet rs = stm.executeQuery(commRate);

        if(rs.next()){
            double percentage = rs.getDouble("percentage");

            String totalLabelText = totalLabel.getText();
            String numericPart = totalLabelText.substring(totalLabelText.indexOf(":") + 1).trim();
            double total = Double.parseDouble(numericPart);

            calc1 = percentage*total;

            CommLabel.setText("After commission : +" + calc1);
        }

    }

    double calc;

    public void ApplyDiscountOnAction() throws SQLException {
        Statement stm = connectDB.createStatement();
        //Statement stm1 = connectDB.createStatement();
        String name = nameLabel1.getText();
        String[] parts = name.split("\\s", 2);
        String firstName = parts[0];
        String lastName = parts[1];

        String disc = "SELECT fixed_discount FROM AVcustomer where first_name = '"+firstName+"' AND last_name = '"+lastName+"'";
        //String disc1 = "SELECT flexible_discount FROM AVcustomer where first_name = '"+firstName+"' AND last_name = '"+lastName+"'";
        ResultSet rs = stm.executeQuery(disc);
        //ResultSet rs1 = stm1.executeQuery(disc1);

        if(rs.next()){
            double fixed = rs.getDouble("fixed_discount");
            String totalLabelText = totalLabel.getText();
            String numericPart = totalLabelText.substring(totalLabelText.indexOf(":") + 1).trim();
            double total = Double.parseDouble(numericPart);

            System.out.println(total);
            calc = fixed*total;
            discountLabel.setText("After discount : -" + calc);
        }
    }

    public void CheckTotalOnAction(){
        double toAdd = -calc + calc1;
        String totalLabelText = totalLabel.getText();
        String numericPart = totalLabelText.substring(totalLabelText.indexOf(":") + 1).trim();
        double total = Double.parseDouble(numericPart);
        double totalAmount = toAdd + total;
        totalLabel.setText("Total amount : " + totalAmount);
    }


    public VBox getAddDetails() {
        return addDetails;
    }

    public VBox getCashAmount() {
        return cashAmount;
    }

    public void CashOnAction(){
        addDetails.setVisible(false);
        cashAmount.setVisible(true);
    }

    public void CardOnAction(){
        cashAmount.setVisible(false);
        addDetails.setVisible(true);
    }

    public void ShowBalanceOnAction(){
        if(amountText.getText().isBlank() == false) {
            String totalLabelText = totalLabel.getText();
            String numericPart = totalLabelText.substring(totalLabelText.indexOf(":") + 1).trim();
            double total = Double.parseDouble(numericPart);
            double received = Double.parseDouble(amountText.getText());
            double balance = received - total;
            balanceLabel.setText(String.valueOf(balance));
        }
    }

}



