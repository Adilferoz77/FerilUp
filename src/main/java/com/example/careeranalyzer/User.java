package com.example.careeranalyzer;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNum;
    private String city;
    private char gender;
    private int previousMarks;

    User(){
        firstName = null;
        lastName = null;
        age = -1;
        email = null;
        phoneNum = null;
        city = null;
        gender = '\u0000';
    }

    User(String firstName, String lastname, int age, String email,String phoneNum, String city, char gender){
        this.firstName = firstName;
        this.lastName = lastname;
        this.age = age;
        this.email = email;
        this.phoneNum = phoneNum;
        this.city = city;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPreviousMarks() {
        return previousMarks;
    }

    public void setPreviousMarks(int previousMarks) {
        this.previousMarks = previousMarks;
    }
}
