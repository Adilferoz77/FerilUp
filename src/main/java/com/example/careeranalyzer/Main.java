package com.example.careeranalyzer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static User currentUser = new User();
    public static CollegeLinkedList collegeLinkedList = new CollegeLinkedList();
    public static UniversityLinkedList universityLinkedList = new UniversityLinkedList();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Get-Started.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,600);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("FerilUp_Logo.png")));
        stage.setTitle("FerilUp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void updateUserDetails(User user){
        currentUser = user;
    }

    public static User getUserDetails(){
        return currentUser;
    }

    public static void addColleges(){
        // Boys
        College adamjeeCollege = new College("Adamjee Govt. Sceince College","Garden East","Government",741,1,"Boys");
        adamjeeCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science");

        College DJCollege = new College("DJ Sindh Govt. Science College","Saddar","Government",702,2,"Boys");
        DJCollege.setFaculties("Pre-Engineering","Pre-Medical");

        College dehliCollege = new College("Govt. Dehli Inter Science College","Hussainabad","Government",691,3, "Boys");
        dehliCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science");

        College gulshanCollege = new College("Govt. Degree Sceince & Commerce College Gulshan-e-Iqbal","Gulshan-e-Iqbal Town Karachi","Government",672,4,"Boys");
        gulshanCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce");

        College nationalCollege = new College("Govt. National College","Shaheed-e-Millat Road","Government",623,5,"Boys");
        nationalCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce","Humanities");

        College joharCollege = new College("Govt. Degree Boys College Gulistan-e-Johar","University Road","Government",558,6,"Boys");
        joharCollege.setFaculties("Pre-Engineering","Pre-Medical","Commerce");

        College jamiaCollege = new College("Govt. Jamia Millia Degree College","Prof. Iftikhar Danish Road Malir","Government",538,7,"Boys");
        jamiaCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Humanities");

        College sirajuDallahCollege = new College("Govt. Sirajudallah Degree College","Fc Area Liaquatabad Town","Government",427,8,"Boys");
        sirajuDallahCollege.setFaculties("Pre-Engineering","Pre-Medical","Commerce","Humanities");

        College forMenCollege = new College("Govt. College For Men Nazimabad","Nazimabad Karachi","Government",660,9,"Boys");
        forMenCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce");

        College islamiaCollege = new College("Islamia Govt. Sceince College","Jamshed Town Karachi","Government",650,10,"Boys");
        islamiaCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science");

        College gulzarEhijriCollege = new College("Govt. Degree. Boys College Gulzar-e-Hijri","Abul Hassan Isahani Road","Government",512,11,"Boys");
        gulzarEhijriCollege.setFaculties("Pre-Engineering","Pre-Medical","Commerce");

        // Girls

        College abdullahCollege = new College("Abdullah Govt. College For Women","North Namzimabad Karachi","Government",615,1,"Girls");
        abdullahCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce","Humanities");

        College forWomenCollege = new College("Govt. College For Women Nazimabad","Namzimabad Karachi","Government",659,2,"Girls");
        forWomenCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce","Humanities");

        College sirSyedCollege = new College("Sir Syed Govt. Girls College","Liaqatabad Town","Government",712,3,"Girls");
        sirSyedCollege.setFaculties("Pre-Engineering","Pre-Medical","Computer Science","Commerce","Humanities");

        College shaheedEmillatCollege = new College("Shaheed-e-Millat Govt. Degree Girls College Karachi","Yaseenabad F.B area Gulberg Town","Government",629,4,"Girls");
        shaheedEmillatCollege.setFaculties("Pre-Engineering","Pre-Medical","Commerce","Humanities");

        College alNoorCollege = new College("Govt. Degree Girls College Al-Noor","Alnoor Society F.B area Gulberg Town","Government",425,5,"Girls");
        alNoorCollege.setFaculties("Pre-Engineering","Pre-Medical","Commerce");

        collegeLinkedList.insertInstitute(abdullahCollege);
        collegeLinkedList.insertInstitute(forWomenCollege);
        collegeLinkedList.insertInstitute(sirSyedCollege);
        collegeLinkedList.insertInstitute(shaheedEmillatCollege);
        collegeLinkedList.insertInstitute(alNoorCollege);
        collegeLinkedList.insertInstitute(adamjeeCollege);
        collegeLinkedList.insertInstitute(DJCollege);
        collegeLinkedList.insertInstitute(dehliCollege);
        collegeLinkedList.insertInstitute(gulshanCollege);
        collegeLinkedList.insertInstitute(nationalCollege);
        collegeLinkedList.insertInstitute(joharCollege);
        collegeLinkedList.insertInstitute(sirajuDallahCollege);
        collegeLinkedList.insertInstitute(forMenCollege);
        collegeLinkedList.insertInstitute(islamiaCollege);
        collegeLinkedList.insertInstitute(gulzarEhijriCollege);
    }

    public static void addUniversities(){
        University IBA = new University("Institute of Business Administration","University Road","Semi-Government",60,3,"286,050");
        IBA.setField("Business Administration","Accounting and Finance","Computer Science","Economics","Economics and Maths","Social Sciences");
        IBA.setMostPreferredFields("BBA","BSAF","BSCS");

        University MAJU = new University("Mohammad Ali Jinnah University","PECHS","Private",45,12,"99000");
        MAJU.setField("Business Administration","Accounting and Finance","Computer Science","Economics","Software Engineering","Social Sciences","Computer System Engineering","Electrical Engineering","Psychology");
        MAJU.setMostPreferredFields("BBA","BSAF","BSCS");

        University FAST = new University("National University of Emerging Sciences and Technology (NUCES)","Shah Abdul Latif Town","Private",50,11,"153,000");
        FAST.setField("Artificial Intelligence","Business Analytics","Computer Science","Cyber Security","Electrical Engineering","Internet of Things","Robotics","Software Engineering");
        FAST.setMostPreferredFields("BSCS","BSSE");

        University CBM = new University("Institute of Business Management","Korangi","Private",50,15,"114,940");
        CBM.setField("Business Administration","Accounting and Finance","Computer Science","Economics","Economics and Maths","Social Sciences");
        CBM.setMostPreferredFields("BBA","BSAF","BSEconomics");

        University suffa = new University("DHA Suffa University","Defence","Private",50,10,"125,500");
        suffa.setField("Business Administration","Electrical Engineering","Computer Science","Software Engineering");
        suffa.setMostPreferredFields("BBA","BSEE","BSCS");

        University SSUET = new University("Sir Syed University Of Engineering and Technology","University Road","Semi-Government",50,6,"110,000");
        SSUET.setField("Business Administration","Electrical Engineering","Computer Science","Software Engineering");
        SSUET.setMostPreferredFields("BSEE","BSSE","BSCS");


        University ziauddin= new University("Ziauddin University","Block 6",  "Clifton”,”Private",50,6,"90,750");
        ziauddin.setField("Electrical Engineering","Computer Science”,”Software Engineering”,Business Administration","Accounting and Finance");
        ziauddin.setMostPreferredFields("BBA","BSAF");


        University szabist = new University("Shaheed Zukfiqar Bhutto","Defence","Private",50,8,"155,555");
        szabist.setField("Business Administration","Accounting and Finance","Computer Science","Social Sciences");
        szabist.setMostPreferredFields("BBA","BSAF","BSSS");



        University FUUAST = new University("Federal Urdu University Of Science and Technology","Defence","Government",45,99,"30,000");
        FUUAST.setField("Business Administration","Accounting and Finance","Computer Science","Economics","Software Engineering","Social Sciences","Computer System Engineering","Electrical Engineering","Psychology");
        FUUAST.setMostPreferredFields("BBA","BSAF","BSCS");

        universityLinkedList.insertInstitute(IBA);
        universityLinkedList.insertInstitute(MAJU);
        universityLinkedList.insertInstitute(FAST);
        universityLinkedList.insertInstitute(CBM);
        universityLinkedList.insertInstitute(suffa);
        universityLinkedList.insertInstitute(SSUET);
        universityLinkedList.insertInstitute(ziauddin);
        universityLinkedList.insertInstitute(szabist);
        universityLinkedList.insertInstitute(FUUAST);
    }
}