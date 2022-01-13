package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    /* These vars are being used in next Scenes of applications. They are connected with
    tableviews of colleges / universities */
    static boolean collegesByFaculty = false;
    static boolean collegesByMerit = false;
    static boolean collegesByRank = false;
    static boolean universitiesByFields = false;
    static boolean universitiesByMerit = false;
    static boolean universitiesByRanks = false;

    public void collegesByFaculty(ActionEvent e) throws IOException {
        collegesByFaculty = true;
        Parent root = FXMLLoader.load(getClass().getResource("collegeFaculty.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void collegesByMerit(ActionEvent e) throws IOException {
        collegesByMerit = true;
        Parent root = FXMLLoader.load(getClass().getResource("College-Merit-Form.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void collegesByRank(ActionEvent e) throws IOException {
        collegesByRank = true;
        Parent root = FXMLLoader.load(getClass().getResource("College-List-View.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void universitiesByFields(ActionEvent e) throws IOException {
        universitiesByFields = true;
        Parent root = FXMLLoader.load(getClass().getResource("University-Field-Form.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void universitiesByMerit(ActionEvent e) throws IOException {
        universitiesByMerit = true;
        Parent root = FXMLLoader.load(getClass().getResource("University-Merit-Form.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void universitiesByRanks(ActionEvent e) throws IOException {
        universitiesByRanks = true;
        Parent root = FXMLLoader.load(getClass().getResource("University-List-View.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //this method is being used for BACK button click
    public static void allFalse(){
        collegesByFaculty = false;
        collegesByMerit = false;
        collegesByRank = false;
        universitiesByFields = false;
        universitiesByMerit = false;
        universitiesByRanks = false;
    }

}
