package com.example.airvivacw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TravelAdvisorSaleController1 {
    @FXML
    private Label numLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label toLabel;

    @FXML
    private Label arrowLabel;

    @FXML
    private Label fromLabel;

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

    @FXML
    private Label nameLabel;

    @FXML
    private Label advisorLabel;


    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Blanks selectedBlank;
    private Flights selectedFlight;

    String number;
    String type;
    String from;
    String to;
    String total;
    String name;
    String advisor;

    private SceneController sceneController = new SceneController();


    public void AllBlank1OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList4 = FXCollections.observableArrayList();

        Statement statement5= connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='"+advisorLabel.getText()+"'");
        if(resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM `AVblank` WHERE blankowner = '" + name + "'");

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
    }

    public void InterlineBlank1OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList5 = FXCollections.observableArrayList();

        Statement statement5 = connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='" + advisorLabel.getText() + "'");
        if (resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank WHERE LEFT(number, 3) = '444' AND blankowner = '" + name + "';");

            while (resultSet4.next()) {
                int id = resultSet4.getInt("id");
                String number = resultSet4.getString("number");
                String type = resultSet4.getString("type");
                int date_received = resultSet4.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList5.add(blanks);
            }
            idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

            BlankTable1.setItems(blanksList5);
        }
    }

    public void InterlineBlank2OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList6 = FXCollections.observableArrayList();

        Statement statement5 = connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='" + advisorLabel.getText() + "'");
        if (resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank WHERE LEFT(number, 3) = '440' AND blankowner = '" + name + "';");

            while (resultSet4.next()) {
                int id = resultSet4.getInt("id");
                String number = resultSet4.getString("number");
                String type = resultSet4.getString("type");
                int date_received = resultSet4.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList6.add(blanks);
            }
            idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

            BlankTable1.setItems(blanksList6);
        }
    }

    public void InterlineBlank3OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList7 = FXCollections.observableArrayList();

        Statement statement5 = connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='" + advisorLabel.getText() + "'");
        if (resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank WHERE LEFT(number, 3) = '420' AND blankowner = '" + name + "';");

            while (resultSet4.next()) {
                int id = resultSet4.getInt("id");
                String number = resultSet4.getString("number");
                String type = resultSet4.getString("type");
                int date_received = resultSet4.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList7.add(blanks);
            }
            idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

            BlankTable1.setItems(blanksList7);
        }
    }

    public void DomesticBlank1OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList8 = FXCollections.observableArrayList();

        Statement statement5 = connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='" + advisorLabel.getText() + "'");
        if (resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank WHERE LEFT(number, 3) = '201' AND blankowner = '" + name + "';");

            while (resultSet4.next()) {
                int id = resultSet4.getInt("id");
                String number = resultSet4.getString("number");
                String type = resultSet4.getString("type");
                int date_received = resultSet4.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList8.add(blanks);
            }
            idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

            BlankTable1.setItems(blanksList8);
        }
    }

    public void DomesticBlank2OnAction(ActionEvent e) throws SQLException {

        ObservableList<Blanks> blanksList9 = FXCollections.observableArrayList();

        Statement statement5 = connectDB.createStatement();
        ResultSet resultSet5 = statement5.executeQuery("SELECT name FROM `AVuser` WHERE user_id ='" + advisorLabel.getText() + "'");
        if (resultSet5.next()) {
            String name = resultSet5.getString("name");

            Statement statement4 = connectDB.createStatement();
            ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM AVblank WHERE LEFT(number, 3) = '101' AND blankowner = '" + name + "';");

            while (resultSet4.next()) {
                int id = resultSet4.getInt("id");
                String number = resultSet4.getString("number");
                String type = resultSet4.getString("type");
                int date_received = resultSet4.getInt("date_received");

                Blanks blanks = new Blanks(id, number, type, date_received);
                blanksList9.add(blanks);
            }
            idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
            numCol1.setCellValueFactory(new PropertyValueFactory<>("number"));
            typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));

            BlankTable1.setItems(blanksList9);
        }
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

    public void SelectBlankOnAction(ActionEvent e){
        selectedBlank = BlankTable1.getSelectionModel().getSelectedItem();
        //System.out.println(selectedBlank.getNumber());
        if (selectedBlank != null) {
            numLabel.setText(selectedBlank.getNumber());
            typeLabel.setText(selectedBlank.getType());
        }
    }

    public void SelectFlightOnAction(ActionEvent e){
        selectedFlight = FlightTable.getSelectionModel().getSelectedItem();
        if (selectedFlight != null){
            toLabel.setText(selectedFlight.getDestination());
            arrowLabel.setText("->");
            fromLabel.setText(selectedFlight.getDepart_from());
        }
    }


    public void NextButtonOnAction(ActionEvent e) throws IOException, SQLException {
        number = selectedBlank.getNumber();
        type = selectedBlank.getType();
        from = selectedFlight.getDepart_from();
        to = selectedFlight.getDestination();
        name = nameLabel.getText();
        advisor = CurrentUser.getUserId();

        SalePage2(e);
    }

    public void BackOnAction1(ActionEvent e) throws IOException {
        sceneController.switchToAdvisorSalesPage(e);
    }

    public void SalePage2(ActionEvent e) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorSalesPage2.fxml"));
        root = loader.load();

        TravelAdvisorController scene2 = loader.getController();
        scene2.setBlankNum(number);
        scene2.setBlankType(type);
        scene2.setFlightFrom(from);
        scene2.setFlightTo(to);
        scene2.setNameLabel1(name);
        scene2.setAdvisorLabel(advisor);

        Statement statement = connectDB.createStatement();
        total = "SELECT price FROM AVflight WHERE depart_from = '"+from+"' AND destination = '"+to+"'";
        ResultSet resultSet = statement.executeQuery(total);

        if(resultSet.next()) {
            double price = resultSet.getDouble("price");
            scene2.setTotalAmount(Double.toString(price));
        }
        scene2.getAddDetails().setVisible(false);
        scene2.getCashAmount().setVisible(false);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCustomer(String name){
        nameLabel.setText(name);
    }
    public void setAdvisorLabel(String userId){
        advisorLabel.setText(userId);
    }

}