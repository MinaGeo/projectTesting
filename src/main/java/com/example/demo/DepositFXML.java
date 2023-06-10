package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class DepositFXML {


    @FXML
    private Button returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField Amount, accountSN;





    @FXML
    private void depositFunction() throws IOException
    {

        try {
            if (Amount.getText() != "" && accountSN.getText() != "") {
                int amountDeposited = Integer.parseInt(this.Amount.getText());
                String sn = accountSN.getText().toString();

                long start = System.currentTimeMillis();
                Account account = Account.validation(sn, "test");

                Random randomNum = new Random();
                int showMe = randomNum.nextInt(1000);
                String randomnumber = String.valueOf(showMe);
                if (account != null) {
                    Transaction transaction = new Transaction(randomnumber, new Date(), amountDeposited, "Deposit", null, null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Transaction Details");
                    alert.setHeaderText(null);
                    long start2 = System.currentTimeMillis();

                    alert.setContentText(transaction.deposit(amountDeposited, account));
                    long finish2 = System.currentTimeMillis();

                    long ElapsedTime2 = finish2 - start2;
                    System.out.println("Elapsed Time in Deposit"+ ElapsedTime2);

                    alert.showAndWait();
                    long finish =System.currentTimeMillis();
                    long ElapsedTime=start-finish;
                    GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());

                } else {
                    warning.setText("Account not available");
                }
            } else {
                warning.setText("Please enter valid data");
            }

        } catch (Exception e)
        {
            warning.setText("Enter valid datatype");
        }

    }
    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        long start = System.currentTimeMillis();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Transactions Screen");
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
