package com.example.careeranalyzer;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GetStartedController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button getStartedButton;
    @FXML
    private ImageView logoView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //logo
        Image logo = new Image(getClass().getResourceAsStream("FerilUp_Logo.png"));
        logoView.setImage(logo);
        logoView.setX(-45);
        logoView.setY(-40);
        logoView.setFitHeight(300);
        logoView.setFitWidth(300);
        //Animation Object
        TranslateTransition buttonAnim = new TranslateTransition();
        buttonAnim.setNode(getStartedButton);
        //direction
        buttonAnim.setByY(-250);
        buttonAnim.setDuration(Duration.millis(1200));
        buttonAnim.play();
        //Adding colleges in Main
        Main.addColleges();
        //Adding Universities in Main
        Main.addUniversities();
    }

    public void switchToFormPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Form-Page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}