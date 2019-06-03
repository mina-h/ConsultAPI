package com.example.consultAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<CompanyItem> company;

    //no longer needed
    public Company()
    {
        this.company = new ArrayList<>();
        //  addMockData();
    }

    public Company(Boolean b) {

        this.company = new ArrayList<>();
        read();
    }

    //getting all the objects from the company list
    public List<CompanyItem> getCompany (String searchString){
        if (searchString.equals(""))
            return company;
        ArrayList<CompanyItem> items = new ArrayList<>();
        for (CompanyItem item : company){
            if(item.getName().toLowerCase().contains(searchString.toLowerCase())){
                items.add(item);
            }
        }
        return items;
    }

    //returning an company by its id
    public CompanyItem getCompanyItem(String id){
        return findItemById(id);
    }

    //posting a new company and save it to the text file
    public void addItem (CompanyItem item){
        company.add(item);
        write();
    }

    //removing an company from the list and save it to the text file
    public CompanyItem deletItem(String id){
        CompanyItem item = findItemById(id);
        company.remove(item);
        write();
        return item;
    }

    //updating an company and save it to the text file
    public void replaceItemById (String id, CompanyItem newItem){
        CompanyItem oldItem = findItemById(id);

        company.remove(oldItem);
        newItem.setId(oldItem.getId());
        company.add(newItem);
        write();
    }

    //finding an company by passing its id
    private CompanyItem findItemById(String id){
        for(CompanyItem item : company){
            if(item.getId().equals(id))
                return item;
        }
        return null;
    }

    public void addMockData(){
        CompanyItem item1 = new CompanyItem(
                "0",
                "ITS Nordic",
                "08-522 433 33",
                "helpdesk@itsnordic.se",
                "Gårdsvägen 18,  169 70 Solna");

        CompanyItem item2 = new CompanyItem(
                "1",
                "IT-mästaren",
                "08-120 165 30",
                "servicedesk@itmastaren.se",
                "Ringvägen 100, 118 60 Stockholm");


        company.add(item1);
        company.add(item2);
    }

    void read() {
        //creating a Gson object
        Gson gson = new Gson();
        try {
            Company company;
            //The GSON JsonReader can read a JSON string or file
            try (JsonReader reader = new JsonReader(new FileReader("company.json"))) {
                company = gson.fromJson(reader, Company.class);
            }
            this.company = company.company;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() {

        //Creating a FileWriter object using specified fileName
        try (FileWriter file = new FileWriter("company.json")) {

            //Creating a Gson Instance and generating JSON from a Java object with GSON
            Gson gson = new GsonBuilder().create();
            gson.toJson(this, file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
