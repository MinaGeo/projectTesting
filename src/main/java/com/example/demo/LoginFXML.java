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

public class LoginFXML {




    @FXML
    private Button Loginbutton, returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField  Email;

    @FXML
            private PasswordField Password;


    @FXML
    private void loginFunction() throws IOException
    {
        try {
            if (Email.getText() != "" && Password.getText() != "") {
                if (User.login(Email.getText().toString(), Password.getText().toString())) {

                    String userID = Email.getText().toString();// Replace this with the actual user ID
                    long start = System.currentTimeMillis();
                    GlobalData.setUserID(userID);
                    warning.setVisible(true);
                    warning.setText("Login is successful");
                    lol();
                    long finish =System.currentTimeMillis();
                    long ElapsedTime=start-finish;
                    GlobalData.setStartTime(ElapsedTime+GlobalData.getTime());
                } else {
                    warning.setText("unsuccessful login, Invalid email or password");
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
        long start=System.currentTimeMillis();
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
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
    public void lol() throws IOException {
        long start = System.currentTimeMillis();
        Stage stage = (Stage) Loginbutton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Main user Screen");
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
