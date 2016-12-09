package com.evapps.Controller;

import com.evapps.Entity.Receipt;
import com.evapps.Service.CRUD.ReadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eduardo veras on 12/7/2016.
 */

@RestController
public class AppController {

    @Autowired
    private ReadDataService RDS;
    @Autowired
    private AdminController adminController;

    @RequestMapping("/rest/login")
    public boolean login(@RequestParam(value = "email", defaultValue = "ev@gmail.com") String email,
                         @RequestParam(value = "password") String password){
        return RDS.findRegisteredUserAccount(email,password);
    }

    @RequestMapping("/rest/transactions")
    public List<Receipt> tranaction(@RequestParam(value = "email", defaultValue = "ev@gmail.com") String email){
        return RDS.findRegisteredUserTransactions(email);
    }
}