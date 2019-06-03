package com.example.consultAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CompanyController {

    private Company company = new Company(false);

    @RequestMapping(value = "/company", method = GET)
    public List<CompanyItem> getCompanyItems (@RequestParam(value = "searchString", defaultValue = "") String searchString){
        ArrayList<CompanyItem> list = new ArrayList<>();

        return company.getCompany(searchString);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public CompanyItem postCompanyItem (@RequestBody CompanyItem item){
        company.addItem(item);
        return item;
    }

    @RequestMapping(value = "/company/{id}", method = GET)
    public CompanyItem getCompanyItem (@PathVariable("id") String itemId){
        CompanyItem item = company.getCompanyItem(itemId);
        return item;
    }

    @RequestMapping(value = "/company/{id}", method = DELETE)
    public CompanyItem deletCompanyItem (@PathVariable("id") String itemId){
        return company.deletItem(itemId);
    }

    @RequestMapping(value = "/company/{id}", method = PUT)
    public CompanyItem putCompanyItem(@PathVariable("id") String itemId,
                                        @RequestBody CompanyItem item){
        company.replaceItemById(itemId,item);
        return item;
    }
}
