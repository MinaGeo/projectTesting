package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TransctionsFXML {

    @FXML
    private Button depositButton, withdrawButton, transferButton, returnButton, billsButton, buyButton, showTransactionsButton;

    @FXML
    public void depositFunction() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) depositButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("DepositFXML.fxml"));
        stage.setTitle("Deposit Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }
    @FXML
    public void withdrawFunction() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) withdrawButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("WithdrawFXML.fxml"));
        stage.setTitle("Withdraw Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }
    @FXML
    public void transferFunction() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) transferButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("TransferFXML.fxml"));
        stage.setTitle("Transfer Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }

    @FXML
    public void returnHome() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Home Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }
    @FXML
    public void billsFunction() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) billsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("ShowBillsFXML.fxml"));
        stage.setTitle("Show bills Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }
    @FXML
    public void buyItemsFunction() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) buyButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("ItemsBuy.fxml"));
        stage.setTitle("Buy items Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }

    @FXML
    public void showTransactions() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) showTransactionsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("transactionListShow_FXML.fxml"));
        stage.setTitle("Buy items Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }


}
