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

public class PayBills {


    @FXML
    private Button returnButton, payButton;

    @FXML
    private TextField accountSN, billsID;

    @FXML
    private Label warning;

    @FXML
    public void payBills() throws IOException {
        try {
            if (accountSN.getText() != "" && billsID.getText() != "") {
                String id = accountSN.getText().toString();
                String bills = billsID.getText().toString().toUpperCase();
                Account account = Account.validation(id, "test");

                if (account != null) {
                    Random randomNum = new Random();
                    int showMe = randomNum.nextInt(1000);
                    String randomnumber = String.valueOf(showMe);
                    Date date = new Date();
                     new Transaction(randomnumber, date, Account.returnBillPrice(bills) , "bill: "+bills,id , null);
                    warning.setText(account.payBill(bills));
                } else {
                    warning.setText("Account doesn't exist");
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

        Parent root = FXMLLoader.load(getClass().getResource("ShowBillsFXML.fxml"));
        stage.setTitle("Show Bills Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
}
