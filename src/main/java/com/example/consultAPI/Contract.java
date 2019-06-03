package com.example.consultAPI;

public class Contract {

    private String id;
    private String employeeName;
    private String companyName;
    private String duration;


    public Contract(){}

    public Contract(String id, String employeeName, String companyName, String duration) {
        this.id = id;
        this.employeeName = employeeName;
        this.companyName = companyName;
        this.duration = duration;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDuration() {
        return duration;
    }


    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeId) {
        this.employeeName = employeeId;
    }

    public void setCompanyName(String companyId) {
        this.companyName = companyId;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
