package com.example.careeranalyzer;

public class Institute {
    String name;
    String location;
    String instituteType;
    int minimumCutOff;

    public Institute(String name, String location, String instituteType, int minimumCutOff) {
        this.name = name;
        this.location = location;
        this.instituteType = instituteType;
        this.minimumCutOff = minimumCutOff;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getInstituteType() {
        return instituteType;
    }

    public int getMinimumCutOff() {
        return minimumCutOff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInstituteType(String instituteType) {
        this.instituteType = instituteType;
    }

    public void setMinimumCutOff(int minimumCutOff) {
        this.minimumCutOff = minimumCutOff;
    }
}
