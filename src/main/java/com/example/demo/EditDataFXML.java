package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EditDataFXML {


    @FXML
    private Button button, returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField Email,OldMailTextBox;

    @FXML
    private PasswordField Password, OldPasswordTextBox;



    private void userRegister() throws IOException {
        checkLogin();
    }


    @FXML
    private void checkLogin() throws IOException {

        try {
            if (OldMailTextBox.getText() != "" && OldPasswordTextBox.getText() != "" && Email.getText() != "" && Password.getText() != "") {
                if (User.updateProfile(OldMailTextBox.getText().toString(), OldPasswordTextBox.getText().toString(), Email.getText().toString(), Password.getText().toString())) {

                    warning.setText("User updated successfully");
                } else {
                    warning.setText("incorrect data, user didn't update");

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
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Main user Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }

}
