package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UniversityFieldFormController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //used ahead
    public static String selectedField = "";

    @FXML
    ChoiceBox<String> fieldBox;

    @FXML
    Text errorText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] fields = {"Business Administration","Accounting and Finance","Computer Science","Economics","Economics and Maths","Social Sciences","Economics","Software Engineering","Computer System Engineering","Electrical Engineering","Psychology","Artificial Intelligence","Business Analytics","Cyber Security","Electrical Engineering","Internet of Things","Robotics"};
        fieldBox.getItems().addAll(fields);
    }


    public void back(ActionEvent e) throws IOException {
        HomePageController.allFalse();
        Parent root = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void proceed(ActionEvent e) throws IOException {
        selectedField = fieldBox.getValue();

        if(selectedField==null){
            errorText.setText("Field can't be Empty");
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("University-List-View.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
