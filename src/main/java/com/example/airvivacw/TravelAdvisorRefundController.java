package com.example.airvivacw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TravelAdvisorRefundController {
    @FXML
    private AnchorPane refundPane;

    @FXML
    private Label advisorLabel;

    @FXML
    private Label refundLabel;

    public AnchorPane getRefundPane() {
        return refundPane;
    }

    public void setAdvisorLabel(String userId){
        advisorLabel.setText(userId);
    }

    public void SearchOnAction(){

    }
}
