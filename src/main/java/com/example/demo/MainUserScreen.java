package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUserScreen {
@FXML
private Button logoutbutton, editDataButton, setupAccountButton, transactionsButton;

    @FXML
    public void editData() throws IOException {
        Stage stage = (Stage) editDataButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("editData_FXML.fxml"));
        stage.setTitle("Edit data Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) logoutbutton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        stage.setTitle("Home Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void setUpAccount() throws IOException {
        Stage stage = (Stage) setupAccountButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("SetAccountFXML.fxml"));
        stage.setTitle("Set up account");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void transactionsScreen() throws IOException {
        Stage stage = (Stage) transactionsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Transactions Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }



}
