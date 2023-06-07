package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private Stage stg;
    @FXML
    private Button RegisterButton, LoginButton;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Online Banking Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(750);
        primaryStage.setHeight(500);
        primaryStage.getIcons().add(new Image("D:\\Mina\\Junior-sem2\\testing\\PROJECT\\demo\\src\\main\\java\\com\\example\\demo\\4874090.png"));
        primaryStage.show();
        Transaction.items.add(new Items("Pen", "IT1", 100, 10));
        Transaction.items.add(new Items("Checkbook", "IT2", 1000, 15));
        }
        @FXML
       public void registerFunction() throws IOException {
        Stage stage = (Stage) RegisterButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Register_FXML.fxml"));
        stage.setTitle("Register Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void loginFunction() throws IOException {
        Stage stage = (Stage) LoginButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Login_FXML.fxml"));
        stage.setTitle("Login Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}