package com.example.careeranalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CollegeListViewController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    AnchorPane anchorPane;
    @FXML
    TableView tableView;
    @FXML
    ChoiceBox<String> filtersBox;
    @FXML
    Button sortButton;
    @FXML
    Text firstNameField;
    @FXML
    Text lastNameField;
    @FXML
    Text ageField;
    @FXML
    Text emailField;
    @FXML
    Text phoneField;
    @FXML
    Text cityField;
    @FXML
    Text genderField;
    @FXML
    Text detailsHead;
    @FXML
    Text customFieldHeading;
    @FXML
    Text customFieldText;
    @FXML
    Text firstNameHead;
    @FXML
    Text lastNameHead;
    @FXML
    Text ageHead;
    @FXML
    Text emailHead;
    @FXML
    Text numberHead;
    @FXML
    Text cityHead;
    @FXML
    Text genderHead;

    CollegeLinkedList currentLL = new CollegeLinkedList();
    User currentUser = Main.getUserDetails();
    String userGender = (currentUser.getGender()=='M')?"Boys":"Girls";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(HomePageController.collegesByRank){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff", "HSC Rank"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<College>();

            TableColumn<College, Integer> hscRank = new TableColumn<College, Integer>("HSC Rank");
            hscRank.setCellValueFactory(new PropertyValueFactory<College, Integer>("hscRank"));
            hscRank.setSortable(false);
            hscRank.setMinWidth(80);
            hscRank.setMaxWidth(80);


            TableColumn<College, String> name = new TableColumn<College, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<College, String>("name"));
            name.setSortable(false);

            TableColumn<College, String> instituteType = new TableColumn<College, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<College, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<College, Integer> minimumCutOff = new TableColumn<College, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<College, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);

            tableView.getColumns().add(hscRank);
            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            CollegeNode node = Main.collegeLinkedList.head;
            while (node.next != null) {
                if(userGender.equals(node.college.getEducationType())) {
                    tableView.getItems().add(node.college);
                    currentLL.insertInstitute(node.college);
                }
                node = node.next;
            }
            if(userGender.equals(node.college.getEducationType())) {
                tableView.getItems().add(node.college);
                currentLL.insertInstitute(node.college);
            }


            firstNameField.setText(currentUser.getFirstName());
            lastNameField.setText(currentUser.getLastName());
            ageField.setText(String.valueOf(currentUser.getAge()));
            emailField.setText(currentUser.getEmail());
            phoneField.setText(currentUser.getPhoneNum());
            cityField.setText(currentUser.getCity());
            if(currentUser.getGender() == 'M'){
                genderField.setText("Male");
            }else{
                genderField.setText("Female");
            }
        }else if(HomePageController.collegesByFaculty){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<College>();


            TableColumn<College, String> name = new TableColumn<College, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<College, String>("name"));
            name.setSortable(false);

            TableColumn<College, String> instituteType = new TableColumn<College, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<College, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<College, Integer> minimumCutOff = new TableColumn<College, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<College, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);


            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            CollegeNode node = Main.collegeLinkedList.head;
            while (node.next != null) {
                if(node.college.faculties.contains(collegeFacultyController.selectedFaculty) && userGender.equals(node.college.getEducationType())) {
                    tableView.getItems().add(node.college);
                    currentLL.insertInstitute(node.college);
                }
                node = node.next;
            }
            if(node.college.faculties.contains(collegeFacultyController.selectedFaculty) && userGender.equals(node.college.getEducationType())) {
                tableView.getItems().add(node.college);
                currentLL.insertInstitute(node.college);
            }


            firstNameField.setText(currentUser.getFirstName());
            lastNameField.setText(currentUser.getLastName());
            ageField.setText(String.valueOf(currentUser.getAge()));
            emailField.setText(currentUser.getEmail());
            phoneField.setText(currentUser.getPhoneNum());
            cityField.setText(currentUser.getCity());
            if(currentUser.getGender() == 'M'){
                genderField.setText("Male");
            }else{
                genderField.setText("Female");
            }
            customFieldHeading.setText("Selected Field: ");
            customFieldText.setText(collegeFacultyController.selectedFaculty);
        }else if(HomePageController.collegesByMerit){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<College>();


            TableColumn<College, String> name = new TableColumn<College, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<College, String>("name"));
            name.setSortable(false);

            TableColumn<College, String> instituteType = new TableColumn<College, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<College, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<College, Integer> minimumCutOff = new TableColumn<College, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<College, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);


            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            CollegeNode node = Main.collegeLinkedList.head;
            while (node.next != null) {
                if(node.college.getMinimumCutOff()<=CollegeMeritFormController.marks && userGender.equals(node.college.getEducationType()))  {
                    tableView.getItems().add(node.college);
                    currentLL.insertInstitute(node.college);
                }
                node = node.next;
            }
            if(node.college.getMinimumCutOff()<=CollegeMeritFormController.marks && userGender.equals(node.college.getEducationType())) {
                tableView.getItems().add(node.college);
                currentLL.insertInstitute(node.college);
            }


            firstNameField.setText(currentUser.getFirstName());
            lastNameField.setText(currentUser.getLastName());
            ageField.setText(String.valueOf(currentUser.getAge()));
            emailField.setText(currentUser.getEmail());
            phoneField.setText(currentUser.getPhoneNum());
            cityField.setText(currentUser.getCity());
            if(currentUser.getGender() == 'M'){
                genderField.setText("Male");
            }else{
                genderField.setText("Female");
            }
            customFieldHeading.setText("Matric Marks: ");
            customFieldText.setText(String.valueOf(CollegeMeritFormController.marks));
        }

        tableView.setRowFactory(tableView -> {

            TableRow<College> college = new TableRow<>();
            college.setOnMouseClicked(mouseEvent -> {
                detailsHead.setText("College Details");
                // System.out.println(college.getItem().getName());
                firstNameHead.setText("Name: ");
                firstNameField.setText(college.getItem().getName());
                lastNameHead.setText("Location: ");
                lastNameField.setText(college.getItem().getLocation());
                ageHead.setText("Inst Type:");
                ageField.setText(college.getItem().getInstituteType());
                emailHead.setText("Min CutOff: ");
                emailField.setText(String.valueOf(college.getItem().getMinimumCutOff()));
                numberHead.setText("HSC Rank: ");
                phoneField.setText(String.valueOf(college.getItem().getHscRank()));
                cityHead.setText("Edc Type: ");
                cityField.setText(college.getItem().getEducationType());
                genderField.setText(String.valueOf(college.getItem().faculties));
                genderHead.setText("Faculties: ");

            });
            return college;
        });

    }

    public void Back(ActionEvent e) throws IOException {
        HomePageController.allFalse();
        Parent root = FXMLLoader.load(getClass().getResource("Home-Page.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sort(ActionEvent event) {
        String sortType = filtersBox.getValue();
        while (!tableView.getItems().isEmpty()) {
            tableView.getItems().remove(0);
        }
        CollegeNode node = currentLL.head;
        CollegeLinkedList sortedList = new CollegeLinkedList();

        while (node.next!=null){
            sortedList.insertInstitute(node.college);
            node = node.next;
        }
        sortedList.insertInstitute(node.college);

        if (sortType == "Minimum CutOff") {
            for (int i=0;i<sortedList.size-1;i++){
                CollegeNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.college.getMinimumCutOff() > current.next.college.getMinimumCutOff()){
                        College temp = current.college;
                        current.college = current.next.college;
                        current.next.college = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "Name") {
            for (int i=0;i<sortedList.size-1;i++){
                CollegeNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.college.getName().compareTo(current.next.college.getName())>0){
                        College temp = current.college;
                        current.college = current.next.college;
                        current.next.college = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "Institute Type") {
            for (int i=0;i<sortedList.size-1;i++){
                CollegeNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.college.getInstituteType().compareTo(current.next.college.getInstituteType())>0){
                        College temp = current.college;
                        current.college = current.next.college;
                        current.next.college = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "HSC Rank") {
            for (int i=0;i<sortedList.size-1;i++){
                CollegeNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.college.getHscRank() > current.next.college.getHscRank()){
                        College temp = current.college;
                        current.college = current.next.college;
                        current.next.college = temp;
                    }
                    current = current.next;
                }
            }
        }

        CollegeNode collegeNode = sortedList.head;
        while (collegeNode.next != null) {
            tableView.getItems().add(collegeNode.college);
            collegeNode = collegeNode.next;
        }
        tableView.getItems().add(collegeNode.college);
    }

}
