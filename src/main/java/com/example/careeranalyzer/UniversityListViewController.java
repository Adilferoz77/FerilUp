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

public class UniversityListViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //THIS CLASS CONTAINS COMMENTS SIMILAR TO CLASS "COLLEGE LIST VIEW CONTROLLER"

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


    //THIS CLASS CONTAINS COMMENTS SIMILAR TO CLASS "COLLEGE LIST VIEW CONTROLLER"

    UniversityLinkedList currentLL = new UniversityLinkedList();
    User currentUser = Main.getUserDetails();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(HomePageController.universitiesByRanks){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff", "HSC Rank"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<University>();

            TableColumn<University, Integer> hecRank = new TableColumn<University, Integer>("HEC Rank");
            hecRank.setCellValueFactory(new PropertyValueFactory<University, Integer>("hecRank"));
            hecRank.setSortable(false);
            hecRank.setMinWidth(80);
            hecRank.setMaxWidth(80);


            TableColumn<University, String> name = new TableColumn<University, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<University, String>("name"));
            name.setSortable(false);

            TableColumn<University, String> instituteType = new TableColumn<University, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<University, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<University, Integer> minimumCutOff = new TableColumn<University, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<University, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);

            tableView.getColumns().add(hecRank);
            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            UniversityNode node = Main.universityLinkedList.head;
            while (node.next != null) {
                tableView.getItems().add(node.university);
                currentLL.insertInstitute(node.university);
                node = node.next;
            }
            tableView.getItems().add(node.university);
            currentLL.insertInstitute(node.university);


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
        }else if(HomePageController.universitiesByFields){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<University>();


            TableColumn<University, String> name = new TableColumn<University, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<University, String>("name"));
            name.setSortable(false);

            TableColumn<University, String> instituteType = new TableColumn<University, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<University, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<University, Integer> minimumCutOff = new TableColumn<University, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<University, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);


            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            UniversityNode node = Main.universityLinkedList.head;
            while (node.next != null) {
                if(node.university.fields.contains(UniversityFieldFormController.selectedField)) {
                    tableView.getItems().add(node.university);
                    currentLL.insertInstitute(node.university);
                }
                node = node.next;
            }
            if(node.university.fields.contains(UniversityFieldFormController.selectedField)) {
                tableView.getItems().add(node.university);
                currentLL.insertInstitute(node.university);
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
            customFieldText.setText(UniversityFieldFormController.selectedField);
        }else if(HomePageController.universitiesByMerit){
            String[] sortOptions = {"Name", "Institute Type", "Minimum CutOff"};
            filtersBox.getItems().addAll(sortOptions);

            tableView = new TableView<University>();


            TableColumn<University, String> name = new TableColumn<University, String>("name");
            name.setCellValueFactory(new PropertyValueFactory<University, String>("name"));
            name.setSortable(false);

            TableColumn<University, String> instituteType = new TableColumn<University, String>("Institute Type");
            instituteType.setCellValueFactory(new PropertyValueFactory<University, String>("instituteType"));
            instituteType.setSortable(false);

            TableColumn<University, Integer> minimumCutOff = new TableColumn<University, Integer>("Cut Off");
            minimumCutOff.setCellValueFactory(new PropertyValueFactory<University, Integer>("minimumCutOff"));
            minimumCutOff.setSortable(false);


            tableView.getColumns().add(name);
            tableView.getColumns().add(instituteType);
            tableView.getColumns().add(minimumCutOff);

            tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
            tableView.setMinHeight(570);
            tableView.setMinWidth(880);
            tableView.setLayoutY(30);

            anchorPane.getChildren().add(tableView);

            UniversityNode node = Main.universityLinkedList.head;
            while (node.next != null) {
                if(node.university.getMinimumCutOff()<=UniversityMeritFormController.percentage) {
                    tableView.getItems().add(node.university);
                    currentLL.insertInstitute(node.university);
                }
                node = node.next;
            }
            if(node.university.getMinimumCutOff()<=UniversityMeritFormController.percentage) {
                tableView.getItems().add(node.university);
                currentLL.insertInstitute(node.university);
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
            customFieldHeading.setText("Inter Percent: ");
            customFieldText.setText(String.valueOf(UniversityMeritFormController.percentage) + "%");
        }

        tableView.setRowFactory(tableView -> {

            TableRow<University> university = new TableRow<>();
            university.setOnMouseClicked(mouseEvent -> {
                detailsHead.setText("University Details");
                // System.out.println(college.getItem().getName());
                firstNameHead.setText("Name: ");
                firstNameField.setText(university.getItem().getName());
                lastNameHead.setText("Location: ");
                lastNameField.setText(university.getItem().getLocation());
                ageHead.setText("Inst Type:");
                ageField.setText(university.getItem().getInstituteType());
                emailHead.setText("Min CutOff: ");
                emailField.setText(String.valueOf(university.getItem().getMinimumCutOff())+ "%");
                numberHead.setText("HSC Rank: ");
                phoneField.setText(String.valueOf(university.getItem().getHecRank()));
                cityHead.setText("Fee: ");
                cityField.setText("Rs. "+university.getItem().feesPerSemester + "/Semester");
                genderHead.setText("Best Fields");
                genderField.setText(String.valueOf(university.getItem().mostPreferredFields));

            });
            return university;
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
        UniversityNode node = currentLL.head;
        UniversityLinkedList sortedList = new UniversityLinkedList();

        while (node.next!=null){
            sortedList.insertInstitute(node.university);
            node = node.next;
        }
        sortedList.insertInstitute(node.university);

        if (sortType == "Minimum CutOff") {
            for (int i=0;i<sortedList.size-1;i++){
                UniversityNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.university.getMinimumCutOff() > current.next.university.getMinimumCutOff()){
                        University temp = current.university;
                        current.university = current.next.university;
                        current.next.university = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "Name") {
            for (int i=0;i<sortedList.size-1;i++){
                UniversityNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.university.getName().compareTo(current.next.university.getName())>0){
                        University temp = current.university;
                        current.university = current.next.university;
                        current.next.university = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "Institute Type") {
            for (int i=0;i<sortedList.size-1;i++){
                UniversityNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.university.getInstituteType().compareTo(current.next.university.getInstituteType())>0){
                        University temp = current.university;
                        current.university = current.next.university;
                        current.next.university = temp;
                    }
                    current = current.next;
                }
            }
        }

        if (sortType == "HSC Rank") {
            for (int i=0;i<sortedList.size-1;i++){
                UniversityNode current = sortedList.head;
                for(int j=0;j<sortedList.size-i-1;j++){
                    if(current.university.getHecRank() > current.next.university.getHecRank()){
                        University temp = current.university;
                        current.university = current.next.university;
                        current.next.university = temp;
                    }
                    current = current.next;
                }
            }
        }

        UniversityNode universityNode = sortedList.head;
        while (universityNode.next != null) {
            tableView.getItems().add(universityNode.university);
            universityNode = universityNode.next;
        }
        tableView.getItems().add(universityNode.university);
    }

}

