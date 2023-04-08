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

import java.io.IOException;
import java.sql.*;

public class TravelAdvisorController {

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
    private TableView<Blanks> BlankTable1;

    @FXML
    private TableColumn<Blanks, Integer> idCol1;

    @FXML
    private TableColumn<Blanks, String> numCol1;

    @FXML
    private TableColumn<Blanks, String> typeCol1;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private TableView<Flights> FlightTable;

    @FXML
    private TableColumn<Flights, Integer> fNumCol;

    @FXML
    private TableColumn<Flights, String> fromCol;

    @FXML
    private TableColumn<Flights, String> toCol;

    @FXML
    private TableColumn<Flights, String> dDateCol;

    @FXML
    private TableColumn<Flights, String> airlineCol;

    @FXML
    private TableColumn<Flights, String> durationCol;


    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();


    private SceneController sceneController = new SceneController();

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
                sceneController.switchToAdvisorSalesPage1(e);
            }
        } else {
            errorMessageLabel.setText("Please enter all the required details");
        }
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

    public void AllBlankOnAction(ActionEvent e) throws SQLException {

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

    public void InterlineBlankOnAction(ActionEvent e) throws SQLException {

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

    public void DomesticBlankOnAction(ActionEvent e) throws SQLException {

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

    public void SearchOnAction(ActionEvent e) throws SQLException {


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

    public void AllBlank1OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList4 = FXCollections.observableArrayList();

        Statement statement4 = connectDB.createStatement();
        ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank");

        while (resultSet4.next()) {
            int id = resultSet4.getInt("id");
            String number = resultSet4.getString("number");
            String type = resultSet4.getString("type");
            int date_received = resultSet4.getInt("date_received");

            Blanks blanks = new Blanks(id, number, type, date_received);
            blanksList4.add(blanks);
        }
        idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

        BlankTable1.setItems(blanksList4);
    }

    public void CheckFlightOnAction(ActionEvent e) throws SQLException {
        if(fromTextField.getText().isBlank() == false && toTextField.getText().isBlank() == false){

            ObservableList<Flights> flightList = FXCollections.observableArrayList();

            Statement statement5 = connectDB.createStatement();
            String showFlights = "SELECT * FROM AVflight WHERE depart_from = '" + fromTextField.getText() + "' AND destination = '" + toTextField.getText() + "'";
            ResultSet queryResult5 = statement5.executeQuery(showFlights);

            while (queryResult5.next()) {
                int flight_num = queryResult5.getInt("flight_num");
                String depart_from = queryResult5.getString("depart_from");
                String destination = queryResult5.getString("destination");
                int flight_date = queryResult5.getInt("flight_date");
                String airline = queryResult5.getString("airline");
                String duration = queryResult5.getString("duration");

                Flights flights = new Flights(flight_num, depart_from, destination, flight_date, airline, duration);
                flightList.add(flights);
            }
            fNumCol.setCellValueFactory(new PropertyValueFactory<>("flight_num"));
            fromCol.setCellValueFactory(new PropertyValueFactory<>("depart_from"));
            toCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
            dDateCol.setCellValueFactory(new PropertyValueFactory<>("flight_date"));
            airlineCol.setCellValueFactory(new PropertyValueFactory<>("airline"));
            durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));

            FlightTable.setItems(flightList);
        }
    }

}



