package com.example.consultAPI;

public class CompanyItem {
    private String id;
    private String name;
    private String number;
    private String website;
    private String address;


    public CompanyItem(){}

    public CompanyItem(String id, String name, String number, String website,
                        String address){
        this.id = id;
        this.name = name;
        this.number = number;
        this.website = website;
        this.address  = address;
    }

    public CompanyItem(String name){
        this.name = name;
    }


    //getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getWebsite() {
        return website;
    }

    public String getAddress() {
        return address;
    }


    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
