package com.example.airvivacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SceneController {

    @FXML
    Label advisorLabel;


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void setAdvisorUserId(String userId) {
        advisorLabel.setText(userId);
    }



    public void switchToManagerHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ManagerHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdvisorHomePage(ActionEvent event) throws IOException {
        HelloController hello = new HelloController();
        hello.AdvisorPage(event);
    }

    public void switchToAdvisorStockPage(ActionEvent event) throws IOException, SQLException {
        root = FXMLLoader.load(getClass().getResource("AdvisorStockPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToAdvisorSalesPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdvisorSalesPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdvisorSalesPage1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdvisorSalesPage1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdvisorSalesPage2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdvisorSalesPage2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
