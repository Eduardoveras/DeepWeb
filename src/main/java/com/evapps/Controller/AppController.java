package com.evapps.Controller;

import com.evapps.Entity.Receipt;
import com.evapps.Service.CRUD.ReadDataService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Eduardo veras on 12/7/2016.
 */

@RestController
public class AppController {
    ReadDataService RDS;

    @RequestMapping(value ="/greeting", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<Receipt> greeting(@RequestParam(value="name", defaultValue="World") String name) {

        List<Receipt> test= RDS.findAllRegisteredTransactions();
        if (RDS.findAllRegisteredTransactions() == null)
        {
            test= new ArrayList<>();
            return test;
        }



        return test;

    }
}
