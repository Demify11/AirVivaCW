package com.example.airvivacw;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ManagerController {

    private SceneController sceneController = new SceneController();

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        sceneController.switchToLoginPage(e);
    }
}
