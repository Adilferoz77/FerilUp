package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CollegeMeritFormController {
    @FXML
    TextField marksField;
    @FXML
    Text errorField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static int marks =0;

    public void proceed(ActionEvent e) throws IOException {
        if(marksField.getText()!=""){
            marks = Integer.parseInt(marksField.getText());
            System.out.println(marks);
            Parent root = FXMLLoader.load(getClass().getResource("College-List-View.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            errorField.setText("Text Field can't be empty");
        }
    }
}
