package com.evapps.Controller;

import com.evapps.Entity.Receipt;
import com.evapps.Service.CRUD.ReadDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eduardo veras on 12/7/2016.
 */

@RestController
class GreetingController {
    private static ReadDataService RDS;

    @GetMapping("/greeting")
    public static List<Receipt> greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return RDS.findAllRegisteredTransactions();
    }
}