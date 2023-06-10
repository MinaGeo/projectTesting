package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TransactionListShowFXML {

    @FXML
    private TextField accountTextField;

    @FXML
    private Label warning,label2;

    @FXML
    private Button returnButton, showTransactionsButton;


    @FXML
    public void returnHome() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
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
    public void showTransactions() throws IOException {
        long start=System.currentTimeMillis();

        try
        {
            warning.setText(Account.showUserDetails(accountTextField.getText().toString()));
            label2.setText(Transaction.getTransactionId());

        }catch (Exception e)
        {
            warning.setText("Please enter valid data");
        }
        long finish =System.currentTimeMillis();
        long ElapsedTime=start-finish;
        GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
    }

}
