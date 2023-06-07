package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Register {

    @FXML
    private Button returnButton, loginButton;

    @FXML
    private Label warning;

    @FXML
    private TextField username, Email;

    @FXML
            private PasswordField Password;

    @FXML
    private void checkLogin() throws IOException

    {
        try {
            if (username.getText() != "" && Email.getText() != "" && Password.getText() != "") {

                if (Password.getText().length() >= 8) {

                    warning.setText(User.register(username.getText().toString(), Email.getText().toString(), Password.getText().toString()));
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Weak password");
                    alert.setHeaderText(null);
                    alert.setContentText("Weak Password");
                    alert.showAndWait();
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

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        stage.setTitle("Home Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void loginFunction() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Login_FXML.fxml"));
        stage.setTitle("Login Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }


}
