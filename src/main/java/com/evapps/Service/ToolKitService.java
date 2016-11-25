/**
 * Created by Djidjelly Siclait on 10/11/2016.
 */
package com.evapps.Service;

import com.evapps.Entity.*;
import com.evapps.Repository.*;
import com.evapps.Tools.Classes.CalendarEvent;
import com.evapps.Tools.Enums.AppointmentStatus;
import com.evapps.Tools.Enums.EventStatus;
import com.evapps.Tools.Enums.Repeat;
import com.evapps.Tools.Enums.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ToolKitService {

    // Attributes
    private static final long MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;


    // Repositories
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;




    public Map<String, List> FetchClinicInventory(String clinicId){
        Map<String, List> inventory = new HashMap<>();


        // Adding Products
        inventory.put("products", StockProductSelf(clinicId));

        return inventory;
    }

    // Inventory Functions
    private List<Product> StockProductSelf(String clinicId) { return productRepository.findByClinic(clinicId); }



    private int differenceInDays(Date start, Date end){
        return (int)((end.getTime() - start.getTime()) / MILLISECONDS_IN_A_DAY);
    }
}