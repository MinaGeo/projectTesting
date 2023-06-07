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

import static com.example.demo.Account.accountsList;

public class SetAccountFXML {

    @FXML
    private Label warning;

    @FXML
    private TextField username, securitynumber, balance, accountType;
@FXML
private Button returnButton,transactionsButton;



    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Main User Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void createAccount() throws IOException
    {

        try {
            if (username.getText() != "" && securitynumber.getText() != "" && balance.getText() != "null") {

                boolean flag = false;
                for (Account account : accountsList) {

                    if (account.getSecurityNumber().equals(securitynumber.getText().toString())) {
                        flag = true;

                        warning.setText("Account already exist.");
                    }
                }
                if (!flag) {
//                    Account account = new Account(username.getText().toString(), securitynumber.getText().toString(), Double.parseDouble(balance.getText()), GlobalData.getUserID(), accountType.getText().toString());
//                    accountsList.add(account);
                  Account account = User.createAccount(username.getText().toString(), securitynumber.getText().toString(), Double.parseDouble(balance.getText()),accountType.getText().toString());
                    warning.setText("Account registered successfully.");
                    account.addBill("WATER BILL", 1000);
                    account.addBill("ELECTRICITY BILL", 500);

                }
            } else {
                warning.setText("Please enter valid data");
            }
        }
        catch (Exception e)
        {
            warning.setText("Enter valid datatype");
        }
    }

    @FXML
    public void transactions() throws IOException {
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
