package com.example.consultAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class EmployeeController {

    private Employee employee = new Employee(false);


    //private Employee employee = new Employee();

    @RequestMapping(value = "/employee", method = GET)
    public List<EmployeeItem> getEmployeeItems (@RequestParam(value = "searchString", defaultValue = "") String searchString){
        ArrayList<EmployeeItem> list = new ArrayList<>();
        return employee.getEmployee(searchString);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public EmployeeItem postEmployeeItem (@RequestBody EmployeeItem item){
        employee.addItem(item);
        return item;
    }

    @RequestMapping(value = "/employee/{id}", method = GET)
    public EmployeeItem getEmployeeItem (@PathVariable("id") String itemId){
        EmployeeItem item = employee.getEmployeeItem(itemId);
        return item;
    }

    @RequestMapping(value = "/employee/{id}", method = DELETE)
    public EmployeeItem deletEmployeeItem (@PathVariable("id") String itemId){
        return employee.deletItem(itemId);
    }


    @RequestMapping(value = "/employee/{id}", method = PUT)
    public EmployeeItem putEmployeeItem(@PathVariable("id") String itemId,
                                        @RequestBody EmployeeItem item){
        employee.replaceItemById(itemId,item);
        return item;
    }
}
