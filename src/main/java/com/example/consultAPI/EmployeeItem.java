package com.example.consultAPI;

public class EmployeeItem {

    private String id;
    private String name;
    private String number;
    private String email;
    private String address;
    private Contract contract;


    public EmployeeItem(){}

    public EmployeeItem(String id, String name, String number, String email,
                          String address){
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address  = address;
    }

    public EmployeeItem(String id, String name, String number, String email,
                        String address, Contract contract){
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address  = address;
        this.contract = contract;
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

    public String getEmail() {
        return email;
    }

    public Contract getContract() {
        return contract;
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

    public void setEmail(String email) {
        this.email = email;
    }


    public void setAddress(String address) {
        this.address = address;
    }
}
