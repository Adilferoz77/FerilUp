package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //all fields used in scene builder, it contains buttons, text views etc
    @FXML
    private TextField firstName;
    @FXML
    private Text firstNameError;
    @FXML
    private Text lastNameError;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private Text emailError;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private Text emptyDOB;
    @FXML
    private TextField phoneNum;
    @FXML
    private Text phoneNumError;
    @FXML
    private ChoiceBox<String> city;
    @FXML
    private Text emptyCity;
    @FXML
    private Text emptyGender;
    @FXML
    private ChoiceBox<String> gender;


    //Initializing method will run whenever the current scene is viewed
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        city.getItems().add("Karachi");
        String [] genders = {"male","female"};
        gender.getItems().addAll(genders);
    }
    //On button Click
    public void submit(ActionEvent event) throws IOException {
        User user;
        // checking if all values of form are entered correctly
        Boolean allCorrect = true;
        //firstName
        String fName = firstName.getText();
        firstNameError.setText("");
        if(fName!="") {
            Pattern p = Pattern.compile("[a-zA-Z]*"); //Using REGEX
            Matcher m = p.matcher(fName);
            if (!m.matches()) {
                firstNameError.setText("Name must contains Letters only.");
                allCorrect = false;
            }
        }else{
            firstNameError.setText("Name Field can't be empty");
            allCorrect = false;
        }
        //lastName
        lastNameError.setText("");
        String lName = lastName.getText();
        if(lName!="") {
            Pattern p = Pattern.compile("[a-zA-Z]*"); //Using REGEX
            Matcher m = p.matcher(lName);
            if (!m.matches()) {
                lastNameError.setText("Name must contains Letters only.");
                allCorrect = false;
            }
        }else{
            lastNameError.setText("Name Field can't be empty");
            allCorrect = false;
        }
        //email
        emailError.setText("");
        String emailField = email.getText();
        if(emailField!=""){
            Pattern p = Pattern.compile("^(.+)@(.+)$"); //Using REGEX
            Matcher m = p.matcher(emailField);
            if (!m.matches()){
                emailError.setText("Invalid Email");
                allCorrect = false;
            }
        }else{
            emailError.setText("Email Field can't be empty");
            allCorrect = false;
        }
        //DOB
        emptyDOB.setText("");
        LocalDate date = dateOfBirth.getValue();
        String formattedDate = "";
        try {
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (NullPointerException e){
            emptyDOB.setText("DOB can't be empty");
            allCorrect = false;
        }
        //Number
        phoneNumError.setText("");
        String phoneNumber = phoneNum.getText();
        if(phoneNumber!=""){
            Pattern p = Pattern.compile("[0-9]{11}"); //Using REGEX
            Matcher m = p.matcher(phoneNumber);
            if(!m.matches()){
                phoneNumError.setText("Invalid Phone Number");
                allCorrect = false;
            }
        }else{
            phoneNumError.setText("Phone Number can't be Empty.");
            allCorrect = false;
        }
        //city
        String selectedCity = city.getValue();
        emptyCity.setText("");
        if(selectedCity==null){
            emptyCity.setText("Please Select City");
            allCorrect = false;
        }
        //gender
        String selectedGender = gender.getValue();
        emptyGender.setText("");
        if(selectedGender==null){
            emptyGender.setText("Please Select your Gender");
            allCorrect = false;
        }

        if(allCorrect){
            //converting selected DOB to age
            int age = Year.now().getValue() -Integer.parseInt(formattedDate.substring(6,10));
            int month = (Calendar.getInstance().get(Calendar.MONTH)+1) - Integer.parseInt(formattedDate.substring(5,7)) ;
            if(month<0){
                age--;
            }
            user = new User(fName,lName,age,emailField,phoneNumber,selectedCity,selectedGender.toUpperCase(Locale.ROOT).charAt(0));
            // Assigning all values of user to a user object in MAIN
            Main.updateUserDetails(user);
            switchStage(event);
        }
    }

    public void switchStage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
