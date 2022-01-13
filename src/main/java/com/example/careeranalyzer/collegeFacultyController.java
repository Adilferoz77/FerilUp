package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class collegeFacultyController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // used ahead for searching colleges containing this value
    public static String selectedFaculty ="";

    @FXML
    Text errorText;

    @FXML
    Button backButton;

    @FXML
    Button proceedButton;

    @FXML
    ChoiceBox<String> facultyBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] faculties = {"Pre-Engineering","Pre-Medical","Computer Science","Humanities","Commerce"};
        facultyBox.getItems().addAll(faculties);
    }

    public void back(ActionEvent e) throws IOException {
        HomePageController.allFalse();
        Parent root = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Proceed(ActionEvent e) throws IOException {
        selectedFaculty = facultyBox.getValue();
        if(selectedFaculty == null){
            errorText.setText("FACULTY CAN'T BE EMPTY");
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("College-List-View.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
