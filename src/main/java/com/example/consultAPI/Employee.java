package com.example.consultAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private List<EmployeeItem> employee;

    //no longer needed
    public Employee()
    {
        this.employee = new ArrayList<>();
       // addMockData();
    }

    public Employee(Boolean b) {

        this.employee = new ArrayList<>();
        read();
    }

    //getting all the objects from the employee list
    public List<EmployeeItem> getEmployee (String searchString){
        if (searchString.equals(""))
            return employee;
        ArrayList<EmployeeItem> items = new ArrayList<>();
        for (EmployeeItem item : employee){
            if(item.getName().toLowerCase().contains(searchString.toLowerCase())){
                items.add(item);
            }
        }
        return items;
    }

    //returning an employee by its id
    public EmployeeItem getEmployeeItem(String id){
        return findItemById(id);
    }

    //posting a new employee and save it to the text file
    public void addItem (EmployeeItem item){
        employee.add(item);
        write();
    }

    //removing an employee from the list and save it to the text file
    public EmployeeItem deletItem(String id){
        EmployeeItem item = findItemById(id);
        employee.remove(item);
        write();
        return item;
    }

    //updating an employee and save it to the text file
    public void replaceItemById (String id, EmployeeItem newItem){
        EmployeeItem oldItem = findItemById(id);
        employee.remove(oldItem);
        newItem.setId(oldItem.getId());
        employee.add(newItem);
        write();
    }

    //finding an employee by passing its id
    private EmployeeItem findItemById(String id){
        for(EmployeeItem item : employee){
            if(item.getId().equals(id))
                return item;
        }
        return null;
    }



    // no longer needed as there is a .json file
    private void addMockData(){

        CompanyItem company1 = new CompanyItem(
                "ITS Nordic");
        EmployeeItem item1 = new EmployeeItem(
                "1",
                "Mina Hosseini",
                "072861886",
                "minaa.hosseinii@gmail.com",
                "Aprikosgatan 1d"
                );
        Contract contract = new Contract(
                "01",
                item1.getName(),
                company1.getName(),
                "six month");
        EmployeeItem employee1 = new EmployeeItem(item1.getId(),
                item1.getName(),
                item1.getNumber(),
                item1.getEmail(),
                item1.getAddress(),
                contract);



        CompanyItem company2 = new CompanyItem(
                "IT-mästaren");
        EmployeeItem item2 = new EmployeeItem(
                "2",
                "Yujie Sui",
                "073124352",
                "yujie.sui@gmail.com",
                "Vallentuna");
        Contract contract2 = new Contract(
                "02",
                item2.getName(),
                company2.getName(),
                "one year");
        EmployeeItem employee2 = new EmployeeItem(item2.getId(),
                item2.getName(),
                item2.getNumber(),
                item2.getEmail(),
                item2.getAddress(),
                contract2);

        employee.add(employee1);
        employee.add(employee2);
    }




    //method to read data from the "employee.json" file saved in project
    void read() {
        //creating a Gson object
        Gson gson = new Gson();

        try {
            Employee employee;
            //The GSON JsonReader can read a JSON string or file
            try (JsonReader reader = new JsonReader(new FileReader("employee.json"))) {
                employee = gson.fromJson(reader, Employee.class);
            }
            this.employee = employee.employee;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to write data to the "employee.json" file saved in project
    void write() {

        //Creating a FileWriter object using specified fileName
        try (FileWriter file = new FileWriter("employee.json")) {

            //Creating a Gson Instance and generating JSON from a Java object with GSON
            Gson gson = new GsonBuilder().create();
            gson.toJson(this, file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
