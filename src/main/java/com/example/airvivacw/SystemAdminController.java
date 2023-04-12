package com.example.airvivacw;

import com.mysql.cj.xdevapi.Result;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.sql.*;

public class SystemAdminController {

    private SceneController sceneController = new SceneController();

    @FXML
    private TextField blankIDText;
    @FXML
    private TextField blankNumText;
    @FXML
    private TextField blankTypeText;
    @FXML
    private TextField blankDateText;
    @FXML
    private PasswordField userPass;
    @FXML
    private TextField fullNameText;
    @FXML
    private TextField userIDText;
    @FXML
    private TextField delUserText;
    @FXML
    private TextField blankDelText;
    @FXML
    private TextField jobType;
    @FXML
    private TextField newComText;
    @FXML
    private TextField updateExchangeText;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private Label blankErrorLabel;

    DatabaseConnection currentDB = new DatabaseConnection();
    Connection connectDB = currentDB.getConnection();

    public void changeInterlineAction(ActionEvent e) throws SQLException, IOException{
        Statement stm = connectDB.createStatement();
        String interChange = "UPDATE AVcommission SET percentage = '" + newComText.getText() + "' WHERE id = 1";
        int res = stm.executeUpdate(interChange);
    }

    public void changeDomesticAction(ActionEvent e) throws SQLException, IOException{
        Statement stm = connectDB.createStatement();
        String domChange = "UPDATE AVcommission SET percentage = '" + newComText.getText() + "' WHERE id = 2";
        int res = stm.executeUpdate(domChange);

    }

    public void changeRateAction(ActionEvent e) throws SQLException, IOException{
        Statement stm = connectDB.createStatement();
        String rateChange = "UPDATE AVcurrency SET rate = '" + updateExchangeText.getText() + "' WHERE id = 1";
        int res = stm.executeUpdate(rateChange);

    }

    public void createAccountAction(ActionEvent e) throws SQLException, IOException{

        if(fullNameText.getText().isBlank() == false && userIDText.getText().isBlank() == false
                && jobType.getText().isBlank() == false && userPass.getText().isBlank() == false)
        {
            Statement statement = connectDB.createStatement();
            String addUserDB = "INSERT INTO AVuser (user_id, name, job_type, password) VALUES (?,?,?,?)";

            PreparedStatement preStm = connectDB.prepareStatement(addUserDB);
            preStm.setString(1, userIDText.getText());
            preStm.setString(2, fullNameText.getText());
            preStm.setString(3, jobType.getText());
            preStm.setString(4, userPass.getText());
            preStm.executeUpdate();
        }

    }

    public void deleteAccountAction(ActionEvent e) throws SQLException, IOException{
        Statement statement = connectDB.createStatement();
        String verifyUser = "SELECT user_id FROM AVuser WHERE user_id = '" + delUserText.getText() + "'";
        ResultSet res = statement.executeQuery(verifyUser);

        if(res.next()) {
            System.out.println("exist");
            Statement stm1 = connectDB.createStatement();
            String delAcc = "DELETE FROM AVuser WHERE user_id = '" + delUserText.getText() + "'";
            int resAcc = stm1.executeUpdate(delAcc);
        }
        else {
            //message to display that user tried an invalid ID
        }

    }

    public void deleteBlankAction(ActionEvent e)throws SQLException, IOException{
        Statement statement = connectDB.createStatement();
        String verifyUser = "SELECT id FROM AVblank WHERE id = '" + blankDelText.getText() + "'";
        ResultSet res = statement.executeQuery(verifyUser);

        if(res.next()) {
            System.out.println("exist");
            Statement stm1 = connectDB.createStatement();
            String delBlank = "DELETE FROM AVblank WHERE id = '" + blankDelText.getText() + "'";
            int resDel = stm1.executeUpdate(delBlank);
        }
        else {
         //message to display that user tried an invalid
        }
    }

    public void createBlankAction(ActionEvent e) throws SQLException, IOException{
        if(blankIDText.getText().isBlank() == false && blankNumText.getText().isBlank() == false
                && blankDateText.getText().isBlank() == false && blankTypeText.getText().isBlank() == false)
        {
            Statement statement1 = connectDB.createStatement();
            String addBlank = "INSERT INTO AVblank(id, number, type, date_received) VALUES (?,?,?,?)";
            PreparedStatement prepStm = connectDB.prepareStatement(addBlank);
            prepStm.setString(1, blankIDText.getText());
            prepStm.setString(2, blankNumText.getText());
            prepStm.setString(3, blankTypeText.getText());
            prepStm.setString(4, blankDateText.getText());
            prepStm.executeUpdate();
        }

    }

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToLoginPage(e);
    }

}

