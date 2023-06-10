package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowBillsFXML {

@FXML
private Button returnButton, payBillsButton;
@FXML
private TextField accountId;
@FXML
private Text billsId, amountBills, payBills;

@FXML
private Label warning;

    @FXML
public void showBills()
{
    try {

        if (accountId.getText() != "") {
            String id = accountId.getText().toString();
            long start=System.currentTimeMillis();
            Account account = Account.validation(id, "test");
            if (account != null) {
                billsId.setText(account.getBillsId());
                amountBills.setText(account.getBillsAmount());
                long finish =System.currentTimeMillis();
                long ElapsedTime=start-finish;
                GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
            } else {
                warning.setText("Account not available");
            }
        } else {
            warning.setText("Please enter a valid account SN");
        }
    }
    catch (Exception e)
    {
        warning.setText("Enter valid datatype");
    }
}

    @FXML
    public void payBills() throws IOException {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) payBillsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("PayBillsFXML.fxml"));
        stage.setTitle("Pay Bills Screen");
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
