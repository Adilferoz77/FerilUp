package com.example.careeranalyzer;

import java.util.ArrayList;
import java.util.Arrays;

public class University extends Institute{

    ArrayList<String> fields = new ArrayList<>();

    int hecRank;
    String feesPerSemester;
    ArrayList<String> mostPreferredFields = new ArrayList<>();

    public University(String name, String location, String instituteType, int minimumCutOff, int HECRank, String feesPerSemester){
        super(name, location, instituteType, minimumCutOff);
        this.hecRank = HECRank;
        this.feesPerSemester = feesPerSemester;
    }

    public void setField(String... fields){
        this.fields.addAll(Arrays.asList(fields));
    }

    public void setMostPreferredFields(String... fields){
        this.mostPreferredFields.addAll(Arrays.asList(fields));
    }

    public int getHecRank() {
        return hecRank;
    }
}
