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

        long start = System.currentTimeMillis();
        GlobalData.setStartTime(0);
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Online Banking Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(750);
        primaryStage.setHeight(500);
        primaryStage.show();
        Transaction.items.add(new Items("Pen", "IT1", 100, 10));
        Transaction.items.add(new Items("Checkbook", "IT2", 1000, 15));
        long finish = System.currentTimeMillis();
        long ElapsedTime = finish-start;
        GlobalData.setStartTime(GlobalData.getTime()+ElapsedTime);
        System.out.println("Elapsed Start time is "+ElapsedTime+ "ms") ;
        }



        @FXML
       public void registerFunction() throws IOException {
            long start = System.currentTimeMillis();
            Stage stage = (Stage) RegisterButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Register_FXML.fxml"));
        stage.setTitle("Register Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
            long finish = System.currentTimeMillis();
            long ElapsedTime = finish-start;
            GlobalData.setStartTime(GlobalData.getTime()+ElapsedTime);
            System.out.println("Elapsed Register time is "+ElapsedTime+ "ms") ;

        }
    @FXML
    public void loginFunction() throws IOException {
        long start = System.currentTimeMillis();

        Stage stage = (Stage) LoginButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Login_FXML.fxml"));
        stage.setTitle("Login Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        long finish = System.currentTimeMillis();
        long ElapsedTime = finish-start;
        GlobalData.setStartTime(GlobalData.getTime()+ElapsedTime);

        System.out.println("Elapsed Login time is "+ElapsedTime+ "ms") ;
    }


    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        launch();
        System.out.println("Total time elapsed during functions: " + GlobalData.getTime());
        long finish=System.currentTimeMillis();
        long Elapsed=finish-start;
        System.out.println("Total time: " + Elapsed);
    }
}