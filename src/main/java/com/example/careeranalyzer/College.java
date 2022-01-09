package com.example.careeranalyzer;

import java.util.ArrayList;

public class College extends Institute{

    ArrayList<String> faculties = new ArrayList<>();

    private int hscRank;
    String educationType;

    public College(String name, String location, String instituteType, int minimumCutOff, int hscRank, String educationType) {
        super(name, location, instituteType, minimumCutOff);
        this.educationType = educationType;
        this.hscRank = hscRank;
    }

    public ArrayList<String> getFaculties() {
        return faculties;
    }

    public void setFaculties(String... faculties){
        for (String i:faculties){
            this.faculties.add(i);
        }
    }

    public int getHscRank() {
        return hscRank;
    }

    public void setHscRank(int hscRank) {
        this.hscRank = hscRank;
    }

    public String getEducationType(){
        return educationType;
    }
}
