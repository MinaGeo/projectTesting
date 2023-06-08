package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class ItemsBuy {



    @FXML
    private Button returnButton, buyItemButton;

    @FXML
    private TextField obtainId, accountSn;
    @FXML
    private Text price, itemsId, itemsName, warning;


    @FXML
    public void showItems()
    {
        itemsName.setText(Transaction.getItemsName());
        itemsId.setText(Transaction.getItemsId());
        price.setText(Transaction.getItemsPrice());
    }

    @FXML
    public void buyItems() throws IOException {
        try {
            if (obtainId.getText() != "" && accountSn.getText() != "") {
                String itemId = obtainId.getText().toString().toUpperCase();
                String accountID = accountSn.getText().toString();

                Random randomNum = new Random();
                int showMe = randomNum.nextInt(1000);
                String randomnumber = String.valueOf(showMe);
                Date date = new Date();
                Transaction transaction = new Transaction(randomnumber, date, Transaction.returnItemPrice(itemId) , "Bought "+itemId,accountID , null);
                warning.setText(transaction.buyItem(itemId, accountID));
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
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Transactions Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
}
